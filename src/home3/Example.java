package home3;

import java.util.Random;



class NumberSeries
{
    static final double EPS = 0.000001;

    //--------------------------------------------------------------------
    private static double funcA(int n)
    {
        return Math.pow(-1, n) * ((n + 1) / Math.pow(2, n - 1));
    }

    static double calculate()
    {
        int n = 0;
        double result;
        do
        {
            result = funcA(n);
            n++;
        } while (Math.abs(result) > EPS);

        return result;
    }

    static double sumFirstMembers(int amount)
    {
        double sum = 0;
        double result;

        for (int i = 0, n = 0; i < amount; i++, n++)
        {
            result = funcA(n);
            sum += result;
            if (Math.abs(result) < EPS) break;
        }

        return sum;
    }
}


class Calc
{
    private double t1;
    private double t2;

    private double a;
    private double b;


    //--------------------------------------------------------------------
    /**
     * ОДЗ:
     * a != 0
     * b != 0
     * x != 0
     * y != 0
     */
    public Calc(int x, int y)
    {
        Random rand = new Random();
        this.a = rand.nextDouble();

    }
    public double formulaT1()
    {
        double y = 2.2, x = 3.1;
        double b = 2, a = 3;
        t1 = (1 / (b * b)) * (Math.log(y / x) + a * x / y);

        //---------



        return 9.9;
    }

    public double formulaT2()
    {
        double y = 2.2, x = 3.1;
        double b = 2, a = 3;

        double op1 = -(x / a) * Math.tan(a * x / 2);
        double op2 = 2 / (a * a) * Math.log(Math.sin(a * x / 2));
        t2 = op1 + op2;



        return 9.9;
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
    }

    int find(int amount)
    {
        if (arr.length == 0)
            return -1;

        int sum, max = 0;
        int index = 0;

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
    public static void main(String[] args)
    {
        System.out.println(NumberSeries.sumFirstMembers(10));
        System.out.println(NumberSeries.calculate());


        MyArray array = new MyArray(200,0, 100);
        array.show();
        int amt = 10;
        System.out.println("Участок из " + amt + " элементов, сумма лялял...");
        int index = array.find(amt);
        System.out.println("участок " + index + " : " + (index + amt));


    }
}
