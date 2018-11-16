package home5.transport;


public abstract class Vehicle implements IManufacturer
{
    /**
     * Производитель
     */
    protected final String country;

    /**
     * Название модели
     */
    protected String model;

    /**
     * Вес, килограммы (kg)
     */
    protected double weight;

    /**
     * Максимальная скорость, километры в час (km/h)
     */
    protected double maxSpeed;
    //------------------------------------------------------------------------


    /**
     * Класс исключения`~~~~~~~~~~~
     */
    public static class CountryError extends Exception
    {
    }


    /****************************************************
     *                КОНСТРУКТОРЫ
     ****************************************************/

    public Vehicle(int ccode) throws CountryError
    {
        this(ccode, "", 0.0, 0.0);
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


    /****************************************************
     *                МЕТОДЫ ДОСТУПА
     ****************************************************/

    @Override
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
}