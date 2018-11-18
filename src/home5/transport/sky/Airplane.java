package home5.transport.sky;

import home5.transport.Vehicle;


public class Airplane extends Vehicle
{
    /**
     * Высота полета, метры (m)
     */
    protected double flightAltitude;

    /**
     * Количество двигателей
     */
    protected int engineCount;

    /**
     * Мощность одного двигателя, лошадиные силы (hp)
     */
    protected double power; //110_000 лс.

    /**
     * Количество баков
     */
    protected int tankCount;

    /**
     * Максимальный объем одного бака, литры (L)
     */
    protected double fuelTankCapacity;

    /**1
     * Общее количество топлива, литры (L)
     */
    protected double fuelLevel;



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

    /***************************************************
     *                МЕТОДЫ ДОСТУПА
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