package other;

import java.io.IOException;


public class Show
{
    public static void getch()
    {
        try
        {
            System.in.readAllBytes();
        }
        catch (IOException e)
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
