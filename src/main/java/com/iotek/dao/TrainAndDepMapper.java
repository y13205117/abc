package com.iotek.dao;

import com.iotek.model.TrainAndDep;
import com.iotek.model.TrainAndDepExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TrainAndDepMapper {
    int countByExample(TrainAndDepExample example);

    int deleteByExample(TrainAndDepExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TrainAndDep record);

    int insertSelective(TrainAndDep record);

    List<TrainAndDep> selectByExample(TrainAndDepExample example);

    TrainAndDep selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TrainAndDep record, @Param("example") TrainAndDepExample example);

    int updateByExample(@Param("record") TrainAndDep record, @Param("example") TrainAndDepExample example);

    int updateByPrimaryKeySelective(TrainAndDep record);

    int updateByPrimaryKey(TrainAndDep record);
}