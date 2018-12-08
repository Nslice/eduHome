package home8;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;


public class Example
{

    public static void main(String[] args)
    {
        if (args.length < 2)
        {
            System.out.println("Not enough arguments");
            return;
        }


        TxtFile file = new TxtFile(args[0]);

        int num = 10;
        try (PrintStream stream = new PrintStream(new File(args[1])))
        {
            file.filterShow(num, System.out);
            file.filterShow(num, stream);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
