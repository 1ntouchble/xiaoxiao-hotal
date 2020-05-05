package com.xiaoxiao.hotal.service.impl;

import com.xiaoxiao.hotal.base.PageResult;
import com.xiaoxiao.hotal.entity.CustomerInfo;
import com.xiaoxiao.hotal.manage.db.CustomerInfoManage;
import com.xiaoxiao.hotal.manage.db.RoomInfoManage;
import com.xiaoxiao.hotal.manage.db.RoomStateInfoManage;
import com.xiaoxiao.hotal.service.RoomService;
import com.xiaoxiao.hotal.vo.request.BookRoomReq;
import com.xiaoxiao.hotal.vo.request.RoomListReq;
import com.xiaoxiao.hotal.vo.response.RoomListResp;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangtianqi
 * @since 2020-05-01 16:48
 */
@Service
public class RoomServiceImpl implements RoomService {

    private static final Logger logger = LoggerFactory.getLogger(RoomService.class);

    @Autowired
    private RoomInfoManage roomInfoManage;

    @Autowired
    private RoomStateInfoManage roomStateInfoManage;

    @Autowired
    private CustomerInfoManage customerInfoManage;


    @Override
    public PageResult<RoomListResp> getRoomList(RoomListReq req) {
        Integer customerId = 0;
        //1 根据roomType看看
        if(StringUtils.isNotBlank(req.getPhone())||StringUtils.isNotBlank(req.getUserName())){
            CustomerInfo customerInfo = new CustomerInfo();
            BeanUtils.copyProperties(req,customerInfo);
            customerId = customerInfoManage.getCustomerLastId(customerInfo);
        }
        PageResult<RoomListResp> result = roomInfoManage.queryRoomInfo(req,customerId);
        return result;
    }

    @Override
    public void bookRoom(BookRoomReq req) {



    }
}
