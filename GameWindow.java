
package stickmantowerdefence;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;
import javax.swing.JPanel;


public class GameWindow extends JPanel{
    
    private Handler handler;
    private Hud hud;
    private Thread thread;
    private Random random = new Random();

    public GameWindow(Handler handler, Hud hud, Thread thread) {
        this.handler=handler;
        this.hud = hud;
        this.thread=thread;
        for(int i=0;i<8;i++){
            Enemy e = new Enemy(new Point(random.nextInt(300), random.nextInt(300)),new Dimension(200, 2000), ID.enemy, 10, 10);
            handler.addObject(e);
        }
        thread.start();
    }
    
    
    public void paint(Graphics g){
        super.paint(g);
        for(int i=0;i<handler.objectSize();i++){
        handler.getObject(i).tick();
        handler.getObject(i).paint(g);
        }
    }
    
    public synchronized void start()
    {
        thread = new Thread();
        thread.start();
    }
    

}
