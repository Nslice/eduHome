package p11.home;

import p11.home.space.Planet;

import java.lang.reflect.Method;


public class Example
{
    public static void main(String[] args)
    {
        for (Method m : Planet.class.getDeclaredMethods())
            System.out.println(m);


        System.out.println("\n\n\n");
        Box<Planet> list = new Box<>();
        list.pop_back();

        list.push_back(new Planet("Earth"), new Planet("Mars"),
                       new Planet("Venus"), new Planet("Neptune"));
        list.show();

        System.out.println("\n\n\n");
        Planet planet = list.pop_back();
        list.show();


        Box<String> strings = new Box<>("Sun", "Oracle", "Oreo", "Grep");
        strings.show();


        System.out.println("Done.");
    }
}
