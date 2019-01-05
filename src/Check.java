import java.awt.*;
import java.awt.event.*;

public class Check
{
    public static void main(String[] args)
    {
        Frame f = new Frame("My frame");
        f.setSize(200, 200);
        f.addNotify(); // для нотификации о закрытии
        // native-окна (JDK 1.3, Solaris 8)
        f.addWindowListener(
                new WindowAdapter()
                {
                    public void windowClosing(WindowEvent w)
                    {
                        System.exit(0);
                    }
                });
        Button b1 = new Button("Yes");
        // кнопка
        b1.addActionListener(
                new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        ((Button) e.getSource())
                                .getParent()
                                .setBackground(Color.green);
                    }
                });
        // обработка события нажатия кнопки “Yes”:
        // вся картинка окрашивается в зеленый цвет
        Button b2 = new Button("No");
                // кнопка
                b2.addActionListener(
                        new ActionListener()
                        {
                            public void actionPerformed(ActionEvent e)
                            {
                                ((Button) e.getSource())
                                        .getParent()
                                        .setBackground(Color.red);
                            }
                        });
        // обработка события нажатия кнопки “No” –
        // вся картинка окрашивается в красный цвет
        Button b3 = new Button("Cancel");
        // кнопка “Cancel”
        b3.addActionListener(
                new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        System.exit(0);
                    }
                });
// обработка события нажатия кнопки “Cancel” –
// выход из приложения
        Button b4 = new Button("Refresh");
        // кнопка “Refresh”
        b4.addActionListener(
                new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        Component p =
                                ((Button) e.getSource()).
                                        getParent();
                        p.setBackground(Color.lightGray);
                        p.repaint();
                    }
                });
        // При нажатии кнопки – перерисовка всей картинки
// размещение кнопок – по “странам света”
        f.add(b1, BorderLayout.WEST);
        f.add(b2, BorderLayout.EAST);
        f.add(b3, BorderLayout.NORTH);
        f.add(b4, BorderLayout.SOUTH);
        // визуализация всей картинки
        f.setVisible(true);
    } // main

} 