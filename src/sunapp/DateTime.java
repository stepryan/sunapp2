package sunapp;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.virtualsolar.vso.vsoi.Time;

public class DateTime {
	
	public static void DTime(Time timeparam) {
		Calendar calendar = new GregorianCalendar(); // create a new gregorian calendar
        int  year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1; // add 1 to month as month starts at 0 not 1
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int minutes = calendar.get(Calendar.MINUTE);
        int seconds = calendar.get(Calendar.SECOND);
        int HourMinus = hours -1;
        
        
        String yearString = Integer.toString(year);
        String monthString = Integer.toString(month);
        String dayString = Integer.toString(dayOfMonth);
        String stringDate = yearString + monthString +  dayString;

        String hourString = Integer.toString(hours);
        String minuteString = Integer.toString(minutes);
        String secondString = Integer.toString(seconds);
        String DayPreviousString = Integer.toString(HourMinus);
        String stringTimeCurrent = hourString + minuteString + secondString;
    	
    	String dateTimeCurrent = stringDate + stringTimeCurrent;
    	

    	String stringTimePrevious = DayPreviousString + minuteString + secondString;   
        String dateTimePrevious = stringDate + stringTimePrevious;
        timeparam.setStart(dateTimePrevious);
        timeparam.setEnd(dateTimeCurrent);
        timeparam.setNear(dateTimeCurrent);
		
	}

}
