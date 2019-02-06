package p11.home;

import java.util.ArrayList;


public class Box<T>
{
    private ArrayList<T> list;


    public Box()
    {
        this.list = new ArrayList<T>();
    }

    public Box(T... args)
    {
        this.list = new ArrayList<T>();
        for (T obj : args)
            this.push_back(obj);
    }

    public int size()
    {
        return list.size();
    }

    public void clear()
    {
        list.clear();
    }

    public void push_back(T... data)
    {
        for (T obj : data)
            push_back(obj);
    }

    public void push_back(T data)
    {
        list.add(list.size(), data);
    }

    public T pop_back()
    {
        if (list.size() > 0)
        {
            T obj = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return obj;
        }
        else return null;
    }

    public void show()
    {
        for (T o : list)
            System.out.println(o);
    }
}