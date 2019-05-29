import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter
    {
    @Override
    public void mousePressed(MouseEvent e)
        {
        int px = e.getX();
        int py = e.getY();

        }

    private boolean hover(int px, int py, int x, int y, int width, int height)
        {

        if (px > x && px < x + width)
            {
            //this will return true or false nice logic
            return py > y && py < y + height;
            }
        else { return false; }
        }

    }
