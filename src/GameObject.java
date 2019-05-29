import java.awt.*;

public abstract class GameObject
    {
    protected Point point;
    protected Dimension dimension;
    private ID id;

    public GameObject(ID id, Point point, Dimension dimension)
        {
        this.id = id;
        this.point = point;
        this.dimension = dimension;
        }

    public ID getId()
        {
        return id;
        }

    public void setId(ID id)
        {
        this.id = id;
        }

    public Point getPoint()
        {
        return point;
        }

    public void setPoint(Point point)
        {
        this.point = point;
        }

    public Dimension getDimension()
        {
        return dimension;
        }

    public void setDimension(Dimension dimension)
        {
        this.dimension = dimension;
        }

    public abstract void tick();

    public abstract void paint(Graphics g);

    //public abstract Rectangle getBounds();
    }
