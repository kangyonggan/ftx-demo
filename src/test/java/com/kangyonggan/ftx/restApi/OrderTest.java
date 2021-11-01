package com.kangyonggan.ftx.restApi;

import com.alibaba.fastjson.JSONObject;
import com.kangyonggan.ftx.AbstractTest;
import com.kangyonggan.ftx.components.FtxClient;
import com.kangyonggan.ftx.model.CreateOrderRes;
import com.kangyonggan.ftx.model.Order;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * @author kyg
 */
public class OrderTest extends AbstractTest {

    @Autowired
    private FtxClient ftxClient;

    /**
     * 下单
     */
    @Test
    public void createOrder() {
        JSONObject params = new JSONObject();
        params.put("market", "BTC-PERP");
        params.put("side", "buy");
        params.put("type", "limit");
        params.put("price", BigDecimal.valueOf(50000));
        params.put("size", BigDecimal.ONE);
        params.put("reduceOnly", false);
        params.put("ioc", false);
        params.put("postOnly", false);
        params.put("clientId", String.valueOf(System.currentTimeMillis()));

        LOGGER.info("createOrder:{}", ftxClient.post("/api/orders", params.toJSONString(), CreateOrderRes.class));
    }

    /**
     * openOrders
     */
    @Test
    public void getOpenOrder() {
        LOGGER.info("openOrders:{}", ftxClient.getList("/api/orders", Order.class));
    }

    /**
     * historyOrders
     */
    @Test
    public void getHistoryOrder() {
        LOGGER.info("historyOrders:{}", ftxClient.getList("/api/orders/history", Order.class));
    }

    /**
     * cancelOrder
     */
    @Test
    public void cancelOrderByOrderId() {
        String orderId = "O123123121323123";
        ftxClient.delete("/api/orders/" + orderId);
    }

    /**
     * cancelOrder
     */
    @Test
    public void cancelOrderByClientId() {
        String clientOrderId = "O123123121323123";
        ftxClient.delete("/api/orders/by_client_id/" + clientOrderId);
    }

}
