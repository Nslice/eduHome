package home12;

class MyThread extends Thread
{
    MyThread(String name)
    {
        super(name);
        System.out.println(name + " STARTED");
    }

    @Override
    public void run()
    {
        int i = 0;
        while (i < 3)
        {
            System.out.print("System.gc ");
            System.out.println(i++);
            try
            {
                Thread.sleep(900);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
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



public class Example
{

    public static void main(String[] args)
    {
        try
        {
            SubThread2 th2 = new SubThread2();
            SubThread1 th1 = new SubThread1(th2);
            th1.start();
            th1.join();

        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        System.out.println("MAIN THREAD STOPPED");
    }
}
