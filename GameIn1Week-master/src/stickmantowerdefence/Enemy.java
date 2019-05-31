
package stickmantowerdefence;

import java.awt.*;


public class Enemy extends stickmantowerdefence.GameObject implements stickmantowerdefence.IClamp {
    
    private float health;
    private float attackdmg;

    public Enemy(Point point, Dimension dimension, stickmantowerdefence.ID id, int x, int y) {
        super(point, dimension, id);
        this.setVelX(x);
        this.setVelY(y);
    }

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = clamp(health,0,100);
    }

    public float getAttackdmg() {
        return attackdmg;
    }

    public void setAttackdmg(float attackdmg) {
        this.attackdmg = clamp(attackdmg,0,100);
    }

    @Override
    public void tick() {
        this.getPoint().translate(this.getVelX(), this.getVelY());
    }

    @Override
    public void paint(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
