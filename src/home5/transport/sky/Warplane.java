package home5.transport.sky;


import home5.transport.Vehicle;

public class Warplane extends Airplane
{
    private int bombs = 0;
    //------------------------------------------------------------------------


    /****************************************************
     *                КОНСТРУКТОРЫ
     ****************************************************/

    public Warplane(int ccode) throws CountryError
    {
        super(ccode);
    }

    public Warplane(int ccode, double tankVolume, double consumption) throws CountryError
    {
        super(ccode, tankVolume, consumption);
    }

    public Warplane(int ccode, String model, double weight, double maxSpeed, double consumption, double tankVolume) throws CountryError
    {
        super(ccode, model, weight, maxSpeed, consumption, tankVolume);
    }


    public Warplane(int ccode, String model, double weight, double maxSpeed) throws CountryError
    {
        super(ccode, model, weight, maxSpeed);
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

    public void setBombs(int bombs)
    {
        this.bombs = bombs;
    }


    /****************************************************
     *                ДРУГИЕ МЕТОДЫ
     ****************************************************/

    @Override
    public String toString()
    {
        return super.toString();
    }

    public static void main(String[] args) throws Vehicle.CountryError
    {
        Warplane plane = new Warplane(2, "Apache", 5000, 1230);
        plane.setTankVolume(216_840).setConsumption(2600).setFuelLevel(50_000)
                .setSpeed(755).setFlyHours(735.2);

        System.out.println("plane.constructed() = " + plane.constructed());
        System.out.println(plane + "\n\n\n");

        System.out.printf("%-25s %20.3f km\n", "Maximal reach:", plane.getMaxReach());
        System.out.printf("%-25s %20s\n", "Fill up 160 343 liters:", plane.fillTank(160_343));
        System.out.printf("%-25s %20.3f km\n", "Maximal reach:", plane.getMaxReach());

        System.out.printf("%-25s %20.3f L\n", "Fuel level before:", plane.getFuelLevel());
        System.out.printf("%-25s %20.3f h\n", "Fly hours before:", plane.getFlyHours());
        System.out.println("plane.fly(32322) = " + plane.fly(32322));
        System.out.printf("%-25s %20.3f L\n", "Fuel level after:", plane.getFuelLevel());
        System.out.printf("%-25s %20.3f h\n", "Fly hours after:", plane.getFlyHours());



    }



}

