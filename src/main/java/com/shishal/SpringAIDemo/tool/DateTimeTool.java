package com.shishal.SpringAIDemo.tool;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.context.i18n.LocaleContextHolder;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeTool
{
    @Tool(description = "Get the current date and time in the user's timezone")
    String getCurrentDateTime() {
        return LocalDateTime.now().atZone(LocaleContextHolder.getTimeZone().toZoneId()).toString();
    }

    @Tool(description = "Find out if given date is allowed for work from home or not")
    boolean isWorkFromHomeAllowed( String localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
        LocalDateTime dateTime = LocalDateTime.parse(localDateTime, formatter);
        return !dateTime.getDayOfWeek().equals(DayOfWeek.TUESDAY);
    }
}
