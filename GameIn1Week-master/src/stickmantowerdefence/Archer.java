package stickmantowerdefence;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Archer extends Units implements IClamp
    {

    private static float healthFactor;
    private static float damageFactor;
    private static float rangeFactor;
    private float range;

    public Archer(Point point, Dimension dimention, ID id)
        {
        super(point, dimention, id);
        setRange(200);
        setMaxHealth(100);
        setAttackDmg(10);
        setHealth(getMaxHealth() + healthFactor);
        }

    public static float getHealthFactor()
        {
        return healthFactor;
        }

    public static void setHealthFactor(float healthFactor)
        {
        if (healthFactor >= 4) { Archer.healthFactor = 4; }
        else if (healthFactor <= 1) { Archer.healthFactor = 1; }
        else { Archer.healthFactor = healthFactor; }
        }

    public static float getDamageFactor()
        {
        return damageFactor;
        }

    public static void setDamageFactor(float damageFactor)
        {
        if (damageFactor >= 4) { Archer.damageFactor = 4; }
        else if (damageFactor <= 1) { Archer.damageFactor = 1; }
        else { Archer.damageFactor = damageFactor; }
        }

    public static float getRangeFactor()
        {
        return rangeFactor;
        }

    public static void setRangeFactor(float rangeFactor)
        {
        if (rangeFactor >= 4) { Archer.rangeFactor = 4; }
        else if (rangeFactor <= 1) { Archer.rangeFactor = 1; }
        else { Archer.rangeFactor = rangeFactor; }
        }

    @Override
    public void setHealth(float health)
        {
        if (health >= getMaxHealth() + healthFactor) { setHealth(getMaxHealth() + healthFactor); }
        else if (health <= 0) { setHealth(0); }
        else { setHealth(health); }
        }

    @Override
    public void setAttackDmg(float damage)
        {
        if (damage >= getAttackDmg() + damageFactor) { setHealth(getAttackDmg() + damageFactor); }
        else if (damage <= 0) { setHealth(0); }
        else { setHealth(damage); }
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


        PictureLoader pl = new PictureLoader();
        BufferedImage im;
        try
            {
            im = pl.loadiamge("/pic/archer.png");
            g.drawImage(im, getPoint().x, getPoint().y, getDimension().width, getDimension().height, null);
            } catch (Exception e)
            {

            g.setColor(Color.cyan);
            g.fillRect(getPoint().x, getPoint().y, getDimension().width, getDimension().height);

            }


        }

    public float getRange()
        {
        return range;
        }

    public void setRange(float range)
        {
        this.range = clamp(range, 0, 500);
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

    @Override
    public float clamp(float var, float min, float max)
        {
        if (var >= max) { return var = max; }
        else if (var <= min) { return var = min; }
        else { return var; }
        }

    }
