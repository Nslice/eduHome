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
            Airplane arp  = new Airplane(2, 2, 2,2 );
            System.out.println(arp);
            System.out.println("arp.getCountry() = " + arp.getCountry());
            Car car = new Car(arp, "Volkswagen");
            System.out.println("car = " + car);
        }
        catch (Vehicle.CountryError ex)
        {
            ex.printStackTrace();
        }

    }
}
