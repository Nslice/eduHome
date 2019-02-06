import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Test
{
    static void test(Class c, String... args)
    {
        try
        {
            Method m = c.getDeclaredMethod("main", String[].class);
            m.invoke(null, new Object[]{args});
        }
        catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException ex)
        {
            ex.printStackTrace();
        }
    }


    public static void main(String[] args)
    {
        /**
         * p1.home(double, double);   13, 6.2
         * p2.home("input/info2.txt");
         * p5.practice("input\in5.txt");
         * p6.practice("input\in6.txt", "out\out6.txt", "input\projFile.zip",
         *      "input\forZip", "out\archive.zip");
         * p8.home("input/in8.txt", "out/words.txt");
         * p10.home.Serialize("input/info2.txt", "out/binObj.bin");
         */

        test(p10.home.Serialize.class, "input/info2.txt", "out/binObj.bin");
    }
}


