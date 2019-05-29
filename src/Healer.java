public class Healer extends Units
    {
    private int mana;
    private boolean hasmana = false;

    public Healer(float x, float y, ID id, Handler handler)
        {
        super(x, y, id, handler);
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
