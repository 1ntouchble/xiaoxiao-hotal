package com.xiaoxiao.hotal.mapper;

import com.xiaoxiao.hotal.entity.CustomerInfo;
import com.xiaoxiao.hotal.entity.CustomerInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerInfoMapper {
    int countByExample(CustomerInfoExample example);

    int deleteByExample(CustomerInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CustomerInfo record);

    int insertSelective(CustomerInfo record);

    List<CustomerInfo> selectByExample(CustomerInfoExample example);

    CustomerInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CustomerInfo record, @Param("example") CustomerInfoExample example);

    int updateByExample(@Param("record") CustomerInfo record, @Param("example") CustomerInfoExample example);

    int updateByPrimaryKeySelective(CustomerInfo record);

    int updateByPrimaryKey(CustomerInfo record);
}