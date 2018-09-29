package home3;

import commonClasses.Show;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Random;
import java.util.Scanner;


class NumberSeries
{
    static final double EPS = 0.000_001;

    //--------------------------------------------------------------------
    private static double funcA(int n)
    {
        return Math.pow(-1, n) * ((n + 1) / Math.pow(2, n - 1));
    }

    static double calculate()
    {
        int n = 0;
        double sum = 0.0, result;
        do
        {
            result = funcA(n++);
            sum += result;
        } while (Math.abs(result) > EPS);

        return sum;
    }

    static double calculate(int amount)
    {
        double sum = 0.0, result;
        for (int i = 0, n = 0; i < amount; i++, n++)
        {
            result = funcA(n);
            sum += result;
            if (Math.abs(result) < EPS) break;
        }

        return sum;
    }
}


@Retention(RetentionPolicy.RUNTIME)
@interface Formula
{
    String description();

    String admissilbeVals();
}

class Calc
{
    @Formula(description = "(1/b^2) * (ln(y/x) + ax/y)   ",
            admissilbeVals = "(b,x,y != 0) and ((y>0 and x>0) or (y<0 and x<0))")
    static double formulaT1(double x, double y)
    {
        double a = 2.1, b = 4.7;
        return (1 / (b * b)) * (Math.log(y / x) + a * x / y);
    }


    @Formula(description = "-(x/a)tg(ax/2) + (2/a^2)ln(sin(ax/2))",
            admissilbeVals = "(a != 0) and (x > 0)")
    static double formulaT2(double x)
    {
        double a = 0.7;
        double op1 = -(x / a) * Math.tan(a * x / 2);
        double op2 = 2 / (a * a) * Math.log(Math.sin(a * x / 2));
        return op1 + op2;
    }
}


class MyArray
{
    private int[] arr;

    //--------------------------------------------------------------------
    MyArray(int size, int low, int high)
    {
        arr = new int[size];
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++)
            arr[i] = low + rand.nextInt(high);
    }

    void show()
    {
        for (int i = 0; i < arr.length; i++)
        {
            if (i % 10 == 0) System.out.println();
            System.out.printf("[%4d]%3d ", i, arr[i]);
        }
        System.out.println();
    }

    int find(int amount)
    {
        if (arr.length == 0)
            return -1;

        int sum, max = 0;
        int index = -1;

        for (int i = 0; i <= arr.length - amount; i++)
        {
            sum = 0;
            for (int j = 0; j < amount; j++)
                sum += arr[i + j];
            if (sum > max)
            {
                max = sum;
                index = i;
            }
        }

        return index;
    }

}


public class Example
{
    public static void main(String[] args) throws Exception
    {
        Scanner in = new Scanner(System.in);
        /*
            для кириллицы в консоле:
            > chcp 1251;
            > javac -encoding utf8 %1.java
        */

        //ex1:
        Show.show(1);
        System.out.println(NumberSeries.calculate());
        System.out.println(NumberSeries.calculate(10));
        Show.getch();


        //ex2:
        Show.show(2);
        Formula anno;
        double x, y;

        anno = Calc.class.getDeclaredMethod("formulaT1", double.class, double.class).getAnnotation(Formula.class);
        System.out.println("formula: " + anno.description() + "\n" + anno.admissilbeVals());
        System.out.println("Enter x, y:");
        x = in.nextDouble();
        y = in.nextDouble();
        System.out.printf("%.4f\n\n", Calc.formulaT1(x, y));

        anno = Calc.class.getDeclaredMethod("formulaT2", double.class).getAnnotation(Formula.class);
        System.out.println("formula: " + anno.description() + "\n" + anno.admissilbeVals());
        System.out.println("Enter x:");
        x = in.nextDouble();
        System.out.printf("%.4f\n", Calc.formulaT2(x));

        Show.getch();


        //ex3:
        Show.show(3);
        MyArray array = new MyArray(200, 0, 100);
        array.show();
        int amount = 10;
        amount = in.nextInt();
        int index = array.find(amount);
        System.out.println("На участке " + index + " : " + (index + amount) + " сумма максимальна");
    }

}
