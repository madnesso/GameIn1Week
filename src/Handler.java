import java.awt.*;
import java.util.ArrayList;

public class Handler
    {
    private ArrayList<GameObject> objects = new ArrayList<>();

    public void tick()
        {
        for (GameObject tempObject : objects)
            {
            tempObject.tick();
            }
        }

    public void paint(Graphics g)
        {
        for (GameObject tempObject : objects)
            {
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
