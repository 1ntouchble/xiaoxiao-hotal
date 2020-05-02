package com.xiaoxiao.hotal.util;

import java.util.UUID;

/**
 * @author zhangtianqi
 * @since 2020-04-30 23:38
 */
public class UuidUtil {

    public static String getUuid(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

}
