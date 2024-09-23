package com.chz.myMyBatisPlus.repository.impl;

import com.chz.myMyBatisPlus.entity.FXSpot;
import com.chz.myMyBatisPlus.persistence.mapper.FXSpotMapper;
import com.chz.myMyBatisPlus.repository.FXSpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FXSpotRepositoryImpl implements FXSpotRepository
{

    @Autowired
    private FXSpotMapper fxSpotMapper;

    @Override
    public void addFXSpot(FXSpot fxSpot)
    {
        fxSpotMapper.insert(fxSpot);
    }

    @Override
    public List<FXSpot> selectFXSpot(FXSpot fxSpot)
    {
        return fxSpotMapper.selectFXSpot(fxSpot);
    }

}
