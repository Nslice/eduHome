package practice8;

import other.Show;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class Example
{

    public static void main(String[] args)
    {
        /** ---------------------------------- EX1 --------------------------------- */
        Show.show(1);
        Class<?> cls = "".getClass();
        System.out.println(cls);
        Show.getch();


        /** ---------------------------------- EX2 --------------------------------- */
        Show.show(2);
        System.out.println(new Date().getClass().getName());
        Show.getch();


        /** ---------------------------------- EX3 --------------------------------- */
        Show.show(3);
        System.out.println("Calendar: " + Modifier.toString(Calendar.class.getModifiers()));
        cls = Calendar.getInstance().getClass();
        System.out.println("GregorianCalendar: " + Modifier.toString(cls.getModifiers()));
        Show.getch();


        /** ---------------------------------- EX4 --------------------------------- */
        Show.show(4);
        System.out.println(ArrayList.class.getSuperclass().getName());
        Show.getch();


        /** ---------------------------------- EX5 --------------------------------- */
        Show.show(5);
        System.out.println("String.class interfaces:");
        for (Class<?> i : String.class.getInterfaces())
            System.out.println(i.getName());
        Show.getch();


        /** ---------------------------------- EX6 --------------------------------- */
        Show.show(6);
        System.out.println("Calendar.class fields:");
        for (Field i : Calendar.class.getDeclaredFields())
            System.out.println(i);
        Show.getch();


        /** ---------------------------------- EX7 --------------------------------- */
        Show.show(7);
        System.out.println("String.class constructors:");
        for (Constructor<?> i : String.class.getConstructors())
            System.out.println(i);
        Show.getch();


        /** ---------------------------------- EX8 --------------------------------- */
        Show.show(8);
        System.out.println("Math.class methods:");
        for (Method i : Math.class.getMethods())
            System.out.println(i);
        Show.getch();


        /** ---------------------------------- EX9 --------------------------------- */
        Show.show(9);

        for (Field i : Calendar.class.getDeclaredFields())
        {
            if (Modifier.isPublic(i.getModifiers())) continue;
            System.out.printf("%-100s%-30s\n", i, i.getName());
        }

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 1812);
        System.out.print("\nCalendar date: " + calendar.getTime() + "\t");
        try
        {
            Field field = Calendar.class.getDeclaredField("fields");
            field.setAccessible(true);

            if (field.getType().isArray())
            {
                if (field.getType().getComponentType() == Integer.TYPE)
                {
                    int[] array = (int[]) field.get(calendar);
                    System.out.println("FIELD = " + array[Calendar.YEAR]);

                    array[Calendar.YEAR] = 2015;
                    System.out.print(" After change: " + calendar.getTime() + "\t");
                    System.out.println("FIELD = " + array[Calendar.YEAR]);

                    System.out.println("\ncalendar.add(Calendar.YEAR, 1);");
                    calendar.add(Calendar.YEAR, 1);
                    System.out.print(" After adding: " + calendar.getTime() + "\t");
                    System.out.println("FIELD = " + array[Calendar.YEAR]);
                }
            }
        }
        catch (NoSuchFieldException | IllegalAccessException ex)
        {
            ex.printStackTrace();
        }

        System.out.println("Done.");
    }
}