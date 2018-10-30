package practice6;

import other.Show;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Formatter;
import java.util.Locale;


public class Example
{
    public static void main(String[] args) throws java.io.IOException
    {
        //ex1:
//        Show.show(1);
//        StringBuffer sb = new StringBuffer();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while (!(line = reader.readLine()).equals("quit"))
//        {
//            sb.append(line).append("\n");
//
//        }
//        System.out.println("THIS: " + sb);


        //ex2:
        Show.show(2);
        float hits = 10, a = 3;
        System.out.println(String.format("hits / a = %.3f", hits / a));
        System.out.println(new Formatter().format("hits / a = %.3f", hits / a));


        //ex3:
        Show.show(3);
        Calendar c = Calendar.getInstance();
        System.out.format("%tB %te, %tY%n", c, c, c);


        //ex4:
        Show.show(4);



        System.out.println("Done.");
    }
}
