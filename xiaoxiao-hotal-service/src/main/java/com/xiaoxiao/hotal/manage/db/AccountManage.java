package com.xiaoxiao.hotal.manage.db;

import com.xiaoxiao.hotal.entity.AccountUser;
import com.xiaoxiao.hotal.vo.request.UpdateUserReq;

import java.util.List;

/**
 * @author zhangtianqi
 * @since 2020-04-30 23:27
 */
public interface AccountManage {

    boolean checkIsExist(String userName,String password);

    List<AccountUser> getAccountUsers(String userName, String password);

    void add(String userName,String password);

    void update(String userName,String encyptOldPassword,String encyptNewPassword);

    boolean checkNameExist(String userName);
}
