package p7.practice;

import java.io.File;
import java.io.FileFilter;


public class FileExtensionFilter implements FileFilter
{
    private String extenstion;
    private int maxLvl;


    public FileExtensionFilter(String extenstion)
    {
        this.extenstion = "." + extenstion;
    }


    @Override
    public boolean accept(File file)
    {
        if (file.isDirectory())
            return true;
        return file.getName().endsWith(extenstion);
    }


    public void printDir(File folder)
    {
        this.maxLvl = -1;
        System.out.println(folder.getAbsolutePath());
        printDir(folder, "", 0);
    }


    public void printDir(File folder, int level)
    {
        this.maxLvl = level;
        System.out.println(folder.getAbsolutePath());
        printDir(folder, "", 0);
    }


    private void printDir(File folder, String prefix, int currentLvl)
    {
        if (currentLvl == maxLvl) return;

        File file;
        File[] fileList = folder.listFiles(this);


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