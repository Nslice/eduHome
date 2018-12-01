package home5;

import home5.transport.Vehicle;
import home5.transport.ground.Car;
import home5.transport.ground.Truck;
import home5.transport.sky.Airplane;
import home5.transport.sky.Warplane;


public class Example
{
    public static void main(String[] args) throws Vehicle.CountryError
    {
        Airplane plane = new Airplane(1, "Boeing 747-400", 395_700,
                917);
        plane.setTankVolume(216_840).setConsumption(2600).setFuelLevel(50_000)
                .setSpeed(755).setFlyHours(735.2);

        System.out.println(plane.getClass().getName() + " plane.constructed() = " + plane.constructed());
        System.out.println(plane + "\n\n");

        System.out.printf("%-25s %20.3f km\n", "Maximal reach:", plane.getMaxReach());
        System.out.printf("%-25s %20s\n", "Fill up 160 343 liters:", plane.fillTank(160_343));
        System.out.printf("%-25s %20.3f km\n", "Maximal reach:", plane.getMaxReach());

        System.out.printf("%-25s %20.3f L\n", "Fuel level before:", plane.getFuelLevel());
        System.out.printf("%-25s %20.3f h\n", "Fly hours before:", plane.getFlyHours());
        System.out.println("plane.fly(32322) = " + plane.fly(32322));
        System.out.printf("%-25s %20.3f L\n", "Fuel level after:", plane.getFuelLevel());
        System.out.printf("%-25s %20.3f h\n", "Fly hours after:", plane.getFlyHours());


        /** ------------------------------------------------------------------------------- */


        System.out.println("\n---------------------------------------------------------\n");
        Truck truck = new Truck(2, "Volvo", 2700, 100);
        truck.setConsumption(25.5).setTankVolume(530).setFuelLevel(245).setLoadCapacity(10250);
        System.out.println(truck.getClass().getName() + " truck.constructed() = " + truck.constructed());
        System.out.println(truck + "\n\n");


        System.out.printf("%-25s %20s\n", "Loading 7435 kg: ", truck.loading(7435));
        System.out.printf("%-25s %20.3f kg\n", "Load level:", truck.getLoadLevel());
        System.out.printf("%-25s %20.3f kg\n\n", "Truck weight:", truck.getWeight());

        System.out.printf("%-25s %20s\n\n", "Loading 5435 kg:", truck.loading(5435));
        System.out.printf("%-25s %20s\n", "Unloading 3000kg:", truck.unloading(3000));
        System.out.printf("%-25s %20s\n", "Loading 5435 kg:", truck.loading(5435));

        System.out.printf("%-25s %20.3f kg\n", "Load level:", truck.getLoadLevel());
        System.out.printf("%-25s %20.3f km\n\n", "Truck weight:", truck.getWeight());

        System.out.printf("%-25s %20.3f L\n", "Fuel level:", truck.getFuelLevel());
        System.out.println(truck.drive(654) + "km");
        System.out.printf("%-25s %20.3f L\n", "Fuel level:", truck.getFuelLevel());


        System.out.println("\n---------------------------------------------------------\n");

        Car audi = new Car(2, "Audi 2321", 785, 230);
        audi.setTankVolume(120).setConsumption(8.45);

        Vehicle[] product = {plane, new Warplane(7), truck, new Car(9)};
        ((Warplane) product[1]).setRockets(5);


        for (Vehicle obj : product)
        {
            System.out.println(obj.getCountry());
            if (obj instanceof Car)
            {
                Car tmp = (Car) obj;   
                System.out.println("\n" + tmp + " \n");
            }
        }


        showAndFill(truck, audi, plane, new Warplane(7, "Crouch", 1200, 500));

    }


    public static void showAndFill(Vehicle... objs)
    {
        System.out.println("\nExample.showModelNames()");
        for (Vehicle o : objs)
        {
            System.out.println(o);
            System.out.print(o.getModel());
            System.out.println("      " + o.getFuelLevel());
            o.setFuelLevel(o.getFuelLevel() + 32);
        }

    }
}
