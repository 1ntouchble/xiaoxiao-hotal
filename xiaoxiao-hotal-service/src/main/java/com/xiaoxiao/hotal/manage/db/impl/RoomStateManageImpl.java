package com.xiaoxiao.hotal.manage.db.impl;

import com.xiaoxiao.hotal.entity.RoomStateInfo;
import com.xiaoxiao.hotal.entity.RoomStateInfoExample;
import com.xiaoxiao.hotal.manage.db.RoomStateManage;
import com.xiaoxiao.hotal.mapper.RoomStateInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhangtianqi
 * @since 2020-05-01 17:16
 */
@Component
public class RoomStateManageImpl implements RoomStateManage {

    @Autowired
    private RoomStateInfoMapper mapper;


    @Override
    public void updateRoomFree(Integer roomId){
        RoomStateInfo roomStateInfo = new RoomStateInfo();
        roomStateInfo.setRoomStatus(roomId);
        RoomStateInfoExample example = new RoomStateInfoExample();
        RoomStateInfoExample.Criteria criteria = example.createCriteria();
        criteria.andRoomIdEqualTo(roomId);
        mapper.updateByExampleSelective(roomStateInfo,example);
    }


}
