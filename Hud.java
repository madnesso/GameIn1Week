
package stickmantowerdefence;

import java.awt.Color;
import java.awt.Graphics;


public class Hud {
    private static int TowerHealth = 1000;
    private static int[] UnitHealth = new int[8];
    private Handler handler;
    private int[] Maxhealth = new int[8];

    public Hud(Handler handler)
        {
        for (int i : UnitHealth)
            {
            UnitHealth[i] = 0;
            }
        this.handler = handler;
        }

//    public void getpoint(Handler handler, int[] testx, int[] testy)
//        {
//        for (GameObject tempObj : handler.objects)
//            {
//            if (tempObj instanceof Units)
//                {
//                for (int i : testx)
//                    {
//                    testx[i] = tempObj.getPoint().x;
//                    testy[i] = tempObj.getPoint().y;
//                    }
//                }
//            }
//
//        }

    public static int getTowerHealth()
        {
        return TowerHealth;
        }

    public static void setTowerHealth(int towerHealth)
        {
        TowerHealth = towerHealth;
        }

    public static int getUnitHealth(int i)
        {
        if (i <= 7)
            {
            return UnitHealth[i];
            }
        return 0;
        }

    public static void setUnitHealth(int unitHealth, int i)
        {
        if (i <= 7)
            {
            UnitHealth[i] = unitHealth;
            }
        }

    public int getMaxhealth(int i)
        {
        return Maxhealth[i];
        }

    public void paint(Graphics g)
        {
        DrawHealth(15, 15, g, TowerHealth, 1000);
        for (int i = 0; i < handler.objectSize(); i++)
            {
            if (handler.getObject(i) instanceof Units)
                {
                int x = handler.getObject(i).getPoint().x;
                int y = handler.getObject(i).getPoint().y;
                DrawHealth(x, y, g, UnitHealth[i], Maxhealth[i]);
                }
            }
        }

    public void DrawHealth(int x, int y, Graphics g, int health, int Maxhealth)
        {
        g.setColor(Color.gray);
        g.fillRect(x, y + 10, Maxhealth * 2, 15);
        g.setColor(Color.green);
        g.fillRect(x, y + 10, health * 2, 15);
        g.setColor(Color.red);
        g.drawRect(x, y + 10, Maxhealth * 2, 15);
        }
}
