package com.xiaoxiao.hotal.manage.db;

import com.xiaoxiao.hotal.entity.CustomerInfo;

import java.util.List;

/**
 * @author zhangtianqi
 * @since 2020-05-02 14:38
 */
public interface UserManage {

    List<CustomerInfo> selectUser(String customerName,String certNo,String phone);
}
