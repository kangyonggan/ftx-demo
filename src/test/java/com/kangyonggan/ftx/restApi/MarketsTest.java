package com.kangyonggan.ftx.restApi;

import com.kangyonggan.ftx.AbstractTest;
import com.kangyonggan.ftx.components.FtxClient;
import com.kangyonggan.ftx.model.Tick;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author kyg
 */
public class MarketsTest extends AbstractTest {

    @Autowired
    private FtxClient ftxClient;

    /**
     * 获取历史K线
     */
    @Test
    public void getHistoryKLine() {
        String marketName = "BTC-PERP";
        // 条数。options: 15, 60, 300, 900, 3600, 14400, 86400, or any multiple of 86400 up to 30*86400
        int size = 300;

        List<Tick> historyTicks = ftxClient.getList("/api/markets/" + marketName + "/candles?resolution=" + size, Tick.class);
        LOGGER.info("历史K线：{}", historyTicks);
    }

}
