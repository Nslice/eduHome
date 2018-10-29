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
         * practice1(void);
         * practice2(void);
         * practice3(void);
         * practice4(void);
         * practice4("in5.txt);
         */


        test(practice1.Example.class);
    }
}


