package com.etlsolutions.examples.weather.data;

import static com.etlsolutions.examples.weather.SettingConstants.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;
import org.apache.log4j.Logger;

/**
 * The DateTime class represent a time point in the data set.
 *
 * @author zc
 */
public final class DateTime implements Comparable<DateTime> {

    public static final DateTime UNKNOWN_DATETIME = new DateTime(new Date(0));

    private final Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(DEFAULT_TIMEZONE), Locale.ENGLISH);

    private DateTime(Date dateTime) {
        calendar.setTime(dateTime);
    }

    private DateTime(String date, String time) {

        String[] dateParts = date.toLowerCase().trim().replaceAll("z", "").split("-");

        calendar.set(Calendar.YEAR, Integer.parseInt(dateParts[0]));
        calendar.set(Calendar.MONTH, Integer.parseInt(dateParts[1]) - 1);
        calendar.set(Calendar.DATE, Integer.parseInt(dateParts[2]));
        calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(time) / 60);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
    }

    public static DateTime getInstance(Date dateTime) {
        
        try {
            return new DateTime(dateTime);
        } catch (Exception ex) {
            Logger.getLogger(DateTime.class).warn("Invalid date/time value: " + dateTime, ex);
            return UNKNOWN_DATETIME;
        }
    }

    public static DateTime getInstance(String date, String time) {

        try {
            return new DateTime(date, time);
        } catch (Exception ex) {

            Logger.getLogger(DateTime.class).warn("Invalid date/time value: " + date + "/" + time, ex);
            return UNKNOWN_DATETIME;
        }
    }

    public Date getDateTime() {
        return calendar.getTime();
    }

    public String getYear() {
        return String.valueOf(calendar.get(Calendar.YEAR));
    }

    public String getShortName() {
        return "DTime";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(getDateTime());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        final DateTime other = (DateTime) obj;

        return Objects.equals(this.getDateTime(), other.getDateTime());
    }

    @Override
    public int compareTo(DateTime other) {
        return this.getDateTime().compareTo(other.getDateTime());
    }

    @Override
    public String toString() {
        return getDateTime().toString();
    }
}
