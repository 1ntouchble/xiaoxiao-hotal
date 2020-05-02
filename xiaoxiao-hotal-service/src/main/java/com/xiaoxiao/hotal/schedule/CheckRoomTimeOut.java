package com.xiaoxiao.hotal.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author zhangtianqi
 * @since 2020-04-30 22:43
 */
@Component
public class CheckRoomTimeOut {

    //fixme 每半小时修改房间状态，比如2点退房，1点半可通知管理员，是否续时间，是否退房，是否强制退房，是否扣除押金转终点房
//    @Scheduled(cron = "")
    public void checkRoomTimeOut(){

    }

}
