package com.xiaoxiao.hotal.controller;

import com.xiaoxiao.hotal.service.LoginService;
import com.xiaoxiao.hotal.vo.request.LoginReq;
import com.xiaoxiao.hotal.vo.request.UpdateUserReq;
import com.xiaoxiao.hotal.vo.response.BaseStrResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangtianqi
 * @since 2020-04-30 22:53
 */
@RequestMapping("/api/account")
@RestController
public class AccountLoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping("/login")
    public BaseStrResp login(@RequestBody LoginReq req){
        String token = loginService.login(req);
        BaseStrResp baseStrResp = new BaseStrResp();
        baseStrResp.setString(token);
        return baseStrResp;
    }

    @RequestMapping("/addUser")
    public void addOrUpdateUser(@RequestBody LoginReq req){
        loginService.addUser(req);
    }

    @RequestMapping("/updateUserPassword")
    public void updateUser(@RequestBody UpdateUserReq req){
        loginService.updateUser(req);
    }
}
