package com.xiaoxiao.hotal.mapper;

import com.xiaoxiao.hotal.entity.RoomStateInfo;
import com.xiaoxiao.hotal.entity.RoomStateInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoomStateInfoMapper {
    int countByExample(RoomStateInfoExample example);

    int deleteByExample(RoomStateInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RoomStateInfo record);

    int insertSelective(RoomStateInfo record);

    List<RoomStateInfo> selectByExample(RoomStateInfoExample example);

    RoomStateInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RoomStateInfo record, @Param("example") RoomStateInfoExample example);

    int updateByExample(@Param("record") RoomStateInfo record, @Param("example") RoomStateInfoExample example);

    int updateByPrimaryKeySelective(RoomStateInfo record);

    int updateByPrimaryKey(RoomStateInfo record);
}