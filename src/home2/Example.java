package home2;

import home2.space.Planet;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Vector;


public class Example
{
    public static void main(String[] args) throws java.io.IOException
    {
        if (args.length == 0)
        {
            System.out.println("Not enough arguments");
            return;
        }

        File f = new File(args[0]);
        BufferedReader fin = new BufferedReader(new FileReader(f));

        Vector<Planet> planets = new Vector<>(20);

        {
            String line;
            while ((line = fin.readLine()) != null)
            {
                String[] str = line.split(" {3,}");
                planets.add(new Planet(str[0], Double.parseDouble(str[1]), Double.parseDouble(str[2]), str[3]));
            }
        }

        for (Planet p : planets)
            System.out.println(p + "\n");




        Scanner scanner = new Scanner(System.in);
        String request;
        System.out.println("Search. Enter the name: ");


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
        }

        System.out.println();
        System.out.println("Enter the name of system:");


        while (!(request = scanner.nextLine()).equals("exit"))
        {
            boolean check = false;
            for (Planet p : planets)
            {
                if (request.equals(p.getIdentification()))
                {
                    check = true;
                    System.out.println(p + "\n");
                }
            }
            if (!check)
                System.out.println("Not found\n");
        }


        System.out.println();
        System.out.println("Search for planets by entered radius (±10%):");

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
                if (radius > low && radius < high)
                {
                    check = true;
                    System.out.println(p + "\n");
                }
            }
            if (!check)
                System.out.println("Not found\n");
        }


        System.out.println();
        System.out.println("Search for planets by entered weight (±10%):");

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
                if (weight > low && weight < high)
                {
                    check = true;
                    System.out.println(p + "\n");
                }
            }
            if (!check)
                System.out.println("Not found\n");
        }

        System.out.println("Done.");
    } //end main


}
