package p11.home;


@FunctionalInterface
interface ArrayCreator<R>
{
    R apply(int size);
}


public class List<T>
{
    private int size = 0;
    private Node head = null;
    private Node tail = null;

    //-------------------------------------------------------------------------------
    private class Node
    {
        private T data;
        private Node next;
        private Node prev;

        Node(T data, Node next, Node prev)
        {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }


    List(T... args)
    {
        for (T obj : args)
            this.push_back(obj);
    }


    public int size()
    {
        return size;
    }


    void clear()
    {
        while (size > 0)
            pop_back();
    }


    void push_back(T... data)
    {
        for (T obj : data)
            push_back(obj);
    }


    void push_back(T data)
    {
        if (head == null)
        {
            tail = head = new Node(data, null, null);
        }
        else
        {
            tail.next = new Node(data, null, tail);
            tail = tail.next;
        }
        size++;
    }


    T pop_back()
    {
        if (head == null)
        {
            return null;
        }
        else
        {
            Node tmp = tail;
            if (head == tail)
            {
                head = tail = null;
                size--;
                return tmp.data;
            }
            else
            {
                tail = tail.prev;
                tail.next = null;
                size--;
                return tmp.data;
            }
        }
    }


    void show()
    {
        Node ptr = head;
        while (ptr != null)
        {
            System.out.println(ptr.data);
            ptr = ptr.next;
        }
    }


    T[] toArray(ArrayCreator<T[]> gen)
    {
        T[] ar = gen.apply(size);
        Node ptr = head;
        int n = 0;

        while (ptr != null)
        {
            ar[n++] = ptr.data;
            ptr = ptr.next;
        }
        return ar;
    }
}