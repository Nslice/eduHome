package home2.space;


/**
 * Класс описывающий планету.
 *
 * @author Talgat
 * @author some@mail.com
 * @version 1.0
 */
public class Planet
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
    private String identification;


    /**
     * Инициализирует все поля, описывающие планету.
     *
     * @param name           название планеты
     * @param radius         радиус, км
     * @param weight         вес, кг
     * @param identification название системы
     */
    public Planet(String name, double radius, double weight, String identification)
    {
        this.name = name;
        this.radius = radius;
        this.weight = weight;
        this.identification = identification;
    }

    /**
     * Инициализирует все поля кроме название системы.
     *
     * @param name   название планеты
     * @param radius раидус, км
     * @param weight вес, кг
     * @see #Planet(String name, double radius, double weight, String identification)
     */
    public Planet(String name, double radius, double weight)
    {
        this(name, radius, weight, "none");
    }

    /**
     * Инициализирует название, остальное по умолчанию.
     *
     * @param name название планеты
     * @see #Planet(String name, double radius, double weight, String identification)
     * @see #Planet()
     */
    public Planet(String name)
    {
        this(name, -1.0, -1.0, "none");
    }

    /**
     * Конструктор по умолчаннию.
     *
     * @see #Planet(String name, double radius, double weight, String identification)
     */
    public Planet()
    {
        this("none", -1.0, -1.0, "none");
    }

    /**
     * Конструктор копирования.
     *
     * @param obj другой объект класса Planet
     * @see #Planet(String name, double radius, double weight, String identification)
     */
    @Deprecated
    public Planet(Planet obj)
    {
        this.name = obj.name;
        this.radius = obj.radius;
        this.weight = obj.weight;
        this.identification = obj.identification;
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
     * @return название системы - {@link Planet#identification}
     */
    public String getIdentification()
    {
        return identification;
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
     * @param identification название
     */
    public void setIdentification(String identification)
    {
        this.identification = identification;
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
                + "\nSystem - " + identification;
    }

}

