package home5.transport.ground;

import home5.transport.Vehicle;


public class Car extends Vehicle
{
    /**
     * Объем двигателя, литры (L)
     */
    protected double engineCapacity;

    /**
     * Мощность двигателя, лошадиные силы (hp)
     */
    protected double power;

    /**
     * Максимальный объем бака, литры (L)
     */
    protected double fuelTankCapacity;

    /**
     * Количество топлива, литры (L)
     */
    protected double fuelLevel;
    //------------------------------------------------------------------------


    /****************************************************
     *                КОНСТРУКТОРЫ
     ****************************************************/

   public Car(int ccode) throws CountryError
    {
        super(ccode);
    }

    public Car(int ccode, String model, double weight, double maxSpeed)
            throws CountryError
    {
        super(ccode, model, weight, maxSpeed);
    }

    public Car(Vehicle obj)
    {
        super(obj);
    }


    /****************************************************
     *                МЕТОДЫ ДОСТУПА
     ****************************************************/
    public double getEngineCapacity()
    {
        return engineCapacity;
    }

    public double getPower()
    {
        return power;
    }

    public double getFuelTankCapacity()
    {
        return fuelTankCapacity;
    }

    public double getFuelLevel()
    {
        return fuelLevel;
    }

    public void setEngineCapacity(double engineCapacity)
    {
        this.engineCapacity = engineCapacity;
    }

    public void setPower(double power)
    {
        this.power = power;
    }

    public void setFuelTankCapacity(double fuelTankCapacity)
    {
        this.fuelTankCapacity = fuelTankCapacity;
    }

    public void setFuelLevel(double fuelLevel)
    {
        this.fuelLevel = fuelLevel;
    }


    /****************************************************
     *                ДРУГИЕ МЕТОДЫ
     ****************************************************/

    /**
     * Заправить бак.
     * @param liters кол-во литров
     * @return false, если не вместилось
     */
    public boolean fillTank(double liters)
    {
        if (fuelLevel + liters <= fuelTankCapacity)
        {
            fuelLevel += liters;
            return true;
        }
        else
            return false;
    }


    public int drive(int kilometres)
    {
        /*
           Формула расхода
           1300 кг
           1.5 литров объем, 110 л.с, speed

         */
        return 0;
    }

    //    @Override
//    public String toString()
//    {
//        String str = "Country: " + country + "\n" +
//                "Model: " + model + "\n" +
//                "Weight: " + weight + " kg\n" +
//                "Power: " + power + " hp\n" +
//                "Max.speed: " + maxSpeed + " km/h\n" +
//                "Engine capacity: " + engineCapacity + " L\u00B3";
//        return str;
//    }


}