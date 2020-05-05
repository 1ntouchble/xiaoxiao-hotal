package com.xiaoxiao.hotal.controller;

import com.xiaoxiao.hotal.base.PageResult;
import com.xiaoxiao.hotal.service.RoomService;
import com.xiaoxiao.hotal.vo.request.BookRoomReq;
import com.xiaoxiao.hotal.vo.request.RoomListReq;
import com.xiaoxiao.hotal.vo.response.RoomListResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangtianqi
 * @since 2020-04-30 22:50
 */
@RequestMapping("/api/hotal")
@RestController
public class RoomBookController {

    @Autowired
    private RoomService roomService;


    @RequestMapping("/bookRoom")
    public void bookRoom(@RequestBody BookRoomReq req){
        roomService.bookRoom(req);
    }

    @RequestMapping("/quitRoom")
    public void quitRoom(){



    }

    @RequestMapping("/queryPage")
    public PageResult<RoomListResp> getRoomList(@RequestBody RoomListReq req){
        return roomService.getRoomList(req);
    }

}
