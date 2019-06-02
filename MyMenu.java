
package stickmantowerdefence;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class MyMenu extends MouseInput
    {
    Windows windows;
    private JButton Play, Shop, Logout;
    private JPanel panel;
    private boolean done = false;
    private boolean shop = false;

    public MyMenu()
        {
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

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public boolean isShop() {
        return shop;
    }

    public void setShop(boolean shop) {
        this.shop = shop;
    }

    @Override
    public void mouseClicked(MouseEvent e)
        {
        JButton tempbtn = (JButton) e.getSource();
        if (tempbtn == Play)
            {
              done = true;
            }
        if (tempbtn == Shop)
            {
                shop = true;
            }
        if (tempbtn == Logout)
            {
                System.exit(0);
            }
        }
    }