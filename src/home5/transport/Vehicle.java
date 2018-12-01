package home5.transport;


public abstract class Vehicle implements IManufacturer
{
    private final String country; // Производитель
    private String model = null;  // Название модели
    private double weight = -1;   // Вес, килограммы (kg)
    private double maxSpeed = -1; // Максимальная скорость, километры в час (km/h)
    //------------------------------------------------------------------------


    /**
     * Класс исключения
     */
    public static class CountryError extends Exception
    {
    }


    /****************************************************
     *                КОНСТРУКТОРЫ
     ****************************************************/

    public Vehicle(int ccode) throws CountryError
    {
        if (ccode >= IManufacturer.countries.length || ccode < 0) throw new CountryError();
        else this.country = IManufacturer.countries[ccode];
    }

    public Vehicle(int ccode, String model, double weight, double maxSpeed) throws CountryError
    {
        if (ccode >= IManufacturer.countries.length || ccode < 0) throw new CountryError();
        else this.country = IManufacturer.countries[ccode];

        this.model = model;
        this.weight = weight;
        this.maxSpeed = maxSpeed;
    }

    public Vehicle(Vehicle obj)
    {
        this.country = obj.country;
        this.model = obj.model;
        this.weight = obj.weight;
        this.maxSpeed = obj.maxSpeed;
    }

    /**
     * Проверяет инициализирован объект полностью или нет.
     *
     * @return false - если не все поля инициализированы
     */
    public boolean constructed()
    {
        return (model != null && weight > 0 && maxSpeed > 0);
    }


    /****************************************************
     *                МЕТОДЫ ДОСТУПА
     ****************************************************/

    public String getCountry()
    {
        return country;
    }

    public String getModel()
    {
        return model;
    }

    public double getWeight()
    {
        return weight;
    }

    public double getMaxSpeed()
    {
        return maxSpeed;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public void setWeight(double weight)
    {
        this.weight = weight;
    }

    public void setMaxSpeed(double maxSpeed)
    {
        this.maxSpeed = maxSpeed;
    }


    public abstract Vehicle setFuelLevel(double lvl);
    public abstract double getFuelLevel();
}