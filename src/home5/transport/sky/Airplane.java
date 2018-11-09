package home5.transport.sky;


import home5.transport.Vehicle;


public class Airplane extends Vehicle
{
    /**
     * Высота полета
     */
    private double flightAltitude;


    //------------------------------------------------------------------------


    public Airplane(int ccode) throws CountryError
    {
        super(ccode);
    }

    public Airplane(Vehicle obj, double flightAltitude)
    {
        super(obj);
        this.flightAltitude = flightAltitude;
    }

    public Airplane(int ccode, double weight, double power, double maxSpeed,
                    double flightAltitude) throws CountryError
    {
        super(ccode, weight, power, maxSpeed);
        this.flightAltitude = flightAltitude;
    }




    @Override
    public void show()
    {

    }
}