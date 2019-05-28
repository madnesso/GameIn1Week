import java.awt.*;
import java.util.ArrayList;

public class Handler
    {
    ArrayList<GameObject> objects = new ArrayList<>();

    public void tick()
        {
        for (int i = 0; i < objects.size(); i++)
            {
            GameObject tempObject = objects.get(i);
            tempObject.tick();
            }
        }

    public void paint(Graphics g)
        {
        for (int i = 0; i < objects.size(); i++)
            {
            GameObject tempObject = objects.get(i);
            tempObject.paint(g);
            }
        }

    public void addObject(GameObject object)
        {
        objects.add(object);
        }

    public void removeObject(GameObject object)
        {
        objects.remove(object);
        }
    }
