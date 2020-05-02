package com.xiaoxiao.hotal.manage.db.impl;

import com.xiaoxiao.hotal.entity.RoomInfo;
import com.xiaoxiao.hotal.manage.db.RoomInfoManage;
import com.xiaoxiao.hotal.mapper.RoomInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author zhangtianqi
 * @since 2020-05-01 17:16
 */
@Component
public class RoomInfoManageImpl implements RoomInfoManage {

    @Autowired
    private RoomInfoMapper mapper;

    @Override
    public Integer insert(RoomInfo roomInfo) {
        roomInfo.setCreatedDate(new Date());
        roomInfo.setIsDeleted(Boolean.FALSE);
        mapper.insertAndReturnId(roomInfo);
        return roomInfo.getId();
    }
}
