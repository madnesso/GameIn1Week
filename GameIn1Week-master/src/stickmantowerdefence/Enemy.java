package stickmantowerdefence;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Enemy extends stickmantowerdefence.GameObject implements stickmantowerdefence.IClamp
    {

    private float health;
    private float attackdmg;

    public Enemy(Point point, Dimension dimension, stickmantowerdefence.ID id, int x, int y)
        {
        super(point, dimension, id);
        setVelX(x);
        setVelY(y);
        }

    public float getHealth()
        {
        return health;
        }

    public void setHealth(float health)
        {
        this.health = clamp(health, 0, 100);
        }

    @Override
    public float clamp(float var, float min, float max)
        {
        if (var >= max) { return var = max; }
        else if (var <= min) { return var = min; }
        else { return var; }
        }

    public float getAttackdmg()
        {
        return attackdmg;
        }

    public void setAttackdmg(float attackdmg)
        {
        this.attackdmg = clamp(attackdmg, 0, 100);
        }

    @Override
    public void tick()
        {
        getPoint().translate(getVelX(), getVelY());
        }

    @Override
    public void paint(Graphics g)
        {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        try
            {
            BufferedImage worr = ImageIO.read(new File("/pic/enemy.png"));
            g.drawImage(worr, getPoint().x, getPoint().y, getDimension().width, getDimension().height, null);

            } catch (IOException e)
            {
            g.setColor(Color.cyan);
            g.drawRect(getPoint().x, getPoint().y, getDimension().width, getDimension().height);

            }


        }


    }
