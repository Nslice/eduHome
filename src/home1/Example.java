package home1;

import other.Show;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;


class Time
{
    static String dob()
    {
        return Time.dob("dd.MM.yyyy");
    }

    static String dob(String form)
    {
        Calendar cl = Calendar.getInstance();
        cl.set(1997, 7, 19);
        SimpleDateFormat formatDate = new SimpleDateFormat(form);
        return formatDate.format(cl.getTime());
    }

    static String now()
    {
        return new Date().toString();
    }
}



class Week
{
    static String[] daysName = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

    static String nameOfDay(int n)
    {
        n = (n > 7) ? 7 : n;
        n = (n < 1) ? 1 : n;
        return daysName[n - 1];
    }
}



public class Example
{
    public static void main(String[] args)
    {
        //ex1:
        Show.show(1);
        System.out.println(Time.dob());
        System.out.println(Time.now());
        Show.getch();


        //ex2:
        Show.show(2);

        if (args.length > 1)
        {
            RightTriangle triangle = new RightTriangle(Double.parseDouble(args[0]), Double.parseDouble(args[1]));
            System.out.printf("%13s %.3f\n", "Hypotenuse:", triangle.getHypotenuse());
            System.out.printf("%13s %.3f\n", "Perimeter:", triangle.perimeter());
            System.out.printf("%13s %.3f\n", "Area:", triangle.area());

            System.out.printf("%13s ", "Angles:");
            double checkSum = 0;
            for (double i : triangle.angles())
            {
                System.out.printf("%.3f   ", i);
                checkSum += i;
            }
            System.out.println("\n\ncheckSum " + checkSum);
        }
        else System.out.println("Not enough arguments");

        Show.getch();


        //ex3:
        Show.show(3);
        Scanner scn = new Scanner(System.in);
        scn.useLocale(Locale.ENGLISH);
        System.out.print("Entet the day number: ");
        System.out.println(Week.nameOfDay(scn.nextInt()));
        scn.close();
    }

}
