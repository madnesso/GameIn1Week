
package stickmantowerdefence;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Login extends MouseInput
{
    Windows windows;
    private DataManger dm;
    private JLabel idlbl = new JLabel("ID"), userlbl = new JLabel("Username"), passwordlbl = new JLabel("Passwrod"), comLabel = new JLabel("Please enter your name and password");
    private JTextArea idtxt, usertxt, passwordtxt;
    private JButton loginbtn, registerbtn;
    private JPanel panel;
    private boolean done = false;

    Login(DataManger dm)
        {
        this.dm = dm;
        idtxt = new JTextArea();
        usertxt = new JTextArea();
        passwordtxt = new JTextArea();
        loginbtn = new JButton("Login");
        registerbtn = new JButton("Register");
        panel = new JPanel(new GridLayout(7, 1));
        windows = new Windows(400, 400, "Login");
        panel.add(idlbl);
        panel.add(idtxt);
        panel.add(userlbl);
        panel.add(usertxt);
        panel.add(passwordlbl);
        panel.add(passwordtxt);
        panel.add(loginbtn);
        panel.add(registerbtn);
        panel.add(comLabel);
        loginbtn.addMouseListener(this);
        registerbtn.addMouseListener(this);
        windows.add(panel, BorderLayout.CENTER);
        windows.setVisible(true);
        }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        JButton tempbtn = (JButton) e.getSource();
        if (tempbtn == loginbtn)
        {
            switch (dm.check(idtxt.getText(), passwordtxt.getText()))
            {
                case "User exists":
                    done = true;
                    break;
                case "Wrong password":
                    comLabel.setText("Wrong password");
                    break;
                case "Unknown id":
                    comLabel.setText("Unknown id");
                    break;
                default:
                    break;
            }
        }
        else if (tempbtn == registerbtn)
        {
            switch (dm.addUser(usertxt.getText(), idtxt.getText(), passwordtxt.getText())) 
            {
                case "ID already exists.":
                    comLabel.setText("ID already exists.");
                    break;
                case "Password already exists.":
                    comLabel.setText("Password already exists.");
                    break;
                case "User added succesfully":
                    done = true;
                    dm.saveUsers();
                    break;
                default:
                    break;
            }
        }
    }

}

