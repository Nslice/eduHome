package practice7;

import java.io.File;
import java.io.FileFilter;

public class HTMLFileFilter implements FileFilter
{
    @Override
    public boolean accept(File file)
    {
        if (file.isDirectory())
            return true;
        return file.getName().endsWith(".html");
    }

    public void printDir(File folder)
    {
        System.out.println(folder.getName());
        printDir(folder, "");
    }

    /*
        Сделать так чтобы директории в которых нет html-файлов не отображались
     */
    private void printDir(File folder, String prefix)
    {
        File file;
        File[] fileList = folder.listFiles(this::accept);


        for (int index = 0; index < fileList.length; index++)
        {
            file = fileList[index];

            if (index == fileList.length - 1)
            {
                System.out.println(prefix + "┗━━━" + file.getName());  // '┗' ==\u2517, '━' == \u2501
                if (file.isDirectory())
                    printDir(file, prefix + "    ");
            }
            else
            {
                System.out.println(prefix + "┣━━━" + file.getName()); // '┣' == \u2523
                if (file.isDirectory())
                    printDir(file, prefix + "┃   "); // '┃' == \u2503
            }
        }

    }

}