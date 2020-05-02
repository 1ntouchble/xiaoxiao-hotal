package com.xiaoxiao.hotal.vo.request;

/**
 * @author zhangtianqi
 * @since 2020-05-01 21:56
 */
public class UpdateUserReq extends LoginReq{

    private String newPassword ;

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }


    @Override
    public String toString() {
        return "UpdateUserReq{" +
                "newPassword='" + newPassword + '\'' +
                '}';
    }
}
