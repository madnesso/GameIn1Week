import java.awt.*;

public class Units extends GameObject
    {
    private int Health;
    private int AttackDmg;
    private int Range;
    private boolean AttackCd;
    private Handler handler;

    public Units(ID id, Point point, Dimension dimension)
        {
        super(id, point, dimension);
        }


    public int getHealth()
        {
        return Health;
        }

    public void setHealth(int health)
        {
        Health = health;
        }

    public int getAttackDmg()
        {
        return AttackDmg;
        }

    public void setAttackDmg(int attackDmg)
        {
        AttackDmg = attackDmg;
        }

    public int getRange()
        {
        return Range;
        }

    public void setRange(int range)
        {
        Range = range;
        }

    public boolean isAttackcd()
        {
        return AttackCd;
        }

    public void setAttackcd(boolean attackCd)
        {
        AttackCd = attackCd;
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
