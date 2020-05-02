package com.xiaoxiao.hotal.mapper;

import com.xiaoxiao.hotal.entity.AccountUser;
import com.xiaoxiao.hotal.entity.AccountUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountUserMapper {
    int countByExample(AccountUserExample example);

    int deleteByExample(AccountUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AccountUser record);

    int insertSelective(AccountUser record);

    List<AccountUser> selectByExample(AccountUserExample example);

    AccountUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AccountUser record, @Param("example") AccountUserExample example);

    int updateByExample(@Param("record") AccountUser record, @Param("example") AccountUserExample example);

    int updateByPrimaryKeySelective(AccountUser record);

    int updateByPrimaryKey(AccountUser record);
}