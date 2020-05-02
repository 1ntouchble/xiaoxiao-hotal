package com.xiaoxiao.hotal.service.impl;

import com.xiaoxiao.hotal.service.RoomService;
import com.xiaoxiao.hotal.vo.request.BookRoomReq;
import com.xiaoxiao.hotal.vo.request.RoomListReq;
import com.xiaoxiao.hotal.vo.response.RoomListResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangtianqi
 * @since 2020-05-01 16:48
 */
@Service
public class RoomServiceImpl implements RoomService {

    private static final Logger logger = LoggerFactory.getLogger(RoomService.class);



    @Override
    public List<RoomListResp> getRoomList(RoomListReq req) {
        //1 根据roomType看看




        return null;
    }

    @Override
    public void bookRoom(BookRoomReq req) {



    }
}
