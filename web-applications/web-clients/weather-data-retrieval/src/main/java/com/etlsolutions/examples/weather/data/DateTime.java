package com.etlsolutions.examples.weather.data;

import static com.etlsolutions.examples.weather.SettingConstants.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;

/**
 * The DateTime class represent a time point in the data set.
 *
 * @author zc
 */
public final class DateTime implements Comparable<DateTime> {

    private final String dateTime;
    private final Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(DEFAULT_TIMEZONE), Locale.ENGLISH);
    private final DateFormat dateFormat = new SimpleDateFormat(DEFAULT_DATETIME_FORMAT);

    public DateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public DateTime(String date, String time) {

        String[] dateParts = date.replaceAll("Z", "").split("-");

        calendar.set(Calendar.YEAR, Integer.parseInt(dateParts[0]));
        calendar.set(Calendar.MONTH, Integer.parseInt(dateParts[1]) - 1);
        calendar.set(Calendar.DATE, Integer.parseInt(dateParts[2]));
        calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(time) / 60);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        dateTime = dateFormat.format(calendar.getTime());
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getYear() {
        return dateTime.substring(14);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.dateTime);
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

        return Objects.equals(this.dateTime, other.dateTime);
    }

    @Override
    public int compareTo(DateTime other) {
        return this.dateTime.compareTo(other.dateTime);
    }

    @Override
    public String toString() {
        return dateTime;
    }
}
