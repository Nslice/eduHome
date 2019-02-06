package p5.practice;

import other.Show;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Example
{
    public static void main(String[] args) throws java.io.IOException
    {
        /** ---------------------------------- EX1 --------------------------------- */
        Show.show(1);
        String str = "This is Jim and Timothy";
        Matcher m = Pattern.compile("[TJ]im").matcher(str);
        while (m.find())
        {
            System.out.println(m.group() + " : " + m.start() + "-" + m.end());
        }
        Show.getch();


        /** ---------------------------------- EX2 --------------------------------- */
        Show.show(2);
        str = "This is Jim and Tom";
        m.reset(str);
        System.out.println("before: " + str);
        str = m.replaceAll("John");
        System.out.println(" after: " + str);
        Show.getch();


        /** ---------------------------------- EX3 --------------------------------- */
        Show.show(3);
        str = "My dad and My mom";
        System.out.println("before: " + str);
        StringBuffer sb = new StringBuffer();
        m = Pattern.compile("My").matcher(str);

        while (m.find())
        {
            m.appendReplacement(sb, "Our");
        }
        m.appendTail(sb);
        str = sb.toString();
        System.out.println(" after: " + str);
        Show.getch();


        /** ---------------------------------- EX4 --------------------------------- */
        Show.show(4);
        str = "The words are town torn ton toon house.";
        m = Pattern.compile("\\st(\\w)*o(\\w)*").matcher(str);
        while (m.find())
        {
            System.out.println(m.group() + "  " + m.start() + " " + m.end());
        }
        Show.getch();


        /** ---------------------------------- EX5 --------------------------------- */
        Show.show(5);
        try (BufferedReader fin = new BufferedReader(new FileReader(args[0])))
        {
            m = Pattern.compile("^a").matcher("");

            while ((str = fin.readLine()) != null)
            {
                m.reset(str);
                if (m.find())
                {
                    System.out.println(str.split("([!?.,] *| +)")[0]);
                }
            }
        }
        catch (FileNotFoundException | ArrayIndexOutOfBoundsException ex)
        {
            ex.printStackTrace();
            System.out.println("Check input arguments");
            System.out.println("Miss task #5");
        }
        Show.getch();


        /** ---------------------------------- EX6 --------------------------------- */
        Show.show(6);
        str = "This is line 1\nHere is line 2\nThis is line 3\n";
        m = Pattern.compile("\\d$").matcher(str);
        while (m.find())
        {
            System.out.println("subsequence: " + m.group());
            System.out.println("    indexes: " + m.start() + "-" + m.end());
        }

        System.out.println("Done.");
    }
}


