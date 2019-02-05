package home7.space;

import java.io.Serializable;


public class Planet implements Serializable
{
    private String name;
    private double radius;
    private double weight;
    private String planetSystem;


    public Planet(String name, double radius, double weight, String planetSystem) throws IllegalArgumentException
    {
        if (radius <= 0 || weight <= 0)
            throw new IllegalArgumentException("radius = " + radius + ", weight = " + weight);

        this.name = name;
        this.radius = radius;
        this.weight = weight;
        this.planetSystem = planetSystem;
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
        if (name == null || name.equals(""))
            throw new IllegalArgumentException("name = " + name + "|");
        this.name = name;
    }

    public void setRadius(double radius)
    {
        if (radius <= 0)
            throw new IllegalArgumentException("radius = " + radius);
        this.radius = radius;
    }

    public void setWeight(double weight)
    {
        if (weight <= 0)
            throw new IllegalArgumentException("weight = " + weight);
        this.weight = weight;
    }

    public void setPlanetSystem(String planetSystem)
    {
        if (planetSystem == null || planetSystem.equals(""))
            throw new IllegalArgumentException("planetSystem = " + planetSystem + "|");
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
                + "\nSystem - " + planetSystem;
    }

}