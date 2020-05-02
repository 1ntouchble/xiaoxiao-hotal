package com.xiaoxiao.hotal.mapper;

import com.xiaoxiao.hotal.entity.ScheduleRoomInfo;
import com.xiaoxiao.hotal.entity.ScheduleRoomInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScheduleRoomInfoMapper {
    int countByExample(ScheduleRoomInfoExample example);

    int deleteByExample(ScheduleRoomInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ScheduleRoomInfo record);

    int insertSelective(ScheduleRoomInfo record);

    List<ScheduleRoomInfo> selectByExample(ScheduleRoomInfoExample example);

    ScheduleRoomInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ScheduleRoomInfo record, @Param("example") ScheduleRoomInfoExample example);

    int updateByExample(@Param("record") ScheduleRoomInfo record, @Param("example") ScheduleRoomInfoExample example);

    int updateByPrimaryKeySelective(ScheduleRoomInfo record);

    int updateByPrimaryKey(ScheduleRoomInfo record);
}