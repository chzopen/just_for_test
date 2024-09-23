package com.chz.myMyBatisPlus.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.chz.myMyBatisPlus.typeHandler.ZonedDateTimeTypeHandler;
import lombok.Data;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Data
@TableName("fx_spot")
public class FXSpot {

    private Long id;
    private String currency1;
    private String currency2;
    private BigDecimal fxRate;

    @TableField(typeHandler= ZonedDateTimeTypeHandler.class)
    private ZonedDateTime datetime;
    private String labels;

}
