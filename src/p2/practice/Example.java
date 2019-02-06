package p2.practice;

import other.Show;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;


class Time
{
    static Calendar toCalendar(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    static Date toDate(Calendar calendar)
    {
        return calendar.getTime();
    }
}


@SuppressWarnings("deprecation")
public class Example
{
    public static void main(String[] args) throws java.text.ParseException
    {
        //ex1:
        Show.show(1);
        Date date = new Date();
        System.out.println(date);
        Show.getch();


        //ex2:
        Show.show(2);
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());
        Show.getch();


        //ex3:
        Show.show(3);
        System.out.println("Calendar " + Time.toDate(calendar));
        System.out.println("Date " + Time.toCalendar(date));
        Show.getch();


        //ex4:
        Show.show(4);
        date = new Date();
        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(formater.format(date));
        Show.getch();


        //ex5:
        Show.show(5);
        String dateString = "12.10.1996";
        DateFormat dateForm = DateFormat.getDateInstance(DateFormat.SHORT);
        date = dateForm.parse(dateString);
        System.out.println(date);
        Show.getch();


        //ex6:
        Show.show(6);
        date = new Date();
        long milliseconds = date.getTime();
        milliseconds += (5 * 24 * 60 * 60 * 1000);
        Date newDate = new Date(milliseconds);
        System.out.println("old date: " + date + "\nnew date: " + newDate);

        System.out.println("\nWith \"Calendar\"");
        calendar.setTime(date);
        calendar.add(Calendar.MILLISECOND, 5 * 24 * 60 * 60 * 1000);
        System.out.println(calendar.getTime());
        Show.getch();


        //ex7:
        Show.show(7);
        Date date1 = new Date();
        Date date2 = new Date(118, 8, 17); // 2018.09.17
        System.out.println("difference: " + Math.abs(date1.getTime() / 86_400_000 - date2.getTime() / 86_400_000));
        Show.getch();


        //ex8:
        Show.show(8);
        System.out.println("date1: " + formater.format(date1));
        System.out.println("date2: " + formater.format(date2));
        System.out.println("date2.before(date1) = " + date2.before(date1));
        System.out.println("date1.equals(date2) = " + date1.equals(date2));
        Show.getch();


        //ex9
        Show.show(9);
        System.out.println("\nCalendar, method get()");
        calendar = Calendar.getInstance();
        System.out.println(calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.ENGLISH));
        System.out.println(calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH));
        System.out.println(calendar.get(Calendar.YEAR));
        Show.getch();


        //ex10:
        Show.show(10);
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

        System.out.println("Done.");
    }
}
