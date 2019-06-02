
package stickmantowerdefence;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;


public class Archer extends Units implements IClamp{
    
    private float range;
    private static float healthFactor;
    private static float damageFactor;
    private static float rangeFactor;

    public Archer(Point point, Dimension dimention, ID id) {
        super(point, dimention, id);
        this.setRange(200);
        this.setMaxHealth(100);
        this.setAttackDmg(10);
        this.setHealth(this.getMaxHealth()+healthFactor);
    }

    @Override
    public void setHealth(float health){
        if(health >= this.getMaxHealth()+healthFactor)
            this.Health=this.getMaxHealth()+healthFactor;
        else if(health <= 0)
            this.Health=0;
        else 
            this.Health=health;
    }
    
    @Override
    public void setAttackDmg(float damage){
        if(damage >= this.getAttackDmg()+damageFactor)
            this.AttackDmg=this.getAttackDmg()+damageFactor;
        else if(damage <= 0)
            this.AttackDmg=0;
        else 
            this.AttackDmg=damage;
    }
    
    public float getRange() {
        return range;
    }

    public void setRange(float range) {
        this.range = clamp(range,0,500);
    }

    public static float getHealthFactor() {
        return healthFactor;
    }

    public static float getDamageFactor() {
        return damageFactor;
    }

    public static void setDamageFactor(float damageFactor) {
        if(damageFactor >= 4)
            Archer.damageFactor = 4;
        else if(damageFactor <= 1)
            Archer.damageFactor = 1;
        else 
            Archer.damageFactor = damageFactor;
    }

    public static float getRangeFactor() {
        return rangeFactor;
    }

    public static void setRangeFactor(float rangeFactor) {
        if(rangeFactor >= 4)
            Archer.rangeFactor = 4;
        else if(rangeFactor <= 1)
            Archer.rangeFactor = 1;
        else 
            Archer.rangeFactor = rangeFactor;
    }

    public static void setHealthFactor(float healthFactor) {
        if(healthFactor >= 4)
            Archer.healthFactor = 4;
        else if(healthFactor <= 1)
            Archer.healthFactor = 1;
        else 
            Archer.healthFactor = healthFactor;
    }
    
    @Override
    public void tick() {
        this.getPoint().translate(this.getVelX(), this.getVelY());
    }

    @Override
    public void paint(Graphics g) {
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
    
    public float archerDamage(float rangeDiff)
    {
        if(this.range > rangeDiff)
        {
            return this.getAttackDmg();
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
