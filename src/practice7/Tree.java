package practice7;

import java.io.File;

/*
    https://www.compart.com/en/unicode/block/U+2500
 */
public class Tree
{
    static void print(String directory)
    {
        System.out.println(directory);
        printDir(new File(directory), "");
    }

    static void printDir(File folder, String prefix)
    {
        File file;
        File[] fileList = folder.listFiles();

        for (int index = 0; index < fileList.length; index++)
        {
            file = fileList[index];

            if (index == fileList.length - 1)
            {
                System.out.println(prefix + "└───" + file.getName());  // '┗' ==\u2517, '━' == \u2501
                if (file.isDirectory())
                    printDir(file, prefix + "    ");
            }
            else
            {
                System.out.println(prefix + "├───" + file.getName()); // '┣' == \u2523
                if (file.isDirectory())
                    printDir(file, prefix + "│   "); // '┃' == \u2503
            }
        }

    }

    private static void dirs(File file, int level)
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

    public static void main(String[] args)
    {
        String directory = "input" + File.separator + "filesPr7";
        print(directory);
//        dirs(new File(directory), 0);
    }
}

