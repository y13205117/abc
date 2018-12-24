package com.iotek.dao;

import com.iotek.model.AwardRecord;
import com.iotek.model.AwardRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AwardRecordMapper {
    int countByExample(AwardRecordExample example);

    int deleteByExample(AwardRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AwardRecord record);

    int insertSelective(AwardRecord record);

    List<AwardRecord> selectByExample(AwardRecordExample example);

    AwardRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AwardRecord record, @Param("example") AwardRecordExample example);

    int updateByExample(@Param("record") AwardRecord record, @Param("example") AwardRecordExample example);

    int updateByPrimaryKeySelective(AwardRecord record);

    int updateByPrimaryKey(AwardRecord record);
}