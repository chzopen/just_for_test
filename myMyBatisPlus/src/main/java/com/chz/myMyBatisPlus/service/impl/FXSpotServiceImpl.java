package com.chz.myMyBatisPlus.service.impl;

import com.chz.myMyBatisPlus.entity.FXSpot;
import com.chz.myMyBatisPlus.repository.FXSpotRepository;
import com.chz.myMyBatisPlus.service.FXSpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FXSpotServiceImpl implements FXSpotService
{

    @Autowired
    private FXSpotRepository fxSpotRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addFXSpot(FXSpot fxSpot)
    {
        fxSpotRepository.addFXSpot(fxSpot);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<FXSpot> selectFXSpot(FXSpot fxSpot)
    {
        return fxSpotRepository.selectFXSpot(fxSpot);
    }

}
