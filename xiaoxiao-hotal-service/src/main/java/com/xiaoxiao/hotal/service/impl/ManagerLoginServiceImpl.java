package com.xiaoxiao.hotal.service.impl;

import com.xiaoxiao.hotal.core.error.ErrorEnum;
import com.xiaoxiao.hotal.core.exception.HotalBusinessException;
import com.xiaoxiao.hotal.entity.AccountUser;
import com.xiaoxiao.hotal.manage.cache.ReidsManage;
import com.xiaoxiao.hotal.manage.db.AccountManage;
import com.xiaoxiao.hotal.service.LoginService;
import com.xiaoxiao.hotal.util.MD5Util;
import com.xiaoxiao.hotal.util.UuidUtil;
import com.xiaoxiao.hotal.vo.request.LoginReq;
import com.xiaoxiao.hotal.vo.request.UpdateUserReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @author zhangtianqi
 * @since 2020-04-30 23:21
 */
@Service
public class ManagerLoginServiceImpl implements LoginService {

    @Autowired
    private AccountManage accountManage;

    @Autowired
    private ReidsManage reidsManage;


    @Override
    public String login(LoginReq req) {
        String encyptPassword = MD5Util.getMD5String(req.getPassword());
        Boolean isExist = accountManage.checkIsExist(req.getUserName(),encyptPassword);
        if(!isExist){
            throw new HotalBusinessException(ErrorEnum.LOGIN_ERROR.getCode(),ErrorEnum.LOGIN_ERROR.getMessage());
        }

        String token = UuidUtil.getUuid();
        reidsManage.setForTimeMIN(token,req.getUserName(),30L);
        return token;
    }

    @Override
    public void addUser(LoginReq req) {
        String userName = req.getUserName();
        String encyptPassword = MD5Util.getMD5String(req.getPassword());
        Boolean userNameExist = accountManage.checkNameExist(userName);
        if(!userNameExist){
            accountManage.add(userName,encyptPassword);
            return;
        }
        throw new HotalBusinessException(ErrorEnum.USER_REPEAT.getCode(),ErrorEnum.USER_REPEAT.getMessage());
    }

    @Override
    public void updateUser(UpdateUserReq req) {
        String encyptPassword = MD5Util.getMD5String(req.getPassword());
        String encyptNewPassword = MD5Util.getMD5String(req.getNewPassword());
        accountManage.update(req.getUserName(),encyptPassword,encyptNewPassword);
    }


}
