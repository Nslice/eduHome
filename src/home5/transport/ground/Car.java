package home5.transport.ground;

import home5.transport.Vehicle;


public class Car extends Vehicle
{
    private double tankVolume = -1;  // Максимальный объем бака, литры (L)
    private double consumption = -1; // Расход на 100 км, литры (L)
    private double fuelLevel = 0.0;  // Количество топлива, литры (L)
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

    /**
     * Проверяет инициализирован объект полностью или нет.
     *
     * @return false - если не все поля инициализированы.
     */
    @Override
    public boolean constructed()
    {
        return super.constructed() && (tankVolume > 0 && consumption > 0);
    }


    /****************************************************
     *                МЕТОДЫ ДОСТУПА
     ****************************************************/

    public double getTankVolume()
    {
        return tankVolume;
    }

    public double getConsumption()
    {
        return consumption;
    }
    
    public Car setTankVolume(double tankVolume)
    {
        this.tankVolume = tankVolume;
        return this;
    }

    public Car setConsumption(double consumption)
    {
        this.consumption = consumption;
        return this;
    }

    @Override
    public double getFuelLevel()
    {
        return fuelLevel;
    }

    @Override
    public Car setFuelLevel(double fuelLevel)
    {
        if (fuelLevel > tankVolume)
            this.fuelLevel = tankVolume;
        else
            this.fuelLevel = fuelLevel;
        return this;
    }


    /****************************************************
     *                ДРУГИЕ МЕТОДЫ
     ****************************************************/

    /**
     * Заправить бак.
     *
     * @param liters кол-во литров.
     * @return false, если не вместилось или объект недоинициализирован.
     */
    public boolean fillTank(double liters)
    {
        if (!constructed())
            return false;
        if (fuelLevel + liters <= tankVolume)
        {
            fuelLevel += liters;
            return true;
        }
        else
            return false;
    }

    /**
     * Ехать.
     *
     * @param km сколько надо ехать.
     * @return километров проехано.
     */
    public int drive(int km)
    {
        if (!constructed())
            return 0;
        int resM = 0;
        double litresOnKm = consumption / 100; //расход на 1 км
        System.out.print("Driving:");

        while ((fuelLevel - litresOnKm) >= 0 && km > 0)
        {
            km--;
            resM++;
            fuelLevel -= litresOnKm;
            System.out.print("-");
        }

        System.out.println();
        return resM;
    }

    /**
     * Выводит всю информацию.
     *
     * @return
     */
    @Override
    public String toString()
    {
        String str = "Country: " + getCountry() + "\n" +
                "Model: " + getModel() + "\n" +
                "Weight: " + getWeight() + " kg\n" +
                "Max.speed: " + getMaxSpeed() + " km/h\n" +
                "Fuel tank volume: " + tankVolume + " L\n" +
                "Fuel consumption on 100 km: " + consumption + " L\n" +
                "Fuel level: " + fuelLevel + " L";
        return str;
    }

}