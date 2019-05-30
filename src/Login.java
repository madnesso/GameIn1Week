import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Login extends MouseInput
    {
    Windows windows;
    private Register register;
    private Menu menu;
    private DataManger dm;
    private JLabel userlbl = new JLabel("Username"), passwordlbl = new JLabel("Passwrod");
    private JTextArea usertxt, passwordtxt;
    private JButton loginbtn, registerbtn;
    private JPanel panel;

    Login(Menu menu, Register register, DataManger dm)
        {
        this.menu = menu;
        this.register = register;
        this.dm = dm;
        usertxt = new JTextArea();
        passwordtxt = new JTextArea();
        loginbtn = new JButton("Login");
        registerbtn = new JButton("Register");
        panel = new JPanel(new GridLayout(3, 1));
        windows = new Windows(400, 400, "Login");
        panel.add(userlbl);
        panel.add(usertxt);
        panel.add(passwordlbl);
        panel.add(passwordtxt);
        panel.add(loginbtn);
        panel.add(registerbtn);
        loginbtn.addMouseListener(this);
        registerbtn.addMouseListener(this);
        windows.add(panel, BorderLayout.CENTER);
        windows.setVisible(true);
        }

    @Override
    public void mouseClicked(MouseEvent e)
        {
        JButton tempbtn = (JButton) e.getSource();
        if (tempbtn == loginbtn)
            {
            if (dm.check(usertxt.getText(), passwordtxt.getText()).equals("User exists"))
                {

                }
            else { System.out.println(dm.check(usertxt.getText(), passwordtxt.getText())); }
            }
        else if (tempbtn == registerbtn)
            {
            //do another thing
            }
        }

    }