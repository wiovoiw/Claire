import requests
import csv




f = open('18、Boss直聘.csv',mode='w',newline='',encoding='utf-8-sig')
w_header = csv.DictWriter(f, fieldnames=
['bossName', 'bossTitle', 'jobName', 'salaryDesc', 'jobLabels', 'skills', 'cityName', 'areaDistrict','businessDistrict','brandName','welfareList'])
w_header.writeheader()


def Get_boss(query):
    url = f'https://www.zhipin.com/wapi/zpgeek/search/joblist.json?scene=1&query=%E7%88%AC%E8%99%AB&city=100010000&experience=&payType=&partTime=&degree=&industry=&scale=&stage=&position=&jobType=&salary=&multiBusinessDistrict=&multiSubway=&page=1&pageSize=30'

    headers = {
    "Accept": "application/json, text/plain, */*",
    "Accept-Encoding": "gzip, deflate, br",
    "Accept-Language": "zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6",
    "Cache-Control": "no-cache",
    "Connection": "keep-alive",
    "Cookie": 'lastCity=101300500; wd_guid=ae417d4f-a733-4c16-b48a-10cfa3d797a4; historyState=state; _bl_uid=djlpbpsbjXdp3p3Uz2kO0qm1R9sa; __zp_seo_uuid__=d6b0c12c-5f2b-4194-838c-277ef80b97d7; Hm_lvt_194df3105ad7148dcf2b98a91b5e727a=1701257976,1701258299; Hm_lpvt_194df3105ad7148dcf2b98a91b5e727a=1701258299; __g=-; __l=r=https%3A%2F%2Fcn.bing.com%2F&l=%2Fwww.zhipin.com%2Fchengshi%2Fc101300500%2F&s=1&g=&s=3&friend_source=0; __zp_stoken__=6919fw4XDmsO9DzQNDg14Dmdia01kwrlpZmbCr3fCr3bCmGxSwqJQfVdhw4BrwqDCukp%2BwqJHwpdMwqhGwrnCsMO9bMKRwpTCv8K5w7zCu8KWxJLEgMKuwqLCk8KqwrXCnTcsAwYIBwQMEQ8QCwgFCg0OAwYIBwQCBwkGBTUxw7PDu8KYMzc8NClRTEoCTWBeQ19JBlhCQzc0BlkLAzQrMzQ3OMK7M8K5wqfCvjXCtsKkw4E4wrjDszQ%2FODXCuMOVIifCtcOLCMK0dAk7NMK3wqRYCQjDh19cF0XCtXgxOTbCt8S5OjgSQTM2Ojc0QDY4IjRFw4VcXRNJwrdMJzcTPjg3PTU2ODc7MzwkNz84JDg0Jz8JCQcMECc9wrhxwrjDljg3; __c=1701258299; __a=21643659.1701257976.1701257976.1701258299.8.2.3.8',
    "Host": "www.zhipin.com",
    "Pragma": "no-cache",
    "Referer": "https://www.zhipin.com/web/geek/job?query=%E7%88%AC%E8%99%AB&city=100010000",
    "sec-ch-ua": "\"Microsoft Edge\";v=\"199\", \"Chromium\";v=\"119\", \"Not?A_Brand\";v=\"24\"",
    "sec-ch-ua-mobile": "?0",
    "sec-ch-ua-platform": "\"Windows\"",
    "Sec-Fetch-Dest": "empty",
    "Sec-Fetch-Mode": "cors",
    "Sec-Fetch-Site": "same-origin",
    "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.0.0 Safari/537.36 Edg/109.0.1518.78",
    "X-Requested-With": "XMLHttpRequest"
}

    res = requests.get(url=url, headers=headers)
    json_data = res.json()
    # print(json_data)
    boss_list = json_data['zpData']['jobList']
    dit = {}
    for i in boss_list:
        # 招聘人
        dit['bossName'] = i['bossName']
        # 招聘人职位
        dit['bossTitle'] = i['bossTitle']
        # 工作岗位名称
        dit['jobName'] = i['jobName']
        # 薪资
        dit['salaryDesc'] = i['salaryDesc']
        # 要求
        dit['jobLabels'] = i['jobLabels']
        # 工作相关内容
        dit['skills'] = i['skills']
        # 详细地址
        dit['cityName'] = i['cityName']
        dit['areaDistrict'] = i['areaDistrict']
        dit['businessDistrict'] = i['businessDistrict']
        # 公司名称
        dit['brandName'] = i['brandName']
        # 福利
        dit['welfareList'] = i['welfareList']
        # print(dit)
        w_header.writerow(dit)
        print('岗位信息以保存完毕！')


Get_boss(query=input('请输入你想要查询的工作岗位:'))
