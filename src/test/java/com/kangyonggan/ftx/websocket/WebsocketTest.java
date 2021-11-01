package com.kangyonggan.ftx.websocket;

import com.alibaba.fastjson.JSONObject;
import com.kangyonggan.ftx.AbstractTest;
import com.kangyonggan.ftx.components.FtxProperties;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URI;
import java.nio.ByteBuffer;

/**
 * @author kyg
 */
public class WebsocketTest extends AbstractTest {

    @Autowired
    private FtxProperties properties;

    private WebSocketClient wsClient;

    @Test
    public void testConnect() throws Exception {
        wsClient = new WebSocketClient(new URI(properties.getWsUrl())) {
            @Override
            public void onOpen(ServerHandshake e) {
                LOGGER.info("connectWs连接成功");

                // 保持心跳
                new Thread(() -> {
                    while (true) {
                        try {
                            // 每隔15s发送一次心跳，如果60s不发送心跳就会被断开
                            Thread.sleep(15000);
                            JSONObject params = new JSONObject();
                            params.put("op", "ping");
                            sendMsg(params);
                        } catch (Exception ex) {
                            LOGGER.error("维持心跳异常", ex);
                        }
                    }
                }).start();

                // 订阅一分钟K线
                JSONObject params = new JSONObject();
                // subscribe: 订阅，unsubscribe：取消订阅
                params.put("op", "subscribe");
                // orderbook：盘口，trades：最新成交，ticker：最新价
                params.put("channel", "ticker");
                params.put("market", "BTC-PERP");
                sendMsg(params);

                // 订阅盘口
                params = new JSONObject();
                // subscribe: 订阅，unsubscribe：取消订阅
                params.put("op", "subscribe");
                // orderbook：盘口，trades：最新成交，ticker：最新价
                params.put("channel", "orderbook");
                params.put("market", "BTC-PERP");
                sendMsg(params);

                // 订阅最新成交
                params = new JSONObject();
                // subscribe: 订阅，unsubscribe：取消订阅
                params.put("op", "subscribe");
                // orderbook：盘口，trades：最新成交，ticker：最新价
                params.put("channel", "trades");
                params.put("market", "BTC-PERP");
                sendMsg(params);
            }

            @Override
            public void onMessage(String msg) {
                LOGGER.info("connectWs收到字符串消息：{}", msg);
            }

            @Override
            public void onError(Exception e) {
                LOGGER.error("connectWs发生错误已关闭", e);
            }

            @Override
            public void onClose(int arg0, String arg1, boolean arg2) {
                LOGGER.info("connectWs链接已关闭");
            }

            @Override
            public void onMessage(ByteBuffer bytes) {
                LOGGER.info("connectWs收到字节消息：{}", bytes);
            }
        };
        wsClient.connect();
        System.in.read();
    }

    /**
     * 向ws服务端发送消息
     *
     * @param params
     */
    private void sendMsg(JSONObject params) {
        LOGGER.info("send:{}", params);
        wsClient.send(params.toJSONString());
    }

}
