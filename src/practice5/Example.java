package practice5;

/*
    https://regex101.com
    https://regexone.com

    (clear regex):
    [ ]         - символьный класс
    [^5]        - отрицание, любой символ кроме '5'
    \Q 1+1 \E   - буквальное выражение между \Q и \E
    \b          - граница слова
    \B          - не граница слова
 */

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
        //ex1:
        Show.show(1);
        String str = "This is Jim and Timothy";
        Matcher m = Pattern.compile("[TJ]im").matcher(str);
        while (m.find())
        {
            System.out.println(m.group() + " : " + m.start() + "-" + m.end());
        }
        Show.getch();


        //ex2:
        Show.show(2);
        str = "This is Jim and Tom";
        m.reset(str);
        System.out.println("before: " + str);
        str = m.replaceAll("John");
        System.out.println(" after: " + str);
        Show.getch();


        //ex3:
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


        //ex4:
        Show.show(4);
        str = "The words are town torn ton toon house.";
        m = Pattern.compile("\\st(\\w)*o(\\w)*").matcher(str);
        while (m.find())
        {
            System.out.println(m.group() + "  " + m.start() + " " + m.end());
        }
        Show.getch();


        //ex5:
        Show.show(5);
        FileReader freader = null;
        try
        {
            freader = new FileReader(args[0]);
        }
        catch (FileNotFoundException | ArrayIndexOutOfBoundsException ex)
        {
            ex.printStackTrace();
            return;
        }
        BufferedReader fin = new BufferedReader(freader);
        m = Pattern.compile("^a").matcher("");

        while ((str = fin.readLine()) != null)
        {
            m.reset(str);
            if (m.find())
            {
                // System.out.println(str.split(" ")[0]); или так, но это не очень
                char ch;
                int i = m.start();
                while (Character.isAlphabetic(ch = str.charAt(i++)) && i < str.length())
                {
                    System.out.print(ch);
                }
                System.out.println();
            }
        }
        Show.getch();


        //ex6:
        Show.show(6);
        str = "This is line 1\nHere is line 2\nThis is line 3\n";
        m = Pattern.compile("\\d$").matcher(str);
        while (m.find())
        {
            System.out.println("subsequence: " + m.group());
            System.out.println("    indexes: " + m.start() + "-" + m.end());
        }


        freader.close();
        System.out.println("Done.");
    }
}


