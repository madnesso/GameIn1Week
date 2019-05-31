
package stickmantowerdefence;

import java.awt.*;


public class Mage extends stickmantowerdefence.Units implements stickmantowerdefence.IClamp {
    
    private float mana;
    private boolean hasMana; 
    private float range;
    private float manaRegen;
    
    public Mage(Point point, Dimension dimension, stickmantowerdefence.ID id, int x, int y) {
        super(point, dimension, id);
        this.setVelX(x);
        this.setVelY(y);
    }

    public float getRange() {
        return range;
    }

    public void setRange(float range) {
        this.range = clamp(range,0,100);
    }

    public float getManaRegen() {
        return manaRegen;
    }

    public void setManaRegen(float manaRegen) {
        this.manaRegen = clamp(manaRegen,0,10);
    }

    public float getMana() {
        return mana;
    }

    public void setMana(float mana) {
        this.mana = clamp(mana,0,100);
    }

    public boolean isHasMana() {
        return hasMana;
    }

    public void setHasMana(boolean hasMana) {
        this.hasMana = hasMana;
    }

    @Override
    public void tick() {
        this.getPoint().translate(this.getVelX(), this.getVelY());
        this.mana += manaRegen;
    }

    @Override
    public void paint(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public float mageDamage(float rangeDiff){
        if(this.range > rangeDiff)
        {
            if(this.mana>0)
            {
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
