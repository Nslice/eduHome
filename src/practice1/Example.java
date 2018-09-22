package practice1;

import java.io.StringReader;
import java.lang.StringBuffer;
import java.util.Stack;
import java.util.StringTokenizer;



public class Example
{
    public static void main(String[] args) throws java.io.IOException
    {
        String str1 = "Tool";
        String str2 = "Event";
        System.out.println("str1: " + str1 + "  str2: " + str2);


        if (str1.equals(str2))
            System.out.println("string are equal");
        else
            System.out.println("strings are not equal");

        System.out.println("str1 == str2 = " + (str1 == str2));
        System.out.println("str1.equalsIgnoreCase(\"TOOL\") = " + str1.equalsIgnoreCase("TOOL"));


        //ex2:

//        int c = "foo".compareTo((String)null); //NullPointerException
        if (str1.compareTo(str2) > 0)
            System.out.println("sr1 follows the str2");
        else if (str1.compareTo(str2) < 0)
            System.out.println("sr2 follows the str1");
        else
            System.out.println("str1 is equal str2");

        //ex3:
        System.out.println();
        String myAdress = "Kyrgyzstan, Bihskek, Victory street, house 4, flat 65";
        String myStreet = myAdress.substring(21, 35);
        System.out.println("myStreet = " + myStreet);
        System.out.println("myAdress.indexOf(\"street\") = " + myAdress.indexOf("street"));
        System.out.println("myAdress.indexOf('e', 9) = " + myAdress.indexOf('e', 9));

        //ex4:
        System.out.println();
        String str = "Coffee";
        for (int i = 0; i < str.length(); i++)
            System.out.println(str.charAt(i));

        System.out.println();
        StringReader reader = new StringReader(str);
        char[] chars = new char[str.length()];
        reader.read(chars, 0, str.length());
        for (char ch : chars)
            System.out.println(ch);

        //ex5:
        System.out.println();
        str = "Microphone";
        System.out.println(str + " " + new StringBuffer(str).reverse());


        //ex6:
        System.out.println();
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

        //ex7:
        System.out.println();
        str = "Microphone";
        str = str.toUpperCase();
        System.out.println("str = " + str);
        str = str.toLowerCase();
        System.out.println("str = " + str);

        //ex8:
        System.out.println();
        str = "          monitor        ";
        System.out.println("|" + str + "|" + "\n|" + str.trim() + "|");

        //ex9:
        System.out.println();
        str = "one, two, three, four";
        String[] lines = str.split("[ ]");
        for (String s : lines)
            System.out.println(s);


        System.out.println("\nTokens:");
        tokenizer = new StringTokenizer(str, " ");
        while (tokenizer.hasMoreTokens())
            System.out.println(tokenizer.nextToken());

    }
}
