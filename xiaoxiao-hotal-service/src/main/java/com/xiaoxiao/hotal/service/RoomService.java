package com.xiaoxiao.hotal.service;

import com.xiaoxiao.hotal.vo.request.BookRoomReq;
import com.xiaoxiao.hotal.vo.request.RoomListReq;
import com.xiaoxiao.hotal.vo.response.RoomListResp;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author zhangtianqi
 * @since 2020-05-01 16:48
 */
public interface RoomService {

    List<RoomListResp> getRoomList(RoomListReq req);

    void bookRoom(BookRoomReq req);
}
