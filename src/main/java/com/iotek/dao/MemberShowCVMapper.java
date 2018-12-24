package com.iotek.dao;

import com.iotek.model.MemberShowCV;
import com.iotek.model.MemberShowCVExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberShowCVMapper {
    int countByExample(MemberShowCVExample example);

    int deleteByExample(MemberShowCVExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MemberShowCV record);

    int insertSelective(MemberShowCV record);

    List<MemberShowCV> selectByExample(MemberShowCVExample example);

    MemberShowCV selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MemberShowCV record, @Param("example") MemberShowCVExample example);

    int updateByExample(@Param("record") MemberShowCV record, @Param("example") MemberShowCVExample example);

    int updateByPrimaryKeySelective(MemberShowCV record);

    int updateByPrimaryKey(MemberShowCV record);
}