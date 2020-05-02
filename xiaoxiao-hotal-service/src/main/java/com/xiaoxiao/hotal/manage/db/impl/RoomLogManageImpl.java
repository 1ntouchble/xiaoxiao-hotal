package com.xiaoxiao.hotal.manage.db.impl;

import com.xiaoxiao.hotal.entity.RoomBizLog;
import com.xiaoxiao.hotal.manage.db.RoomLogManage;
import com.xiaoxiao.hotal.manage.db.RoomStateManage;
import com.xiaoxiao.hotal.mapper.RoomBizLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author zhangtianqi
 * @since 2020-05-01 17:44
 */
@Component
public class RoomLogManageImpl implements RoomLogManage {

    @Autowired
    private RoomBizLogMapper mapper;

    @Override
    public void addLog(RoomBizLog log) {
        log.setCreatedDate(new Date());
        log.setIsDeleted(Boolean.FALSE);
        mapper.insert(log);
    }






}
