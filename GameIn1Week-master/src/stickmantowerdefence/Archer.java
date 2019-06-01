
package stickmantowerdefence;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;


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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
