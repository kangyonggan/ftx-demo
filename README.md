# FTX接口示例Java版

## 准备工作
- Jdk1.8
- Maven
- Git

## 配置
- FTX的apiKey
- FTX的apiSecretKey

## 示例功能
1. 通过ws订阅最新K线、盘口、最新成交。[WebsocketTest.java](https://github.com/kangyonggan/ftx-demo/blob/master/src/test/java/com/kangyonggan/ftx/websocket/WebsocketTest.java)
2. 通过rest api获取历史K线数据。[FuturesTest.java](https://github.com/kangyonggan/ftx-demo/blob/master/src/test/java/com/kangyonggan/ftx/restApi/FuturesTest.java)
3. 获取账户信息。[AccountTest.java](https://github.com/kangyonggan/ftx-demo/blob/master/src/test/java/com/kangyonggan/ftx/restApi/AccountTest.java)
4. 下单、撤销订单、查询订单。[OrderTest.java](https://github.com/kangyonggan/ftx-demo/blob/master/src/test/java/com/kangyonggan/ftx/restApi/OrderTest.java)

## 官方文档
[https://docs.ftx.com/#overview](https://docs.ftx.com/#overview)



