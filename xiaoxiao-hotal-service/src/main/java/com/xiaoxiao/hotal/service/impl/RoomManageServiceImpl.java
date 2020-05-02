package com.xiaoxiao.hotal.service.impl;

import com.xiaoxiao.hotal.entity.RoomInfo;
import com.xiaoxiao.hotal.entity.RoomStateInfo;
import com.xiaoxiao.hotal.manage.db.RoomInfoManage;
import com.xiaoxiao.hotal.manage.db.RoomPriceManage;
import com.xiaoxiao.hotal.manage.db.RoomStateInfoManage;
import com.xiaoxiao.hotal.service.RoomManageService;
import com.xiaoxiao.hotal.vo.request.RoomAddReq;
import com.xiaoxiao.hotal.vo.request.UpdateRoomPriceReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhangtianqi
 * @since 2020-05-01 21:12
 */
@Service
public class RoomManageServiceImpl implements RoomManageService {

    @Autowired
    private RoomInfoManage roomInfoManage;

    @Autowired
    private RoomPriceManage roomPriceManage;

    @Autowired
    private RoomStateInfoManage roomStateInfoManage;

    @Override
    public void addRoom(RoomAddReq req) {
        RoomInfo roomInfo = new RoomInfo();
        roomInfo.setRoomNumber(req.getRoomNum());
        roomInfo.setRoomType(req.getRoomType());
        Integer roomId = roomInfoManage.insert(roomInfo);
        RoomStateInfo stateInfo = new RoomStateInfo();
        stateInfo.setRoomId(roomId);
        roomStateInfoManage.insert(stateInfo);
    }

    @Override
    public void updateRoom(RoomAddReq req) {

    }

    @Override
    public void addOrUpdateUpdatePrice(UpdateRoomPriceReq updateRoomPriceReq) {

    }
}
