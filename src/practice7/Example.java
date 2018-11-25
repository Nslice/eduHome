package practice7;

import java.io.File;
import java.io.IOException;
import other.Show;

public class Example
{
	public static void main(String[] args)
	{
		String outputPath = "./out/pr7/";
		try
		{
			File file = new File(outputPath + "newFile.txt");
			System.out.println("create: " + file.createNewFile());
			System.out.println("static creation: " + File.createTempFile("staticFile",".bin", new File(outputPath)));


			String mytxt = "myfile.txt";
			file = new File(outputPath + mytxt);
			System.out.println("create myfile.txt: " + file.createNewFile());
			mytxt = "renamed.txt";
			System.out.println("rename myfile.txt:" + file.renameTo(new File(outputPath + mytxt)));
			Show.getch();

			Show.show(3);
			file = new File(outputPath + mytxt);
			System.out.println("deleting " + mytxt + ": " + file.delete());

			Show.show(4);
			file = new File(outputPath + mytxt);
			System.out.println("Writable?: " + file.canWrite());











		}
		catch (IOException | IllegalArgumentException ex)
		{
			ex.printStackTrace();
			return;
		}

	}
}