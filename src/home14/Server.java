package home14;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable
{
    private ServerSocket server;
    private Socket connection;
    private ObjectInputStream input;
    private ObjectOutputStream output;

    @Override
    public void run()
    {
        try
        {
            server = new ServerSocket(1177);
            while (true)
            {
                connection = server.accept();
                connection = server.accept();
                output = new ObjectOutputStream(connection.getOutputStream());
                output.flush();
                input = new ObjectInputStream(connection.getInputStream());
                output.writeObject("Вы прислали: " + input.readObject());
                output.flush();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                input.close();
                output.close();
                connection.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

    }
}