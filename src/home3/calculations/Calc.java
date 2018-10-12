package home3.calculations;


public class Calc
{
    @Formula(description = "(1/b^2) * (ln(y/x) + ax/y)",
            condition = "(b,x,y != 0) and ((y>0 and x>0) or (y<0 and x<0))")
    public static double formulaT1(double x, double y)
    {
        double a = 2.1, b = 4.7;
        return (1 / (b * b)) * (Math.log(y / x) + a * x / y);
    }


    @Formula(description = "-(x/a)tg(ax/2) + (2/a^2)ln(sin(ax/2))",
            condition = "(a != 0) and (x > 0)")
    public static double formulaT2(double x)
    {
        double a = 0.7;
        double op1 = -(x / a) * Math.tan(a * x / 2);
        double op2 = 2 / (a * a) * Math.log(Math.sin(a * x / 2));
        return op1 + op2;
    }
}
