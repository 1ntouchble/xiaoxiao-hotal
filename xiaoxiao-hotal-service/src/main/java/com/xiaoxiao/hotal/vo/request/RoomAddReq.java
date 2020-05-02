package com.xiaoxiao.hotal.vo.request;

/**
 * @author zhangtianqi
 * @since 2020-05-01 21:00
 */
public class RoomAddReq {

    private Integer roomType;

    private Integer roomNum;

    public void setRoomType(Integer roomType) {
        this.roomType = roomType;
    }

    public void setRoomNum(Integer roomNum) {
        this.roomNum = roomNum;
    }


    public Integer getRoomType() {
        return roomType;
    }

    public Integer getRoomNum() {
        return roomNum;
    }


    @Override
    public String toString() {
        return "RoomAddReq{" +
                "roomType=" + roomType +
                ", roomNum=" + roomNum +
                ""+
                '}';
    }
}
