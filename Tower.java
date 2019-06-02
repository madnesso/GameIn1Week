
package stickmantowerdefence;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

public class Tower extends GameObject{
    
    private float health;
    private float maxHealth;

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        if(health >= 1000)
            this.health = 1000;
        else if(health <= 0)
            this.health = 0;
        else 
            this.health = health;
    }
    
    public Tower(Point point, Dimension dimention, ID id) {
        super(point, dimention, id);
    }

    public float getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(float maxHealth) {
        this.maxHealth = maxHealth;
    }

    @Override
    public void tick() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void paint(Graphics g) {
         PictureLoader pl = new PictureLoader();
        BufferedImage im;
        try
            {
            im = pl.loadiamge("/pic/dirty.png");
            g.drawImage(im, getPoint().x, getPoint().y, getDimension().width, getDimension().height, null);
            } catch (Exception e)
            {

            g.setColor(Color.cyan);
            g.fillRect(getPoint().x, getPoint().y, getDimension().width, getDimension().height);

            }


        }
    
}
