import stickmantowerdefence.MouseInput;
import stickmantowerdefence.Windows;
import stickmantowerdefence.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Shop extends MouseInput
    {
    public Windows windows;
    private MyMenu myMenu;
    private JLabel wor = new JLabel("Worrior"), mage = new JLabel("Mage"), healer = new JLabel("Healer"), archer =
            new JLabel("Archer");
    private JButton[] Health;
    private JButton[] Mana;
    private JButton[] ManaReg;
    private JButton[] Range;
    private JButton[] Damage;
    private JButton Back;
    private JPanel panel;

    public Shop(MyMenu myMenu)
        {
        this.myMenu = myMenu;
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
            upgradeWarriorHealth();
            }
        if (tempbtn == Health[1])
            {
            upgradeArcherHealth();
            }
        if (tempbtn == Health[2])
            {
            upgradeMageHealth();
            }
        if (tempbtn == Health[3])
            {
            upgradeHealerHealth();
            }
        if (tempbtn == Damage[0])
            {
            upgradeWarriorDamage();
            }
        if (tempbtn == Damage[1])
            {
            upgradeArcherDamage();
            }
        if (tempbtn == Damage[2])
            {
            upgradeMageDamage();
            }
        if (tempbtn == Range[1])
            {
            upgradeArcherRange();
            }
        if (tempbtn == Range[2])
            {
            upgradeMageRange();
            }
        if (tempbtn == Range[3])
            {
            upgradeHealerRange();
            }
        if (tempbtn == Mana[2])
            {
            upgradeMageMana();
            }
        if (tempbtn == Mana[3])
            {
            upgradeHealerMana();
            }
        if (tempbtn == ManaReg[2])
            {
            upgradeMageRegen();
            }
        if (tempbtn == ManaReg[3])
            {
            upgradeHealerRegen();
            }
        if (tempbtn == Back)
            {
            myMenu.windows.setVisible(true);
            windows.setVisible(false);
            }
        }

    public void upgradeWarriorHealth()
        {
        Warrior.setHealthFactor(Warrior.getHealthFactor() + 1);
        }

    public void upgradeArcherHealth()
        {
        Archer.setHealthFactor(Archer.getHealthFactor() + 1);
        }

    private void upgradeMageHealth()
        {
        Mage.setHealthFactor(Mage.getHealthFactor() + 1);
        }

    public void upgradeHealerHealth()
        {
        Healer.setHealthFactor(Healer.getHealthFactor() + 1);
        }

    public void upgradeWarriorDamage()
        {
        Warrior.setDamageFactor(Warrior.getDamageFactor() + 1);
        }

    public void upgradeArcherDamage()
        {
        Archer.setDamageFactor(Archer.getDamageFactor() + 1);
        }

    public void upgradeMageDamage()
        {
        Mage.setDamageFactor(Mage.getDamageFactor() + 1);
        }

    public void upgradeArcherRange()
        {
        Archer.setRangeFactor(Archer.getRangeFactor() + 1);
        }

    public void upgradeMageRange()
        {
        Mage.setRangeFactor(Mage.getRangeFactor() + 1);
        }

    public void upgradeHealerRange()
        {
        Healer.setRangeFactor(Healer.getRangeFactor() + 1);
        }

    public void upgradeMageMana()
        {
        Mage.setManaFactor(Mage.getManaFactor() + 1);
        }

    public void upgradeHealerMana()
        {
        Healer.setManaFactor(Mage.getManaFactor() + 50);
        }

    public void upgradeMageRegen()
        {
        Mage.setManaRegenFactor(Mage.getManaRegenFactor() + 1);
        }

    public void upgradeHealerRegen()
        {
        Healer.setManaRegenFactor(Healer.getManaRegenFactor() + 1);
        }
    }
