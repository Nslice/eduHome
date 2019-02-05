package home12;

import java.util.Random;

public class ThreadEx4 implements Runnable
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
            for (int i = 0; i < iter; i++)
            {
                try
                {
                    System.out.print(th.getName() + " - " + i + ";   ");
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
