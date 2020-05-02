package com.xiaoxiao.hotal.mapper;

import com.xiaoxiao.hotal.entity.HotalConstant;
import com.xiaoxiao.hotal.entity.HotalConstantExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HotalConstantMapper {
    int countByExample(HotalConstantExample example);

    int deleteByExample(HotalConstantExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HotalConstant record);

    int insertSelective(HotalConstant record);

    List<HotalConstant> selectByExample(HotalConstantExample example);

    HotalConstant selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HotalConstant record, @Param("example") HotalConstantExample example);

    int updateByExample(@Param("record") HotalConstant record, @Param("example") HotalConstantExample example);

    int updateByPrimaryKeySelective(HotalConstant record);

    int updateByPrimaryKey(HotalConstant record);
}