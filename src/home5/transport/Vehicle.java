package home5.transport;

public abstract class Vehicle
{
    private double weight;
    private double power;
    private double speed;


    public Vehicle()
    {
        this(0.0, 0.0, 0.0);
    }
    public Vehicle(double weight, double power, double speed)
    {
        this.weight = weight;
        this.power = power;
        this.speed = speed;
    }

    public abstract void show();
}