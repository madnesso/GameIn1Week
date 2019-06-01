package stickmantowerdefence;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Tower extends GameObject
    {

    private float health = 1000;
    private float Maxhealth;

    public Tower(Point point, Dimension dimention, stickmantowerdefence.ID id)
        {
        super(point, dimention, id);
        }

    public float getHealth()
        {
        return health;
        }

    public void setHealth(float health)
        {
        if (health >= 1000) { this.health = 1000; }
        else if (health <= 0) { this.health = 0; }
        else { this.health = health; }
        }

    public float getMaxhealth()
        {
        return Maxhealth;
        }

    public void setMaxhealth(float maxhealth)
        {
        if (maxhealth >= 3000) { Maxhealth = 3000; }
        else if (maxhealth <= 0) { Maxhealth = 0; }
        else { Maxhealth = maxhealth; }
        }

    @Override
    public void tick()
        {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    @Override
    public void paint(Graphics g)
        {
        //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        try
            {
            BufferedImage towrz = ImageIO.read(new File("/pic/dirty.png"));
            g.drawImage(towrz, getPoint().x, getPoint().y, 350, 600, null);

            } catch (IOException e)
            {
            g.setColor(Color.cyan);
            g.drawRect(getPoint().x, getPoint().y, getDimension().width, getDimension().height);

            }


        }

    }
