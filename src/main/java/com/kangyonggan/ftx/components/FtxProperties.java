package com.kangyonggan.ftx.components;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author kyg
 */
@Component
@ConfigurationProperties(prefix = "ftx")
@Data
public class FtxProperties {

    private String host;
    private String wsUrl;
    private String apiKey;
    private String apiSecretKey;

}
