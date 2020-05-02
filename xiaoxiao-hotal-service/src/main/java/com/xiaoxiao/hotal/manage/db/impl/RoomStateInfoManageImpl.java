package com.xiaoxiao.hotal.manage.db.impl;

import com.xiaoxiao.hotal.entity.RoomStateInfo;
import com.xiaoxiao.hotal.manage.db.RoomStateInfoManage;
import com.xiaoxiao.hotal.mapper.RoomStateInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author zhangtianqi
 * @since 2020-05-02 12:18
 */
@Component
public class RoomStateInfoManageImpl implements RoomStateInfoManage {

    @Autowired
    private RoomStateInfoMapper mapper;

    @Override
    public void insert(RoomStateInfo roomStateInfo) {
        roomStateInfo.setCreatedDate(new Date());
        mapper.insert(roomStateInfo);
    }
}
