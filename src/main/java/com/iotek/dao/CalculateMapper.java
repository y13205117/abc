package com.iotek.dao;

import com.iotek.model.Calculate;
import com.iotek.model.CalculateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CalculateMapper {
    int countByExample(CalculateExample example);

    int deleteByExample(CalculateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Calculate record);

    int insertSelective(Calculate record);

    List<Calculate> selectByExample(CalculateExample example);

    Calculate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Calculate record, @Param("example") CalculateExample example);

    int updateByExample(@Param("record") Calculate record, @Param("example") CalculateExample example);

    int updateByPrimaryKeySelective(Calculate record);

    int updateByPrimaryKey(Calculate record);
}