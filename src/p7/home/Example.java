package p7.home;

import p7.home.calculations.Calc;
import p7.home.space.Planet;

import java.util.Locale;
import java.util.Scanner;

public class Example
{
    public static void main(String[] args)
    {
        try
        {
            Planet pl = new Planet("Earth", 4325, 5345, "Solar");

            System.out.println("pl = " + pl);
            pl.setName("Er");
            System.out.println("pl = " + pl);
            pl.setWeight(-2);

        }
        catch (IllegalArgumentException ex)
        {
            ex.printStackTrace();
            System.out.println("exp.message: \"" + ex.getMessage() + "\"");
        }
        System.out.println("\n");



        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.ENGLISH);

        while (true)
        {
            try
            {
                double x, y;
                System.out.println("Condition: ((y>0 and x>0) or (y<0 and x<0))");
                System.out.println("Enter x, y:");
                x = in.nextDouble();
                y = in.nextDouble();
                System.out.printf("%.4f\n\n", Calc.formulaT1(x, y));

                System.out.println("Condition: (x > 0)");
                System.out.println("Enter x:");
                x = in.nextDouble();
                System.out.printf("%.4f\n", Calc.formulaT2(x));
                break;
            }
            catch (Calc.CalcErr ex)
            {
                System.out.println("EXCEPTION");
                System.out.println("exp.message: \"" + ex.getMessage() + "\"");
                System.out.println("\n-----------------Enter again\n");
                continue;
            }
        }


        in.close();
        System.out.println("Done.");
    }
}
