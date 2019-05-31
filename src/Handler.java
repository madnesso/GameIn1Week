import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;


public class Handler {
    
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
    
    public boolean collide(Rectangle r1,Rectangle r2){

            if(r1.intersects(r2)){

                return true;
            }else {
                return false;
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
                        if (collide(tempObject.getbounds(),tempObject2.getbounds()))
                        {
                            int tempx = tempObject.getVelX();
                            int tempy = tempObject.getVelY();
                            tempObject.setVelX(0);
                            tempObject.setVelY(0);
                            float x = ((Enemy)tempObject).getAttackdmg();
                            float y = ((Tower)tempObject2).getHealth();
                            ((Tower)tempObject2).setHealth(y-x);
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
                    if (tempObject2.getId().equals("warrior"))
                    {
                        if (collide(tempObject.getbounds(),tempObject2.getbounds()))
                        {
                            int tempx = tempObject.getVelX();
                            int tempy = tempObject.getVelY();
                            tempObject.setVelX(0);
                            tempObject.setVelY(0);
                            float x = ((Enemy)tempObject).getAttackdmg();
                            float y = ((Warrior)tempObject2).getHealth();
                            ((Warrior)tempObject2).setHealth(y-x);
                            float a = ((Enemy)tempObject).getHealth();
                            float b = ((Warrior)tempObject2).getAttackDmg();
                            ((Enemy)tempObject).setHealth(a-b);
                            float m = ((Warrior)tempObject2).getHealth();
                            float n = ((Enemy)tempObject).getHealth();
                            if(m == 0){
                                objects.remove(tempObject2);
                                tempObject.setVelX(tempx);
                                tempObject.setVelY(tempy);
                            }
                            if(n == 0){
                                objects.remove(tempObject);
                            } 
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
                        if (collide(tempObject.getbounds(),tempObject2.getbounds()))
                        {
                            int tempx = tempObject.getVelX();
                            int tempy = tempObject.getVelY();
                            tempObject.setVelX(0);
                            tempObject.setVelY(0);
                            float x = ((Enemy)tempObject).getAttackdmg();
                            float y = ((Healer)tempObject2).getHealth();
                            ((Healer)tempObject2).setHealth(y-x);
                            float m = ((Healer)tempObject2).getHealth();
                            if(m == 0){
                                objects.remove(tempObject2);
                                tempObject.setVelX(tempx);
                                tempObject.setVelY(tempy);
                            }
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
                    if (tempObject2.getId().equals("mage"))
                    {
                        if (collide(tempObject.getbounds(),tempObject2.getbounds()))
                        {
                            int tempx = tempObject.getVelX();
                            int tempy = tempObject.getVelY();
                            tempObject.setVelX(0);
                            tempObject.setVelY(0);
                            float x = ((Enemy)tempObject).getAttackdmg();
                            float y = ((Mage)tempObject2).getHealth();
                            ((Mage)tempObject2).setHealth(y-x);
                            float m = ((Mage)tempObject2).getHealth();
                            if(m == 0){
                                objects.remove(tempObject2);
                                tempObject.setVelX(tempx);
                                tempObject.setVelY(tempy);
                            }
                        }
                        else
                        {
                            float x = ((Mage)tempObject2).mageDamage(Math.abs(tempObject.getPoint().x-tempObject2.getPoint().x));
                            ((Enemy)tempObject).setHealth(((Enemy)tempObject).getHealth()-x);
                            if(((Enemy)tempObject).getHealth() == 0){
                                objects.remove(tempObject);
                            }
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
                    if (tempObject2.getId().equals("archer"))
                    {
                        if (collide(tempObject.getbounds(),tempObject2.getbounds()))
                        {
                            int tempx = tempObject.getVelX();
                            int tempy = tempObject.getVelY();
                            tempObject.setVelX(0);
                            tempObject.setVelY(0);
                            float x = ((Enemy)tempObject).getAttackdmg();
                            float y = ((Archer)tempObject2).getHealth();
                            ((Archer)tempObject2).setHealth(y-x);
                            float m = ((Archer)tempObject2).getHealth();
                            if(m == 0){
                                objects.remove(tempObject2);
                                tempObject.setVelX(tempx);
                                tempObject.setVelY(tempy);
                            }
                        }
                        else
                        {
                            float x = ((Archer)tempObject2).archerDamage(Math.abs(tempObject.getPoint().x-tempObject2.getPoint().x));
                            ((Enemy)tempObject).setHealth(((Enemy)tempObject).getHealth()-x);
                            if(((Enemy)tempObject).getHealth() == 0){
                                objects.remove(tempObject);
                            }
                        }
                    }
                }
            }
        }
        
        for (GameObject tempObject : objects)
        {
            if (tempObject.getId().equals("healer"))
            {
                for (GameObject tempObject2 : objects)
                {
                    if (tempObject2.getId().equals("healer") || tempObject2.getId().equals("mage") || tempObject2.getId().equals("archer") || tempObject2.getId().equals("warrior"))
                    {
                        float x = ((Healer)tempObject2).Heal(Math.abs(tempObject.getPoint().x-tempObject2.getPoint().x));
                        ((Units)tempObject2).setHealth(((Units)tempObject).getHealth()-x);
                    }
                }
            }
        }

    }

}
