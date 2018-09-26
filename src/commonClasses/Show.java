package commonClasses;

public class Show
{
    public static void getch() throws java.io.IOException
    {
        System.in.read();
    }

    public static void show(int taskNumber)
    {
        System.out.println("\n------------------------------------");
        System.out.printf("%17s %d\n", "Task", taskNumber);
        System.out.println("------------------------------------");
    }

}
