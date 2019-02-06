package p6.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;


public class Zip
{
    public static void showZip(ZipFile zip)
    {
        Enumeration<? extends ZipEntry> entries = zip.entries();

        SimpleDateFormat form = new SimpleDateFormat("yyyy.MM.dd - HH:mm");
        while (entries.hasMoreElements())
        {
            ZipEntry entry = entries.nextElement();
            Date date = new Date(entry.getLastModifiedTime().toMillis());
            System.out.print(form.format(date));
            System.out.println("\t" + entry.getName());
        }
    }


    public static void doZip(ZipOutputStream stream, File path) throws IOException, ZipException
    {
        byte[] buffer = new byte[8192];
        doZip(stream, path, buffer);
    }

    private static void doZip(ZipOutputStream stream, File path, byte[] buffer) throws IOException, ZipException
    {
        /*
          entry.setLastModifiedTime() устанавливает время изменения как было.
          По умолчанию всем файлам в дату последнего изменения ставится
          дата создания архива.
         */
        for (File f : path.listFiles())
        {
            if (f.isDirectory())
            {
                ZipEntry entry = new ZipEntry(f.getPath() + File.separator);
                entry.setLastModifiedTime(FileTime.fromMillis(f.lastModified()));
                stream.putNextEntry(entry);

                doZip(stream, f, buffer);
                stream.closeEntry();
            }
            else
            {
                ZipEntry entry = new ZipEntry(f.getPath());
                entry.setLastModifiedTime(FileTime.fromMillis(f.lastModified()));
                stream.putNextEntry(entry);

                int length;
                FileInputStream fin = new FileInputStream(f);
                while ((length = fin.read(buffer)) != -1)
                    stream.write(buffer, 0, length);
                stream.closeEntry();
                fin.close();
            }
        }
    }
}
