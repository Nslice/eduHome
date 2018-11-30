package home5.transport.sky;

import home5.transport.Vehicle;

public class Airplane extends Vehicle
{
    private double maxWeight;
    private double emptyWeight;
    private double loadWeight;
    private double travelSpeed;
    private double flyHours;
    private double consumption;
    private double maxFuel;
    private double kerosinStorage;

    public Airplane(double maxWeight, double emptyWeight, double loadWeight,
                    double travelSpeed, double flyHours, double consumption,
                    double maxFuel, double kerosinStorage) throws CountryError
    {
        super(1);
        this.maxWeight = maxWeight;
        this.emptyWeight = emptyWeight;
        this.loadWeight = loadWeight;
        this.travelSpeed = travelSpeed;
        this.flyHours = flyHours;
        this.consumption = consumption;
        this.maxFuel = maxFuel;
        this.kerosinStorage = kerosinStorage < this.maxFuel
                ? kerosinStorage
                : this.maxFuel;
    }


    public Airplane(int ccode) throws CountryError
    {
        super(ccode);
    }

    public Airplane(int ccode, String model, double weight, double maxSpeed)
            throws CountryError
    {
        super(ccode, model, weight, maxSpeed);
    }

    public Airplane(int ccode, String model, double weight, double maxSpeed, double consumption)
            throws CountryError
    {
        super(ccode, model, weight, maxSpeed);
        this.consumption = consumption;
    }

    public Airplane(Vehicle obj)
    {
        super(obj);
    }


    /****************************************************
     *                МЕТОДЫ ДОСТУПА
     ****************************************************/

    public double getMaxWeight()
    {
        return maxWeight;
    }

    public double getEmptyWeight()
    {
        return emptyWeight;
    }

    public double getLoadWeight()
    {
        return loadWeight;
    }

    public double getTravelSpeed()
    {
        return travelSpeed;
    }

    public double getFlyHours()
    {
        return flyHours;
    }

    public double getConsumption()
    {
        return consumption;
    }

    public double getMaxFuel()
    {
        return maxFuel;
    }

    public double getKerosinStorage()
    {
        return kerosinStorage;
    }


    public Airplane setMaxWeight(double maxWeight)
    {
        this.maxWeight = maxWeight;
        return this;
    }

    public Airplane setEmptyWeight(double emptyWeight)
    {
        this.emptyWeight = emptyWeight;
        return this;
    }

    public Airplane setLoadWeight(double loadWeight)
    {
        this.loadWeight = loadWeight;
        return this;
    }

    public Airplane setTravelSpeed(double travelSpeed)
    {
        this.travelSpeed = travelSpeed;
        return this;
    }

    public Airplane setFlyHours(double flyHours)
    {
        this.flyHours = flyHours;
        return this;
    }

    public Airplane setConsumption(double consumption)
    {
        this.consumption = consumption;
        return this;
    }

    public Airplane setMaxFuel(double maxFuel)
    {
        this.maxFuel = maxFuel;
        return this;
    }

    public Airplane setKerosinStorage(double kerosinStorage)
    {
        this.kerosinStorage = this.kerosinStorage + kerosinStorage > maxFuel
                ? maxFuel : this.kerosinStorage + kerosinStorage;
        return this;
    }



    /*
        Returns the total weight of the plane. Which is: emptyWeight +
            weight of load + weight of kerosin.
            Expect 1 liter Kerosin as 0.8 kg.
    */
    public double getTotalWeight()
    {
        return emptyWeight + loadWeight
                + (kerosinStorage * 0.8);
    }

    /*
        How far can the plane fly with the current kerosin storage?
    */

    public double getMaxReach()
    {
        return (kerosinStorage / consumption) * travelSpeed;
    }

    /*
        Prevent flying further then possible (with the current kerosin) !
    */

    /****************************************************
     *                ДРУГИЕ МЕТОДЫ
     ****************************************************/

    public boolean fly(double km)
    {
        if (km <= 0 || getMaxReach() < km || getTotalWeight() > maxWeight)
        {
            return false;
        }

        flyHours += (km / travelSpeed);
        kerosinStorage -= (km / travelSpeed) * consumption;

        return true;
    }

    /*
        ! The parameter 'liter' can be a negative number.
        Doesn't have to be overfilled.
        Prevent a negative number as value of the 'kerosinStorage' property !
    */
    public void fillUp(double liter)
    {
        if ((kerosinStorage + liter) > maxFuel)
        {
            kerosinStorage = maxFuel;
        }
        else if ((kerosinStorage + liter) < 0)
        {
            kerosinStorage = 0;
        }
        else
        {
            kerosinStorage += liter;
        }
    }

    /*
        Prevent illogical value-assignments !
    */
    public boolean load(double kg)
    {

        if ((loadWeight + emptyWeight + kg) > maxWeight)
        {
            return false;
        }
        else if ((emptyWeight + kg) < 0)
        {
            loadWeight = 0;
            return true;
        }
        else
        {
            loadWeight += kg;
            return true;
        }
    }

    // Display flying hours, kerosin storage & total weight on t. terminal.
    public void info()
    {
        System.out.println("Flying hours: " + flyHours + ", Kerosin: "
                + kerosinStorage + ", Weight: " + getTotalWeight());
    }






    public static void main(String[] args) throws Vehicle.CountryError
    {
        Airplane jet = new Airplane( 70000, 35000, 10000,
                800, 500, 2500, 25000, 8000);

        jet.info();

        jet.setKerosinStorage(1000);
        System.out.println(jet.getKerosinStorage());
        System.out.println(jet.getTotalWeight());
        System.out.println("Maximal reach: " + jet.getMaxReach());

        System.out.println("Fly hours 1: " + jet.getFlyHours());
        jet.fly(5000);
        System.out.println("Fly hours 1: " + jet.getFlyHours());

        jet.load(10000);
        jet.info();
    }
}