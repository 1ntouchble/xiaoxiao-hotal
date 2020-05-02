package com.xiaoxiao.hotal.vo.response;

import com.xiaoxiao.hotal.entity.CustomerInfo;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author zhangtianqi
 * @since 2020-05-01 16:50
 */
public class RoomListResp {

    //房间id
    private String roomId;

    //房间号
    private String roomNum;

    //房间类型
    private Integer roomType;

    //房间价格
    private BigDecimal roomPrice;

    //客户信息
    private List<CustomerInfo> customerInfoLists;



}
