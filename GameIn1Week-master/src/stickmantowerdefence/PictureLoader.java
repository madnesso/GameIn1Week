package stickmantowerdefence;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PictureLoader
    {
    private BufferedImage image;

    public BufferedImage loadiamge(String path)
        {
        try
            {
            image = ImageIO.read(getClass().getResource(path));
            } catch (IOException e)
            {
            e.printStackTrace();
            }
        return image;
        }


    }
