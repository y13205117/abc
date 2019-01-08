package com.iotek.dao;

import com.iotek.model.TrainAndEmp;
import com.iotek.model.TrainAndEmpExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TrainAndEmpMapper {
    int countByExample(TrainAndEmpExample example);

    int deleteByExample(TrainAndEmpExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TrainAndEmp record);

    int insertSelective(TrainAndEmp record);

    List<TrainAndEmp> selectByExample(TrainAndEmpExample example);

    TrainAndEmp selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TrainAndEmp record, @Param("example") TrainAndEmpExample example);

    int updateByExample(@Param("record") TrainAndEmp record, @Param("example") TrainAndEmpExample example);

    int updateByPrimaryKeySelective(TrainAndEmp record);

    int updateByPrimaryKey(TrainAndEmp record);
}