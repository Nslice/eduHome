package home8;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

/**
 * класс
 */
public class TxtFile
{
    private File txt;


    public TxtFile(String path)
    {
        txt = new File(path);
    }

    public void open(String path)
    {
        txt = new File(path);
    }

    /**
     * Показать предложения только с заданным количеством слов.
     *
     * @param num кол-во слов в предложении.
     * @param os  поток для вывода.
     * @throws IOException ошибки ввода/вывода.
     */
    public void filterShow(int num, OutputStream os) throws IOException
    {
        BufferedReader fin = new BufferedReader(new FileReader(txt));
        Scanner scanner = new Scanner(txt).useDelimiter("[.?!](\\s+|$)");
        String token;

        while (scanner.hasNext())
        {
            token = scanner.next();
            if (token.split("\\s+").length == num)
            {
                token = token.replaceAll("(\r\n)|\n", " ");
                os.write((token + ".\r\n").getBytes());
            }
        }

        fin.close();
        scanner.close();
    }
}
