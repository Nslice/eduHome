package home5;



import home5.transport.IManufacturer;
import home5.transport.Vehicle;
import home5.transport.sky.Airplane;


/**
 * НАПИСАТЬ ГДЕ downcast, а где upcast
 */

public class Example
{

    public static void main(String[] args)
    {
        System.out.println("Example.main");
        IManufacturer prod;

        try
        {
            IManufacturer p = new Airplane(2, 3 , 3, 3, 5000);
        }
        catch (Vehicle.CountryError ex)
        {
            ex.printStackTrace();
        }
    }
}
