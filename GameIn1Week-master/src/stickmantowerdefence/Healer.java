package stickmantowerdefence;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Healer extends stickmantowerdefence.Units implements stickmantowerdefence.IClamp
    {

    private float heal;
    private float mana;
    private boolean hasMana;
    private float range;

    public Healer(Point point, Dimension dimention, stickmantowerdefence.ID id, int x, int y)
        {
        super(point, dimention, id);
        setVelX(x);
        setVelY(y);
        }

    public float getHeal()
        {
        return heal;
        }

    public void setHeal(float heal)
        {
        this.heal = clamp(heal, 0, 100);
        }

    @Override
    public float clamp(float var, float min, float max)
        {
        if (var >= max) { return var = max; }
        else if (var <= min) { return var = min; }
        else { return var; }
        }

    public float getMana()
        {
        return mana;
        }

    public void setMana(float mana)
        {
        this.mana = clamp(mana, 0, 100);
        }

    public boolean isHasMana()
        {
        return hasMana;
        }

    public void setHasMana(boolean hasMana)
        {
        this.hasMana = hasMana;
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
    public void tick()
        {
        getPoint().translate(getVelX(), getVelY());
        }

    @Override
    public void paint(Graphics g)
        {
        //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       /* g.drawImage(healerr, (int) getPoint().x, getPoint().y, 128, 128, null);
        g.setColor(Color.cyan);
        g.drawRect((int) getPoint().x, getPoint().y , getDimension().width, getDimension().height);
*/


        try
            {
            BufferedImage healerr = ImageIO.read(new File("/pic/Healer.png"));
            g.drawImage(healerr, getPoint().x, getPoint().y, 128, 128, null);

            } catch (IOException e)
            {
            g.setColor(Color.cyan);
            g.drawRect(getPoint().x, getPoint().y, getDimension().width, getDimension().height);

            }

        }

    public float Heal(float allyRange)
        {
        if (range > allyRange)
            {
            if (mana > 0)
                {
                return heal;
                }
            return 0;
            }
        else
            {
            return 0;
            }
        }
    }
