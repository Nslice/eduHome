package home14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client extends JFrame implements Runnable
{
    private Socket connection;
    private InputStream input;
    private OutputStream output;

    Client()
    {
        setLayout(new FlowLayout());
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        JTextField field = new JTextField(10);
        JButton button = new JButton("send");
        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (e.getSource() == button)
                {
//                    System.out.println(field.getText());
//                    sendData(field.getText());
                    try
                    {
                        output.write(25354);
                    }
                    catch (IOException e1)
                    {
                        e1.printStackTrace();
                    }
                }
            }
        });

        add(field);
        add(button);
    }


    @Override
    public void run()
    {
        try
        {
            while (true)
            {

                connection = new Socket(InetAddress.getByName("127.0.0.1"), 1177);
                input = connection.getInputStream();
                output = connection.getOutputStream();
//                JOptionPane.showMessageDialog(null,
//                        (String) input.readObject());
//                System.out.println(input);
//                System.out.println(output);
                output.write(44);
            }
        }
        catch (UnknownHostException ex)
        {
            System.out.println("UnknownHost");
            ex.printStackTrace();
        }
        catch ( IOException ex)
        {
            ex.printStackTrace();
        }


    }

    private void sendData(Object obj)
    {
//        System.out.println((String) obj);
//        System.out.println(Thread.currentThread().getName());
//        try
//        {
//            output.flush();
//            output.writeObject(obj);
//        }
//        catch (IOException e)
//        {
//            e.printStackTrace();
//            System.out.println("wtf");
//        }

    }
}