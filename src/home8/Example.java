package home8;

import java.io.*;
import java.util.Scanner;

class TxtFile
{
    private File txt;
    private File outtxt;

    TxtFile(String path)
    {
        txt = new File(path);
    }

    public void setOuttxt(String path)
    {
        outtxt = new File(path);
    }

    void show()
    {
        try (BufferedReader fin = new BufferedReader(new FileReader(txt));
                BufferedWriter fout = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            char[] buffer = new char[1042];
            int len;
            while ((len = fin.read(buffer, 0, buffer.length)) != -1)
            {
                fout.write(buffer, 0, len);
            }

        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            System.out.flush();
            System.out.println("CHECK " + System.out.checkError());
        }
    }


    void filterShow(int num) throws Exception
    {
        String text;
        BufferedReader fin = new BufferedReader(new FileReader(txt));
        BufferedWriter fout = new BufferedWriter(new FileWriter(outtxt));


        Scanner scanner = new Scanner(txt).useDelimiter("\\.(\\s+|$)");      //  \\s|
        String token = "LOL";
        while (scanner.hasNext())
        {
            token = scanner.next() + ".";
            String[] strs = token.split(" ");
            if (strs.length == 7)
            {
                System.out.println(token);
                fout.write(token);
                fout.newLine();
            }
        }

        fout.close();

//
//        String line;
//        while ((line = fin.readLine()) != null)
//        {
//            sb.append(line);
//        }
//
//        StringTokenizer tokenizer = new StringTokenizer(sb.toString(), ".", false);
//        int cod = tokenizer.countTokens();
//        while (tokenizer.hasMoreTokens())
//        {
//            System.out.println(tokenizer.nextToken());
//        }
//
//        System.out.println(sb);
//        System.out.println(sb.length());
//
//        String[] sentences = sb.toString().split("\\.");
//        for (String s : sentences)
//        {
//            String[] words = s.split(" ");
//            if (words.length == num)
//            {
//                System.out.println(s);
//            }
//        }


//        String[] lines = sb.toString().split("\\.");
//        for (String s : lines)
//            System.out.println(s);

    }
}


public class Example
{

    public static void main(String[] args) throws Exception
    {
        System.out.println("Example.main");

        TxtFile file = new TxtFile("./input/in8.txt");
        file.setOuttxt("./out/sevenWords.txt");
        file.filterShow(7);

    }
}
