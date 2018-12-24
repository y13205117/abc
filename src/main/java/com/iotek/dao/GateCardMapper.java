package com.iotek.dao;

import com.iotek.model.GateCard;
import com.iotek.model.GateCardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GateCardMapper {
    int countByExample(GateCardExample example);

    int deleteByExample(GateCardExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GateCard record);

    int insertSelective(GateCard record);

    List<GateCard> selectByExample(GateCardExample example);

    GateCard selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GateCard record, @Param("example") GateCardExample example);

    int updateByExample(@Param("record") GateCard record, @Param("example") GateCardExample example);

    int updateByPrimaryKeySelective(GateCard record);

    int updateByPrimaryKey(GateCard record);
}