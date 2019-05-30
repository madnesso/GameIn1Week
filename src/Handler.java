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

    public void collision()
        {
        for (GameObject tempObject : objects)
            {
            if (tempObject.getId().equals("enemy"))
                {
                for (GameObject tempObject2 : objects)
                    {

                    if (tempObject2.getId().equals("tower"))
                        {

                        if (collide(tempObject.getbounds(), tempObject2.getbounds()))
                            {

                            tempObject2.Health--;
                            tempObject.velx = 0;
                            }
                        }
                    }
                }
            }

        for (GameObject tempObject : objects)
            {
            if (tempObject.getId().equals("enemy"))
                {


                for (GameObject tempObject2 : objects)
                    {

                    if (tempObject2.getId().equals("warior"))
                        {

                        if (collide(tempObject.getbounds(), tempObject2.getbounds()))
                            {

                            tempObject.Health -= 10;
                            tempObject2.Health--;
                            tempObject.velx = 0;
                            tempObject2.velx = 0;
                            }
                        }
                    }
                }
            }


        for (GameObject tempObject : objects)
            {
            if (tempObject.getId().equals("enemy"))
                {


                for (GameObject tempObject2 : objects)
                    {

                    if (tempObject2.getId().equals("healer"))
                        {

                        if (collide(tempObject.getbounds(), tempObject2.getbounds()))
                            {

                            tempObject2.Health--;
                            tempObject.velx = 0;
                            }
                        }
                    }
                }
            }


        for (GameObject tempObject : objects)
            {
            if (tempObject.getId().equals("enemy"))
                {


                for (GameObject tempObject2 : objects)
                    {

                    if (tempObject2.getId().equals("wizard"))
                        {

                        if (collide(tempObject.getbounds(), tempObject2.getbounds()))
                            {
                            tempObject.Health -= 5;
                            tempObject2.Health--;
                            tempObject.velx = 0;
                            tempObject2.velx = 0;
                            }
                        }
                    }
                }
            }


        }

    public boolean collide(Rectangle r1, Rectangle r2)
        {

        return r1.intersects(r2);

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
