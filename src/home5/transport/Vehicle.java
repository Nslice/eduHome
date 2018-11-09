package home5.transport;


public abstract class Vehicle implements IManufacturer
{
    /**
     * Производитель
     */
    protected final String country;
    /**
     * Вес
     */
    protected double weight;
    /**
     * Мощность мотора
     */
    protected double power;
    /**
     * Максмимальная скорость
     */
    protected double maxSpeed;


    //------------------------------------------------------------------------
    public class CountryError extends Exception
    {

    }


    public Vehicle(int ccode) throws CountryError
    {
        this(ccode, 0.0, 0.0, 0.0);
    }

    public Vehicle(int ccode, double weight, double power, double maxSpeed) throws CountryError
    {
        if (ccode >= IManufacturer.countries.length || ccode < 0) throw new CountryError();
        else this.country = IManufacturer.countries[ccode];

        this.weight = weight;
        this.power = power;
        this.maxSpeed = maxSpeed;
    }

    public Vehicle(Vehicle obj)
    {
        this.country = obj.country;
        this.weight = obj.weight;
        this.power = obj.power;
        this.maxSpeed = obj.maxSpeed;
    }

    public double getWeight()
    {
        return weight;
    }

    public double getPower()
    {
        return power;
    }

    public double getMaxSpeed()
    {
        return maxSpeed;
    }

    @Override
    public String getCountry()
    {
        return country;
    }

    public void setWeight(double weight)
    {
        this.weight = weight;
    }

    public void setPower(double power)
    {
        this.power = power;
    }

    public void setMaxSpeed(double maxSpeed)
    {
        this.maxSpeed = maxSpeed;
    }


    /**
     * вывод всей информации
     */
    public abstract void show();
}