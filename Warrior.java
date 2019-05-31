
package stickmantowerdefence;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;


public class Warrior extends Units implements IClamp{

    public Warrior(Point point, Dimension dimention, ID id, int x, int y) {
        super(point, dimention, id);
        this.setVelX(x);
        this.setVelY(y);
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
