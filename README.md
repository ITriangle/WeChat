# WeChat
订阅号作为交互窗口,微信后台集成服务API

## 环境
用 ngrok 将内网映射到外网.

具体可以查看 好人博主(http://qydev.com/)

## API情况
目前集成了一下API:

1. 百度翻译API
2. 和风天气API

## 简单部署

1. nohup java -jar Application-0.0.1-SNAPSHOT.jar &
2. (./ngrok -config=ngrok.cfg -subdomain product 8081 &)