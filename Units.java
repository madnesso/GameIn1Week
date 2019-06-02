
package stickmantowerdefence;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;


public abstract class Units extends GameObject {
    
    protected float Health;
    protected float maxHealth;
    protected float AttackDmg;

    public Units(Point point, Dimension dimension, ID id) {
        super(point, dimension, id);
    }

    public float getHealth() {
        return Health;
    }

    public void setHealth(float Health) {
        this.Health = Health;        
    }

    public float getAttackDmg() {
        return AttackDmg;
    }

    public void setAttackDmg(float AttackDmg) {
        this.AttackDmg = AttackDmg;
    }

    public float getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(float maxHealth) {
        this.maxHealth = maxHealth;
    }

    @Override
    public void tick() {
        this.getPoint().translate(this.getVelX(), this.getVelY());
    }

    @Override
    public abstract void paint(Graphics g);
    
}
