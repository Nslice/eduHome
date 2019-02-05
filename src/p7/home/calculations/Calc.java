package p7.home.calculations;


public class Calc
{

    public static class CalcErr extends Exception
    {
        public CalcErr(String message)
        {
            super(message);
        }

    }

    public static double formulaT1(double x, double y) throws CalcErr
    {
        if (!((y > 0 && x > 0) || (y < 0 && x < 0)))
            throw new CalcErr("x = " + x + ", y = " + y);
        
        double a = 2.1, b = 4.7;
        return (1 / (b * b)) * (Math.log(y / x) + a * x / y);
    }


    public static double formulaT2(double x) throws CalcErr
    {
        if (x <= 0)
            throw new CalcErr("x = " + x);

        double a = 0.7;
        double op1 = -(x / a) * Math.tan(a * x / 2);
        double op2 = 2 / (a * a) * Math.log(Math.sin(a * x / 2));
        return op1 + op2;
    }
}
