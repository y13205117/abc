package com.iotek.dao;

import com.iotek.model.Vitae;
import com.iotek.model.VitaeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VitaeMapper {
    int countByExample(VitaeExample example);

    int deleteByExample(VitaeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Vitae record);

    int insertSelective(Vitae record);

    List<Vitae> selectByExample(VitaeExample example);

    Vitae selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Vitae record, @Param("example") VitaeExample example);

    int updateByExample(@Param("record") Vitae record, @Param("example") VitaeExample example);

    int updateByPrimaryKeySelective(Vitae record);

    int updateByPrimaryKey(Vitae record);
}