package home2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;


class Planet
{
    private String name;
    private double radius;
    private double weight;
    private String identification;


    public Planet(String name, double radius, double weight, String identification)
    {
        this.name = name;
        this.radius = radius;
        this.weight = weight;
        this.identification = identification;
    }

    public Planet(String name, double radius, double weight)
    {
        this(name, radius, weight, "none");
    }

    public Planet(String name)
    {
        this(name, -1.0, -1.0, "none");
    }

    public Planet()
    {
        this("none", -1.0, -1.0, "none");
    }

    public Planet(Planet obj)
    {
        this.name = obj.name;
        this.radius = obj.radius;
        this.weight = obj.weight;
        this.identification = obj.identification;
    }

    public String getName()
    {
        return name;
    }

    public double getRadius()
    {
        return radius;
    }

    public double getWeight()
    {
        return weight;
    }

    public String getIdentification()
    {
        return identification;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setRadius(double radius)
    {
        this.radius = radius;
    }

    public void setWeight(double weight)
    {
        this.weight = weight;
    }

    public void setIdentification(String identification)
    {
        this.identification = identification;
    }

    //---------------------------------------------------------------------------------------------

    public void show()
    {
        System.out.println("Planet - " + name);
        System.out.println("Radius - " + radius + " (km)");
        System.out.println("Weight - " + weight + " (kg)");
        System.out.println("System - " + identification);
    }

    @Override
    public String toString()
    {
        return name + " | " + radius + " | " + weight + " | " + identification;
    }
}


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

        Planet[] planets = new Planet[5];

        {
            String line;
            int i = 0;
            while ((line = fin.readLine()) != null && i < 5)
            {
                String[] str = line.split("[ ]+");
                planets[i++] = new Planet(str[0], Double.parseDouble(str[1]), Double.parseDouble(str[2]), str[3]);
            }
        }

        for (Planet i : planets)
        {
            i.show();
            System.out.println();
        }


        Scanner scanner = new Scanner(System.in);
        String str;
        System.out.println("Search. Enter the name: ");

        while (!(str = scanner.nextLine()).equals("exit"))
        {
            Planet pl = null;
            for (Planet i : planets)
            {
                if (str.equals(i.getName()))
                {
                    pl = new Planet(i);
                    break;
                }
            }
            System.out.println(pl);
        }
    }


}
