package stickmantowerdefence;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Mage extends stickmantowerdefence.Units implements stickmantowerdefence.IClamp
    {

    private float mana;
    private boolean hasMana;
    private float range;
    private float manaRegen;

    public Mage(Point point, Dimension dimension, stickmantowerdefence.ID id, int x, int y)
        {
        super(point, dimension, id);
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

    public float getManaRegen()
        {
        return manaRegen;
        }

    public void setManaRegen(float manaRegen)
        {
        this.manaRegen = clamp(manaRegen, 0, 10);
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

    @Override
    public void tick()
        {
        getPoint().translate(getVelX(), getVelY());
        mana += manaRegen;
        }

    @Override
    public void paint(Graphics g)
        {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        try
            {
            BufferedImage magg = ImageIO.read(new File("/pic/mage_temp.webp"));
            g.drawImage(magg, getPoint().x, getPoint().y, getDimension().width, getDimension().height, null);

            } catch (IOException e)
            {
            g.setColor(Color.cyan);
            g.drawRect(getPoint().x, getPoint().y, getDimension().width, getDimension().height);

            }


        }

    public float mageDamage(float rangeDiff)
        {
        if (range > rangeDiff)
            {
            if (mana > 0)
                {
                return getAttackDmg();
                }
            return 0;
            }
        else
            {
            return 0;
            }
        }
    }
