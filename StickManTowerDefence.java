
package stickmantowerdefence;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class StickManTowerDefence implements Runnable{

    private boolean running;
    private Thread thread;
    private Handler handler;
    private Windows gameWindow;
    private Login login;
    private MyMenu menu;
    private Hud hud;
    private ShopWindow shop;
    private DataManger manger;
    private File myFile = new File("Data.bin");

    private GameWindow panel ;
    private JLabel x = new JLabel("hi");
    
    public StickManTowerDefence() {
        this.handler = new Handler();
        this.thread = new Thread();
        this.panel = new GameWindow(handler, hud, thread);
        this.manger = new DataManger(myFile);
        this.menu = new MyMenu();
        this.login = new Login(manger);
        this.shop = new ShopWindow();
        this.gameWindow = new Windows(1920, 1080, "StickMan Tower Defence");
        gameWindow.setVisible(false);
        gameWindow.add(panel);
        
        
    }
    
    @Override
    public void run(){
        login.windows.setVisible(true);
        menu.windows.setVisible(false);
        shop.windows.setVisible(false);
        gameWindow.setVisible(false);
        while(running){
            tick();
            panel.start();
            try{
                Thread.sleep(10);
            }catch(Exception e){
                e.printStackTrace();
            }
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
    
    public static void main(String[] args) throws IOException {
     /*   Socket s=new Socket("127.0.0.1",9000);
                InputStream is=s.getInputStream();

                BufferedReader bf=new BufferedReader(new InputStreamReader(is));
                String ServerMessage=bf.readLine();
                System.out.println("Server says :" + ServerMessage);
                bf.close();
                s.close();*/
        StickManTowerDefence game = new StickManTowerDefence();
        game.start();
    }
    
}
