package p5.home.transport.sky;

import p5.home.transport.Vehicle;


public class Airplane extends Vehicle
{
    private double tankVolume = -1;  // Максимальный объем бака, литры (L)
    private double consumption = -1; // Расход топлива в час, литры (L)
    private double fuelLevel = 0.0;  // Количество топлива, литры (L)
    private double speed = -1;       // Скорость (km/h)
    private double flyHours = 0.0;   // Время полета (h)
    //------------------------------------------------------------------------


    /****************************************************
     *                КОНСТРУКТОРЫ
     ****************************************************/

    public Airplane(int ccode) throws CountryError
    {
        super(ccode);
    }

    public Airplane(int ccode, String model, double weight, double maxSpeed)
            throws CountryError
    {
        super(ccode, model, weight, maxSpeed);
    }

    public Airplane(int ccode, String model, double weight, double maxSpeed, double consumption,
                    double tankVolume) throws CountryError
    {
        super(ccode, model, weight, maxSpeed);
        this.consumption = consumption;
        this.tankVolume = tankVolume;
    }

    public Airplane(Vehicle obj)
    {
        super(obj);
    }

    /**
     * Проверяет инициализирован объект полностью или нет.
     *
     * @return false - если не все поля инициализированы.
     */
    @Override
    public boolean constructed()
    {
        return super.constructed() &&
                (tankVolume > 0 && consumption > 0 && speed > 0);
    }


    /****************************************************
     *                МЕТОДЫ ДОСТУПА
     ****************************************************/

    public double getTankVolume()
    {
        return tankVolume;
    }

    public double getConsumption()
    {
        return consumption;
    }


    public double getSpeed()
    {
        return speed;
    }

    public double getFlyHours()
    {
        return flyHours;
    }

    public Airplane setTankVolume(double tankVolume)
    {
        this.tankVolume = tankVolume;
        return this;
    }

    public Airplane setConsumption(double consumption)
    {
        this.consumption = consumption;
        return this;
    }

    public Airplane setSpeed(double speed)
    {
        this.speed = speed > getMaxSpeed() ? getMaxSpeed() : speed;
        return this;
    }

    public Airplane setFlyHours(double flyHours)
    {
        this.flyHours = flyHours;
        return this;
    }

    @Override
    public double getFuelLevel()
    {
        return fuelLevel;
    }

    @Override
    public Airplane setFuelLevel(double fuelLevel)
    {
        if (fuelLevel > tankVolume)
            this.fuelLevel = tankVolume;
        else
            this.fuelLevel = fuelLevel;
        return this;
    }


    /****************************************************
     *                ДРУГИЕ МЕТОДЫ
     ****************************************************/

    /**
     * Возвращает кол-во км. которое может пролететь самолет
     * с текущим запасом топлива.
     *
     * @return максимально расстояние которое может пролететь самолет.
     */
    public double getMaxReach()
    {
        if (!constructed())
            return 0.0;
        return (fuelLevel / consumption) * speed;
    }

    /**
     * Лететь.
     *
     * @param km кол-во километров.
     * @return false - если не хватает топлива или объект недоинициализирован.
     */
    public boolean fly(double km)
    {
        if (km <= 0 || getMaxReach() < km)
        {
            return false;
        }

        flyHours += (km / speed);
        fuelLevel -= (km / speed) * consumption;

        return true;
    }

    /**
     * Заправить бак.
     *
     * @param liters кол-во литров.
     * @return false, если не вместилось или объект недоинициализирован.
     */
    public boolean fillTank(double liters)
    {
        if (!constructed())
            return false;
        if (fuelLevel + liters <= tankVolume)
        {
            fuelLevel += liters;
            return true;
        }
        else
            return false;
    }

    /**
     * Выводит всю информацию.
     *
     * @return
     */
    @Override
    public String toString()
    {
        String str = "Country: " + getCountry() + "\n" +
                "Model: " + getModel() + "\n" +
                "Weight: " + getWeight() + " kg\n" +
                "Max.speed: " + getMaxSpeed() + " km/h\n" +
                "Fuel tank volume: " + tankVolume + " L\n" +
                "Fuel consumption on hour: " + consumption + " L\n" +
                "Fuel level: " + fuelLevel + " L\n" +
                "Speed: " + speed + " km/h\n" +
                "Fly hours: " + flyHours + " h";
        return str;
    }



//    public static void main(String[] args) throws Vehicle.CountryError
//    {
//        Airplane plane = new Airplane(1, "Boeing 747-400", 395_700,
//                917);
//        plane.setTankVolume(216_840).setConsumption(2600).setFuelLevel(50_000)
//                .setSpeed(755).setFlyHours(735.2);
//
//        System.out.println("plane.constructed() = " + plane.constructed());
//        System.out.println(plane + "\n\n\n");
//
//        System.out.printf("%-25s %20.3f km\n", "Maximal reach:", plane.getMaxReach());
//        System.out.printf("%-25s %20s\n", "Fill up 160 343 liters:", plane.fillTank(160_343));
//        System.out.printf("%-25s %20.3f km\n", "Maximal reach:", plane.getMaxReach());
//
//        System.out.printf("%-25s %20.3f L\n", "Fuel level before:", plane.getFuelLevel());
//        System.out.printf("%-25s %20.3f h\n", "Fly hours before:", plane.getFlyHours());
//        System.out.println("plane.fly(32322) = " + plane.fly(32322));
//        System.out.printf("%-25s %20.3f L\n", "Fuel level after:", plane.getFuelLevel());
//        System.out.printf("%-25s %20.3f h\n", "Fly hours after:", plane.getFlyHours());
//
//    }


}