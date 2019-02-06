package p8.home;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;


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

        int num;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter word count: ");
        num = scan.nextInt();

        try (PrintStream stream = new PrintStream(new File(args[1])))
        {
            file.filterShow(num, System.out);
            file.filterShow(num, stream);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        scan.close();
        System.out.println("Done.");
    }
}
