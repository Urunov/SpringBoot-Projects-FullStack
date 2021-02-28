package com.urunov.jwtauth.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Utils {

    public static String getStartOfToday()
    {
        LocalDateTime now = LocalDateTime.now();
        return now.with(LocalTime.MIN).toString();
    }

    public static String getTodayDateStr()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return (LocalDate.now().format(formatter));
    }
    public static String getCurrentTimeStamp(){
        return new SimpleDateFormat("yyyy-MM-ddHH:mm:ss").format(new Date());
    }
}
