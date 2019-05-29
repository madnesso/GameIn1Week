import java.awt.*;

public class Tower extends GameObject
    {

    private int hight;
    private int width;
    private int health = 1000;


    private Handler h;

    public Tower(float x, float y, ID id, Handler handler)
        {
        super(x, y, id);
        h = handler;
        h.addObject(this);
        }

    @Override
    public void tick()
        {

        if (health <= 0)
            {
            h.removeObject(this);

            }
        }

    @Override
    public void paint(Graphics g)
        {

        }

    public int getCastleHealth()
        {
        return health;
        }

    public void setCastleHealth(int castleHealth)
        {
        health = castleHealth;
        }


    }
