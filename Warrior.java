
package stickmantowerdefence;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;


public class Warrior extends Units implements IClamp{
    
    private static float healthFactor;
    private static float damageFactor;

    public Warrior(Point point, Dimension dimention, ID id) {
        super(point, dimention, id);
        this.setMaxHealth(100);
        this.setAttackDmg(10);
        this.setHealth(this.getMaxHealth()+healthFactor);
    }

    @Override
    public void setHealth(float health){
        if(health >= this.getMaxHealth()+healthFactor)
            this.setHealth(this.getMaxHealth()+healthFactor);
        else if(health <= 0)
            this.setHealth(0);
        else 
            this.setHealth(health);
    }
    
    @Override
    public void setAttackDmg(float damage){
        if(damage >= this.getAttackDmg()+damageFactor)
            this.setHealth(this.getAttackDmg()+damageFactor);
        else if(damage <= 0)
            this.setHealth(0);
        else 
            this.setHealth(damage);
    }
    
    public static float getHealthFactor() {
        return healthFactor;
    }

    public static void setHealthFactor(float healthFactor) {
        if(healthFactor >= 4)
            Warrior.healthFactor = 4;
        else if(healthFactor <= 1)
            Warrior.healthFactor = 1;
        else 
            Warrior.healthFactor = healthFactor;
    }

    public static float getDamageFactor() {
        return damageFactor;
    }

    public static void setDamageFactor(float damageFactor) {
        if(damageFactor >= 4)
            Warrior.damageFactor = 4;
        else if(damageFactor <= 1)
            Warrior.damageFactor = 1;
        else 
            Warrior.damageFactor = damageFactor;
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
            im = pl.loadiamge("/pic/worrior.png");
            g.drawImage(im, getPoint().x, getPoint().y, getDimension().width, getDimension().height, null);
            } catch (Exception e)
            {

            g.setColor(Color.cyan);
            g.fillRect(getPoint().x, getPoint().y, getDimension().width, getDimension().height);

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
