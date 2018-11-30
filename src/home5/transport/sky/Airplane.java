package home5.transport.sky;

import home5.transport.Vehicle;


public class Airplane extends Vehicle
{
    /**
     * Высота полета, метры (m)
     */
    protected double flightAltitude = 0.0;

    /**
     * Максимальный объем бака, литры (L)
     */
    protected double fuelTankCapacity = -1;

    /**
     * Расход на 100 км, литры (L)
     */
    protected double fuelConsumption = -1;


    /**
     * Общее количество топлива, литры (L)
     */
    protected double fuelLevel = 0.0;


    //------------------------------------------------------------------------
    public Airplane(int ccode) throws CountryError
    {
        super(ccode);
    }

    public Airplane(Vehicle obj)
    {
        super(obj);
    }

    public Airplane(int ccode, double weight, double power, double maxSpeed)
            throws CountryError
    {
        super(ccode, "", power, maxSpeed);
    }

    @Override
    public boolean constructed()
    {
        return super.constructed();
    }


    /***************************************************
     *                МЕТОДЫ ДОСТУПА
     ****************************************************/

    public double getFlightAltitude()
    {
        return flightAltitude;
    }

    public double getFuelTankCapacity()
    {
        return fuelTankCapacity;
    }

    public double getFuelConsumption()
    {
        return fuelConsumption;
    }

    public double getFuelLevel()
    {
        return fuelLevel;
    }


    public void setFlightAltitude(double flightAltitude)
    {
        this.flightAltitude = flightAltitude;
    }

    public void setFuelTankCapacity(double fuelTankCapacity)
    {
        this.fuelTankCapacity = fuelTankCapacity;
    }

    public void setFuelConsumption(double fuelConsumption)
    {
        this.fuelConsumption = fuelConsumption;
    }

    public void setFuelLevel(double fuelLevel)
    {
        this.fuelLevel = fuelLevel;
    }


    /****************************************************
     *                ДРУГИЕ МЕТОДЫ
     ****************************************************/

//    @Override
//    public String toString()
//    {
//        String str = "Country: " + country + "\n" +
//                "Model: " + model + "\n" +
//                "Weight: " + weight + " kg\n" +
//                "Power: " + power + " hp\n" +
//                "Max.speed: " + maxSpeed + " km/h\n" +
//                "Flight altitude: " + flightAltitude + " m";
//        return str;
//    }

}