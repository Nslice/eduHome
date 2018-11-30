package home5;


import home5.transport.IManufacturer;
import home5.transport.Vehicle;
import home5.transport.ground.Truck;


/**
 * НАПИСАТЬ ГДЕ downcast, а где upcast
 */


public class Example
{
    public static void main(String[] args)
    {
        IManufacturer prod;

        try
        {
//            Car car = new Car(2, "Audi", 700, 230);
//            car.setFuelConsumption(10.3);
//            car.setFuelTankCapacity(70);
//            car.setFuelLevel(45);
//            System.out.println("car.constructed() = " + car.constructed());
//            System.out.println(car);
//
//            System.out.println("\n\ncar.fillTank(23) = " + car.fillTank(23));
//            System.out.printf("fuelLevel = %.3f\n", car.getFuelLevel());
//
//
//            car.drive(542);
//            System.out.printf("fuelLevel = %.3f\n", car.getFuelLevel());

            Truck car = new Truck(2, "Volvo", 2700, 100);
            car.setConsumption(25.5);
            car.setTankVolume(530);
            car.setFuelLevel(245);
            car.setLoadCapacity(10250);
            System.out.println(car);

            System.out.println("\n\n " + car.loading(7435));
            System.out.println("car.getLoadLevel() = " + car.getLoadLevel());
            System.out.println("car.getWeight() = " + car.getWeight());
            System.out.println("\n\n " + car.loading(5435));
            System.out.println("unloading: " + car.unloading(3000));
            System.out.println("\n\n " + car.loading(5435));
            System.out.println("car.getLoadLevel() = " + car.getLoadLevel());
            System.out.println("car.getWeight() = " + car.getWeight());


        }
        catch (Vehicle.CountryError ex)
        {
            ex.printStackTrace();
        }

    }
}
