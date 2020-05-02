package com.xiaoxiao.hotal.manage.db.impl;

import com.xiaoxiao.hotal.core.error.ErrorEnum;
import com.xiaoxiao.hotal.core.exception.HotalBusinessException;
import com.xiaoxiao.hotal.entity.AccountUser;
import com.xiaoxiao.hotal.entity.AccountUserExample;
import com.xiaoxiao.hotal.manage.db.AccountManage;
import com.xiaoxiao.hotal.mapper.AccountUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @author zhangtianqi
 * @since 2020-04-30 23:27
 */
@Component
public class AccountManageImpl implements AccountManage {

    @Autowired
    private AccountUserMapper mapper;

    @Override
    public boolean checkIsExist(String userName, String password) {
        List<AccountUser> accountUserList = getAccountUsers(userName,password);
        if(CollectionUtils.isEmpty(accountUserList)){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public List<AccountUser> getAccountUsers(String userName, String password) {
        AccountUserExample example = new AccountUserExample();
        AccountUserExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(userName);
        criteria.andPasswordEqualTo(password);
        return mapper.selectByExample(example);
    }

    @Override
    public void add(String userName, String password) {
        AccountUser accountUser = new AccountUser();
        accountUser.setIsDeleted(Boolean.FALSE);
        accountUser.setCreatedDate(new Date());
        accountUser.setUserName(userName);
        accountUser.setPassword(password);
        int count = mapper.insert(accountUser);
        if(count==0){
            throw new HotalBusinessException(ErrorEnum.DB_INSERT_ERROR.getCode(),ErrorEnum.DB_INSERT_ERROR.getMessage());
        }
    }

    @Override
    public void update(String userName,String encyptOldPassword,String encyptNewPassword) {

        AccountUserExample example = new AccountUserExample();
        AccountUserExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(userName);
        Boolean isExist = checkIsExist(userName,encyptOldPassword);
        if(isExist){
            AccountUser accountUser = new AccountUser();
            accountUser.setPassword(encyptNewPassword);
            AccountUserExample updateExample = new AccountUserExample();
            AccountUserExample.Criteria updateUserCriteria = updateExample.createCriteria();
            updateUserCriteria.andUserNameEqualTo(userName);
            mapper.updateByExampleSelective(accountUser,updateExample);
        }
        throw new HotalBusinessException(ErrorEnum.PASSWORD_ERROR.getCode(),ErrorEnum.PASSWORD_ERROR.getMessage());
    }

    @Override
    public boolean checkNameExist(String userName) {
        AccountUserExample example = new AccountUserExample();
        AccountUserExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(userName);
        List<AccountUser> accountUserList = mapper.selectByExample(example);
        if(CollectionUtils.isEmpty(accountUserList)){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
