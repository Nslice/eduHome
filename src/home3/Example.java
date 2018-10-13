package home3;

import home3.calculations.*;
import other.Show;

import java.util.Locale;
import java.util.Scanner;


public class Example
{
    public static void main(String[] args) throws Exception
    {
        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.ENGLISH);

        //ex1:
        Show.show(1);
        System.out.println("Sum of series:        " + NumberSeries.calculate());
        System.out.println("Sum of first 10 term: " + NumberSeries.calculate(10));
        Show.getch();


        //ex2:
        Show.show(2);
        Formula anno;
        double x, y;

        anno = Calc.class.getDeclaredMethod("formulaT1", double.class, double.class).getAnnotation(Formula.class);
        System.out.println("CONDITION: " + anno.condition() + "\nFORMULA: " + anno.description());
        System.out.println("Enter x, y:");
        x = in.nextDouble();
        y = in.nextDouble();
        System.out.printf("%.4f\n\n", Calc.formulaT1(x, y));

        anno = Calc.class.getDeclaredMethod("formulaT2", double.class).getAnnotation(Formula.class);
        System.out.println("CONDITION: " + anno.condition() + "\nFORMULA: " + anno.description());
        System.out.println("Enter x:");
        x = in.nextDouble();
        System.out.printf("%.4f\n", Calc.formulaT2(x));

        Show.getch();


        //ex3:
        Show.show(3);
        MyArray array = new MyArray(200, 0, 100);
        array.show();
        int amount = 10;
        System.out.println("Enter the length of the segment to search ('0' to quit): ");

        while ((amount = in.nextInt()) != 0)
        {
            try
            {
                int index = array.find(amount);
                System.out.print("On the segment " + index + " : " + (index + amount - 1) + " the maximum sum");
                System.out.println(" (" + array.sum(index, amount) + ")");
            }
            catch (IndexOutOfBoundsException ex)
            {
                System.out.println("Invalid argument");
                ex.printStackTrace();
            }
        }

        in.close();
        System.out.println("Done.");


    }

}
