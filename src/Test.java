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
         * Serialize("input\info2.txt", "out\binObj.bin");
         * home1(double, double);   13, 6.2
         * home2("input\info2.txt");
         * home3(void);
         * home5(void);
         * home6(void);
         * home8("input/in8.txt", "out/words.txt");
         */

        /*
          ³ = "\u00B3"
         */

        test(home1.Example.class, "13", "6.2");
//        test(home2.Example.class, "input\\info2.txt");
    }
}


