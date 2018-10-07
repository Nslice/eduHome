package other;


public class Show
{
    public static void getch()
    {
        try
        {
            System.in.read();
        }
        catch (java.io.IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void show(int taskNumber)
    {
        System.out.println("\n------------------------------------");
        System.out.printf("%17s %d\n", "Task", taskNumber);
        System.out.println("------------------------------------");
    }

}
