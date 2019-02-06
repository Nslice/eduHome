package p7.practice;

import java.io.File;


class Dir
{
    // https://www.compart.com/en/unicode/block/U+2500

    private static int maxLvl;


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
