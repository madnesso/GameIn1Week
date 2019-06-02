
package stickmantowerdefence;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;


public class Mage extends Units implements IClamp{
    
    private float mana;
    private float range;
    private float manaRegen;
    private float maxMana;
    private static float manaFactor;
    private static float manaRegenFactor;
    private static float healthFactor;
    private static float rangeFactor;
    private static float damageFactor;
    
    public Mage(Point point, Dimension dimension, ID id, int x, int y) {
        super(point, dimension, id);
        this.setVelX(x);
        this.setVelY(y);
    }

    public static float getDamageFactor() {
        return damageFactor;
    }

    public static void setDamageFactor(float damageFactor) {
        if(damageFactor >= 4)
            Mage.damageFactor = 4;
        else if(damageFactor <= 1)
            Mage.damageFactor = 1;
        else 
            Mage.damageFactor = damageFactor;
    }

    public float getRange() {
        return range;
    }

    public void setRange(float range) {
        this.range = clamp(range,0,this.range+rangeFactor);
    }

    public float getManaRegen() {
        return manaRegen;
    }

    public void setManaRegen(float manaRegen) {
        this.manaRegen = clamp(manaRegen,0,this.manaRegen+manaRegenFactor);
    }

    public float getMana() {
        return mana;
    }

    public void setMana(float mana) {
        this.mana = clamp(mana,0,maxMana+manaFactor);
    }

    public float getMaxMana() {
        return maxMana;
    }

    public void setMaxMana(float maxMana) {
        this.maxMana = maxMana;
    }

    public static float getManaFactor() {
        return manaFactor;
    }

    public static void setManaFactor(float manaFactor) {
        if(manaFactor >= 4)
            Mage.manaFactor = 4;
        else if(manaFactor <= 1)
            Mage.manaFactor = 1;
        else 
            Mage.manaFactor = manaFactor;
    }

    public static float getManaRegenFactor() {
        return manaRegenFactor;
    }

    public static void setManaRegenFactor(float manaRegenFactor) {
        if(manaRegenFactor >= 4)
            Mage.manaRegenFactor = 4;
        else if(manaRegenFactor <= 1)
            Mage.manaRegenFactor = 1;
        else 
            Mage.manaRegenFactor = manaRegenFactor;
    }

    public static float getHealthFactor() {
        return healthFactor;
    }

    public static float getRangeFactor() {
        return rangeFactor;
    }

    public static void setRangeFactor(float rangeFactor) {
        if(rangeFactor >= 4)
            Mage.rangeFactor = 4;
        else if(rangeFactor <= 1)
            Mage.rangeFactor = 1;
        else 
            Mage.rangeFactor = rangeFactor;
    }

    public static void setHealthFactor(float healthFactor) {
        if(healthFactor >= 4)
            Mage.healthFactor = 4;
        else if(healthFactor <= 1)
            Mage.healthFactor = 1;
        else 
            Mage.healthFactor = healthFactor;
    }
    
    @Override
    public void tick() {
        this.getPoint().translate(this.getVelX(), this.getVelY());
        this.mana += manaRegen;
    }

    @Override
    public void paint(Graphics g) {
        PictureLoader pl = new PictureLoader();
        BufferedImage im;
        try
            {
            im = pl.loadiamge("/pic/mage.png");
            g.drawImage(im, getPoint().x, getPoint().y, getDimension().width, getDimension().height, null);
            } catch (Exception e)
            {

            g.setColor(Color.cyan);
            g.fillRect(getPoint().x, getPoint().y, getDimension().width, getDimension().height);

            }

    }
    
    public float mageDamage(float rangeDiff){
        if(this.range > rangeDiff)
        {
            if(this.mana>0)
            {
                this.setMana(this.getMana()-10);
                return this.getAttackDmg();
            }
            return 0;
        }
        else 
        {
            return 0;
        }
    }

    @Override
    public float clamp(float var, float min, float max) {
        if(var >= max)
            return var = max;
        else if(var <= min)
            return var = min;
        else 
            return var;
    }
}
