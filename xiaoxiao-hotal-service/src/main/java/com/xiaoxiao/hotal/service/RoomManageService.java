package com.xiaoxiao.hotal.service;

import com.xiaoxiao.hotal.vo.request.RoomAddReq;
import com.xiaoxiao.hotal.vo.request.UpdateRoomPriceReq;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author zhangtianqi
 * @since 2020-05-01 21:11
 */
public interface RoomManageService {

    void addRoom(RoomAddReq req);

    void updateRoom(RoomAddReq req);

    void addOrUpdateUpdatePrice(UpdateRoomPriceReq updateRoomPriceReq);
}
