
package stickmantowerdefence;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;


public abstract class Units extends GameObject {

    private float Maxhealth;
    private float Health;
    private float AttackDmg;
    protected float attackinc=0;
    private boolean AttackCd;

    public Units(Point point, Dimension dimension, ID id) {
        super(point, dimension, id);
    }

    public float getHealth() {
        return Health;
    }

    public void setHealth(float Health) {
        if(Health >= Maxhealth)
            this.Health = Maxhealth;
        else if(Health <= 0)
            this.Health = 0;
        else 
            this.Health = Health;
    }


    public float getMaxhealth() {
        return Maxhealth;
    }

    public void setMaxhealth(float maxhealth) {
        if(maxhealth >= 1500)
            this.Maxhealth = 1500;
        else if(maxhealth<= 500)
            this.Maxhealth = 500;
        else
            this.Maxhealth = maxhealth;
    }



    public float getAttackDmg() {
        return AttackDmg;
    }

    public void setAttackDmg(float AttackDmg) {
        if(AttackDmg+attackinc >= 500)
            this.AttackDmg = 500;
        else if(AttackDmg <= 0)
            this.AttackDmg = 0;
        else
            this.AttackDmg= AttackDmg+attackinc;
    }

    public boolean isAttackCd() {
        return AttackCd;
    }

    public void setAttackCd(boolean AttackCd) {
        this.AttackCd = AttackCd;
    }

    @Override
    public void tick() {
        this.getPoint().translate(this.getVelX(), this.getVelY());
    }

    @Override
    public abstract void paint(Graphics g);
    
}
