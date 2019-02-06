package p3.home.calculations;

import java.util.Random;


public class MyArray
{
    private int[] arr;


    public MyArray(int size, int low, int high)
    {
        arr = new int[size];
        Random rand = new Random();
        int range = high - low;
        for (int i = 0; i < arr.length; i++)
            arr[i] = low + rand.nextInt(range);
    }


    public void show()
    {
        for (int i = 0; i < arr.length; i++)
        {
            if (i % 10 == 0) System.out.println();
            System.out.printf("[%4d]%3d ", i, arr[i]);
        }
        System.out.println();
    }


    public int find(int amount)
    {
        if (amount > arr.length || amount <= 0)
            throw new IndexOutOfBoundsException("int amount = " + amount);

        int sum, max = 0;
        int index = -1;

        for (int i = 0; i <= arr.length - amount; i++)
        {
            sum = 0;
            for (int j = 0; j < amount; j++)
                sum += arr[i + j];
            if (sum > max)
            {
                max = sum;
                index = i;
            }
        }
        return index;
    }


    public int sum(int pos, int len)
    {
        int sum = 0;
        for (int i = 0; i < len; i++)
            sum += arr[pos + i];

        return sum;
    }
}