package home5.transport.ground;

import home5.transport.Vehicle;

public class Car extends Vehicle
{

    /** Объем двигателя */
    protected double engineCapacity;

    //------------------------------------------------------------------------

    public Car(int ccode) throws CountryError
    {
        super(ccode);
    }

    public Car(Vehicle obj, double engineCapacity)
    {
        super(obj);
        this.engineCapacity = engineCapacity;
    }

    public Car(int ccode, double weight, double power, double maxSpeed,
                    double engineCapacity) throws CountryError
    {
        super(ccode, weight, power, maxSpeed);
        this.engineCapacity = engineCapacity;
    }




    @Override
    public void show()
    {

    }
}