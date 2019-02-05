package p6.home;


import p6.home.time.MyDate;

import java.util.Calendar;


interface IBase
{
    void foo();
}


interface IDerive extends IBase
{
    void bar();

    static class Inner
    {
        private String str;

        Inner(String str)
        {
            this.str = str;
        }

        @Override
        public String toString()
        {
            return super.toString() + " " + str;
        }
    }
}


@SuppressWarnings("deprecation")
public class Example
{
    public static void main(String[] args) throws Exception
    {
        //ex1:
        IDerive.Inner smth = new IDerive.Inner("stone");
        System.out.println(smth + "\n\n");

        //ex2:
        int year = 2017, month = 1, day = 2;

        testCalendar(year, month, day);
        testMy(year, month, day);

        year = 2018;
        month = 12;
        day = 3;

        testCalendar(year, month, day);
        testMy(year, month, day);


        System.out.println();
        System.out.println(new MyDate().nameDayOfWeek());
        System.out.println(new MyDate().currentDayOfWeek());


    }


    static void testMy(int year, int month, int day)
    {
        MyDate date = new MyDate(year - 1900, month - 1, day);
        System.out.print(date);
        System.out.println(" = " + date.currentWeekNumber());
    }

    static void testCalendar(int year, int month, int day)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        System.out.print(calendar.getTime());
        System.out.println(" = " + calendar.get(Calendar.WEEK_OF_YEAR));
    }


}