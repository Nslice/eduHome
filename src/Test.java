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
         * p1.practice(void);
         * p2.practice(void);
         * practice3(void);
         * practice4(void);
         * practice5("input\in5.txt");
         * practice6("input\in6.txt", "out\out6.txt", "input\projFile.zip",
         *      "input\forZip", "out\archive.zip");
         * practice7(void);
         * practice8(void);
         */

        test(p1.practice.Example.class);
    }
}


