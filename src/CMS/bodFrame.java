package CMS;

import javax.swing.*;
import java.awt.*;

// abstract class without any  abstract method
abstract class bodFrame  extends JFrame {   //extending the JFrame class
    private JFrame frame = new JFrame();
    ImageIcon img = new ImageIcon("cms.png");
    public  JFrame bod_frame() {

        //adding components to the extended JFrame class
        frame.setIconImage(img.getImage());
        frame.getContentPane().setBackground(new Color(40,170,150));
        frame.setSize(1000,800);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setResizable(false);   //Size cannot be changed
        frame.setVisible(true);  //Makes the gui visible
        return frame;


    }


}
