package home8;

import java.io.*;
import java.util.Scanner;

public class TxtFile
{
    private File txt;


    /**
     * Открывает txt файл.
     *
     * @param path путь к файлу.
     */
    public TxtFile(String path)
    {
        txt = new File(path);
    }

    public void open(String path)
    {
        txt = new File(path);
    }

    /**
     * Выводит предложения только с заданным количеством слов.
     *
     * @param num кол-во слов в предложении.
     * @param os  поток для вывода.
     * @throws IOException ошибки ввода/вывода.
     */
    public void filterShow(int num, PrintStream os) throws IOException
    {
        Scanner scanner = new Scanner(txt).useDelimiter("[.?!](\\s+|$)");
        String token;

        while (scanner.hasNext())
        {
            token = scanner.next();
            if (token.split("\\s+").length == num)
            {
                token = token.replaceAll("\r\n|\n", " ");
                os.println(token + ".");
            }
        }

        scanner.close();
    }
}