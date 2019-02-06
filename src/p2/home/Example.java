package p2.home;

import p2.home.space.Planet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;
import java.util.Vector;


// > javadoc -d path -encoding utf8 -private -author -version %1.java %2.java

/**
 * Тестируюищй класс для класса {@link p2.home.space.Planet}.
 *
 * @author Talgat
 * @author some@mail.com
 * @version 1.0
 */
public class Example
{
    /**
     * @param args Имя текстового файла с описанием планет, должен быть заполнен по шаблону: <br>
     *             name(String)    radius(double)    weight(double)    identif.(String) <br>
     *             не менее трех пробелов между столбцами.
     * @throws java.io.IOException Если возникает ошибка ввода-вывода
     */
    public static void main(String[] args) throws java.io.IOException
    {
        if (args.length == 0)
        {
            System.out.println("Not enough arguments");
            return;
        }

        Vector<Planet> planets = new Vector<>(20);
        try (BufferedReader fin = new BufferedReader(new FileReader(args[0])))
        {
            String line;
            while ((line = fin.readLine()) != null)
            {
                String[] str = line.split(" {3,}");
                planets.add(new Planet(str[0], Double.parseDouble(str[1]), Double.parseDouble(str[2]), str[3]));
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
            return;
        }


        for (Planet p : planets)
            System.out.println(p + "\n");


        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);
        String request;

        System.out.println("Search. Enter the name: ");
        System.out.print(" > ");
        while (!(request = scanner.nextLine()).equals("exit"))
        {
            boolean check = false;
            for (Planet p : planets)
            {
                if (request.equals(p.getName()))
                {
                    System.out.println(p + "\n");
                    check = true;
                }
            }
            if (!check)
                System.out.println("Not found\n");
            System.out.print(" > ");
        }


        System.out.println("\nEnter the name of system:");
        System.out.print(" > ");
        while (!(request = scanner.nextLine()).equals("exit"))
        {
            boolean check = false;
            for (Planet p : planets)
            {
                if (request.equals(p.getPlanetSystem()))
                {
                    check = true;
                    System.out.println(p + "\n");
                }
            }
            if (!check)
                System.out.println("Not found\n");
            System.out.print(" > ");
        }


        System.out.println("\nSearch planet by entered radius (±10%):");
        System.out.print(" > ");
        while (!(request = scanner.nextLine()).equals("exit"))
        {
            boolean check = false;
            double radius = 0;
            try
            {
                radius = Double.parseDouble(request);
            }
            catch (NumberFormatException e)
            {
                System.out.println("Invalid argument");
                continue;
            }

            for (Planet p : planets)
            {
                double low = p.getRadius() - p.getRadius() * 10.0 / 100.0;
                double high = p.getRadius() + p.getRadius() * 10.0 / 100.0;
                if (radius >= low && radius <= high)
                {
                    check = true;
                    System.out.println(p + "\n");
                }
            }
            if (!check)
                System.out.println("Not found\n");
            System.out.print(" > ");
        }


        System.out.println("\nSearch planet by entered weight (±10%):");
        System.out.print(" > ");
        while (!(request = scanner.nextLine()).equals("exit"))
        {
            boolean check = false;
            double weight = 0;
            try
            {
                weight = Double.parseDouble(request);
            }
            catch (NumberFormatException e)
            {
                System.out.println("Invalid argument");
                continue;
            }

            for (Planet p : planets)
            {
                double low = p.getWeight() - p.getWeight() * 10.0 / 100.0;
                double high = p.getWeight() + p.getWeight() * 10.0 / 100.0;
                if (weight >= low && weight <= high)
                {
                    check = true;
                    System.out.println(p + "\n");
                }
            }
            if (!check)
                System.out.println("Not found\n");
            System.out.print(" > ");
        }

        scanner.close();
        System.out.println("Done.");
    }
}
