package com.xiaoxiao.hotal.manage.db;

import com.xiaoxiao.hotal.entity.CustomerInfo;

/**
 * @author zhangtianqi
 * @since 2020-05-04 11:25
 */
public interface CustomerInfoManage {

    Integer getCustomerLastId(CustomerInfo customerInfo);
}
