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
//<<<<<<< HEAD
//         * p1.practice(void);
//         * p2.practice(void);
//         * p3.practice(void);
//         * p4.practice(void);
//         * p5.practice("input\in5.txt");
//         * p6.practice("input\in6.txt", "out\out6.txt", "input\projFile.zip",
//         *      "input\forZip", "out\archive.zip");
//         * p7.practice(void);
//         * p8.practice(void);
//         */
//
//        test(p1.practice.Example.class);
//=======
//         * Serialize("input/info2.txt", "out/binObj.bin");
//         * p1.home(double, double);   13, 6.2
//         * p2.home("input/info2.txt");
//         * p3.home(void);
//         * p5.home(void);
//         * p6.home(void);
//         * p7.home(void);
//         * p8.home("input/in8.txt", "out/words.txt");
//         * p11.home(void);
//         * p12.home(void);
//         * p14.home(void);
//         */
//
//        /*
//          ³ = "\u00B3"
//         */
//
//        test(p1.home.Example.class, "13", "6.2");
////        test(p2.home.Example.class, "input\\info2.txt");
//>>>>>>> merger/master
    }
}


