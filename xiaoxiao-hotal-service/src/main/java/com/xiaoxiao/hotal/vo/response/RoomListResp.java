package com.xiaoxiao.hotal.vo.response;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zhangtianqi
 * @since 2020-05-01 16:50
 */
public class RoomListResp {

    //房间id
    private Integer roomId;

    //房间号
    private Integer roomNumber;

    //房间类型
    private Integer roomType;

    //客户信息
    private Integer customerId;

    //价格
    private BigDecimal price;

    //创建日期
    private Date createdDate;

    //修改日期
    private Date updatedDate;

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getRoomType() {
        return roomType;
    }

    public void setRoomType(Integer roomType) {
        this.roomType = roomType;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
