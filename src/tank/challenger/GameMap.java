/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tank.challenger;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author yehya_000
 */
public class GameMap extends JFrame {
    
     String path = "D:\\test\\Tank\\map.jpg";
     String pathTank = "D:\\test\\tank\\TankS.png";
     DuelGame du = new DuelGame();
     Thread t1=new Thread(du);
    
        
     
    
    public GameMap(){
    setSize(600, 500);
        setLayout(null);
        addKeyListener(new keylist());
        JPanel map = new JPanel();
        map.setBounds(0, 0, 600, 500);
        add(map);
        map.repaint();
        
         add(du,BorderLayout.CENTER);
                       du.setBounds(385, 150, 200, 70);
                       
                       du.setVisible(true);
                       
                       t1.start();
                       
        
    }
    private class keylist implements KeyListener
     {

        @Override
        public void keyTyped(KeyEvent e) {
            
             }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode()==KeyEvent.VK_A)
            {
               
             if(du.tim)
             {
                 JOptionPane.showMessageDialog(null, "player 1 wins!",
                                    "Winner!", JOptionPane.NO_OPTION);
                 setVisible(false);
                 
             }
             else if(du.tim == false)
             {
                 JOptionPane.showMessageDialog(null, "player 2 wins!",
                                    "Winner!", JOptionPane.NO_OPTION);
                 setVisible(false);
                 
             }
               
            }
            if (e.getKeyCode()==KeyEvent.VK_L)
            {
                if(du.tim)
             {
                 JOptionPane.showMessageDialog(null, "player 2 wins!",
                                    "Winner!", JOptionPane.NO_OPTION);
                 setVisible(false);
                 
             }
             else if(du.tim == false)
             {
                JOptionPane.showMessageDialog(null, "player 1 wins!",
                                    "Winner!", JOptionPane.NO_OPTION);
                  setVisible(false);
             }
            }
             }

        @Override
        public void keyReleased(KeyEvent e) {
             }
         
     }
    public void  paint(Graphics g)
    {
         g.clearRect(0, 0, 600, 600);
        BufferedImage map = null;
        BufferedImage tank1 = null;
        BufferedImage tank2 = null;
         AffineTransform tran = new AffineTransform();
         AffineTransform tran2 = new AffineTransform();
         AffineTransform tran3 = new AffineTransform();
       tran.translate(300,200);
        tran.rotate(0);
        tran.scale(0.9, 0.5); 
        tran2.translate(300, 400);
        tran2.rotate(0);
        tran2.scale(0.6, 0.6); 
        tran3.translate(300, 100);
        tran3.rotate(Math.PI);
        tran3.scale(0.6, 0.6); 
        
       
       
         try {
             
              map = ImageIO.read(new File(path));
               tank1 = ImageIO.read(new File(pathTank));
               tank2 = ImageIO.read(new File(pathTank));
             } catch (IOException ex) {
             Logger.getLogger(GameMap.class.getName()).log(Level.SEVERE, null, ex);
             }
       
        
       
         tran.translate(-map.getWidth()/2, -map.getHeight()/2);
         tran2.translate(-tank1.getWidth()/2, -tank1.getHeight()/2);
         tran3.translate(-tank2.getWidth()/2, -tank2.getHeight()/2);
        Graphics2D g2d = (Graphics2D) g;
       
        g2d.drawImage(map, tran, null);
        g2d.drawImage(tank1, tran2, null);
        g2d.drawImage(tank2, tran3, null);
        
        
         
         
    
    }
}
