package com.xiaoxiao.hotal.manage.db.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoxiao.hotal.base.PageResult;
import com.xiaoxiao.hotal.entity.RoomInfo;
import com.xiaoxiao.hotal.manage.db.RoomInfoManage;
import com.xiaoxiao.hotal.mapper.RoomInfoMapper;
import com.xiaoxiao.hotal.mapper.RoomStateInfoMapper;
import com.xiaoxiao.hotal.pojo.RoomListPojo;
import com.xiaoxiao.hotal.vo.request.RoomListReq;
import com.xiaoxiao.hotal.vo.response.RoomListResp;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author zhangtianqi
 * @since 2020-05-01 17:16
 */
@Component
public class RoomInfoManageImpl implements RoomInfoManage {

    private static final BigDecimal DEFAULT_HOTAL_PRICE = BigDecimal.valueOf(200L);

    @Autowired
    private RoomInfoMapper mapper;

    @Autowired
    private RoomStateInfoMapper roomStateInfoMapper;

    @Override
    public Integer insert(RoomInfo roomInfo) {
        roomInfo.setCreatedDate(new Date());
        roomInfo.setIsDeleted(Boolean.FALSE);
        mapper.insertAndReturnId(roomInfo);
        return roomInfo.getId();
    }

    @Override
    public PageResult<RoomListResp> queryRoomInfo(RoomListReq req, Integer customerId) {
        PageResult<RoomListResp> pageResult = new PageResult<>();

        Map<String,Object> params = new HashMap<>();
        params.put("roomNumber",req.getRoomNum());
        params.put("roomType",req.getRoomType());
        params.put("roomStatus",req.getRoomStatus());
        params.put("customrId",customerId);

        PageHelper.startPage(req.getPageNo() == null ? 1 : req.getPageNo(), req.getPageSize() == null ? 10 : req.getPageSize());
        List<RoomListPojo> roomList = mapper.getRoomPage(params);

        PageInfo<RoomListPojo> pageInfo = new PageInfo(roomList);
        pageResult.setTotalResults(pageInfo.getTotal());
        pageResult.setHasNext(pageInfo.isHasNextPage());

        List<RoomListResp> respList = new ArrayList<>();

        if (!pageInfo.getList().isEmpty()) {
            pageInfo.getList().forEach(data -> {
                if(data.getPrice()==null || data.getPrice().compareTo(BigDecimal.ZERO)!=0){
                    //去查一下默认值
                    //fixme
                    data.setPrice(DEFAULT_HOTAL_PRICE);
                }
                RoomListResp roomListResp = new RoomListResp();
                BeanUtils.copyProperties(data,roomListResp);
                roomListResp.setRoomId(data.getId());

                respList.add(roomListResp);
            });
        }
        pageResult.setData(respList);
        pageResult.setPageNo(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        return pageResult;
    }
}
