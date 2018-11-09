package home5.transport.sky;


public class SkyTruck extends Airplane
{
    /** Грузоподемность */
    protected double carrying;

    //------------------------------------------------------------------------


    public SkyTruck(int ccode, double weight, double power, double maxSpeed,
                    double flightAltitude, double carrying) throws CountryError
    {
        super(ccode, weight, power, maxSpeed, flightAltitude);
        this.carrying = carrying;
    }
}

