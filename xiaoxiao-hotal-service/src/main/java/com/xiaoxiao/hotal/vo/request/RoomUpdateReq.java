package com.xiaoxiao.hotal.vo.request;

/**
 * @author zhangtianqi
 * @since 2020-05-01 21:06
 */
public class RoomUpdateReq extends RoomAddReq {

    private String roomId;

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return "RoomUpdateReq{" +
                "roomId='" + roomId + '\'' +
                '}';
    }
}
