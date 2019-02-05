package home5.transport.ground;

import home5.transport.Vehicle;


public class Truck extends Car
{
    private double loadCapacity = -1; // Грузоподъемность, килограммы (kg)
    private double loadLevel = 0.0;   // Всего загружено (kg)
    //------------------------------------------------------------------------


    /****************************************************
     *                КОНСТРУКТОРЫ
     ****************************************************/

    public Truck(int ccode) throws CountryError
    {
        super(ccode);
    }

    public Truck(int ccode, String model, double weight, double maxSpeed)
            throws CountryError
    {
        super(ccode, model, weight, maxSpeed);
    }

    public Truck(Vehicle obj)
    {
        super(obj);
    }

    /**
     * Проверяет инициализирован объект полностью или нет.
     *
     * @return false - если поля не инициализированы кроме loadLevel.
     */
    @Override
    public boolean constructed()
    {
        return super.constructed() && (loadCapacity > 0);
    }


    /****************************************************
     *                МЕТОДЫ ДОСТУПА
     ****************************************************/

    public double getLoadCapacity()
    {
        return loadCapacity;
    }

    public double getLoadLevel()
    {
        return loadLevel;
    }

    public Truck setLoadCapacity(double loadCapacity)
    {
        this.loadCapacity = loadCapacity;
        return this;
    }

    @Override
    public Truck setTankVolume(double tankVolume)
    {
        return (Truck) super.setTankVolume(tankVolume);
    }

    @Override
    public Truck setConsumption(double consumption)
    {
        return (Truck) super.setConsumption(consumption);
    }

    @Override
    public Truck setFuelLevel(double fuelLevel)
    {
        return (Truck) super.setFuelLevel(fuelLevel);
    }

    /****************************************************
     *                ДРУГИЕ МЕТОДЫ
     ****************************************************/

    /**
     * Погрузка.
     *
     * @param load кол-во килограмм.
     * @return false, если не вместилось или объект недоинициализирован.
     */
    public boolean loading(double load)
    {
        if (!constructed())
            return false;
        if (load > (loadCapacity - loadLevel))
        {
            System.out.println("Too much weight");
            return false;
        }
        else
        {
            loadLevel += load;
            super.setWeight(super.getWeight() + loadLevel);
            return true;
        }
    }

    /**
     * Разгрузка.
     *
     * @param load кол-во килограмм.
     * @return false, если нечего или объект недоинициализирован.
     */
    public boolean unloading(double load)
    {
        if (!constructed())
            return false;
        if (load > loadLevel)
        {
            return false;
        }
        else
        {
            loadLevel -= load;
            super.setWeight(super.getWeight() - loadLevel);
            return true;
        }
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
                "Load capacity: " + loadCapacity + " kg\n" +
                "Load level: " + loadLevel + " kg\n" +
                "Fuel tank volume: " + getTankVolume() + " L\n" +
                "Fuel consumption on 100 km: " + getConsumption() + " L\n" +
                "Fuel level: " + getFuelLevel() + " L";
        return str;
    }


}
