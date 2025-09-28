package com.wdbyte.bing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.wdbyte.bing.html.HtmlFileUtils;
import com.wdbyte.bing.html.WebSiteGenerator;

/**
 * @author niujinpeng
 * @date 2021/02/08
 * @link https://github.com/niumoo
 */
public class Wallpaper {

    // BING API
    private static final String BING_API_TEMPLATE = "https://global.bing.com/HPImageArchive.aspx?format=js&idx=0&n=9&pid=hp&FORM=BEHPTB&uhd=1&uhdwidth=3840&uhdheight=2160&setmkt=%s&setlang=en";
    private static String BING_URL = "https://cn.bing.com";

    /**
     * {"en-US", "zh-CN", "ja-JP", "en-IN", "pt-BR", "fr-FR", "de-DE", "en-CA", "en-GB", "it-IT", "es-ES", "fr-CA"};
     */
    private static String[] regions = {"en-US", "zh-CN"};

    public static String CURRENT_REGION = "en-US";

    public static void main(String[] args) throws IOException {
        for (String region : regions) {
            try {
                System.out.println("正在处理区域: " + region);
                changeConfig(region);
                
                String bingApi = String.format(BING_API_TEMPLATE, region);
                System.out.println("API URL: " + bingApi);
                
                String httpContent = HttpUtls.getHttpContent(bingApi);
                if (httpContent == null || httpContent.isEmpty()) {
                    System.err.println("获取API数据失败，跳过区域: " + region);
                    continue;
                }
                
                JSONObject jsonObject = JSON.parseObject(httpContent);
                if (jsonObject == null) {
                    System.err.println("JSON解析失败，跳过区域: " + region);
                    continue;
                }
                
                JSONArray jsonArray = jsonObject.getJSONArray("images");
                if (jsonArray == null || jsonArray.isEmpty()) {
                    System.err.println("未找到图片数据，跳过区域: " + region);
                    continue;
                }

                JSONObject imageObject = jsonArray.getJSONObject(0);
                if (imageObject == null) {
                    System.err.println("图片对象为空，跳过区域: " + region);
                    continue;
                }
                
                // 图片地址
                String url = BING_URL + imageObject.getString("url");
                if (url == null || url.equals(BING_URL)) {
                    System.err.println("图片URL无效，跳过区域: " + region);
                    continue;
                }

                // 图片时间
                String enddate = imageObject.getString("enddate");
                LocalDate localDate = LocalDate.parse(enddate, DateTimeFormatter.BASIC_ISO_DATE);
                enddate = localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);

                // 图片版权
                String copyright = imageObject.getString("copyright");

                // 读取或创建图片列表
                List<Images> imagesList = BingFileUtils.readBing();
                if (imagesList == null) {
                    imagesList = new ArrayList<>();
                }
                
                // 安全地更新列表
                Images newImage = new Images(copyright, enddate, url);
                if (imagesList.isEmpty()) {
                    imagesList.add(newImage);
                } else {
                    imagesList.set(0, newImage);
                }
                
                // 去重并保存
                imagesList = imagesList.stream().distinct().collect(Collectors.toList());
                BingFileUtils.writeBing(imagesList);
                BingFileUtils.writeReadme(imagesList);
                BingFileUtils.writeMonthInfo(imagesList);
                
                // 确保目录存在
                Files.createDirectories(HtmlFileUtils.BING_HTML_ROOT);
                new WebSiteGenerator().htmlGenerator();
                
                System.out.println("区域 " + region + " 处理完成");
                
            } catch (Exception e) {
                System.err.println("处理区域 " + region + " 时发生错误: " + e.getMessage());
                e.printStackTrace();
                // 继续处理下一个区域，不中断整个流程
            }
        }
        System.out.println("所有区域处理完成");
    }

    public static void changeConfig(String region) {
        region = region.toLowerCase();
        CURRENT_REGION = region;
        if ("en-us".equalsIgnoreCase(region)) {
            BingFileUtils.README_PATH = Paths.get("README.md");
            BingFileUtils.BING_PATH = Paths.get("bing-wallpaper.md");
            BingFileUtils.MONTH_PATH = Paths.get("picture/");
            HtmlFileUtils.BING_HTML_ROOT = Paths.get("docs/");
        } else {
            // 确保区域目录存在
            try {
                Files.createDirectories(Paths.get(region));
                Files.createDirectories(Paths.get("docs/" + region));
            } catch (IOException e) {
                System.err.println("创建目录失败: " + e.getMessage());
            }
            
            BingFileUtils.README_PATH = Paths.get(region + "/README.md");
            BingFileUtils.BING_PATH = Paths.get(region + "/bing-wallpaper.md");
            BingFileUtils.MONTH_PATH = Paths.get(region + "/picture/");
            HtmlFileUtils.BING_HTML_ROOT = Paths.get("docs/" + region + "/");
        }
    }
}