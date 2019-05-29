import java.awt.*;

public class Tower extends GameObject
    {

    private int hight;
    private int width;
    private int Health = 1000;
    private Handler handler;

    public Tower(float x, float y, ID id, Handler handler)
        {
        super(x, y, id);
        this.handler = handler;
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
        }


    }
