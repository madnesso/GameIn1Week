
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;


public abstract class Units extends GameObject {
    
    private float Health;
    private float AttackDmg;
    private boolean AttackCd;

    public Units(Point point, Dimension dimension, ID id) {
        super(point, dimension, id);
    }

    public float getHealth() {
        return Health;
    }

    public void setHealth(float Health) {
        if(Health >= 500)
            this.Health = 500;
        else if(Health <= 0)
            this.Health = 0;
        else 
            this.Health = Health;
    }

    public float getAttackDmg() {
        return AttackDmg;
    }

    public void setAttackDmg(float AttackDmg) {
        if(AttackDmg >= 500)
            this.AttackDmg = 500;
        else if(AttackDmg <= 0)
            this.AttackDmg = 0;
        else 
            this.Health = AttackDmg;
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
