package com.xiaoxiao.hotal.manage.db;

import com.xiaoxiao.hotal.base.PageResult;
import com.xiaoxiao.hotal.entity.RoomInfo;
import com.xiaoxiao.hotal.vo.request.RoomListReq;
import com.xiaoxiao.hotal.vo.response.RoomListResp;

/**
 * @author zhangtianqi
 * @since 2020-05-01 17:15
 */
public interface RoomInfoManage {

    Integer insert(RoomInfo roomInfo);

    PageResult<RoomListResp> queryRoomInfo(RoomListReq req, Integer customerId);

}
