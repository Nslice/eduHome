package practice1;

import commonClasses.Show;
import java.io.StringReader;
import java.lang.StringBuffer;
import java.util.Stack;
import java.util.StringTokenizer;


public class Example
{
    public static void main(String[] args) throws java.io.IOException
    {
        //ex1:
        Show.show(1);
        String str1 = "Event";
        String str2 = "Event";
        System.out.println("str1: " + str1 + "  str2: " + str2);

        if (str1.equals(str2))
            System.out.println("string are equal");
        else
            System.out.println("strings are not equal");

        System.out.println("str1 == str2 = " + (str1 == str2));
        System.out.println("str1.equalsIgnoreCase(\"eVent\") = " + str1.equalsIgnoreCase("eVent"));
        Show.getch();


        //ex2:
        Show.show(2);
        str2 = "Tool";
        if (str1.compareTo(str2) > 0)
            System.out.println("str1 follows the str2");
        else if (str1.compareTo(str2) < 0)
            System.out.println("str2 follows the str1");
        else
            System.out.println("str1 is equal str2");

        Show.getch();


        //ex3:
        Show.show(3);
        String myAdress = "Kyrgyzstan, Bihskek, Victory street, house 4, flat 65";
        String myStreet = myAdress.substring(21, 35);
        System.out.println("myStreet = " + myStreet);
        System.out.println("myAdress.indexOf(\"street\") = " + myAdress.indexOf("street"));
        System.out.println("myAdress.indexOf('e', 9) = " + myAdress.indexOf('e', 9));
        Show.getch();


        //ex4:
        Show.show(4);
        String str = "Coffee";
        for (int i = 0; i < str.length(); i++)
            System.out.println(str.charAt(i));

        System.out.println();
        StringReader reader = new StringReader(str);
        char[] chars = new char[str.length()];
        reader.read(chars, 0, str.length());
        for (char ch : chars)
            System.out.println(ch);
        Show.getch();


        //ex5:
        Show.show(5);
        str = "Microphone";
        System.out.println(str + " " + new StringBuffer(str).reverse());
        Show.getch();


        //ex6:
        Show.show(6);
        str = "Inserts the string into this";
        StringTokenizer tokenizer = new StringTokenizer(str);

        Stack<String> stack = new Stack<>();
        while (tokenizer.hasMoreTokens())
            stack.push(tokenizer.nextToken());

        StringBuffer revStr = new StringBuffer();
        while (!stack.empty())
        {
            if (revStr.length() != 0)
                revStr.insert(revStr.length(), " " );

            revStr.insert(revStr.length(), stack.pop() );
        }

        System.out.println(str + "\n" + revStr);
        Show.getch();


        //ex7:
        Show.show(7);
        str = "Microphone";
        str = str.toUpperCase();
        System.out.println("str = " + str);
        str = str.toLowerCase();
        System.out.println("str = " + str);
        Show.getch();


        //ex8:
        Show.show(8);
        str = "          monitor        ";
        System.out.println("|" + str + "|" + "\n|" + str.trim() + "|");
        Show.getch();


        //ex9:
        Show.show(9);
        str = "one, two, three, four";
        String[] lines = str.split("[ ]");
        for (String s : lines)
            System.out.println(s);

        System.out.println("\nTokens:");
        tokenizer = new StringTokenizer(str);
        while (tokenizer.hasMoreTokens())
            System.out.println(tokenizer.nextToken());

    }
}
