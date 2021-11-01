package com.kangyonggan.ftx.model;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author kyg
 */
@Data
public class Tick implements Serializable {

    private BigDecimal high;
    private BigDecimal open;
    private BigDecimal close;
    private BigDecimal low;
    private BigDecimal volume;
    private String startTime;

}
