
package stickmantowerdefence;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;


public abstract class GameObject {
    
    private Point point;
    private Dimension dimension;
    private ID id;
    private int velX;
    private int velY;

    public GameObject(Point point, Dimension dimension, ID id) {
        this.point = point;
        this.dimension = dimension;
        this.id = id;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public int getVelX() {
        return velX;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public int getVelY() {
        return velY;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }
    
    public Rectangle getbounds(){
            return new Rectangle(point.x, point.y, dimension.width, dimension.height);
        }

    public abstract void tick();
    
    public abstract void paint(Graphics g);
    
    
}
