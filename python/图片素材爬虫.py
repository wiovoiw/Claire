import os
import requests
from bs4 import BeautifulSoup
from urllib.parse import urljoin

def download_images(url):
    # 发送 GET 请求获取网页内容
    response = requests.get(url)
    # 使用 BeautifulSoup 解析网页内容
    soup = BeautifulSoup(response.text, "html.parser")

    # 创建保存图片的目录
    os.makedirs("img", exist_ok=True)

    # 获取所有的 <img> 标签
    img_tags = soup.find_all("img")

    # 遍历每个 <img> 标签，下载并保存图片
    for img_tag in img_tags:
        # 获取图片的 URL
        img_url = urljoin(url, img_tag["src"])
        # 发送 GET 请求下载图片
        img_response = requests.get(img_url)
        # 提取图片文件名
        img_filename = os.path.basename(img_url)
        # 拼接保存路径
        save_path = os.path.join("img", img_filename)
        # 保存图片到本地
        with open(save_path, "wb") as img_file:
            img_file.write(img_response.content)
            print(f"Downloaded image: {img_filename}")

# 指定要爬取的网页 URL
url = "https://www.canva.cn/design/DAF1oO3Sews/2dHHN4rh7s7Lxefda1aAnA/edit"
# 调用函数开始下载图片
download_images(url)
