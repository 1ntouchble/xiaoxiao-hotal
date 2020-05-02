package com.xiaoxiao.hotal.mapper;

import com.xiaoxiao.hotal.entity.RoomBizLog;
import com.xiaoxiao.hotal.entity.RoomBizLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoomBizLogMapper {
    int countByExample(RoomBizLogExample example);

    int deleteByExample(RoomBizLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RoomBizLog record);

    int insertSelective(RoomBizLog record);

    List<RoomBizLog> selectByExample(RoomBizLogExample example);

    RoomBizLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RoomBizLog record, @Param("example") RoomBizLogExample example);

    int updateByExample(@Param("record") RoomBizLog record, @Param("example") RoomBizLogExample example);

    int updateByPrimaryKeySelective(RoomBizLog record);

    int updateByPrimaryKey(RoomBizLog record);
}