package com.xiaoxiao.hotal.vo.request;

/**
 * @author zhangtianqi
 * @since 2020-05-02 14:07
 */
public class BookRoomReq {

    private String customerName;

    private String cretNo;

    private String phone;

    private Integer roomNum;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCretNo() {
        return cretNo;
    }

    public void setCretNo(String cretNo) {
        this.cretNo = cretNo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(Integer roomNum) {
        this.roomNum = roomNum;
    }

    @Override
    public String toString() {
        return "BookRoomReq{" +
                "customerName='" + customerName + '\'' +
                ", cretNo='" + cretNo + '\'' +
                ", phone='" + phone + '\'' +
                ", roomNum=" + roomNum +
                '}';
    }
}
