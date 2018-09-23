package practice2;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

class Time
{
    public static Calendar toCalendar(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    public static Date toDate(Calendar calendar)
    {
        Date date = calendar.getTime();
        return date;
    }
}


public class Example
{
    public static void main(String[] args) throws java.text.ParseException
    {

        //ex1:
        Date date = new Date();
        System.out.println(date);

        //ex2:
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());

        //ex3:
        date = Time.toDate(calendar);
        calendar = Time.toCalendar(date);

        //ex4:
        date = new Date();
        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(formater.format(date));

        //ex5:
        String dateString = "12.10.1996";
        DateFormat dateForm = DateFormat.getDateInstance();
        date = dateForm.parse(dateString);
        System.out.println(date);


        //ex6:
        System.out.println();
        date = new Date();
        long milliseconds = date.getTime();
        milliseconds += (5 * 24 * 60 * 60 * 1000);
        Date newDate = new Date(milliseconds);
        System.out.println("old date: " + date + "\nnew date: " + newDate);

        System.out.println("\nWith \"Calendar\"");
        calendar.setTime(date);
        calendar.add(Calendar.MILLISECOND, 5 * 24 * 60 * 60 * 1000);
        System.out.println(calendar.getTime());


        //ex7:
        System.out.println();
        Date date1 = new Date();
        Date date2 = new Date(118, 8, 17); // 2018.09.17
        System.out.println("difference: " + Math.abs(date1.getTime() / 86_400_000 - date2.getTime() / 86_400_000));

        //ex8:
        System.out.println("date2.before(date1) = " + date2.before(date1));
        System.out.println("date1.equals(date2) = " + date1.equals(date2));

        //ex9
        System.out.println("\nCalendar, method get()");
        calendar = Calendar.getInstance();
        System.out.println(calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.ENGLISH));
        System.out.println(calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH));
        System.out.println(calendar.get(Calendar.YEAR));

        //ex10:

        System.out.println();
        long start = System.currentTimeMillis();
        int[] arr = new int[10_000];
        Random rand = new Random();
        int sum = 0;

        for (int i = 0; i < arr.length; i++)
        {
            if (i % 25 == 0) System.out.println();
            arr[i] = rand.nextInt(100);
            System.out.printf("%3d", arr[i]);
            sum += arr[i];
        }
        System.out.println("\n");
        System.out.println("Average = " + (double)sum / arr.length);
        long end = System.currentTimeMillis();
        System.out.println("Time of operation = " + (end - start) + " milliseconds");

    }
}
