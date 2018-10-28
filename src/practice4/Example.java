package practice4;

import other.Show;

import java.text.NumberFormat;
import java.util.Random;

import static java.lang.Math.*;


public class Example
{
    public static void main(String[] args)
    {
        //ex1:
        Show.show(1);
        String str1 = "01FF", str2 = " 423";
        System.out.printf("str1 = |%s|\n", str1);
        System.out.printf("str2 = |%s|\n", str2);

        System.out.println("\nTry to parse:");
        try
        {
            System.out.println("str1 = " + Integer.parseInt(str1, 16));
            System.out.println("str2 = " + Integer.parseInt(str2));
        }
        catch (NumberFormatException ex)
        {
            System.out.println("Exception " + ex.getMessage());
            ex.printStackTrace();
        }
        Show.getch();


        //ex2:
        Show.show(2);
        Float f1 = 43.4f, f2 = 43.4f;
        System.out.println("f1 = " + f1 + "\nf2 = " + f2);
        System.out.println("f1.equals(f2) = " + f1.equals(f2));
        f2++;
        System.out.println("\nf1 = " + f1 + "\nf2 = " + f2);
        System.out.println("f1.equals(f2) = " + f1.equals(f2));
        Show.getch();


        //ex3:
        Show.show(3);
        f1 = 27.574f;
        f2 = 27.613f;
        System.out.println("f1 = " + f1 + "\nf2 = " + f2);

        if (abs(f1 - f2) <= 0.05f)
            System.out.println("equals, difference is " + abs(f1 - f2));
        else
            System.out.println("not equals, difference is " + abs(f1 - f2));

        Show.getch();


        //ex4:
        Show.show(4);
        System.out.println("323.54f, round = " + round(323.54f));
        System.out.println("28.786, round = " + round(28.786));
        Show.getch();


        //ex5:
        Show.show(5);
        double value = 1_623_542.765;
        NumberFormat formatter = NumberFormat.getNumberInstance();
        System.out.println(value);
        System.out.println(formatter.format(value));
        Show.getch();


        //ex6:
        Show.show(6);
        value = 0.8;
        formatter = NumberFormat.getPercentInstance();
        System.out.println(value);
        System.out.println(formatter.format(value));
        Show.getch();


        //ex7:
        Show.show(7);
        value = 567_123_678.99;
        formatter = NumberFormat.getCurrencyInstance(/*Locale.US*/);
        System.out.println(formatter.format(value));
        Show.getch();


        //ex8:
        Show.show(8);
        int val = 24;
        System.out.println("DEC: " + val);
        System.out.println("BIN: " + Integer.toBinaryString(val));
        System.out.println("OCT: " + Integer.toOctalString(val));
        System.out.println("HEX: " + Integer.toHexString(val));
        Show.getch();


        //ex9:
        Show.show(9);
        Random rand = new Random();
        System.out.println("with \"Random\":");
        System.out.println("random int = " + rand.nextInt(500));
        System.out.println("random double = " + rand.nextDouble() * rand.nextInt(100));

        System.out.println("\nwith \"Math\":");
        System.out.println("random int = " + (int) (Math.random() * 500));
        System.out.println("random double = " + Math.random());
        Show.getch();


        //ex10:
        Show.show(10);
        double grads = 45;
        double rads = toRadians(grads);
        System.out.println("sin(" + grads + ") = " + sin(rads));
        System.out.println("cos(" + grads + ") = " + cos(rads));
        System.out.println("tan(" + grads + ") = " + tan(rads));
        Show.getch();


        //ex11:
        Show.show(11);
        value = 125.5;
        System.out.println("log(" + value + ") = " + log(125.5));
        System.out.println("log10(" + value + ") = " + log10(125.5));
    }

}
