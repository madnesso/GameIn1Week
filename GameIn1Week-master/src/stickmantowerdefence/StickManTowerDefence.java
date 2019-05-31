
package stickmantowerdefence;

public class StickManTowerDefence implements Runnable{

    private boolean running;
    private Thread thread;
    private Handler handler;
    
    public void run(){
        while(running){
            
        }
    }
    
    public void tick(){
        
    }
    
    public void paint(){
        
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
    }
    
}
