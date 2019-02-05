package p5.home.transport.sky;

import p5.home.transport.Vehicle;


public class Warplane extends Airplane
{
    private int bombs = 0;
    private int rockets = 0;
    //------------------------------------------------------------------------


    /****************************************************
     *                КОНСТРУКТОРЫ
     ****************************************************/

    public Warplane(int ccode) throws CountryError
    {
        super(ccode);
    }

    public Warplane(int ccode, String model, double weight, double maxSpeed) throws CountryError
    {
        super(ccode, model, weight, maxSpeed);
    }

    public Warplane(int ccode, String model, double weight, double maxSpeed, double consumption,
                    double tankVolume) throws CountryError
    {
        super(ccode, model, weight, maxSpeed, consumption, tankVolume);
    }

    public Warplane(Vehicle obj)
    {
        super(obj);
    }

    @Override
    public boolean constructed()
    {
        return super.constructed();
    }


    /****************************************************
     *                МЕТОДЫ ДОСТУПА
     ****************************************************/

    public int getBombs()
    {
        return bombs;
    }

    public int getRockets()
    {
        return rockets;
    }

    public Warplane setBombs(int bombs)
    {
        this.bombs = bombs;
        return this;
    }

    public Warplane setRockets(int rockets)
    {
        this.rockets = rockets;
        return this;
    }


    /****************************************************
     *                ДРУГИЕ МЕТОДЫ
     ****************************************************/

    /**
     * Сбросить бомбы.
     *
     * @param num количество.
     * @return сброшено.
     */
    public int dropBombs(int num)
    {
        if (!constructed())
            return 0;

        int droped = (bombs <= num) ? bombs : num;
        bombs -= droped;
        return droped;

    }

    /**
     * Пустить ракеты.
     *
     * @param num количество.
     * @return запущено.
     */
    public int launchRockets(int num)
    {
        if (!constructed())
            return 0;

        int launched = (rockets <= num) ? rockets : num;
        rockets -= launched;
        return launched;
    }

    @Override
    public String toString()
    {
        String str = super.toString() + "\n" +
                "Bombs: " + bombs + "\n" +
                "Rockets: " + rockets;
        return str;
    }


}

