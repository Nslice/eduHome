package home14;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server implements Runnable
{
    private Socket connection;
    private ServerSocket server;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private boolean isRunning = true;

    public static void main(String[] args)
    {
        System.out.println("Server started  ");
        new Thread(new Server()).start();
    }

    @Override
    public void run()
    {
        try
        {
            String request = "";
            server = new ServerSocket(1234);
            while (isRunning)
            {
                connection = server.accept();
                System.out.println(connection.getInetAddress());
                output = new ObjectOutputStream(connection.getOutputStream());
                input = new ObjectInputStream(connection.getInputStream());
                request = (String) input.readObject();
                switch (request)
                {
                case "date":
                    output.writeObject(new Date().toString());
                    break;
                default:
                    output.writeObject("Unknown: " + request);
                }
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
                isRunning = false;
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

    }
}