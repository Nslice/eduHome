package home14;

import javax.swing.*;

public class Example extends JFrame
{


    public static void main(String[] args)
    {
        new Thread(new Server()).start();
        new Thread(new Client()).start();
    }


}



