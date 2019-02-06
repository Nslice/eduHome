package p14.home;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class Client extends JFrame implements Runnable
{
    private Socket connection;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private boolean isRunning = true;

    private JLabel label;


    public Client()
    {
        setLayout(new FlowLayout());
        pack();
        setSize(340, 340);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        label = new JLabel("Connecting...");
        JTextField field = new JTextField(10);


        JButton send = new JButton("send");
        send.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                sendData(field.getText());
                field.setText("");
            }
        });

        add(send);
        add(field);
        add(label);
    }


    @Override
    public void run()
    {
        try
        {
            while (isRunning)
            {
                connection = new Socket("127.0.0.1", 1234);
                output = new ObjectOutputStream(connection.getOutputStream());
                input = new ObjectInputStream(connection.getInputStream());
                label.setText("Connected");
                JOptionPane.showMessageDialog(null, (String) input.readObject());
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


    public void sendData(String str)
    {
        try
        {
            output.flush();
            output.writeObject(str);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}