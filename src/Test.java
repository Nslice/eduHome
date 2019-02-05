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
<<<<<<< HEAD
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
=======
         * Serialize("input/info2.txt", "out/binObj.bin");
         * p1.home(double, double);   13, 6.2
         * p2.home("input/info2.txt");
         * home3(void);
         * home5(void);
         * home6(void);
         * home7(void);
         * home8("input/in8.txt", "out/words.txt");
         * home11(void);
         * home12(void);
         * home14(void);
         */

        /*
          ³ = "\u00B3"
         */

        test(p1.home.Example.class, "13", "6.2");
//        test(p2.home.Example.class, "input\\info2.txt");
>>>>>>> merger/master
    }
}


