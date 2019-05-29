import java.awt.*;

public class Healer extends Units
    {
    private int mana;
    private boolean hasmana = false;

    public Healer(ID id, Point point, Dimension dimension)
        {
        super(id, point, dimension);
        }


    public int getMana()
        {
        return mana;
        }

    public void setMana(int mana)
        {
        this.mana = mana;
        }

    public boolean isHasmana()
        {
        return hasmana;
        }

    public void setHasmana(boolean hasmana)
        {
        this.hasmana = hasmana;
        }
    }
