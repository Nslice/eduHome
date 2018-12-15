package home11;

import home11.space.Planet;

import java.lang.reflect.Method;
import java.util.ArrayList;

class Container<T>
{
    private ArrayList<T> list;
    //-------------------------------------------------------------------------------

    public Container()
    {
        this.list = new ArrayList<T>();
    }

    Container(T... args)
    {
        this.list = new ArrayList<T>();
        for (T obj : args)
            this.push_back(obj);
    }

    public int size()
    {
        return list.size();
    }

    void clear()
    {
        list.clear();
    }

    void push_back(T... data)
    {
        for (T obj : data)
            push_back(obj);
    }

    void push_back(T data)
    {

        list.add(list.size(), data);
    }

    T pop_back()
    {
        if (list.size() > 0)
        {
            T obj = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return obj;
        }
        else return null;
    }

    void show()
    {
        for (T o : list)
            System.out.println(o);
    }

}

public class Example
{
    public static void main(String[] args) throws Exception
    {
        for (Method m : Planet.class.getDeclaredMethods())
            System.out.println(m);


        System.out.println("\n\n\n");
        Container<Planet> list = new Container<>();
        list.pop_back();

        list.push_back(new Planet("Earth"),
                new Planet("Mars"),
                new Planet("Venus"),
                new Planet("Neptune"));

        list.show();

        System.out.println("\n\n\n");
        Planet planet = list.pop_back();
        list.show();


        Container<String> strings = new Container<>("Sun", "Oracle", "Oreo", "Grep");
        strings.show();


        System.out.println("Done.");
    }


}
