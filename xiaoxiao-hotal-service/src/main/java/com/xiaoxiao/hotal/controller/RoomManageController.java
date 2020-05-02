package com.xiaoxiao.hotal.controller;

import com.xiaoxiao.hotal.service.RoomManageService;
import com.xiaoxiao.hotal.vo.request.RoomAddReq;
import com.xiaoxiao.hotal.vo.request.UpdateRoomPriceReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhangtianqi
 * @since 2020-05-01 21:03
 */
@RestController
@RequestMapping("/api/manage/room")
public class RoomManageController {

    @Autowired
    private RoomManageService roomManageService;

    @PostMapping("/addRoomInfo")
    public void addRoom(@RequestBody RoomAddReq req){
        roomManageService.addRoom(req);
    }

    @PutMapping("/updateRoomInfo")
    public void updateRoom(@RequestBody RoomAddReq req){
        roomManageService.updateRoom(req);
    }

    @PutMapping("/addOrUpdateUpdatePrice")
    public void addOrUpdateUpdatePrice(@RequestBody UpdateRoomPriceReq updateRoomPriceReq){
        roomManageService.addOrUpdateUpdatePrice(updateRoomPriceReq);
    }




}
