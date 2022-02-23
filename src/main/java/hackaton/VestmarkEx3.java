package hackaton;

import org.joda.time.DateTime;
import org.joda.time.Weeks;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/*
 * John has always dreamed of taking a vacation on Hawaii. He has decided to make his dream come true during the next holiday period, and he would like to spend as much time there as possible.
 * The problem is that there is only one plane per week connecting Hawaii with the city where John lives. The plane departs every Monday and arrives every Sunday. There is no other way to get to Hawaii and back. It means that John can spend only whole weeks in Hawaii.
 * John knows in which month his vacation starts and in which month it ends. His vacation period starts on the first day of the beginning month and ends on the last day of the ending month. John also knows the year in which his vacation takes place.
 * For example, if John's vacation lasts from July to September in 2008, then it starts on 1st July 2008 and ends on 30th September 2008.
 * Your task is to calculate how many weeks John will spend in Hawaii, given:
 * the month when the vacation begins;
 * the month when the vacation ends;
 * the year when the vacation takes place;
 * the day of the week for 1st January in the vacation year (for convenience).
 *
 * Pay attention to leap years; you should also consider them. The year of the vacation will be a number between 2001 and 2099, inclusive, and you can tell that the year is a leap year if it's divisible by 4.
 *
 * Given an integer Y and three non-empty strings A, B and W, denoting the year of the vacation, the beginning month, the ending month and the day of the week for 1st January of that year, returns the maximum number of weeks that John can spend in Hawaii.
 *
 * */

public class VestmarkEx3 {
    private static final Map<String, Integer> mapOfMonths = new HashMap<String, Integer>(){
        {
            put("JANUARY", Calendar.JANUARY);
            put("FEBRUARY", Calendar.FEBRUARY);
            put("MARCH", Calendar.MARCH);
            put("APRIL", Calendar.APRIL);
            put("MAY", Calendar.MAY);
            put("JUNE", Calendar.JUNE);
            put("JULY", Calendar.JULY);
            put("AUGUST", Calendar.AUGUST);
            put("SEPTEMBER", Calendar.SEPTEMBER);
            put("OCTOBER", Calendar.OCTOBER);
            put("NOVEMBER", Calendar.NOVEMBER);
            put("DECEMBER", Calendar.DECEMBER);
        }
    };

    public static int solution(int Y, String A, String B, String W) {
        int weeks = 0;
        int year = Y;
        int startVacation = mapOfMonths.get(A.toUpperCase())+1;
        int endVacation = mapOfMonths.get(B.toUpperCase())+1;
        int firstDayOfMonth = 1;
        int lastDayOfMonth = -1;
        if (startVacation != 0 && endVacation != 0) {
            DateTime dateTime1 = new DateTime(year, startVacation, getDay(year, startVacation, Calendar.MONDAY, firstDayOfMonth), 23, 59);
            System.out.println(dateTime1);
            DateTime dateTime2 = new DateTime(year, endVacation, getDay(year, endVacation, Calendar.SUNDAY, lastDayOfMonth), 23, 59);
            System.out.println(dateTime2);
            weeks = Weeks.weeksBetween(dateTime1, dateTime2).getWeeks();
        }
        if(weeks < 0) {throw new IllegalArgumentException("Incorrect input");}
        return weeks;
    }

    private static int getDay(int year, int month, int dateOfWeek, int orderOfDay) {
        Calendar cacheCalendar = Calendar.getInstance();
        cacheCalendar.set(Calendar.YEAR, year);
        cacheCalendar.set(Calendar.MONTH, month);
        cacheCalendar.set(Calendar.DAY_OF_WEEK_IN_MONTH, orderOfDay ); //Last -1 / First 1
        cacheCalendar.set(Calendar.DAY_OF_WEEK, dateOfWeek); //Sun or Mon
        System.out.println(dateOfWeek);
        return cacheCalendar.get(Calendar.DATE);
    }

    public static void main(String[] args){
        System.out.println(solution(2018, "May", "June", "Wend"));
    }
}
