package home5.transport.ground;

import home5.transport.Vehicle;


public class Truck extends Car
{
    /**
     * Грузоподъемность, килограммы (kg)
     */
    protected double carrying;



























    public Truck(int ccode) throws Vehicle.CountryError
    {
        super(ccode);
    }
}
