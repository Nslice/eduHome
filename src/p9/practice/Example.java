package p9.practice;

class NewThread extends Thread
{

    @Override
    public void run()
    {
        for (int i = 0; i < 15; i++)
        {
            System.out.println("Running extends Thread");
            try {
                Thread.sleep(500);
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
}



class NewThread2 implements Runnable
{
    NewThread2()
    {
        new Thread(this).start();
    }


    @Override
    public void run()
    {
        for (int i = 0; i < 15; i++)
        {
            System.out.println("Running implements Runnable");
            try {
                Thread.sleep(500);
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
}



class MyThread
{
    Thread th;
    MyThread()
    {

        th = new Thread()
        {
            @Override
            public void run()
            {
                for (int i = 0; i < 15; i++)
                {
                    System.out.println("Running annonym class");
                    try {
                        Thread.sleep(500);
                    }
                    catch (Exception ex)
                    {
                        ex.printStackTrace();
                    }
                }
            }
        };


    }
}


class MyThread2 extends Thread
{

    boolean done = false;
    MyThread2()
    {
        super();

    }

    @Override
    public void run()
    {
        int n = 0;
        while (!done)
        {

            n++;
            if (n >= 10) shutDown();
            System.out.println("Running EX4");
            try {
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
        // new NewThread().start();
        // new NewThread2().start();
        MyThread2 thread = new MyThread2();
        thread.start();

        // Thread.sleep(4000);
        // thread.shutDown();

        // Thread.sleep(4000);


        // new Thead()
        // {
        // 	@Override
        // 	public void run()
        // 	{
        // 		System.out.println("Running annonym class");
        // 		try {
        // 			Thread.sleep(500);
        // 		}
        // 		catch (Exception ex)
        // 		{
        // 			ex.printStackTrace();
        // 		}
        // 	}
        // }



    }
}