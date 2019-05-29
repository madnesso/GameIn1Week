import java.awt.*;

//so far mafish fe dma8y 8er wa7d like a zombie horde cloae range walk slowly law lamess 7ad by3ml dmg ay 7ad tany 3ando afkar ?
public class Enmey extends GameObject
    {
    private int health;
    private int attackdmg;
    private Handler handler;

    public Enmey(float x, float y, ID id, Handler handler)
        {
        super(x, y, id);
        this.handler = handler;
        }

    public int getHealth()
        {
        return health;
        }

    public void setHealth(int health)
        {
        this.health = health;
        }

    public int getAttackdmg()
        {
        return attackdmg;
        }

    public void setAttackdmg(int attackdmg)
        {
        this.attackdmg = attackdmg;
        }

    @Override
    public void tick()
        {

        }

    @Override
    public void paint(Graphics g)
        {

        }
    }
