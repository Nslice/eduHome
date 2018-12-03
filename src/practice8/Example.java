package practice8;

import other.Show;
import java.util.*;
import java.util.Calendar;
import java.lang.reflect.*;

public class Example
{

    public static void main(String[] args)
    {
        System.out.println("OK");


        Show.show(1);
        Class<?> c = String.class;
        System.out.println(c);


        Show.show(2);
        System.out.println(new Date().getClass().getName());

        Show.show(3);
        c = Calendar.getInstance().getClass();

        System.out.println(Modifier.toString(c.getModifiers()));

        Show.show(4);
        ArrayList<Integer> list =new ArrayList<>();
        c = list.getClass();
        c = c.getSuperclass();
        System.out.println(c.getName());

        Show.show(5);
        c = String.class;


        AnnotatedType[] anns = c.getAnnotatedInterfaces();
        for (AnnotatedType o : anns)
            System.out.println(o);
    }
}