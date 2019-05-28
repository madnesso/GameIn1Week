import javax.swing.*;
import java.awt.*;

public class Windows extends Canvas
    {

    private static final long serialVersionUID = 802980368275219408L;

    //,Game game)
    public Windows(int width, int height, String tittle)
        {
        JFrame frame = new JFrame(tittle);
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        // hanadd 7agat hena to the game like we can send game awe ay menu tanya
        ///////////////////////////////////


        ///////////////////////////////////
        }

    }
