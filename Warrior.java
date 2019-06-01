
package stickmantowerdefence;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


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
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        try
        {
            BufferedImage worr= ImageIO.read(new File("/pic/Worrior.gif"));
            g.drawImage(worr, (int) getPoint().x, getPoint().y,getDimension().width, getDimension().height, null);

        }
        catch (IOException e)
        {
            g.setColor(Color.cyan);
            g.drawRect((int) getPoint().x, getPoint().y , getDimension().width, getDimension().height);

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
