package home12;

import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

class ThreadEx1 extends Thread
{
    ThreadEx1(String name)
    {
        super(name);
        System.out.println(getName() + " STARTED");
    }

    @Override
    public void run()
    {
        for (int i = 0; i < 3; i++)
        {
            try
            {
                System.out.println("message " + i);
                Thread.sleep(900);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        System.gc();
        System.runFinalization();
    }

    @Override
    protected void finalize() throws Throwable
    {
        System.out.println(getName() + " STOPPED");
    }
}


class SubThread1 extends Thread
{
    Thread thread;

    public SubThread1()
    {
    }

    public SubThread1(Thread otherThread)
    {
        this.thread = otherThread;
    }

    @Override
    public void run()
    {
        while (true)
        {
            try
            {
                System.out.println("SubThread 1 ");
                Thread.sleep(900);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}

class SubThread2 extends Thread
{
    @Override
    public void run()
    {

    }
}


class ThreadEx3 extends Thread
{
    private static int sNumber = 0;
    private int threadNumber;
    private int count = 5;

    public ThreadEx3()
    {
        this.threadNumber = ++sNumber;
    }

    public void run()
    {
        while (true)
        {
            System.out.println("Thread #" + threadNumber + " (" + count + ")");
            count--;
            try
            {
                Thread.sleep(300);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            if (count == 0)
            {
                System.out.println("Thread #" + threadNumber + " stopped ");
                return;
            }
        }
    }

}


class ThreadEx4 implements Runnable
{
    Thread th;
    int iter;

    public ThreadEx4(String name, int iter)
    {
        this.iter = iter;
        th = new Thread(this, name);
        th.start();
    }

    @Override
    public void run()
    {
        synchronized (System.out)
        {
            for (int i = 1; i <= iter; i++)
            {
                try
                {
                    System.out.print(th.getName() + " - " + i + "; ");
                    Thread.sleep(new Random().nextInt(500));
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            System.out.println();
        }
    }
}


public class Example
{


    public static void main(String[] args) throws Exception
    {

        System.out.println("Example.main");
        Thread th = null;
//        for (int i = 0; i < 5; i++)
//        {
//            th = new ThreadEx3();
//            th.start();
//        }
//        try
//        {
//            th.join();
//        }
//        catch (InterruptedException e)
//        {
//            e.printStackTrace();
//        }

        ThreadEx1 t = new ThreadEx1("thread ex1");
        t.start();
        ThreadEx1 t2 = new ThreadEx1("thread2 ex1");
        t2.start();


        t.join();
        t2.join();

        int n = 2, m = 5;

        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);

//        n = scanner.nextInt();
//        m = scanner.nextInt();
//
//
//
//        for (int i = 0; i < n; i++)
//        {
//            new ThreadEx4("Thread_" + i, m);
//        }



        





        scanner.close();
    }
}
