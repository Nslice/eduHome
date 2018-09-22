package practice2;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class Time
{
    public static Calendar makeCalendar(Date date) ///???
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    public static Date makeDate(Calendar calendar)////???
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
        date = new Date(milliseconds);
        System.out.println("new date " + date);// сдлеать

        Calendar c;

        //ex7:




    }
}
