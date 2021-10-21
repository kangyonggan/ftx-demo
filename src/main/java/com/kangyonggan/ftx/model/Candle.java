package com.kangyonggan.ftx.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author kyg
 */
@Data
public class Candle implements Serializable {
    private BigDecimal close;
    private BigDecimal high;
    private BigDecimal low;
    private BigDecimal open;
    private String startTime;
    private BigDecimal volume;
}
