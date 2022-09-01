package com.myblog.blog.util;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
public class TimeUtil {
   public boolean offTime() {
       Calendar start = Calendar.getInstance();
       start.setTime(new Date());
       start.set(Calendar.HOUR_OF_DAY, 0);
       start.set(Calendar.MINUTE, 0);
       start.set(Calendar.SECOND, 0);
       Date startDate = start.getTime();
       Calendar end = Calendar.getInstance();
       end.setTime(startDate);
       end.add(Calendar.DATE, +1);
       Date endDate = end.getTime();
       Date now = new Date();
       long startTime = startDate.getTime();
       long nowTime = now.getTime();
       long endTime = endDate.getTime();
       boolean flag = (startTime <= nowTime) && (endTime >= nowTime);
       return flag;
   }

}
