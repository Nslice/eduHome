package practice5;

/*
    https://regex101.com
    https://regexone.com
    https://ru.wikipedia.org/wiki/Регулярные_выражения



    (clear regex):
    [ ]         - символьный класс
    [^5]        - отрицание, любой символ кроме '5'
    \Q 1+1 \E   - буквальное выражение между \Q и \E
    \b          - граница слова
    \B          - не граница слова
 */

import other.Show;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Example
{
    public static void main(String[] args)
    {


//        Pattern p = Pattern.compile("\\bgr[a%e]y\\b");
//        Matcher m = p.matcher("gray dfhgdf gr%y ]]]gr%yhfjghjghj grey");
//
//        while (m.find())
//        {
//            System.out.println(m.start() + "-" + m.end() + "     sqe: " + m.group() );
//        }

        Domashka.go();


        System.out.println("Done.");
    }
}


class Domashka
{
    public static void go()
    {
        String str = "This is Jim and Timothy";
        String regex = "[TJ]im";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);

        while (m.find())
        {
            System.out.println(m.group() + " : " + m.start() + "-" + m.end());
        }


        //ex2:
        Show.show(2);
        str = m.replaceAll("John");
        System.out.println("after replace: " + str);


        //ex3:
        Show.show(3);
        StringBuffer sb = new StringBuffer("My dad and My mom");
        System.out.println(sb);
        p = Pattern.compile("My");
        m = p.matcher(sb);

        while (m.find())
        {
            m.appendReplacement(sb, "Our");
        }
        System.out.println(sb);


    }
}