import home2.space.Planet;

import java.io.*;
import java.util.Vector;

/**
 * ДОБАВИТЬ (де)сериализацию c JSON
 * http://qaru.site/questions/16517/java-json-serialization-best-practice
 */


public class Serialize
{
    public static void main(String[] args)
    {
        /** СЧИТЫВАНИЕ ИЗ .txt */
        Vector<Planet> planets = new Vector<>(20);

        try (BufferedReader freader = new BufferedReader(new FileReader(args[0])))
        {
            String line;
            while ((line = freader.readLine()) != null)
            {
                String[] str = line.split(" {3,}");
                planets.add(new Planet(str[0], Double.parseDouble(str[1]), Double.parseDouble(str[2]), str[3]));
            }
        }
        catch (IOException | ArrayIndexOutOfBoundsException ex)
        {
            System.out.println("Can't find file");
            ex.printStackTrace();
            return;
        }



        /** СЕРИАЛИЗАЦИЯ */
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(args[1])))
        {
            oos.writeObject(planets);
        }
        catch (IOException | ArrayIndexOutOfBoundsException ex)
        {
            System.out.println("Can't find file");
            ex.printStackTrace();
            return;
        }


        /** ДЕСЕРИАЛИЗАЦИЯ */
        Vector<Planet> pls = new Vector<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(args[1])))
        {
            pls = (Vector<Planet>) ois.readObject();
        }
        catch (IOException | ClassNotFoundException ex)
        {
            ex.printStackTrace();
            return;
        }

        for (Planet p : pls)
            System.out.println(p + "\n");


    }
}
