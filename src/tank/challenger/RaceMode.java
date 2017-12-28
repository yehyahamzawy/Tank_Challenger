/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tank.challenger;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author yehya_000
 */
public class RaceMode extends JFrame {

     String path = "D:\\test\\Tank\\map.jpg";
     RaceGame ra = new RaceGame();
     Thread t1=new Thread(ra);
    public RaceMode() {
         setSize(600, 500);
        setLayout(null);
        add(ra,BorderLayout.CENTER);
        ra.setBounds(0, 0, 600, 500);
        ra.setFocusable(true);
        ra.setVisible(true);
                       
        t1.start();
    }
    
   
    
}
