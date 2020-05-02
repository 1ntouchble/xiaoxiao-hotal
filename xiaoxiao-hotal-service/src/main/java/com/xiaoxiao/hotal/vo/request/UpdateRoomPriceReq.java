package com.xiaoxiao.hotal.vo.request;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zhangtianqi
 * @since 2020-05-01 21:15
 */
public class UpdateRoomPriceReq {

    private Integer roomType;

    private Integer roomInnerType;

    private Integer roomId;

    private BigDecimal roomPrice;

    private Date roomBookStartDate;

    private Date roomBookEndDate;

    @Override
    public String toString() {
        return "UpdateRoomPriceReq{" +
                "roomType=" + roomType +
                ", roomInnerType=" + roomInnerType +
                ", roomId=" + roomId +
                ", roomPrice=" + roomPrice +
                ", roomBookStartDate=" + roomBookStartDate +
                ", roomBookEndDate=" + roomBookEndDate +
                '}';
    }
}
