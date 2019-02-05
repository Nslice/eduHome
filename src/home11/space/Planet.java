package home11.space;

import java.io.Serializable;

public class Planet implements Serializable
{
    private String name;
    private double radius;
    private double weight;
    private String planetSystem;


    public Planet(String name, double radius, double weight, String planetSystem)
    {
        this.name = name;
        this.radius = radius;
        this.weight = weight;
        this.planetSystem = planetSystem;
    }

    public Planet(String name, double radius, double weight)
    {
        this(name, radius, weight, "none");
    }

    public Planet(String name)
    {
        this(name, -1.0, -1.0, "none");
    }

    public Planet()
    {
        this("none", -1.0, -1.0, "none");
    }

    @Deprecated
    public Planet(Planet obj)
    {
        this.name = obj.name;
        this.radius = obj.radius;
        this.weight = obj.weight;
        this.planetSystem = obj.planetSystem;
    }

    public String getName()
    {
        return name;
    }

    public double getRadius()
    {
        return radius;
    }

    public double getWeight()
    {
        return weight;
    }

    public String getPlanetSystem()
    {
        return planetSystem;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setRadius(double radius)
    {
        this.radius = radius;
    }

    public void setWeight(double weight)
    {
        this.weight = weight;
    }

    public void setPlanetSystem(String planetSystem)
    {
        this.planetSystem = planetSystem;
    }

    public void show()
    {
        System.out.println(this);
    }

    @Override
    public String toString()
    {
        return "Planet - " + name + "\nRadius - " + radius + "\nWeight - " + weight
                + "\nSystem - " + planetSystem + "\n";
    }

}

