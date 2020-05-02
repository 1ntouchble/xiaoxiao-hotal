package com.xiaoxiao.hotal.service;

import com.xiaoxiao.hotal.vo.request.LoginReq;
import com.xiaoxiao.hotal.vo.request.UpdateUserReq;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author zhangtianqi
 * @since 2020-04-30 23:21
 */
public interface LoginService {

    String login(LoginReq loginReq);

    void addUser(LoginReq req);

    void updateUser(UpdateUserReq req);
}
