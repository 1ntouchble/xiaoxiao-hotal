package com.xiaoxiao.hotal.service;

import com.xiaoxiao.hotal.entity.CustomerInfo;

/**
 * @author zhangtianqi
 * @since 2020-04-30 23:23
 */
public interface UserService {

    Integer checkAndInsert(CustomerInfo customerInfo);
}
