package practice10;

import other.Show;

import java.util.HashMap;
import java.util.Map;

public class Example
{
    static String fromBinToOctString(String bin)
    {
        int str = Integer.parseInt(bin, 2);
        StringBuffer octStr = new StringBuffer(20);
        int bits = Integer.SIZE;

        int tmp;
        int rem = bits % 3; // старшие биты не входящие в триаду
        if (rem != 0)
        {
            int shift = 0;
            if (rem == 2) shift = 0b11;
            else if (rem == 1) shift = 0b1;

            tmp = (str >> (bits - rem)) & shift;
            octStr.append((char) (tmp + '0'));
        }

        for (int i = bits - rem - 3; i >= 0; i -= 3)
        {
            tmp = (str >> i) & 0b111;
            octStr.append((char) (tmp + '0'));
        }
        return octStr.toString().replaceFirst("\\b0+", "");
    }

    static String fromBinToDecString(String bin)
    {
        int sum = 0;
        int rank = 0;
        for (int i = bin.length() - 1; i >= 0; i--, rank++)
        {
            if (bin.charAt(i) == '1')
                sum += Math.pow(2, rank);
        }
        sum = (bin.charAt(0) == '-') ? -sum : sum;

        return "" + sum;
    }


    static String fromBinToHexString(String bin)
    {
        int str = Integer.parseInt(bin, 2);
        StringBuffer hexStr = new StringBuffer(20);
        char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F'
        };

        for (int i = Integer.SIZE - 4; i >= 0; i -= 4)
        {
            int tmp = (str >> i) & 0xF;
            hexStr.append(hex[tmp]);
        }
        return hexStr.toString().replaceFirst("\\b0+", "");
    }


    static String fromOctToBinString(String oct)
    {
        Map<Character, String> map = new HashMap<Character, String>()
        {
            {
                put('0', "000");
                put('1', "001");
                put('2', "010");
                put('3', "011");
                put('4', "100");
                put('5', "101");
                put('6', "110");
                put('7', "111");

            }
        };
        StringBuffer binStr = new StringBuffer(20);
        for (Character ch : oct.toCharArray())
            binStr.append(map.get(Character.toUpperCase(ch)) + " ");

        return binStr.toString();
    }


    static String fromOctToDecString(String oct)
    {
        String binStr = fromOctToBinString(oct).replace(" ", "");
        return fromBinToDecString(binStr);
    }

    static String fromHexToBinString(String hex)
    {
        Map<Character, String> map = new HashMap<Character, String>()
        {
            {
                put('0', "0000");
                put('1', "0001");
                put('2', "0010");
                put('3', "0011");
                put('4', "0100");
                put('5', "0101");
                put('6', "0110");
                put('7', "0111");
                put('8', "1000");
                put('9', "1001");
                put('A', "1010");
                put('B', "1011");
                put('C', "1100");
                put('D', "1101");
                put('E', "1110");
                put('F', "1111");
            }
        };
        StringBuffer binStr = new StringBuffer(20);
        for (Character ch : hex.toCharArray())
            binStr.append(map.get(Character.toUpperCase(ch)) + " ");

        return binStr.toString();
    }


    static String fromHexToOctString(String hex)
    {
        return fromBinToOctString(fromHexToBinString(hex).replace(" ", ""));
    }


    static String fromHexToDecString(String hex)
    {
        int sum = 0;
        int rank = 1;
        Map<Character, Integer> map = new HashMap<Character, Integer>()
        {
            {
                put('0', 0);
                put('1', 1);
                put('2', 2);
                put('3', 3);
                put('4', 4);
                put('5', 5);
                put('6', 6);
                put('7', 7);
                put('8', 8);
                put('9', 9);
                put('A', 10);
                put('B', 11);
                put('C', 12);
                put('D', 13);
                put('E', 14);
                put('F', 15);
            }
        };
        for (int i = hex.length() - 1; i >= 0; i--, rank *= 16)
        {
            sum += map.get(hex.charAt(i)) * rank;
        }
        return "" + sum;
    }


    static String fromDecToBinString(String dec) throws NumberFormatException
    {
        int num = Integer.parseInt(dec);
        StringBuffer binStr = new StringBuffer(20);

        int count = 0;
        while (num > 0)
        {
            binStr.append((num % 2) + ((count % 4 == 3) ? " " : ""));
            num = num / 2;
            count++;
        }


        return binStr.reverse().toString();
    }


    static String _____fromDecToOctString(String dec)
    {
        int num = Integer.parseInt(dec);
        StringBuffer octStr = new StringBuffer(20);

//////// НЕ СДЕЛАНО
        return octStr.reverse().toString();
    }



    public static void main(String[] args)
    {
        // спецификации исключений пересмотреть у всех методов
        // сделать без парсов
        // case sens. чекнуть
        System.out.println("Examples.main");

        /** ---------------------------------- EX2 --------------------------------- */
        Show.show(2);
        String str = "111111111111";
        System.out.println("BIN: " + str);
        System.out.println("OCT: " + fromBinToOctString(str));
        System.out.println("HEX: " + fromBinToHexString(str));


        /** ---------------------------------- EX3 --------------------------------- */
        Show.show(3);
        str = "3A7D";
        System.out.println(fromHexToBinString(str));


        /** ---------------------------------- EX4 --------------------------------- */
        Show.show(4);
        str = "765F";
        System.out.println(fromHexToOctString(str));

        /** ---------------------------------- EX5 --------------------------------- */
        Show.show(5);
        str = "1111111";
        System.out.println(fromBinToDecString(str));
//        System.out.println("std: " + Integer.parseInt("-101", 2)); // пример

        /** ---------------------------------- EX6 --------------------------------- */
        Show.show(6);
        str = "426";
        System.out.println(fromOctToDecString(str));

        /** ---------------------------------- EX7 --------------------------------- */
        Show.show(7);
        str = "FFFF";
        System.out.println(fromHexToDecString(str));

        /** ---------------------------------- EX8 --------------------------------- */
        Show.show(8);
        str = "299";
        System.out.println(fromDecToBinString(str));


//        int str = 0b1111_1111_1111;
//        System.out.println(str);
//        System.out.println("OCT: " + Integer.toOctalString(str));
//        System.out.println("HEX: " + Integer.toHexString(str).toUpperCase());
//
//        Show.show(3);
//        String snum = "3A7D";
//        System.out.println("HEX: " + snum);
//        System.out.println("BIN: " + Integer.toBinaryString(Integer.parseInt(snum, 16)));
//
//
//        int ds = 10;
//        ds = 0xA;
//        System.out.println("ds = " + ds);
//        ds = 0b1010;
//        System.out.println("ds = " + ds);
//        ds = 012;
//        System.out.println("ds = " + ds);
//
//        Show.show(4);
//        snum = "765F";
//        System.out.println(Integer.toOctalString(Integer.parseInt(snum, 16)));


    }
}
