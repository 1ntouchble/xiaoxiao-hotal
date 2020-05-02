package com.xiaoxiao.hotal.vo.request;

/**
 * @author zhangtianqi
 * @since 2020-05-01 16:55
 */
public class RoomListReq {

    private Integer roomType;

    private String userName;

    private String phone;

    private String roomStatus;


    @Override
    public String toString() {
        return "RoomListReq{" +
                "roomType=" + roomType +
                ", userName='" + userName + '\'' +
                ", phone='" + phone + '\'' +
                ", roomStatus='" + roomStatus + '\'' +
                '}';
    }
}
