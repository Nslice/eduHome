package practice3;

import other.Show;

import java.util.*;


public class Example
{
    public static void main(String[] args)
    {
        //ex1:
        Show.show(1);
        int[] ar1 = new Random().ints(15, 0, 100).toArray();
        System.out.println("ar1: " + Arrays.toString(ar1));

        int[] ar2 = new int[ar1.length + 10];
        System.arraycopy(ar1, 0, ar2, 0, ar1.length);
        ar1 = ar2;
        System.out.println("ar1: " + Arrays.toString(ar1));
        Show.getch();


        //ex2:
        Show.show(2);
        String[] keys = {"Tom", "Peter", "Mich", "Mary", "Bill", "Tobi", "Stan"};
        String[] phoneNumbers = {"7-555-432343", "996-777-23-43-65", "473-130-233254", "144-25-5464",
                "567-24-2546", "157-62-7935", "456-62-5527"};

        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < keys.length; i++)
            map.put(keys[i], phoneNumbers[i]);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the follow keys: " + Arrays.toString(keys));

        for (int i = 0; i < 4; i++)
        {
            String reply = map.get(scanner.nextLine());
            if (reply == null)
                System.out.println("empty");
            else
                System.out.println(reply);
        }
        Show.getch();


        //ex3:
        Show.show(3);
        int[] arr = {9, 3, 1, 65, 312, 43, 423, 123, 32, 12};
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("Sorting:");
        System.out.println(Arrays.toString(arr));
        Show.getch();


        //ex4:
        Show.show(4);
        System.out.println("ArratList:");
        ArrayList<String> list = new ArrayList<>();
        list.add("Word");
        list.add("Excel");
        list.add("Looper");

        System.out.println(list);
        System.out.println("Sorting:");
        Collections.sort(list);
        System.out.println(list);
        Show.getch();


        //ex5:
        Show.show(5);
        System.out.println("TreeSet:");
        TreeSet<String> set = new TreeSet<>(list);
        set.add("wav");
        set.add("Arrow");
        set.add("Grid");
        System.out.println(set);
        Show.getch();


        //ex6:
        Show.show(6);
        System.out.println("list.indexOf(\"Word\") = " + list.indexOf("Word"));

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
        Show.getch();


        //ex7:
        Show.show(7);
        System.out.println("Binary search:");
        System.out.println(Arrays.toString(arr));
        System.out.println("value | index");
        System.out.printf("%5d%5d\n", 23, Arrays.binarySearch(arr, 23));
        System.out.printf("%5d%5d\n", 65, Arrays.binarySearch(arr, 65));
        System.out.printf("%5d%5d\n", 71, Arrays.binarySearch(arr, 71));
        System.out.printf("%5d%5d\n", 312, Arrays.binarySearch(arr, 312));
        System.out.printf("%5d%5d\n", 423, Arrays.binarySearch(arr, 423));
        Show.getch();


        //ex8:
        Show.show(8);
        System.out.println("ArrayList<String> to String[]:");
        String[] strs = new String[list.size()];
        list.toArray(strs);
        System.out.println(Arrays.toString(strs));
        Show.getch();


        //ex9:
        Show.show(9);
        System.out.println("HashMap to String[]");
        System.out.println("map.size() = " + map.size());
        strs = new String[map.size()];
        map.values().toArray(strs); // возвращает HashMap$Values интерфейса Collection<E>, потом массив
        System.out.println(Arrays.toString(strs));

        scanner.close();
    }

}
