package home12;

public class ThreadEx3 extends Thread
{
    private static int sId = 0;
    private int id;
    private int count = 5;

    public ThreadEx3()
    {
        this.id = ++sId;
    }

    @Override
    public void run()
    {
        for (int i = 0; i < count; i++)
        {
            try
            {
                System.out.println("Thread #" + id + " (" + i + ")");
                Thread.sleep(300);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        System.out.println("Thread #" + id + " stopped ");

    }

}
