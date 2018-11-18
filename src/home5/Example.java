package home5;



import home5.transport.IManufacturer;
import home5.transport.Vehicle;
import home5.transport.sky.Airplane;
import home5.transport.ground.Car;


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
            Car car = new Car(2);
            car.setFuelConsumption(10.3);
            car.setFuelTankCapacity(70);
            car.setFuelLevel(45);
            car.setPower(232);
            System.out.println("car.constructed() = " + car.constructed());
            System.out.println(car);
            System.out.println("car.fillTank() = " + car.fillTank(23));
            System.out.println("car.getFuelLevel() = " + car.getFuelLevel());
            System.out.println(car.getModel());
        }
        catch (Vehicle.CountryError ex)
        {
            ex.printStackTrace();
        }

    }
}
