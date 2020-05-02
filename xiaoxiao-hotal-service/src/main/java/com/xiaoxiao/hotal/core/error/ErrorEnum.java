package com.xiaoxiao.hotal.core.error;

import com.xiaoxiao.hotal.core.exception.ErrorInfoInterface;

public enum ErrorEnum implements ErrorInfoInterface {

    DB_INSERT_ERROR ( "XXDB01" , "DB插入异常" ) ,
    DB_UPDATE_ERROR ( "XXDB02" , "DB修改异常" ) ,
    DB_DELETE_ERROR ( "XXDB03" , "DB删除异常" ) ,
    FILE_READ_ERROR ( "XXDB04" , "文件读写异常" ),


    USER_REPEAT("XXUS01","用户已存在"),
    PASSWORD_ERROR("XXUS02","密码输入错误"),
    LOGIN_ERROR("XXLG01","账号/密码输入有误");


    private String code;
    private String message;


    ErrorEnum( String code , String message ) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

}