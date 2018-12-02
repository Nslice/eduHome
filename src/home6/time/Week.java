package home6.time;


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