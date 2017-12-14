package com.wapzjn.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: wapzjn
 * @Email: wapzjn@gmail.com
 * @Create: 2017-12-13 19:42
 **/
public class MyTime {

    public static Date format(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        date = Timestamp.valueOf(simpleDateFormat.format(date));
        return date;
    }
}
