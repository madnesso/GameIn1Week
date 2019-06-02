
package stickmantowerdefence;

import java.awt.Dimension;
import javax.swing.JFrame;


public class Windows extends JFrame{

    public Windows(int width, int height, String tittle) {
        setPreferredSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    
}
