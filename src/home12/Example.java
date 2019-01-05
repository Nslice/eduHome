package home12;

import other.Show;

import java.util.Scanner;

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


public class Example
{


    public static void main(String[] args)
    {
        /** ---------------------------------- EX1 --------------------------------- */
        Show.show(1);
        try
        {
            new ThreadEx1("thread1 ex1");
            new ThreadEx1("thread2 ex1").join();
            System.gc();
            System.runFinalization();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }


        /** ---------------------------------- EX3 --------------------------------- */
        Show.show(3);
        try
        {
            Thread th = null;
            for (int i = 0; i < 5; i++)
            {
                th = new ThreadEx3();
                th.start();
            }
            th.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }


        /** ---------------------------------- EX4 --------------------------------- */
        Show.show(4);
        Scanner scanner = null;
        try
        {
            int n = 2, m = 5;
            scanner = new Scanner(System.in);
            System.out.println("Enter N, M: ");
            n = scanner.nextInt();
            m = scanner.nextInt();

            ThreadEx4 th = null;
            for (int i = 0; i < n; i++)
                th = new ThreadEx4("Thread_" + i, m);
            th.th.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        scanner.close();
        System.out.println("Done.");
    }
}
