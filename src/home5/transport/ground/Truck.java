package home5.transport.ground;

import home5.transport.Vehicle;


public class Truck extends Car
{
    /**
     * Грузоподъемность, килограммы (kg).
     */
    protected double loadCapacity = -1;

    /**
     * Всего загружено (kg).
     */
    protected double loadLevel = 0.0;
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
     * @return false - если не все поля инициализированы.
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
            super.weight += loadLevel;
            return true;
        }
    }


    /**
     * Рагрузка.
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
            super.weight -= loadLevel;
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
        String str = "Country: " + country + "\n" +
                "Model: " + model + "\n" +
                "Weight: " + weight + " kg\n" +
                "Max.speed: " + maxSpeed + " km/h\n" +
                "Load capacity: " + loadCapacity + " kg\n" +
                "Load level: " + loadLevel + " kg\n" +
                "Fuel tank capacity: " + fuelTankCapacity + " L\n" +
                "Fuel consumption on 100 km: " + fuelConsumption + " L\n" +
                "Fuel level: " + fuelLevel + " L";
        return str;
    }
}
