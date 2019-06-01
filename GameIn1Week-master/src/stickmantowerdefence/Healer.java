package stickmantowerdefence;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Healer extends Units implements IClamp
    {

    private static float healFactor;
    private static float manaFactor;
    private static float healthFactor;
    private static float rangeFactor;
    private static float manaRegenFactor;
    private float mana;
    private float heal;
    private float range;
    private float maxMana;
    private float manaRegen;

    public Healer(Point point, Dimension dimention, ID id, int x, int y)
        {
        super(point, dimention, id);
        setVelX(x);
        setVelY(y);
        setHealth(getMaxHealth() + healthFactor);
        }

    public static float getManaRegenFactor()
        {
        return manaRegenFactor;
        }

    public static void setManaRegenFactor(float manaRegenFactor)
        {
        if (manaRegenFactor >= 4) { Healer.manaRegenFactor = 4; }
        else if (manaRegenFactor <= 1) { Healer.manaRegenFactor = 1; }
        else { Healer.manaRegenFactor = manaRegenFactor; }
        }

    public static float getManaFactor()
        {
        return manaFactor;
        }

    public static void setManaFactor(float manaFactor)
        {
        if (manaFactor >= 4) { Healer.manaFactor = 4; }
        else if (manaFactor <= 1) { Healer.manaFactor = 1; }
        else { Healer.manaFactor = manaFactor; }
        }

    public static float getHealFactor()
        {
        return healFactor;
        }

    public static void setHealFactor(float healFactor)
        {
        if (healFactor >= 4) { Healer.healFactor = 4; }
        else if (healFactor <= 1) { Healer.healFactor = 1; }
        else { Healer.healFactor = healFactor; }
        }

    public static float getHealthFactor()
        {
        return healthFactor;
        }

    public static void setHealthFactor(float healthFactor)
        {
        if (healthFactor >= 4) { Healer.healthFactor = 4; }
        else if (healthFactor <= 1) { Healer.healthFactor = 1; }
        else { Healer.healthFactor = healthFactor; }
        }

    public static float getRangeFactor()
        {
        return rangeFactor;
        }

    public static void setRangeFactor(float rangeFactor)
        {
        if (rangeFactor >= 4) { Healer.rangeFactor = 4; }
        else if (rangeFactor <= 1) { Healer.rangeFactor = 1; }
        else { Healer.rangeFactor = rangeFactor; }
        }

    @Override
    public void setHealth(float health)
        {
        if (health >= getMaxHealth() + healthFactor) { setHealth(getMaxHealth() + healthFactor); }
        else if (health <= 0) { setHealth(0); }
        else { setHealth(health); }
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
            im = pl.loadiamge("/pic/healer.png");

            g.drawImage(im, getPoint().x, getPoint().y, getDimension().width, getDimension().height, null);
            } catch (Exception e)
            {

            g.setColor(Color.cyan);
            g.fillRect(getPoint().x, getPoint().y, getDimension().width, getDimension().height);

            }


        }

    public float getManaRegen()
        {
        return manaRegen;
        }

    public void setManaRegen(float manaRegen)
        {
        this.manaRegen = clamp(manaRegen, 0, manaRegenFactor + this.manaRegen);
        }

    @Override
    public float clamp(float var, float min, float max)
        {
        if (var >= max) { return var = max; }
        else if (var <= min) { return var = min; }
        else { return var; }
        }

    public float getHeal()
        {
        return heal;
        }

    public void setHeal(float heal)
        {
        this.heal = clamp(heal, 0, this.heal + healFactor);
        }

    public float getRange()
        {
        return range;
        }

    public void setRange(float range)
        {
        this.range = clamp(range, 0, range + rangeFactor);
        }

    public float getMaxMana()
        {
        return maxMana;
        }

    public void setMaxMana(float maxMana)
        {
        this.maxMana = maxMana;
        }

    public float Heal(float allyRange)
        {
        if (range > allyRange)
            {
            if (mana > 0)
                {
                setMana(getMana() - 10);
                return heal;
                }
            return 0;
            }
        else
            {
            return 0;
            }
        }

    public float getMana()
        {
        return mana;
        }

    public void setMana(float mana)
        {
        this.mana = clamp(mana, 0, maxMana + manaFactor);
        }
    }
