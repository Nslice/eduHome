package home12;

public class ThreadEx1 extends Thread
{
    ThreadEx1(String name)
    {
        super(name);
        System.out.println(getName() + " STARTED");
        start();
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

