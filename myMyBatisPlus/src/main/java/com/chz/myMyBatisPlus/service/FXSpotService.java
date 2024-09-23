package com.chz.myMyBatisPlus.service;

import com.chz.myMyBatisPlus.entity.FXSpot;

import java.util.List;

public interface FXSpotService
{

    void addFXSpot(FXSpot fxSpot);

    List<FXSpot> selectFXSpot(FXSpot fxSpot);

}
