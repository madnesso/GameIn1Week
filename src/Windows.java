import javax.swing.*;
import java.awt.*;

public class Windows extends JFrame
    {
    private static final long serialVersionUID = 2727454497246459180L;

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
