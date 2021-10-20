package com.kangyonggan.ftx.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author kyg
 */
@Data
public class Position implements Serializable {

    private BigDecimal cost;
    private BigDecimal entryPrice;
    private String future;
    private BigDecimal initialMarginRequirement;
    private BigDecimal longOrderSize;
    private BigDecimal maintenanceMarginRequirement;
    private BigDecimal netSize;
    private BigDecimal openSize;
    private BigDecimal realizedPnl;
    private BigDecimal shortOrderSize;
    private String side;
    private BigDecimal size;
    private BigDecimal unrealizedPnl;

}
