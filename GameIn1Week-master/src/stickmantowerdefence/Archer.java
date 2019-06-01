package stickmantowerdefence;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Archer extends stickmantowerdefence.Units implements stickmantowerdefence.IClamp
    {

    private float range;

    public Archer(Point point, Dimension dimention, stickmantowerdefence.ID id, int x, int y)
        {
        super(point, dimention, id);
        setVelX(x);
        setVelY(y);
        }

    public float getRange()
        {
        return range;
        }

    public void setRange(float range)
        {
        this.range = clamp(range, 0, 100);
        }

    @Override
    public float clamp(float var, float min, float max)
        {
        if (var >= max) { return var = max; }
        else if (var <= min) { return var = min; }
        else { return var; }
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
            BufferedImage worr = ImageIO.read(new File("/pic/archer.png"));
            g.drawImage(worr, getPoint().x, getPoint().y, getDimension().width, getDimension().height, null);

            } catch (IOException e)
            {
            g.setColor(Color.cyan);
            g.drawRect(getPoint().x, getPoint().y, getDimension().width, getDimension().height);

            }


        }

    public float archerDamage(float rangeDiff)
        {
        if (range > rangeDiff)
            {
            return getAttackDmg();
            }
        else
            {
            return 0;
            }
        }

    }
