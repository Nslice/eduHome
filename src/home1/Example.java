package home1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

class RightTriangle
{
    private double cathetus1;
    private double cathetus2;
    private double hypotenuse;
    //-------------------------------------------------------------------------

    RightTriangle(double cathetus1, double cathetus2)
    {
        this.cathetus1 = cathetus1;
        this.cathetus2 = cathetus2;
        this.hypotenuse = Math.sqrt(cathetus1 * cathetus1 + cathetus2 * cathetus2);
    }


    double getCathetus_1()
    {
        return cathetus1;
    }

    double getCathetus_2()
    {
        return cathetus2;
    }

    double getHypotenuse()
    {
        return hypotenuse;
    }

    double perimeter()
    {
        return cathetus1 + cathetus2 + hypotenuse;
    }

    double area()
    {
        return (cathetus1 * cathetus2) / 2.0;
    }

    double[] angles()
    {
        double[] val = new double[3];
        val[0] = 90;
        if (cathetus1 > cathetus2) val[1] = Math.sin(cathetus1 / hypotenuse) * 180 / Math.PI;
        else val[1] = Math.cos(cathetus2 / hypotenuse) * 180 / Math.PI;
        val[2] = 180 - val[1] - val[0];
        return val;
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
    public static void main(String[] args) throws Exception
    {
//        Date date = new Date();
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        System.out.println(calendar.getTime());
//        calendar.add(Calendar.WEEK_OF_MONTH, 1);
//        SimpleDateFormat simpleFormat = new SimpleDateFormat("dd.MM.yyyy - HH.mm");
//        System.out.println(simpleFormat.format(calendar.getTime()));


        System.out.println(Time.dob());
        System.out.println(Time.now());

        System.out.println();
        if (args.length > 1)
        {
            RightTriangle triangle = new RightTriangle(Double.parseDouble(args[0]), Double.parseDouble(args[1]));
            System.out.printf("%13s %.3f\n", "Hypotenuse:", triangle.getHypotenuse());
            System.out.printf("%13s %.3f\n", "Perimeter:", triangle.perimeter());
            System.out.printf("%13s %.3f\n", "Area:", triangle.area());

            System.out.printf("%13s ", "Angles:");
            double check = 0;
            for (double i : triangle.angles())
            {
                System.out.printf("%.3f   ", i);
                check += i;
            }
            System.out.println("\n\ncheck sum " + check);
        }

        Scanner scn = new Scanner(System.in);
        System.out.print("Entet the day number: ");
        System.out.println(Week.nameOfDay(scn.nextInt()));
    }
}
