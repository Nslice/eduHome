package home8;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class Example
{

    public static void main(String[] args)
    {
        TxtFile file = new TxtFile("./input/in8.txt");

        int num = 10;
        try (FileOutputStream stream = new FileOutputStream(new File("./out/words.txt")))
        {
            file.filterShow(num, System.out);
            file.filterShow(num, stream);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
