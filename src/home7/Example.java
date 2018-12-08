package home7;

import home7.space.Planet;
import home7.calculations.Calc;

import java.util.Locale;
import java.util.Scanner;

public class Example
{


    public static void main(String[] args)
    {
        System.out.println("Example.main");

        try
        {
            Planet pl = new Planet("Earth", 4325, 5345, "Solar");

            System.out.println("pl = " + pl);
            pl.setName("Er");
            System.out.println("pl = " + pl);

        }
        catch (IllegalArgumentException e)
        {
            e.printStackTrace();
            e.getMessage();
            return;
        }
        System.out.println("\n");

        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.ENGLISH);

        double x, y;

        try
        {
            System.out.println("-(b != 0) and ((y>0 and x>0) or (y<0 and x<0))");
            System.out.println("Enter x, y:");
            x = in.nextDouble();
            y = in.nextDouble();
            System.out.printf("%.4f\n\n", Calc.formulaT1(x, y));

            System.out.println("(a != 0) and (x > 0)");
            System.out.println("Enter x:");
            x = in.nextDouble();
            System.out.printf("%.4f\n", Calc.formulaT2(x));
        }
        catch (Calc.CalcErr ex)
        {
            ex.printStackTrace();
            ex.getMessage();
            return;
        }


        System.out.println("Done.");

    }
}
