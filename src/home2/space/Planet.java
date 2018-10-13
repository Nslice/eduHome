package home2.space;


public class Planet
{
    private String name;
    private double radius;
    private double weight;
    private String identification;


    public Planet(String name, double radius, double weight, String identification)
    {
        this.name = name;
        this.radius = radius;
        this.weight = weight;
        this.identification = identification;
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

    public Planet(Planet obj)
    {
        this.name = obj.name;
        this.radius = obj.radius;
        this.weight = obj.weight;
        this.identification = obj.identification;
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

    public String getIdentification()
    {
        return identification;
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

    public void setIdentification(String identification)
    {
        this.identification = identification;
    }


    public void show()
    {
        System.out.println(this);
    }


    @Override
    public String toString()
    {
        return "Planet - " + name + "\nRadius - " + radius + "\nWeight - " + weight 
            + "\nSystem - " + identification;
    }
    
}

