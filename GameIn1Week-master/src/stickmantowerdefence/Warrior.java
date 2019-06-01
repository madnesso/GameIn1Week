package stickmantowerdefence;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Warrior extends Units implements IClamp
    {

    public Warrior(Point point, Dimension dimention, ID id, int x, int y)
        {
        super(point, dimention, id);
        setVelX(x);
        setVelY(y);
        }

    @Override
    public void tick()
        {
        getPoint().translate(getVelX(), getVelY());
        }

    @Override
    public void paint(Graphics g)
        {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        try
            {
            BufferedImage worr = ImageIO.read(new File("/pic/worrior.gif"));
            g.drawImage(worr, getPoint().x, getPoint().y, getDimension().width, getDimension().height, null);

            } catch (IOException e)
            {
            g.setColor(Color.cyan);
            g.drawRect(getPoint().x, getPoint().y, getDimension().width, getDimension().height);

            }


        }

    @Override
    public float clamp(float var, float min, float max)
        {
        if (var >= max) { return var = max; }
        else if (var <= min) { return var = min; }
        else { return var; }
        }

    }
