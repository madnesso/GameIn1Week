
package stickmantowerdefence;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.JLabel;


public class Enemy extends GameObject implements IClamp{
    
    private float health;
    private float attackdmg;


    public Enemy(Point point, Dimension dimension, ID id, int x, int y) {
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
        PictureLoader pl = new PictureLoader();
        BufferedImage im;
        
        try
            {
            im = pl.loadiamge("/pic/enemy.png");
            g.drawImage(im, getPoint().x, getPoint().y, getDimension().width, getDimension().height, null);
            } catch (Exception e)
            {
            g.setColor(Color.cyan);
            g.fillRect(getPoint().x, getPoint().y, getDimension().width, getDimension().height);
            }
this.getPoint().translate(this.getVelX(), this.getVelY());
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
