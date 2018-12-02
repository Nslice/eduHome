package home6.time;

import java.util.Date;


@SuppressWarnings("deprecation")
public class MyDate extends Date implements Week
{
    public MyDate()
    {
        super();
    }

    public MyDate(long date)
    {
        super(date);
    }

    public MyDate(int year, int month, int date)
    {
        super(year, month, date);
    }

    public MyDate(int year, int month, int date, int hrs, int min)
    {
        super(year, month, date, hrs, min);
    }

    public MyDate(int year, int month, int date, int hrs, int min, int sec)
    {
        super(year, month, date, hrs, min, sec);
    }

    public MyDate(String s)
    {
        super(s);
    }


    /**
     * @return номер недели в текущем году.
     */
    @Override
    public int currentWeekNumber()
    {
        //обычный год, 365 дней
        int[] dayInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int yr = getYear();    // если високосный
        if ((yr % 4 == 0) && (yr % 100 != 0) || (yr % 400 == 0))
            dayInMonth[1]++;

        int days = 0;
        for (int i = 0; i < getMonth(); i++)
            days += dayInMonth[i];

        for (int i = 0; i < getDate() - 1; i++)
            days++;

        int firstDayOfYear = new MyDate(getYear(), 0, 1).currentDayOfWeek();
        return (days + firstDayOfYear) / 7 + 1;
    }

    /**
     * @return номер дня недели.
     */
    @Override
    public int currentDayOfWeek()
    {
        String str = super.toString();
        switch (str.substring(0, 3))
        {
        case "Mon":
            return 0;
        case "Tue":
            return 1;
        case "Wed":
            return 2;
        case "Thu":
            return 3;
        case "Fri":
            return 4;
        case "Sat":
            return 5;
        case "Sun":
            return 6;
        default:
            return -1;
        }
    }

    /**
     * @return название дня недели.
     */
    @Override
    public String nameDayOfWeek()
    {
        int number = currentDayOfWeek();
        return Names.values()[number].toString();
    }

}