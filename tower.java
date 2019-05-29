import java.awt.*;

public class tower extends GameObject{

    private int hight;
    private int width;
    private int health=1000;


    private Handler h;
    public tower(float x, float y, ID id, Handler handler)
    {
        super(x, y, id);
        this.h=handler;
    }

    @Override
    public void tick() {

    }

    @Override
    public void paint(Graphics g) {

    }

    public int getCastleHealth() {
        return health;
    }

    public void setCastleHealth(int castleHealth) {
        this.health= castleHealth;
    }


}
