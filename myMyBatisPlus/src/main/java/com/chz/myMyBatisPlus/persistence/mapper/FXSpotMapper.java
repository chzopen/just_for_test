package com.chz.myMyBatisPlus.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chz.myMyBatisPlus.entity.FXSpot;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FXSpotMapper extends BaseMapper<FXSpot>
{

    List<FXSpot> selectFXSpot(@Param("fxSpot") FXSpot fxSpot);

}