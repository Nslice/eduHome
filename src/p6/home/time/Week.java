package p6.home.time;


public interface Week
{
    enum Names
    {
        Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday
    }

    int currentWeekNumber();

    int currentDayOfWeek();

    String nameDayOfWeek();
}