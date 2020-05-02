package com.xiaoxiao.hotal.service.impl;

import com.xiaoxiao.hotal.entity.CustomerInfo;
import com.xiaoxiao.hotal.manage.db.UserManage;
import com.xiaoxiao.hotal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author zhangtianqi
 * @since 2020-04-30 23:23
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserManage userManage;

    @Override
    public Integer checkAndInsert(CustomerInfo customerInfo) {
        List<CustomerInfo> customerInfos = userManage.selectUser(customerInfo.getCustomerName(),customerInfo.getCertNo(),customerInfo.getPhone());
        if(CollectionUtils.isEmpty(customerInfos)){

        }
        return customerInfos.get(0).getId();
    }
}
