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
        //fixme 查询数据库中是否已经存在这个roomNumer的数据，如果有，就throw new HotalException

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
        //fixme 修改customerId啥的，修改状态

    }

    @Override
    public void addOrUpdateUpdatePrice(UpdateRoomPriceReq updateRoomPriceReq) {
        //fixme 判断当前时间内房间价格，如果有的话就修改，没有就删除
    }
}
