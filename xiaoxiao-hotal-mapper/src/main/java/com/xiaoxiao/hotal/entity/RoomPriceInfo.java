package com.xiaoxiao.hotal.entity;

import java.math.BigDecimal;
import java.util.Date;

public class RoomPriceInfo {
    private Integer id;

    private Integer roomType;

    private Integer roomInnerType;

    private Integer roomId;

    private BigDecimal price;

    private Date roomBookStartDate;

    private Date roomBookEndDate;

    private Date createdDate;

    private Date updatedDate;

    private Boolean isDeleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoomType() {
        return roomType;
    }

    public void setRoomType(Integer roomType) {
        this.roomType = roomType;
    }

    public Integer getRoomInnerType() {
        return roomInnerType;
    }

    public void setRoomInnerType(Integer roomInnerType) {
        this.roomInnerType = roomInnerType;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getRoomBookStartDate() {
        return roomBookStartDate;
    }

    public void setRoomBookStartDate(Date roomBookStartDate) {
        this.roomBookStartDate = roomBookStartDate;
    }

    public Date getRoomBookEndDate() {
        return roomBookEndDate;
    }

    public void setRoomBookEndDate(Date roomBookEndDate) {
        this.roomBookEndDate = roomBookEndDate;
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

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}