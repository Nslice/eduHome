package p9.practice;


class MyThread1 extends Thread
{
    @Override
    public void run()
    {
        try
        {
            for (int i = 0; i < 5; i++)
            {
                System.out.println("Running... (extends Thread)");
                Thread.sleep(500);
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}


class MyThread2 implements Runnable
{
    MyThread2()
    {
        new Thread(this).start();
    }

    @Override
    public void run()
    {
        try
        {
            for (int i = 0; i < 5; i++)
            {
                System.out.println("Running... (implements Runnable)");
                Thread.sleep(500);
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}


class MyThread3
{
    Thread th;

    MyThread3(Runnable thread)
    {
        th = new Thread(thread);
        th.start();
    }
}


class MyThread4 extends Thread
{
    boolean done = false;

    @Override
    public void run()
    {
        int n = 0;
        while (!done)
        {
            try
            {
                n++;
                if (n >= 10) shutDown();
                System.out.println("MyThread4 running, n = " + n);
                Thread.sleep(500);
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }

    void shutDown()
    {
        done = true;
    }
}


public class Example
{
    public static void main(String[] args) throws Exception
    {
        new MyThread1().start();
        new MyThread2();


        new MyThread3(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    for (int i = 0; i < 5; i++)
                    {
                        System.out.println("Running from annonym class");
                        Thread.sleep(500);
                    }
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        }).th.join();


        new MyThread4().start();

        System.out.println("MAIN THREAD STOPPED.");
    }
}