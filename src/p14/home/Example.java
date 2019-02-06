package p14.home;


public class Example
{
    public static void main(String[] args)
    {
        new Thread(new Server()).start();
        new Thread(new Client()).start();
    }
}



