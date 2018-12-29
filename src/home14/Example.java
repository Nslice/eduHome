package home14;

import java.io.*;
import java.net.*;

public class Example
{
    public Example()
    {
        new Thread(new MyServer()).start();
        new Thread(new MyClient()).start();
    }

    public static void main(String args[])
    {
        new Example();
    }
}

class MyServer implements Runnable
{
    public void run()
    {
        ServerSocket server = null;
        Socket serverSocket = null;
        OutputStream os = null;
        try
        {
            server = new ServerSocket(1177);
            serverSocket = server.accept();
            System.out.println("Connect on the Server side!");
            os = serverSocket.getOutputStream();
            os.write(44);
        }
        catch (IOException e)
        {
        }
    }
}

class MyClient implements Runnable
{
    public void run()
    {
        Socket clientSocket = null;
        InputStream is = null;
        try
        {
            clientSocket = new Socket("127.000.000.001", 1177);
            is = clientSocket.getInputStream();
            System.out.println("Client reads: " + is.read());
        }
        catch (UnknownHostException e)
        {
            System.out.println("UnknownHost");
        }
        catch (IOException e)
        {
        }
    }
} 