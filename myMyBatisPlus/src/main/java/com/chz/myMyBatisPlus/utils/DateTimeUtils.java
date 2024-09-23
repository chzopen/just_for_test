package com.chz.myMyBatisPlus.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class DateTimeUtils
{

    public static ZonedDateTime toUTCZoned(LocalDateTime localDateTime, ZoneId localZoneId)
    {
        return toZoned(localDateTime, localZoneId, ZoneId.from(ZoneOffset.UTC));
    }

    public static ZonedDateTime toZoned(LocalDateTime localDateTime, ZoneId localZoneId, ZoneId targetZonedId)
    {
        return localDateTime.atZone(localZoneId).withZoneSameInstant(targetZonedId);
    }

    public static ZonedDateTime toZoned(LocalDateTime localDateTime, ZoneId localZoneId)
    {
        return localDateTime.atZone(localZoneId);
    }

    public static ZonedDateTime convertZoneId(ZonedDateTime zonedDateTime, ZoneId targetZonedId)
    {
        return zonedDateTime.withZoneSameInstant(targetZonedId);
    }

    public static ZoneId getDefaultZoneId()
    {
        return ZoneId.systemDefault();
    }

    public static ZoneId getUTCZoneId()
    {
        return ZoneId.from(ZoneOffset.UTC);
    }

    public static void main(String[] args) {

    }

}
