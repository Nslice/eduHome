package home2.space;

import java.io.Serializable;

/**
 * Класс описывающий планету.
 *
 * @author Talgat
 * @author some@mail.com
 * @version 1.0
 */
public class Planet implements Serializable
{
    /**
     * название планеты
     */
    private String name;

    /**
     * радиус, км
     */
    private double radius;

    /**
     * вес, кг
     */
    private double weight;

    /**
     * название планетарной системы
     */
    private String planetSystem;


    /**
     * Инициализирует все поля, описывающие планету.
     *
     * @param name         название планеты
     * @param radius       радиус, км
     * @param weight       вес, кг
     * @param planetSystem название системы
     */
    public Planet(String name, double radius, double weight, String planetSystem)
    {
        this.name = name;
        this.radius = radius;
        this.weight = weight;
        this.planetSystem = planetSystem;
    }

    /**
     * Инициализирует все поля кроме название системы.
     *
     * @param name   название планеты
     * @param radius раидус, км
     * @param weight вес, кг
     * @see #Planet(String name, double radius, double weight, String planetSystem)
     */
    public Planet(String name, double radius, double weight)
    {
        this(name, radius, weight, "none");
    }

    /**
     * Инициализирует название, остальное по умолчанию.
     *
     * @param name название планеты
     * @see #Planet(String name, double radius, double weight, String planetSystem)
     * @see #Planet()
     */
    public Planet(String name)
    {
        this(name, -1.0, -1.0, "none");
    }

    /**
     * Конструктор по умолчаннию.
     *
     * @see #Planet(String name, double radius, double weight, String planetSystem)
     */
    public Planet()
    {
        this("none", -1.0, -1.0, "none");
    }

    /**
     * Конструктор копирования.
     *
     * @param obj другой объект класса Planet
     * @see #Planet(String name, double radius, double weight, String planetSystem)
     */
    @Deprecated
    public Planet(Planet obj)
    {
        this.name = obj.name;
        this.radius = obj.radius;
        this.weight = obj.weight;
        this.planetSystem = obj.planetSystem;
    }

    /**
     * Возвращает название планеты.
     *
     * @return название - {@link Planet#name}
     */
    public String getName()
    {
        return name;
    }

    /**
     * Возвращает радиус планеты.
     *
     * @return радиус - {@link Planet#radius}
     */
    public double getRadius()
    {
        return radius;
    }

    /**
     * Возвращает вес планеты.
     *
     * @return вес - {@link Planet#weight}
     */
    public double getWeight()
    {
        return weight;
    }

    /**
     * Возвращает название системы.
     *
     * @return название системы - {@link Planet#planetSystem}
     */
    public String getPlanetSystem()
    {
        return planetSystem;
    }

    /**
     * Устанавливает название планеты.
     *
     * @param name название
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Устанавливает радиус.
     *
     * @param radius радиус, км
     */
    public void setRadius(double radius)
    {
        this.radius = radius;
    }

    /**
     * Устанавливает вес.
     *
     * @param weight вес, кг
     */
    public void setWeight(double weight)
    {
        this.weight = weight;
    }

    /**
     * Устанавливает название системы.
     *
     * @param planetSystem название
     */
    public void setPlanetSystem(String planetSystem)
    {
        this.planetSystem = planetSystem;
    }


    /**
     * Выводит информацию о планете.
     */
    public void show()
    {
        System.out.println(this);
    }


    /**
     * @return строка, представляющая описание планеты.
     */
    @Override
    public String toString()
    {
        return "Planet - " + name + "\nRadius - " + radius + "\nWeight - " + weight
                + "\nSystem - " + planetSystem;
    }

}

