package com.xiaoxiao.hotal.mapper;

import com.xiaoxiao.hotal.entity.RoomPriceInfo;
import com.xiaoxiao.hotal.entity.RoomPriceInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoomPriceInfoMapper {
    int countByExample(RoomPriceInfoExample example);

    int deleteByExample(RoomPriceInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RoomPriceInfo record);

    int insertSelective(RoomPriceInfo record);

    List<RoomPriceInfo> selectByExample(RoomPriceInfoExample example);

    RoomPriceInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RoomPriceInfo record, @Param("example") RoomPriceInfoExample example);

    int updateByExample(@Param("record") RoomPriceInfo record, @Param("example") RoomPriceInfoExample example);

    int updateByPrimaryKeySelective(RoomPriceInfo record);

    int updateByPrimaryKey(RoomPriceInfo record);
}