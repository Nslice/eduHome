package home14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

public class Example extends JFrame
{


    public static void main(String args[]) throws Exception
    {
        new Thread(new Server()).start();
        new Thread(new Client()).start();

    }
}



