package p1.home;

public class RightTriangle
{
    private double cathetus1;
    private double cathetus2;
    private double hypotenuse;
    //-------------------------------------------------------------------------

    public RightTriangle(double cathetus1, double cathetus2)
    {
        this.cathetus1 = cathetus1;
        this.cathetus2 = cathetus2;
        this.hypotenuse = Math.sqrt(cathetus1 * cathetus1 + cathetus2 * cathetus2);
    }


    public double getCathetus_1()
    {
        return cathetus1;
    }

    public double getCathetus_2()
    {
        return cathetus2;
    }

    public double getHypotenuse()
    {
        return hypotenuse;
    }

    public double perimeter()
    {
        return cathetus1 + cathetus2 + hypotenuse;
    }

    public double area()
    {
        return (cathetus1 * cathetus2) / 2.0;
    }

    public double[] angles()
    {
        double[] val = new double[3];
        val[0] = 90;
        if (cathetus1 > cathetus2)
            val[1] = Math.toDegrees(Math.sin(cathetus1 / hypotenuse));
        else
            val[1] = Math.toDegrees(Math.cos(cathetus2 / hypotenuse));
        val[2] = 180 - val[1] - val[0];
        return val;
    }
}
