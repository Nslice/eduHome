import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Test
{
    static void test(Class c, String... args)
    {

        try
        {
            Method m = c.getDeclaredMethod("main", String[].class);
            m.invoke(null, new Object[] {args});
        }
        catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException ex)
        {
            ex.printStackTrace();
        }
    }



    public static void main(String[] args)
    {
        /**
         * practice1();
         * practice2();
         */

        test(practice1.Example.class);
        test(practice2.Example.class);
    }
}


