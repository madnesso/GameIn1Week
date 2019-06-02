
package stickmantowerdefence;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ShopWindow extends MouseInput{
    Windows windows;
    private Shop shop;
    private JLabel wor = new JLabel("Worrior"), mage = new JLabel("Mage"), healer = new JLabel("Healer"), archer = new JLabel("Archer");
    private JButton[] Health;
    private JButton[] Mana;
    private JButton[] ManaReg;
    private JButton[] Range;
    private JButton[] Damage;
    private JButton Back;
    private JPanel panel;
    private boolean done = false;

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public ShopWindow()
        {
        Health = new JButton[4];
        Mana = new JButton[4];
        ManaReg = new JButton[4];
        Range = new JButton[4];
        Damage = new JButton[4];
        Back = new JButton();
        panel = new JPanel(new GridLayout(5, 6));
        windows = new Windows(600, 600, "Shop");
        for (int i = 0; i < 4; i++)
            {
            Health[i] = new JButton("add Health");
            Mana[i] = new JButton(" add Mana");
            ManaReg[i] = new JButton("add ManaReg");
            Damage[i] = new JButton("add Damage");
            Range[i] = new JButton("add Range");
            Health[i].addMouseListener(this);
            Mana[i].addMouseListener(this);
            ManaReg[i].addMouseListener(this);
            Damage[i].addMouseListener(this);
            Range[i].addMouseListener(this);
            }
        Mana[0].setEnabled(false);
        Mana[1].setEnabled(false);
        ManaReg[0].setEnabled(false);
        ManaReg[1].setEnabled(false);
        Damage[3].setEnabled(false);
        Range[0].setEnabled(false);
        panel.add(wor);
        panel.add(Health[0]);
        panel.add(Mana[0]);
        panel.add(ManaReg[0]);
        panel.add(Damage[0]);
        panel.add(Range[0]);
        panel.add(archer);
        panel.add(Health[1]);
        panel.add(Mana[1]);
        panel.add(ManaReg[1]);
        panel.add(Damage[1]);
        panel.add(Range[1]);
        panel.add(mage);
        panel.add(Health[2]);
        panel.add(Mana[2]);
        panel.add(ManaReg[2]);
        panel.add(Damage[2]);
        panel.add(Range[2]);
        panel.add(healer);
        panel.add(Health[3]);
        panel.add(Mana[3]);
        panel.add(ManaReg[3]);
        panel.add(Damage[3]);
        panel.add(Range[3]);
        panel.add(Back);
        Back.addMouseListener(this);
        windows.add(panel, BorderLayout.CENTER);
        windows.setVisible(false);
        }

    @Override
    public void mouseClicked(MouseEvent e)
        {
        JButton tempbtn = (JButton) e.getSource();
        if (tempbtn == Health[0])
            {
            shop.upgradeWarriorHealth();
            }
        if (tempbtn == Health[1])
            {
            shop.upgradeArcherHealth();
            }
        if (tempbtn == Health[2])
            {
            shop.upgradeMageHeath();
            }
        if (tempbtn == Health[3])
            {
            shop.upgradeHealerHealth();
            }
        if (tempbtn == Damage[0])
            {
            shop.upgradeWarriorDamage();
            }
        if (tempbtn == Damage[1])
            {
            shop.upgradeArcherDamage();
            }
        if (tempbtn == Damage[2])
            {
            shop.upgradeMageDamage();
            }
        if (tempbtn == Range[1])
            {
            shop.upgradeArcherRange();
            }
        if (tempbtn == Range[2])
            {
            shop.upgradeMageRange();
            }
        if (tempbtn == Range[3])
            {
            shop.upgradeHealerRange();
            }
        if (tempbtn == Mana[2])
            {
            shop.upgradeMageMana();
            }
        if (tempbtn == Mana[3])
            {
            shop.upgradeHealerMana();
            }
        if (tempbtn == ManaReg[2])
            {
            shop.upgradeMageRegen();
            }
        if (tempbtn == ManaReg[3])
            {
            shop.upgradeHealerRegen();
            }
        if (tempbtn == Back)
            {
                done = true;
            }
        }
    
}
