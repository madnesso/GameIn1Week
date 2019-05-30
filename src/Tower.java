import java.awt.*;

public class Tower extends GameObject
    {

    private int hight;
    private int width;
//    private int Health = 1000;
    private Handler handler;

    public Tower(ID id, Point point, Dimension dimension)
        {
        super(id, point, dimension);
        }


    @Override
    public void tick()
        {

        if (Health <= 0)
            {
            handler.removeObject(this);

            }
        }

    @Override
    public void paint(Graphics g)
        {

        }

    public int getCastleHealth()
        {
        return Health;
        }

    public void setCastleHealth(int castleHealth)
        {
        if (Health <= 1000)
            {
            Health = castleHealth;
            }
        else { Health = 1000; }
        }

    /*    public Rectangle getbounds(){
            return new Rectangle(point.x,point.y,dimension.width,dimension.height);
        }
    */
    }
