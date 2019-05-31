
package stickmantowerdefence;

import java.awt.*;


public class Archer extends stickmantowerdefence.Units implements stickmantowerdefence.IClamp {
    
    private float range;

    public Archer(Point point, Dimension dimention, stickmantowerdefence.ID id, int x, int y) {
        super(point, dimention, id);
        this.setVelX(x);
        this.setVelY(y);
    }

    public float getRange() {
        return range;
    }

    public void setRange(float range) {
        this.range = clamp(range,0,100);
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
