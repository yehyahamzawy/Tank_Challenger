/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tank.challenger;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author yehya_000
 */
public class RaceGame extends JPanel implements Runnable {
    
    
     String path = "D:\\test\\Tank\\map.jpg";
     RaceTank tank1 = new RaceTank();
     RaceTank tank2 = new RaceTank();
     RaceBullet bullet1 = new RaceBullet();
     RaceBullet bullet2 = new RaceBullet();
     Point pos = new Point();
     Random rand = new Random();
     JLabel timr = new JLabel();
     JLabel P1score = new JLabel();
     JLabel P2score = new JLabel();
     int count = 0;
     int sec = 5, min = 1;
     boolean hit = true;
     boolean show = true;
     int P1 = 0;
     int P2 = 0;
     
    public RaceGame() {
       addKeyListener(new RaceGame.keylist());
       tank1.pos.y = 400;
       tank2.pos.y = 50;
       bullet1.pos.y = tank1.pos.y;
       bullet2.pos.y = tank2.pos.y;
       bullet1.pos.x = tank1.pos.x;
       bullet2.pos.x = tank2.pos.x;
       bullet1.speed = -bullet1.speed;
       pos.x = 100;
       pos.y = 100;
        
       add(timr);
       P1score.setVisible(true);
       P1score.setBounds(0, 400, 100, 20);
       add(P1score);
       timr.setVisible(true);
       timr.setBounds(0, 50, 100, 20);
       add(P2score);
       P2score.setVisible(true);
       P2score.setBounds(0, 10, 100, 20);
      setLayout(null);
         
    }
    
    public void  paintComponent(Graphics g)
    {
        g.clearRect(0, 0, 600, 600);
       // BufferedImage map = null;
        BufferedImage tnk1 = null;
        BufferedImage tnk2 = null;
        BufferedImage blt1 = null;
        BufferedImage blt2 = null;
        //AffineTransform tran = new AffineTransform();
        AffineTransform tran2 = new AffineTransform();
        AffineTransform tran3 = new AffineTransform();
        AffineTransform tran4 = new AffineTransform();
        AffineTransform tran5 = new AffineTransform();
        
        //tran.translate(350,300);
       // tran.rotate(0);
       // tran.scale(0.9, 0.5); 
        
        tran2.translate(tank1.pos.x,tank1.pos.y);
        tran2.rotate(0);
        tran2.scale(0.5, 0.5); 
        
        tran3.translate(tank2.pos.x,tank2.pos.y);
        tran3.rotate(Math.PI);
        tran3.scale(0.5, 0.5); 
        
        
        tran4.translate(bullet1.pos.x,bullet1.pos.y);
        tran4.rotate(0);
        tran4.scale(0.5, 0.5); 
        
        tran5.translate(bullet2.pos.x,bullet2.pos.y);
        tran5.rotate(Math.PI);
        tran5.scale(0.5, 0.5); 
       
       
       
         try {
             
             // map = ImageIO.read(new File(path));
              tnk1 = ImageIO.read(new File(tank1.path));
              tnk2 = ImageIO.read(new File(tank2.path));
              blt1 = ImageIO.read(new File(bullet1.path));
              blt2 = ImageIO.read(new File(bullet2.path));

              
             } catch (IOException ex) {
             Logger.getLogger(GameMap.class.getName()).log(Level.SEVERE, null, ex);
             }
       
        
       
         //tran.translate(-map.getWidth()/2, -map.getHeight()/2);
         tran2.translate(-tnk1.getWidth()/2, -tnk1.getHeight()/2);
         tran3.translate(-tnk2.getWidth()/2, -tnk2.getHeight()/2);
         tran4.translate(-blt1.getWidth()/2, -blt1.getHeight()/2);
         tran5.translate(-blt2.getWidth()/2, -blt2.getHeight()/2);
         
        Graphics2D g2d = (Graphics2D) g;
       
        //g2d.drawImage(map, tran, null);
        g2d.drawImage(tnk1, tran2, null);
        g2d.drawImage(tnk2, tran3, null);
        g2d.drawImage(blt1, tran4, null);
        g2d.drawImage(blt2, tran5, null);
       
        g.setColor(Color.black);
      g.fillOval(pos.x,pos.y,30,30);
      g.setColor(Color.white);
      g.fillOval(pos.x+5,pos.y+5,20,20);
      g.setColor(Color.red);
      g.fillOval(pos.x+10,pos.y+10,10,10);
        
         
         
    
    }
    
    
    private class keylist implements KeyListener
     {

        @Override
        public void keyTyped(KeyEvent e) {
            
             }

        @Override
        public void keyPressed(KeyEvent e) 
    {
            if (e.getKeyCode()==KeyEvent.VK_A)
            {
               tank1.moveL();
            }
            if (e.getKeyCode()==KeyEvent.VK_D)
            {
             tank1.moveR();
            
            }
            if (e.getKeyCode()==KeyEvent.VK_W)
            {
             bullet1.shoot(tank1.pos);
            
            }
            if (e.getKeyCode()==KeyEvent.VK_NUMPAD8)
            {
             bullet2.shoot(tank2.pos);
            
            }
            if (e.getKeyCode()==KeyEvent.VK_NUMPAD4)
            {
               tank2.moveL();
            }
            if (e.getKeyCode()==KeyEvent.VK_NUMPAD6)
            {
             tank2.moveR();
            
            }
    }

            
        
        @Override
        public void keyReleased(KeyEvent e) {
             }
         
     }
    
    
    
    @Override
    public void run() 
    {
             try
    {
    while(true)
    {
        if(bullet1.pos.distance(pos.x+20,pos.y)<=30)
        {
            hit = true;
            P1++;
        }
        if(bullet2.pos.distance(pos.x+20,pos.y)<=30)
        {
            hit = true;
            P2++;
        }
        if(hit){
            
        pos.x = rand.nextInt(500) + 20;
        pos.y = rand.nextInt(150) + 150;
        hit = false;
        }
        
        if(count >= 20)
        {
            count = 0;
            sec--;
            if(sec == -1)
            {
                sec = 59;
                min--;
            }
            
        }
        if(min <=0 && sec <=0 && show)
        {
            if(P1 < P2)
            {
                JOptionPane.showMessageDialog(null, "player 2 wins!",
                                    "Winner!", JOptionPane.NO_OPTION);
                 show = false;
            }
            else if(P1 > P2 )
            {
                JOptionPane.showMessageDialog(null, "player 1 wins!",
                                    "Winner!", JOptionPane.NO_OPTION);
                 show = false;
            }
            else if(P1 == P2)
            {
                JOptionPane.showMessageDialog(null, "Play one more time?",
                                    "Draw", JOptionPane.NO_OPTION);
                 show = false;
            }
        }
        timr.setText(min + ":" + sec);
        P1score.setText("Score:" + P1);
        P2score.setText("Score:" + P2);
        count++;
        bullet1.fire();
        bullet2.fire();
        Thread.sleep(50);
        
        repaint();
    }
    }
    catch (InterruptedException e)
    {}
    }
    
}
