package hackaton;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class VestmarkEx2 {

    private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MMM");

    public static int solution(int Y, String A, String B, String W) throws ParseException {

        int year = Y;
        String startVacation = A;
        String endVacation = B;
        String dateOneInput = year + "-" + startVacation;
        String dateTwoInput = year + "-" + endVacation;
        //DATE 1
        Calendar c1 = getCalend(dateOneInput);
        //DATE 2
        Calendar c2 = getCalend(dateTwoInput);
        System.out.println("Date 1 : " + c1.getTime());
        System.out.println("Date 2 : " + c2.getTime());

        //Difference in weeks
        int weeks = c2.get(Calendar.WEEK_OF_YEAR) - c1.get(Calendar.WEEK_OF_YEAR);
        System.out.println("Number of weeks :" + (1 + weeks));
        return 1 + weeks;
    }

    private static Calendar getCalend(String dateInput) throws ParseException{
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(formatter.parse(dateInput));
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        calendar.set(Calendar.DAY_OF_WEEK_IN_MONTH, -1);
        return calendar;
    }

    public static void main(String[] args) throws ParseException {
        System.out.println(solution(2018, "July", "September", "Wend"));
    }

}
