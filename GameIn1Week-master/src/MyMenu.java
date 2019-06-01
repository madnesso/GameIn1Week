import stickmantowerdefence.MouseInput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class MyMenu extends MouseInput
    {
    Windows windows;
    private Login login;
    private Shop shop;
    private JButton Play, Shop, Logout;
    private JPanel panel;

    public MyMenu(Login login, Shop shop)
        {
        this.login = login;
        this.shop = shop;
        Play = new JButton("Play");
        Shop = new JButton("Shop");
        Logout = new JButton("Logout");
        panel = new JPanel(new GridLayout(3, 1));
        windows = new Windows(300, 300, "MyMenu");
        panel.add(Play);
        panel.add(Shop);
        panel.add(Logout);
        Play.addMouseListener(this);
        Shop.addMouseListener(this);
        Logout.addMouseListener(this);
        windows.add(panel, BorderLayout.CENTER);
        windows.setVisible(false);
        }

    @Override
    public void mouseClicked(MouseEvent e)
        {
        JButton tempbtn = (JButton) e.getSource();
        if (tempbtn == Play)
            {
            //open game
            }
        if (tempbtn == Shop)
            {
            shop.windows.setVisible(true);
            windows.setVisible(false);
            }
        if (tempbtn == Logout)
            {
            login.windows.setVisible(true);
            windows.setVisible(false);
            }
        }
    }
