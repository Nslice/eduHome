package p3.home.calculations;


public class NumberSeries
{
    private static final double EPS = 0.000_001;

    //--------------------------------------------------------------------
    private static double funcA(int n)
    {
        return Math.pow(-1, n) * ((n + 1) / Math.pow(2, n - 1));
    }


    public static double calculate()
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


    public static double calculate(int amount)
    {
        double sum = 0.0, result;
        for (int n = 0; n < amount; n++)
        {
            result = funcA(n);
            sum += result;
            if (Math.abs(result) < EPS) break;
        }
        return sum;
    }
}