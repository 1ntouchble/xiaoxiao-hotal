package com.xiaoxiao.hotal.manage.db.impl;

import com.xiaoxiao.hotal.entity.AccountUserExample;
import com.xiaoxiao.hotal.entity.CustomerInfo;
import com.xiaoxiao.hotal.entity.CustomerInfoExample;
import com.xiaoxiao.hotal.manage.db.UserManage;
import com.xiaoxiao.hotal.mapper.AccountUserMapper;
import com.xiaoxiao.hotal.mapper.CustomerInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhangtianqi
 * @since 2020-05-02 14:38
 */
@Component
public class UserManageImpl implements UserManage {

    @Autowired
    private CustomerInfoMapper mapper;

    @Override
    public List<CustomerInfo> selectUser(String customerName, String certNo, String phone) {
        CustomerInfoExample example = new CustomerInfoExample();
        CustomerInfoExample.Criteria criteria = example.createCriteria();
        criteria.andCustomerNameEqualTo(customerName);
        criteria.andCertNoEqualTo(certNo);
        criteria.andPhoneEqualTo(phone);
        return mapper.selectByExample(example);
    }
}
