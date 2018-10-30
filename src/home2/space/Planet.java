package home2.space;


/**
 * класс описывающий планету
 * @author Talgat
 * @author some@mail.com
 * @version 1.0
 */
public class Planet
{   /** название планеты */
    private String name;
    /** радиус, км */
    private double radius;
    /** вес, кг */
    private double weight;
    /** название планетарной системы */
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

    /** @return Возвращает название планеты*/
    public String getName()
    {
        return name;
    }

    /** @return Возвращает радиус*/
    public double getRadius()
    {
        return radius;
    }

    /** @return Возвращает вес*/
    public double getWeight()
    {
        return weight;
    }

    /** @return Возвращает название системы*/
    public String getIdentification()
    {
        return identification;
    }

    /**
     * Устанавливает название планеты
     * @param name название */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Устанавливает радиус
     * @param radius радиус */
    public void setRadius(double radius)
    {
        this.radius = radius;
    }

    /**
     * Устанавливает вес
     * @param weight вес */
    public void setWeight(double weight)
    {
        this.weight = weight;
    }

    /**
     * Устанавливает название системы
     * @param identification название */
    public void setIdentification(String identification)
    {
        this.identification = identification;
    }


    /**
     * Выводит информацию о планете
     */
    public void show()
    {
        System.out.println(this);
    }


    /**
     * @return строка, представлющая описание планеты
     */
    @Override
    public String toString()
    {
        return "Planet - " + name + "\nRadius - " + radius + "\nWeight - " + weight 
            + "\nSystem - " + identification;
    }
    
}

