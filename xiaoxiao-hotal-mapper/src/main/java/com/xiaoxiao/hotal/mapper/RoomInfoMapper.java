package com.xiaoxiao.hotal.mapper;

import com.xiaoxiao.hotal.entity.RoomInfo;
import com.xiaoxiao.hotal.entity.RoomInfoExample;
import com.xiaoxiao.hotal.pojo.RoomListPojo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RoomInfoMapper {
    int countByExample(RoomInfoExample example);

    int deleteByExample(RoomInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RoomInfo record);

    int insertSelective(RoomInfo record);

    List<RoomInfo> selectByExample(RoomInfoExample example);

    RoomInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RoomInfo record, @Param("example") RoomInfoExample example);

    int updateByExample(@Param("record") RoomInfo record, @Param("example") RoomInfoExample example);

    int updateByPrimaryKeySelective(RoomInfo record);

    int updateByPrimaryKey(RoomInfo record);

    int insertAndReturnId(RoomInfo recore);

    List<RoomListPojo> getRoomPage(Map<String,Object> params);
}