package practice3;

import other.Show;
import java.util.*;


public class Example
{
    static void fill(int[] ar)
    {
        Random rand = new Random();
        for (int i = 0; i < ar.length; i++)
            ar[i] = rand.nextInt(ar.length);
    }


    public static void main(String[] args)
    {
        //ex1:
        Show.show(1);
        int[] ar1 = new int[15];
        fill(ar1);
        System.out.println("ar1: " + Arrays.toString(ar1));

        int[] ar2 = new int[ar1.length + 10];
        System.arraycopy(ar1, 0, ar2, 0, ar1.length);
        ar1 = ar2;
        System.out.println("ar2: " + Arrays.toString(ar1));
        Show.getch();

        //ex2:
        Show.show(2);
        String[] keys = {"Tom", "Peter", "Mich", "Mary", "Bill", "Tobi", "Stan"};
        String[] phoneNumbers = {"7-555-432343", "996-777-23-43-65", "473-130-233254", "144-25-5464",
                "567-24-2546", "157-62-7935", "456-62-5527 "};

        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < keys.length; i++)
            map.put(keys[i], phoneNumbers[i]);

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 4; i++)
        {
            String reply = map.get(scanner.nextLine());
            if (reply == null)
                System.out.println("empty");
            else
                System.out.println(reply);
        }

        //ex3:
        int[] arr = {9, 3, 1, 65, 312, 43, 423, 123, 32, 12};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        Show.getch();

        //ex4:
        Show.show(4);
        ArrayList<String> list = new ArrayList<>();
        list.add("Word");
        list.add("Excel");
        list.add("Looper");
        Collections.sort(list);
        for (String str : list)
            System.out.println(str);

        //ex5:
        Show.show(5);
        TreeSet<String> set = new TreeSet<>(list);
        set.add("www");
        set.add("Arrow");
        set.add("Grid");
        for (String str : set)
            System.out.println(str);

        //ex6:
        Show.show(6);
        System.out.println(list.indexOf("Word"));
        String request = "144-25-5464";
        System.out.println(request + " contains in HashMap : " + map.containsValue(request));
        request = "157-62-7931";
        System.out.println(request + " contains in HashMap : " + map.containsValue(request));
        request = "157-62-7935";
        System.out.println(request + " contains in HashMap : " + map.containsValue(request));

        request = "Mich";
        System.out.println("\nkey: \"" + request + "\" contains in HashMap : " + map.containsKey(request));
        request = "Jerry";
        System.out.println("key: \"" + request + "\" contains in HashMap : " + map.containsKey(request));


        //ex7:
        Show.show(7);
        System.out.println(Arrays.toString(arr));
        System.out.println("value | index");
        System.out.printf("%5d%5d\n", 23, Arrays.binarySearch(arr, 23));
        System.out.printf("%5d%5d\n", 65, Arrays.binarySearch(arr, 65));
        System.out.printf("%5d%5d\n", 71, Arrays.binarySearch(arr, 71));
        System.out.printf("%5d%5d\n", 312, Arrays.binarySearch(arr, 312));
        System.out.printf("%5d%5d\n", 423, Arrays.binarySearch(arr, 423));

        //ex8:
        Show.show(8);
        String[] strs = new String[list.size()];
        list.toArray(strs);
        System.out.println(Arrays.toString(strs));

        //ex9:
        Show.show(9);
        System.out.println("map.size() = " + map.size());
        strs = new String[map.size()];
        map.values().toArray(strs);
        System.out.println(Arrays.toString(strs));

    }
}
