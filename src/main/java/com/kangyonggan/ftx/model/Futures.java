package com.kangyonggan.ftx.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author kyg
 */
@Data
public class Futures implements Serializable {

    private Integer ask;
    private BigDecimal bid;
    private Integer change1h;
    private Integer change24h;
    private Integer changeBod;
    private BigDecimal volumeUsd24h;
    private BigDecimal volume;
    private String description;
    private Boolean enabled;
    private Boolean expired;
    private String expiry;
    private BigDecimal index;
    private BigDecimal imfFactor;
    private BigDecimal last;
    private BigDecimal lowerBound;
    private BigDecimal mark;
    private String name;
    private BigDecimal openInterest;
    private BigDecimal openInterestUsd;
    private Boolean perpetual;
    private BigDecimal positionLimitWeight;
    private Boolean postOnly;
    private BigDecimal priceIncrement;
    private BigDecimal sizeIncrement;
    private String underlying;
    private BigDecimal upperBound;
    private String type;

}
