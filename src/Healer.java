import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;


public class Healer extends Units implements IClamp{
    
    private float heal;
    private float mana;
    private boolean hasMana;
    private float range;
    
    public Healer(Point point, Dimension dimention, ID id, int x, int y) {
        super(point, dimention, id);
        this.setVelX(x);
        this.setVelY(y);
    }

    public float getHeal() {
        return heal;
    }

    public void setHeal(float heal) {
        this.heal = clamp(heal,0,100);
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
    
    public float Heal(float allyRange){
        if(this.range > allyRange)
        {
            if(this.mana>0)
            {
            return this.heal;
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
