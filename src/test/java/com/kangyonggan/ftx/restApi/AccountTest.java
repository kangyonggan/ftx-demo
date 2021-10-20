package com.kangyonggan.ftx.restApi;

import com.kangyonggan.ftx.AbstractTest;
import com.kangyonggan.ftx.model.Account;
import org.junit.Test;

/**
 * @author kyg
 */
public class AccountTest extends AbstractTest {

    /**
     * 获取账户信息
     */
    @Test
    public void account() {
        LOGGER.info("账户信息：{}", ftxClient.get("/api/account", Account.class));
    }

}
