package stickmantowerdefence;

public class StickManTowerDefence implements Runnable
    {

    private boolean running = true;
    private Thread thread;
    private Handler handler;

    public static void main(String[] args)
        {
        }

    @Override
    public void run()
        {
        while (running)
            {
            start();
            tick();
            paint();
            }
        stop();
        }

    public synchronized void start()
        {
        thread = new Thread(this);
        thread.start();
        running = true;
        }

    public void tick()
        {

        }

    public void paint()
        {

        }

    public synchronized void stop()
        {
        try
            {
            thread.join();
            running = false;
            } catch (Exception e)
            {
            e.printStackTrace();
            }
        }

    }
