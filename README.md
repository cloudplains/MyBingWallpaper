## Bing Wallpaper
![](https://cn.bing.com/th?id=OHR.TankLakes_EN-US9278332978_UHD.jpg&w=1000)Today: [Tank Lakes, Alpine Lakes Wilderness, Washington (© Austin Trigg/TANDEM Stills + Motion)](https://cn.bing.com/th?id=OHR.TankLakes_EN-US9278332978_UHD.jpg&rf=LaDigue_UHD.jpg&pid=hp&w=3840&h=2160&rs=1&c=4)

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bing 每日壁纸</title>
    <style>
        body {
            font-family: 'Microsoft YaHei', sans-serif;
            max-width: 1200px;
            margin: 0 auto;
            padding: 20px;
            background-color: #f5f5f5;
            line-height: 1.6;
        }
        .header {
            text-align: center;
            margin-bottom: 30px;
            padding: 20px;
            background: white;
            border-radius: 12px;
            box-shadow: 0 4px 15px rgba(0,0,0,0.1);
        }
        .today-wallpaper {
            text-align: center;
            margin-bottom: 40px;
            background: white;
            border-radius: 12px;
            padding: 25px;
            box-shadow: 0 4px 15px rgba(0,0,0,0.1);
        }
        .today-wallpaper img {
            max-width: 100%;
            height: auto;
            max-height: 500px;
            border-radius: 8px;
            margin-bottom: 15px;
            cursor: pointer;
        }
        .today-title {
            font-size: 24px;
            font-weight: bold;
            color: #333;
            margin-bottom: 10px;
        }
        .today-date {
            font-size: 18px;
            color: #666;
            margin-bottom: 15px;
        }
        .wallpaper-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
            gap: 20px;
            margin-bottom: 30px;
        }
        .wallpaper-item {
            background: white;
            border-radius: 8px;
            padding: 15px;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
            transition: transform 0.3s ease;
        }
        .wallpaper-item:hover {
            transform: translateY(-5px);
            box-shadow: 0 5px 15px rgba(0,0,0,0.2);
        }
        .wallpaper-item img {
            width: 100%;
            height: 200px;
            object-fit: cover;
            border-radius: 4px;
            cursor: pointer;
        }
        .date {
            font-weight: bold;
            margin: 10px 0;
            color: #333;
        }
        .download-link {
            display: inline-block;
            background: #007cba;
            color: white;
            padding: 8px 15px;
            text-decoration: none;
            border-radius: 4px;
            font-size: 14px;
            transition: background 0.3s ease;
            margin: 5px;
        }
        .download-link:hover {
            background: #005a87;
        }
        .loading {
            text-align: center;
            padding: 40px;
            font-size: 18px;
            color: #666;
        }
        .section-title {
            font-size: 22px;
            margin: 30px 0 20px 0;
            color: #333;
            border-left: 4px solid #007cba;
            padding-left: 15px;
        }
        .modal {
            display: none;
            position: fixed;
            z-index: 1000;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0,0,0,0.9);
        }
        .modal-content {
            margin: auto;
            display: block;
            max-width: 90%;
            max-height: 90%;
            margin-top: 2%;
        }
        .close {
            position: absolute;
            top: 15px;
            right: 35px;
            color: #f1f1f1;
            font-size: 40px;
            font-weight: bold;
            cursor: pointer;
        }
        .archive-links {
            text-align: center;
            margin: 30px 0;
            padding: 20px;
            background: white;
            border-radius: 12px;
            box-shadow: 0 4px 15px rgba(0,0,0,0.1);
        }
        .archive-link {
            display: inline-block;
            margin: 5px;
            padding: 8px 15px;
            background: #f0f0f0;
            border-radius: 4px;
            text-decoration: none;
            color: #333;
            transition: background 0.3s ease;
        }
        .archive-link:hover {
            background: #ddd;
        }
    </style>
</head>
<body>
    <div class="header">
        <h1>Bing 每日壁纸</h1>
        <p>自动更新的 Bing 每日精美壁纸收藏</p>
    </div>
    
    <div id="wallpaper-content">
        <!-- 壁纸内容将由JavaScript动态生成 -->
        <div class="loading">正在加载壁纸...</div>
    </div>

    <!-- 图片预览模态框 -->
    <div id="imageModal" class="modal">
        <span class="close">&times;</span>
        <img class="modal-content" id="modalImage">
    </div>

    <script>
        // 壁纸数据
        const wallpapers = [
            {
                thumbnail: "https://cn.bing.com/th?id=OHR.TankLakes_EN-US9278332978_UHD.jpg&pid=hp&w=384&h=216&rs=1&c=4",
                fullsize: "https://cn.bing.com/th?id=OHR.TankLakes_EN-US9278332978_UHD.jpg&rf=LaDigue_UHD.jpg&pid=hp&w=3840&h=2160&rs=1&c=4",
                date: "2025-09-28",
                title: "Tank Lakes, Alpine Lakes Wilderness, Washington"
            },
            {
                thumbnail: "https://cn.bing.com/th?id=OHR.AutumnChipmunk_EN-US9248365602_UHD.jpg&pid=hp&w=384&h=216&rs=1&c=4",
                fullsize: "https://cn.bing.com/th?id=OHR.AutumnChipmunk_EN-US9248365602_UHD.jpg&rf=LaDigue_UHD.jpg&pid=hp&w=3840&h=2160&rs=1&c=4",
                date: "2025-09-27",
                title: "Autumn Chipmunk"
            },
            {
                thumbnail: "https://cn.bing.com/th?id=OHR.FortChittorgarh_EN-US9184486139_UHD.jpg&pid=hp&w=384&h=216&rs=1&c=4",
                fullsize: "https://cn.bing.com/th?id=OHR.FortChittorgarh_EN-US9184486139_UHD.jpg&rf=LaDigue_UHD.jpg&pid=hp&w=3840&h=2160&rs=1&c=4",
                date: "2025-09-26",
                title: "Fort Chittorgarh"
            },
            {
                thumbnail: "https://cn.bing.com/th?id=OHR.BearLodge_EN-US9061134971_UHD.jpg&pid=hp&w=384&h=216&rs=1&c=4",
                fullsize: "https://cn.bing.com/th?id=OHR.BearLodge_EN-US9061134971_UHD.jpg&rf=LaDigue_UHD.jpg&pid=hp&w=3840&h=2160&rs=1&c=4",
                date: "2025-09-25",
                title: "Bear Lodge"
            },
            {
                thumbnail: "https://cn.bing.com/th?id=OHR.ToucanForest_EN-US8319635845_UHD.jpg&pid=hp&w=384&h=216&rs=1&c=4",
                fullsize: "https://cn.bing.com/th?id=OHR.ToucanForest_EN-US8319635845_UHD.jpg&rf=LaDigue_UHD.jpg&pid=hp&w=3840&h=2160&rs=1&c=4",
                date: "2025-09-24",
                title: "Toucan Forest"
            },
            {
                thumbnail: "https://cn.bing.com/th?id=OHR.AspenEquinox_EN-US8237887036_UHD.jpg&pid=hp&w=384&h=216&rs=1&c=4",
                fullsize: "https://cn.bing.com/th?id=OHR.AspenEquinox_EN-US8237887036_UHD.jpg&rf=LaDigue_UHD.jpg&pid=hp&w=3840&h=2160&rs=1&c=4",
                date: "2025-09-23",
                title: "Aspen Equinox"
            },
            {
                thumbnail: "https://cn.bing.com/th?id=OHR.IceOtters_EN-US7982442590_UHD.jpg&pid=hp&w=384&h=216&rs=1&c=4",
                fullsize: "https://cn.bing.com/th?id=OHR.IceOtters_EN-US7982442590_UHD.jpg&rf=LaDigue_UHD.jpg&pid=hp&w=3840&h=2160&rs=1&c=4",
                date: "2025-09-22",
                title: "Ice Otters"
            },
            {
                thumbnail: "https://cn.bing.com/th?id=OHR.OktoberfestSwing_EN-US7916182497_UHD.jpg&pid=hp&w=384&h=216&rs=1&c=4",
                fullsize: "https://cn.bing.com/th?id=OHR.OktoberfestSwing_EN-US7916182497_UHD.jpg&rf=LaDigue_UHD.jpg&pid=hp&w=3840&h=2160&rs=1&c=4",
                date: "2025-09-21",
                title: "Oktoberfest Swing"
            },
            {
                thumbnail: "https://cn.bing.com/th?id=OHR.ThousandIslands_EN-US7884567746_UHD.jpg&pid=hp&w=384&h=216&rs=1&c=4",
                fullsize: "https://cn.bing.com/th?id=OHR.ThousandIslands_EN-US7884567746_UHD.jpg&rf=LaDigue_UHD.jpg&pid=hp&w=3840&h=2160&rs=1&c=4",
                date: "2025-09-20",
                title: "Thousand Islands"
            }
        ];

        // 渲染壁纸内容
        function renderWallpapers() {
            const container = document.getElementById('wallpaper-content');
            
            if (wallpapers.length === 0) {
                container.innerHTML = '<div class="loading">暂无壁纸数据</div>';
                return;
            }
            
            let html = '';
            
            // 今日壁纸（第一张）
            const today = wallpapers[0];
            html += `
                <div class="today-wallpaper">
                    <img src="${today.thumbnail.replace('&w=384&h=216', '&w=1000')}" 
                         alt="${today.title}" 
                         onclick="openModal('${today.fullsize}')">
                    <div class="today-title">${today.title}</div>
                    <div class="today-date">${today.date} · 今日壁纸</div>
                    <a href="${today.fullsize}" class="download-link" target="_blank" download="bing-wallpaper-${today.date}.jpg">
                        下载 4K 壁纸
                    </a>
                </div>
            `;
            
            // 历史壁纸
            if (wallpapers.length > 1) {
                html += `<div class="section-title">历史壁纸</div>`;
                html += '<div class="wallpaper-grid">';
                
                for (let i = 1; i < wallpapers.length; i++) {
                    const wp = wallpapers[i];
                    html += `
                        <div class="wallpaper-item">
                            <img src="${wp.thumbnail}" 
                                 alt="${wp.title}" 
                                 onclick="openModal('${wp.fullsize}')">
                            <div class="date">${wp.date}</div>
                            <div style="font-size: 14px; color: #666; margin-bottom: 10px;">${wp.title}</div>
                            <a href="${wp.fullsize}" class="download-link" target="_blank" download="bing-wallpaper-${wp.date}.jpg">
                                下载 4K
                            </a>
                        </div>
                    `;
                }
                
                html += '</div>';
            }
            
            // 归档链接
            html += `
                <div class="archive-links">
                    <h3>历史归档</h3>
                    <div>
                        <a href="/picture/2025-09/" class="archive-link">2025-09</a>
                        <a href="/picture/2025-08/" class="archive-link">2025-08</a>
                        <a href="/picture/2025-07/" class="archive-link">2025-07</a>
                        <a href="/picture/2025-06/" class="archive-link">2025-06</a>
                        <a href="/picture/2025-05/" class="archive-link">2025-05</a>
                        <a href="/picture/2025-04/" class="archive-link">2025-04</a>
                        <a href="/picture/2025-03/" class="archive-link">2025-03</a>
                        <a href="/picture/2025-02/" class="archive-link">2025-02</a>
                        <a href="/picture/2025-01/" class="archive-link">2025-01</a>
                    </div>
                </div>
            `;
            
            container.innerHTML = html;
        }
        
        // 打开图片预览模态框
        function openModal(imageUrl) {
            const modal = document.getElementById('imageModal');
            const modalImg = document.getElementById('modalImage');
            modal.style.display = 'block';
            modalImg.src = imageUrl;
        }
        
        // 关闭模态框
        function closeModal() {
            document.getElementById('imageModal').style.display = 'none';
        }
        
        // 页面加载完成后执行
        document.addEventListener('DOMContentLoaded', function() {
            renderWallpapers();
            
            // 点击模态框关闭
            document.getElementById('imageModal').addEventListener('click', function(e) {
                if (e.target === this || e.target.className === 'close') {
                    closeModal();
                }
            });
            
            // ESC键关闭模态框
            document.addEventListener('keydown', function(e) {
                if (e.key === 'Escape') {
                    closeModal();
                }
            });
        });
    </script>
</body>
</html>

|      |      |      |
| :----: | :----: | :----: |
|![](https://cn.bing.com/th?id=OHR.TankLakes_EN-US9278332978_UHD.jpg&pid=hp&w=384&h=216&rs=1&c=4)2025-09-28 [download 4k](https://cn.bing.com/th?id=OHR.TankLakes_EN-US9278332978_UHD.jpg&rf=LaDigue_UHD.jpg&pid=hp&w=3840&h=2160&rs=1&c=4)|![](https://cn.bing.com/th?id=OHR.AutumnChipmunk_EN-US9248365602_UHD.jpg&pid=hp&w=384&h=216&rs=1&c=4)2025-09-27 [download 4k](https://cn.bing.com/th?id=OHR.AutumnChipmunk_EN-US9248365602_UHD.jpg&rf=LaDigue_UHD.jpg&pid=hp&w=3840&h=2160&rs=1&c=4)|![](https://cn.bing.com/th?id=OHR.FortChittorgarh_EN-US9184486139_UHD.jpg&pid=hp&w=384&h=216&rs=1&c=4)2025-09-26 [download 4k](https://cn.bing.com/th?id=OHR.FortChittorgarh_EN-US9184486139_UHD.jpg&rf=LaDigue_UHD.jpg&pid=hp&w=3840&h=2160&rs=1&c=4)|
|![](https://cn.bing.com/th?id=OHR.BearLodge_EN-US9061134971_UHD.jpg&pid=hp&w=384&h=216&rs=1&c=4)2025-09-25 [download 4k](https://cn.bing.com/th?id=OHR.BearLodge_EN-US9061134971_UHD.jpg&rf=LaDigue_UHD.jpg&pid=hp&w=3840&h=2160&rs=1&c=4)|![](https://cn.bing.com/th?id=OHR.ToucanForest_EN-US8319635845_UHD.jpg&pid=hp&w=384&h=216&rs=1&c=4)2025-09-24 [download 4k](https://cn.bing.com/th?id=OHR.ToucanForest_EN-US8319635845_UHD.jpg&rf=LaDigue_UHD.jpg&pid=hp&w=3840&h=2160&rs=1&c=4)|![](https://cn.bing.com/th?id=OHR.AspenEquinox_EN-US8237887036_UHD.jpg&pid=hp&w=384&h=216&rs=1&c=4)2025-09-23 [download 4k](https://cn.bing.com/th?id=OHR.AspenEquinox_EN-US8237887036_UHD.jpg&rf=LaDigue_UHD.jpg&pid=hp&w=3840&h=2160&rs=1&c=4)|
|![](https://cn.bing.com/th?id=OHR.IceOtters_EN-US7982442590_UHD.jpg&pid=hp&w=384&h=216&rs=1&c=4)2025-09-22 [download 4k](https://cn.bing.com/th?id=OHR.IceOtters_EN-US7982442590_UHD.jpg&rf=LaDigue_UHD.jpg&pid=hp&w=3840&h=2160&rs=1&c=4)|![](https://cn.bing.com/th?id=OHR.OktoberfestSwing_EN-US7916182497_UHD.jpg&pid=hp&w=384&h=216&rs=1&c=4)2025-09-21 [download 4k](https://cn.bing.com/th?id=OHR.OktoberfestSwing_EN-US7916182497_UHD.jpg&rf=LaDigue_UHD.jpg&pid=hp&w=3840&h=2160&rs=1&c=4)|![](https://cn.bing.com/th?id=OHR.ThousandIslands_EN-US7884567746_UHD.jpg&pid=hp&w=384&h=216&rs=1&c=4)2025-09-20 [download 4k](https://cn.bing.com/th?id=OHR.ThousandIslands_EN-US7884567746_UHD.jpg&rf=LaDigue_UHD.jpg&pid=hp&w=3840&h=2160&rs=1&c=4)|

### 历史归档：
[2025-09](/picture/2025-09/) | [2025-08](/picture/2025-08/) | [2025-07](/picture/2025-07/) | [2025-06](/picture/2025-06/) | [2025-05](/picture/2025-05/) | [2025-04](/picture/2025-04/) | [2025-03](/picture/2025-03/) | [2025-02](/picture/2025-02/) | 
[2025-01](/picture/2025-01/) | [2024-12](/picture/2024-12/) | [2024-11](/picture/2024-11/) | [2024-10](/picture/2024-10/) | [2024-09](/picture/2024-09/) | [2024-08](/picture/2024-08/) | [2024-07](/picture/2024-07/) | [2024-06](/picture/2024-06/) | 
[2024-05](/picture/2024-05/) | [2024-04](/picture/2024-04/) | [2024-03](/picture/2024-03/) | [2024-02](/picture/2024-02/) | [2024-01](/picture/2024-01/) | [2023-12](/picture/2023-12/) | [2023-11](/picture/2023-11/) | [2023-10](/picture/2023-10/) | 
[2023-09](/picture/2023-09/) | [2023-08](/picture/2023-08/) | [2023-07](/picture/2023-07/) | [2023-06](/picture/2023-06/) | [2023-05](/picture/2023-05/) | [2023-04](/picture/2023-04/) | [2023-03](/picture/2023-03/) | [2023-02](/picture/2023-02/) | 
[2023-01](/picture/2023-01/) | [2022-12](/picture/2022-12/) | [2022-11](/picture/2022-11/) | [2022-10](/picture/2022-10/) | [2022-09](/picture/2022-09/) | [2022-08](/picture/2022-08/) | [2022-07](/picture/2022-07/) | [2022-06](/picture/2022-06/) | 
[2022-05](/picture/2022-05/) | [2022-04](/picture/2022-04/) | [2022-03](/picture/2022-03/) | [2022-02](/picture/2022-02/) | [2022-01](/picture/2022-01/) | [2021-12](/picture/2021-12/) | [2021-11](/picture/2021-11/) | [2021-10](/picture/2021-10/) | 
[2021-09](/picture/2021-09/) | [2021-08](/picture/2021-08/) | [2021-07](/picture/2021-07/) | [2021-06](/picture/2021-06/) | [2021-05](/picture/2021-05/) | [2021-04](/picture/2021-04/) | [2021-03](/picture/2021-03/) | [2021-02](/picture/2021-02/) |