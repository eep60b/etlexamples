package com.etlsolutions.examples.weather.data;

import static com.etlsolutions.examples.weather.SettingConstants.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;


/**
 *
 * @author zc
 */
public final class DateTime implements Comparable<DateTime>{

    private final String dataTime;
    private final Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(DEFAULT_TIMEZONE), Locale.ENGLISH);
    private final DateFormat dateFormat = new SimpleDateFormat(DEFAULT_DATETIME_FORMAT);
    
    public DateTime(String date, String time) {
        
        calendar.set(Calendar.YEAR, Integer.parseInt(date.substring(0, 3)));
        calendar.set(Calendar.MONTH, Integer.parseInt(date.substring(5, 6)));
        calendar.set(Calendar.DATE, Integer.parseInt(date.substring(8, 9)));
        calendar.set(Calendar.HOUR, Integer.parseInt(time)/60);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        
        dataTime = dateFormat.format(calendar.getTime());
    }
    
    public String getDateTime(){
        return dataTime;
    }
    
    public String getYear() {
        return dataTime.substring(14);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.dataTime);
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
        
        return Objects.equals(this.dataTime, other.dataTime);
    }

    
    
    @Override
    public int compareTo(DateTime other) {
        return this.dataTime.compareTo(other.dataTime);
    }
    
}
