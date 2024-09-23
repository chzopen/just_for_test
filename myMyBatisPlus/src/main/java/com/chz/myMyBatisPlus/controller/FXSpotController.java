package com.chz.myMyBatisPlus.controller;

import com.chz.myMyBatisPlus.entity.FXSpot;
import com.chz.myMyBatisPlus.service.FXSpotService;
import com.chz.myMyBatisPlus.utils.DateTimeUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@RestController
@RequestMapping("/fxSpot")
public class FXSpotController {

    @Autowired
    private FXSpotService fxSpotService;

    @ApiImplicitParams({
            @ApiImplicitParam(name="currency1"),
            @ApiImplicitParam(name="currency2"),
            @ApiImplicitParam(name="labels")
    })
    @PostMapping("/addFXSpot")
    public String addFXSpot(@RequestParam(value = "currency1", required = true) String currency1,
                            @RequestParam(value = "currency2", required = true) String currency2,
                            @RequestParam(value = "fxRate", required = true) BigDecimal fxRate,
                            @RequestParam(value = "labels", required = false) String labels)
    {
        if( StringUtils.length(currency1)!=3 ){
            return "length of currency1 must be 3";
        }
        if( StringUtils.length(currency2)!=3 ){
            return "length of currency2 must be 3";
        }

        FXSpot fxSpot = new FXSpot();
        fxSpot.setId(ThreadLocalRandom.current().nextLong());
        fxSpot.setCurrency1(StringUtils.upperCase(currency1));
        fxSpot.setCurrency2(StringUtils.upperCase(currency2));
        fxSpot.setFxRate(fxRate);
        fxSpot.setDatetime(DateTimeUtils.toUTCZoned(LocalDateTime.now(), DateTimeUtils.getDefaultZoneId()));
        fxSpot.setLabels(labels);
        fxSpotService.addFXSpot(fxSpot);
        return "ok";
    }

    @GetMapping("/selectFXSpot")
    public List<FXSpot> selectFXSpot(@RequestParam(value = "currency1", required = true) String currency1,
                                     @RequestParam(value = "currency2", required = true) String currency2)
    {
        if( StringUtils.length(currency1)!=3 ){
            return new ArrayList<>();
        }
        if( StringUtils.length(currency2)!=3 ){
            return new ArrayList<>();
        }
        FXSpot fxSpot = new FXSpot();
        fxSpot.setCurrency1(StringUtils.upperCase(currency1));
        fxSpot.setCurrency2(StringUtils.upperCase(currency2));
        return fxSpotService.selectFXSpot(fxSpot);
    }

}

















