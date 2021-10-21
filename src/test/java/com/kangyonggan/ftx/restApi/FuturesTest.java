package com.kangyonggan.ftx.restApi;

import com.kangyonggan.ftx.AbstractTest;
import com.kangyonggan.ftx.model.Account;
import com.kangyonggan.ftx.model.Candle;
import com.kangyonggan.ftx.model.Futures;
import org.junit.Test;

/**
 * 期货
 *
 * @author kyg
 */
public class FuturesTest extends AbstractTest {

    /**
     * 获取历史行情
     */
    @Test
    public void historyCandles() {
        LOGGER.info("历史行情：{}", ftxClient.getList("/api/indexes/BTC/candles?resolution=15", Candle.class));
    }


    /**
     * 期货列表
     */
    @Test
    public void futures() {
        LOGGER.info("期货列表：{}", ftxClient.getList("/api/futures", Futures.class));
    }

}
