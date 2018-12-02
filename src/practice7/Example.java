package practice7;

import other.Show;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Example
{
    public static void main(String[] args)
    {
        final String SP = File.separator;


        String outPath = "out" + SP + "pr7" + SP;
        String inPath = "input" + SP;
        Random rand = new Random();
        try
        {
            /** ---------------------------------- EX1 --------------------------------- */
            Show.show(1);
            File file = new File(outPath + "newFile.txt");
            System.out.println("create: " + file.createNewFile());
//            System.out.println("create tmp-file: " +
//                    File.createTempFile("smth", ".tmp", new File(outPath)));
//            Show.getch();


            /** ---------------------------------- EX2 --------------------------------- */
//            Show.show(2);
//            String mytxt = "myfile.txt";
//            file = new File(outPath + mytxt);
//            System.out.println("create \"" + mytxt + "\" = " + file.createNewFile());
//
//            mytxt = rand.nextInt(500) + "renamed.txt";
//            System.out.print("Push button for rename file");
//            Show.getch();
//            System.out.println("rename to \"" + mytxt + "\" = " + file.renameTo(new File(outPath + mytxt)));
//
//            // переименование директории:
//            file = new File(outPath);
//            System.out.println("\n" + file + "\nfile.isDirectory() = " + file.isDirectory());
//            String dirName = file.getParent() + File.separator + "MY_DIR";
//            System.out.println("rename to \"" + dirName + "\" = " + file.renameTo(new File(dirName)));
//
//            System.out.print("Push button for rename directory again");
//            Show.getch();
//            file = new File(dirName);
//            System.out.println("rename again = " + file.renameTo(new File(outPath)));
//            Show.getch();


            /** ---------------------------------- EX3 --------------------------------- */
//            Show.show(3);
//            file = new File(outPath + mytxt);
//            System.out.println("delete \"" + mytxt + "\" = " + file.delete());
//            Show.getch();


            /** ---------------------------------- EX4 --------------------------------- */
//            Show.show(4);
//            file = new File(outPath + "newFile.txt");
//            System.out.println("Writable? = " + file.canWrite());
//            file.setWritable(false);
//            System.out.println("Writable? = " + file.canWrite());


            /** ---------------------------------- EX5 --------------------------------- */
//            Show.show(5);
//            System.out.println("before last modified = " + new Date(file.lastModified()));
//            file.setLastModified(file.lastModified() - 5 * 86_400_000);
//            System.out.println(" after last modified = " + new Date(file.lastModified()));
//            Show.getch();


            /** ---------------------------------- EX6 --------------------------------- */
//            Show.show(6);
//            file = new File(inPath + "projFile.zip");
//            System.out.println(file + "\nsize = " + file.length() + "  bytes");
//
//
//            /** ---------------------------------- EX7 --------------------------------- */
//            Show.show(7);
//            System.out.println(file + " - Exists? = " + file.exists());
//            file = new File(inPath + "readme.txt");
//            System.out.println(file + " - Exists? = " + file.exists());
//
//
//            /** ---------------------------------- EX8 --------------------------------- */
//            Show.show(8);
//            file = new File(inPath + "projFile.zip");
//            System.out.println(file + " - Exists? = " + file.exists());
//
//            System.out.println("rename = " + file.renameTo(new File(outPath + "projFile.zip")));


            /** ---------------------------------- EX9 --------------------------------- */
//            Show.show(9);
//            file = new File(inPath + "projFile.zip");
//            System.out.println("file = " + file);
//            System.out.println(file + " - Exists? = " + file.exists());
//            System.out.println("Absolute path: " + file.getAbsolutePath());
//
//
//            /** ---------------------------------- EX10 --------------------------------- */
//            Show.show(10);
//            System.out.println("file = " + file);
//            System.out.println("file.isDirectory() = " + file.isDirectory());
//            System.out.println("file.isFile() = " + file.isFile());
//

            /** ---------------------------------- EX11 --------------------------------- */
//            Show.show(11);
//
//            file = new File(inPath + "filesPr7");
//            System.out.println("\nList of files and folders for archiving:");
//            showFiles(file);


            /** ---------------------------------- EX13 --------------------------------- */
            Show.show(13);
            file = new File(inPath + "filesPr7");
            System.out.println("\nList of files and folders for archiving:");
//            tree(file, "___");
            File[] arr = {file};
//            RecursivePrint(arr, 0,0);


            dirs(file);

        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }


    }


    public static void dirs(File file)
    {
        dirs(file, 0);
    }

    public static void dirs(File file, int level)
    {
        for (File f : file.listFiles())
        {
            for (int i = 0; i < level; i++)
                System.out.print("\t");

            if (f.isDirectory())
            {
                System.out.println(f.getName() + "/");
                dirs(f, level + 1);
            }
            else
                System.out.println(f.getName());
        }
    }

    public static void showFiles(File dir)
    {
        for (File f : dir.listFiles())
        {
            if (f.isDirectory())
            {
                System.out.println("<DIR>  " + f.getName());
                showFiles(f);
            }
            else System.out.println("       " + f.getName());
        }
    }
}