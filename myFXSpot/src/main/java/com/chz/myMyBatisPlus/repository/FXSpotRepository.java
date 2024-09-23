package com.chz.myMyBatisPlus.repository;

import com.chz.myMyBatisPlus.entity.FXSpot;

import java.util.List;

public interface FXSpotRepository
{
    void addFXSpot(FXSpot fxSpot);

    List<FXSpot> selectFXSpot(FXSpot fxSpot);

}
