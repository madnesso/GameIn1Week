
package stickmantowerdefence;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.io.File;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StickManTowerDefence implements Runnable{

    private boolean running;
    private Thread thread;
    private Handler handler;
    private Windows gameWindow;
    private Random random = new Random();
    private Hud hud;
    private Login login;
    private MyMenu menu;
    private ShopWindow shop;
    private DataManger manger;
    private File myFile = new File("Data.bin");
    private Graphics g;
    private JPanel panel = new JPanel(true);
    private JLabel x = new JLabel("hi");
    
    public StickManTowerDefence() {
        this.handler = new Handler();
        this.thread = new Thread();
        this.manger = new DataManger(myFile);
        this.hud = new Hud(handler);
        this.menu = new MyMenu();
        this.login = new Login(manger);
        this.shop = new ShopWindow();
        this.gameWindow = new Windows(1920, 1080, "StickMan Tower Defence");
        gameWindow.setVisible(false);
        for(int i=0;i<8;i++)
        {
            handler.addObject(new Enemy(new Point(random.nextInt(500),random.nextInt(100)), new Dimension(221,440), ID.enemy, 2, 2));
        }
        gameWindow.add(panel);
        panel.paint(g);
        
    }
    
    @Override
    public void run(){
        login.windows.setVisible(true);
        menu.windows.setVisible(false);
        shop.windows.setVisible(false);
        gameWindow.setVisible(false);
        while(running){
            tick();
            paint(g);
        }
        stop();
    }
    
    public void tick()
    {
        if(login.isDone()==true){
            login.windows.setVisible(false);
            menu.windows.setVisible(true);
            shop.windows.setVisible(false);
            gameWindow.setVisible(false);
            login.setDone(false);
        }
        else if(menu.isDone()==true){
            login.windows.setVisible(false);
            menu.windows.setVisible(false);
            shop.windows.setVisible(false);
            gameWindow.setVisible(true);
            menu.setDone(false);
            menu.setShop(false);
            
        }
        else if(menu.isShop()==true){
            login.windows.setVisible(false);
            menu.windows.setVisible(false);
            shop.windows.setVisible(true);
            gameWindow.setVisible(false);
            menu.setDone(false);
            menu.setShop(false);
        }
        if(shop.isDone()==true){
            login.windows.setVisible(false);
            menu.windows.setVisible(true);
            shop.windows.setVisible(false);
            gameWindow.setVisible(false);
            shop.setDone(false);

        }
    }
    
    public void paint(Graphics g){
        handler.paint(g);
        hud.paint(g);
    }
    
    public synchronized void start()
    {
        thread = new Thread(this);
        thread.start();
        running = true;
    }
    
    public synchronized void stop()
    {
        try{
        thread.join();
        running = false;}
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        StickManTowerDefence game = new StickManTowerDefence();
        game.start();
    }
    
}
