package practice7;

import other.Show;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

public class Example
{
    static final String SP = File.separator;
    static final String outPath = "out" + SP + "pr7" + SP;
    static final String inPath = "input" + SP;

    public static void main(String[] args) throws IOException
    {
        Random rand = new Random();
        File file;
        /** ---------------------------------- EX1 --------------------------------- */
        Show.show(1);
        file = new File(outPath + "newFile.txt");
        System.out.println("create: " + file.createNewFile());
        System.out.println("create tmp-file: " +
                File.createTempFile("smth", ".tmp", new File(outPath)));
        Show.getch();


        /** ---------------------------------- EX2 --------------------------------- */
        Show.show(2);
        String mytxt = "myfile.txt";
        file = new File(outPath + mytxt);
        System.out.println("create \"" + mytxt + "\" = " + file.createNewFile());

        mytxt = rand.nextInt(500) + "renamed.txt";
        System.out.print("Push button for rename file");
        Show.getch();
        System.out.println("rename to \"" + mytxt + "\" = " + file.renameTo(new File(outPath + mytxt)));

        // переименование директории:
        System.out.print("\nPush button for rename directory");
        Show.getch();
        file = new File(outPath);
        System.out.println(file + " - isDirectory() = " + file.isDirectory());
        String dirName = file.getParent() + SP + "MY_DIR";
        System.out.println("rename to \"" + dirName + "\" = " + file.renameTo(new File(dirName)));

        // переименование директории:
        System.out.print("\nPush button for rename directory again");
        Show.getch();
        file = new File(dirName);
        System.out.println("rename again = " + file.renameTo(new File(outPath)));
        Show.getch();


        /** ---------------------------------- EX3 --------------------------------- */
        Show.show(3);
        file = new File(outPath + mytxt);
        System.out.println("delete \"" + mytxt + "\" = " + file.delete());
        Show.getch();


        /** ---------------------------------- EX4 --------------------------------- */
        Show.show(4);
        file = new File(outPath + "newFile.txt");
        System.out.println("Writable? = " + file.canWrite());
        file.setWritable(false);
        System.out.println("Writable? = " + file.canWrite());
        Show.getch();


        /** ---------------------------------- EX5 --------------------------------- */
        Show.show(5);
        System.out.println("before last modified = " + new Date(file.lastModified()));
        file.setLastModified(file.lastModified() - 5 * 86_400_000);
        System.out.println(" after last modified = " + new Date(file.lastModified()));
        Show.getch();


        /** ---------------------------------- EX6 --------------------------------- */
        Show.show(6);
        file = new File(inPath + "projFile.zip");
        System.out.println(file + "\nsize = " + file.length() + "  bytes");

        Show.getch();


        /** ---------------------------------- EX7 --------------------------------- */
        Show.show(7);
        System.out.println(file + " - Exists? = " + file.exists());
        file = new File(inPath + "readme.txt");
        System.out.println(file + " - Exists? = " + file.exists());
        Show.getch();


        /** ---------------------------------- EX8 --------------------------------- */
        Show.show(8);
        file = new File(inPath + "projFile.zip");
        System.out.println(file + " - Exists? = " + file.exists());
        System.out.println("rename = " + file.renameTo(new File(outPath + "projFile.zip")));
        Show.getch();


        /** ---------------------------------- EX9 --------------------------------- */
        Show.show(9);
        file = new File(inPath + "copy.zip");
        System.out.println("file = " + file);
        System.out.println(file + " - Exists? = " + file.exists());
        System.out.println("Absolute path: " + file.getAbsolutePath());
        Show.getch();


        /** ---------------------------------- EX10 --------------------------------- */
        Show.show(10);
        System.out.println("file = " + file);
        System.out.println("file.isDirectory() = " + file.isDirectory());
        System.out.println("file.isFile() = " + file.isFile());
        Show.getch();


        /** ---------------------------------- EX11 --------------------------------- */
        Show.show(11);
        file = new File(inPath + "filesPr7");
        Dir.printDir(file);
        Show.getch();


        /** ---------------------------------- EX12 --------------------------------- */
        Show.show(12);
        System.out.println("HTML-FILES");
        FileExtensionFilter filter = new FileExtensionFilter("html");
        file = new File(inPath + "filesPr7");
        filter.printDir(file);
        Show.getch();


        /** ---------------------------------- EX13 --------------------------------- */
        Show.show(13);
        file = new File(outPath + "newDir" + SP + "sources" + SP + "some");
        System.out.println("file.mkdirs() = " + file.mkdirs());
        file = new File(outPath + "newDir" + SP + "other" + SP + "pics");
        System.out.println("file.mkdirs() = " + file.mkdirs());
    }


}


class Dir
{
    // https://www.compart.com/en/unicode/block/U+2500

    private static int maxLvl;
    //------------------------------------------------------------------------

    /**
     * Выводит дерево директорий и папок, включая все вложенные.
     *
     * @param folder директория.
     */
    public static void printDir(File folder)
    {
        maxLvl = -1;
        System.out.println(folder.getAbsolutePath());
        printDir(folder, "", 0);
    }

    /**
     * Выводит дерево директорий и папок, включая вложенные до заданной глубины.
     *
     * @param folder директория.
     * @param level  уровень вложенности.
     */
    public static void printDir(File folder, int level)
    {
        maxLvl = level;
        System.out.println(folder.getAbsolutePath());
        printDir(folder, "", 0);
    }

    /**
     * Напрямую этот метод не вызывается.
     *
     * @param folder     директория.
     * @param prefix     строка с пробелами и спец. символами.
     * @param currentLvl текущий уровень вложенности.
     */
    private static void printDir(File folder, String prefix, int currentLvl)
    {
        if (currentLvl == maxLvl) return;

        File file;
        File[] fileList = folder.listFiles();


        for (int index = 0; index < fileList.length; index++)
        {
            file = fileList[index];
            if (file.isHidden()) continue;

            if (index == fileList.length - 1)
            {
                System.out.println(prefix + "┗━━━" + file.getName());  // '┗' ==\u2517, '━' == \u2501
                if (file.isDirectory())
                    printDir(file, prefix + "    ", currentLvl + 1);
            }
            else
            {
                System.out.println(prefix + "┣━━━" + file.getName()); // '┣' == \u2523
                if (file.isDirectory())
                    printDir(file, prefix + "┃   ", currentLvl + 1); // '┃' == \u2503
            }
        }

    }
}
