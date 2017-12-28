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
public class BattleGame extends JPanel implements Runnable{
     String path = "D:\\test\\Tank\\map.jpg";
     BattleTank tank1 = new BattleTank();
     BattleTank tank2 = new BattleTank();
     BattleRocket bullet1 = new BattleRocket();
     BattleRocket bullet2 = new BattleRocket();


     double rot1 = 0;
     double rot2 = Math.PI;
     int count01 = 0;
     int count02 = 0;
     int count1 = 0;
     int count2 = 0;
     int sec = 5, min = 1;
     boolean hit1 = true;
     boolean hit2 = true;
     boolean show = true;
     boolean pressed1 = true;
     boolean pressed2 = true;
     int P1 = 0;
     int P2 = 0;
     
    public BattleGame() {
       addKeyListener(new BattleGame.keylist());
       tank1.pos.y = 400;
       tank2.pos.y = 50;
       tank2.pos.x= 200;
       bullet1.pos.y = tank1.pos.y;
       bullet2.pos.y = tank2.pos.y;
       bullet1.pos.x = tank1.pos.x;
       bullet2.pos.x = tank2.pos.x;
       bullet1.speed = -bullet1.speed;
       bullet2.speed = -bullet2.speed;
      
        
      
         
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
        tran2.rotate(rot1);
        tran2.scale(0.5, 0.5); 
        
        tran3.translate(tank2.pos.x,tank2.pos.y);
        tran3.rotate(rot2);
        tran3.scale(0.5, 0.5); 
        
        
        tran4.translate(bullet1.pos.x,bullet1.pos.y);
        tran4.rotate(rot1);
        tran4.scale(0.5, 0.5); 
        
        tran5.translate(bullet2.pos.x,bullet2.pos.y);
        tran5.rotate(rot2);
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
       
        if(tank1.health <40)
        {
            g.setColor(Color.red);
            g.fillRect(0,440,tank1.health,20);
        }
       else if(tank1.health <70)
        {
            g.setColor(Color.orange);
            g.fillRect(0,440,tank1.health,20);
        }
        else
       {
         g.setColor(Color.green);
         g.fillRect(0,440,tank1.health,20);
       }
        
        if(tank2.health <40)
        {
            g.setColor(Color.red);
            g.fillRect(0,0,tank2.health,20);
        }
       else if(tank2.health <70)
        {
            g.setColor(Color.orange);
            g.fillRect(0,0,tank2.health,20);
        }
        else
       {
         g.setColor(Color.green);
         g.fillRect(0,0,tank2.health,20);
       }
      
      
         
         
    
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
                if(pressed1)
                {
                    
             bullet1.shoot(tank1.pos,rot1);
             count1 = 0;
             pressed1 = false;
                }
            
            }
            if (e.getKeyCode()==KeyEvent.VK_E)
            {
             rot1+=0.2;
            
            }
            if (e.getKeyCode()==KeyEvent.VK_Q)
            {
             rot1-=0.2;
            
            }
            if (e.getKeyCode()==KeyEvent.VK_NUMPAD7)
            {
             rot2-=0.2;
            
            }
            if (e.getKeyCode()==KeyEvent.VK_NUMPAD9)
            {
             rot2+=0.2;
            
            }
            
            if (e.getKeyCode()==KeyEvent.VK_NUMPAD8)
            {
                if(pressed2)
                {
             bullet2.shoot(tank2.pos,rot2);
             count2 = 0;
             pressed2 = false;
                }
            
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
        if(bullet2.pos.distance(tank1.pos.x,tank1.pos.y)<=50&&hit1)
        {
            count01 = 0;
            hit1 = false;
           tank1.hit(30);
        }
        if(bullet1.pos.distance(tank2.pos.x,tank2.pos.y)<=50&&hit2)
        {
            count02 = 0;
            hit2 = false;
           tank2.hit(30);
        }
        if(count01 == 20)
        {
            
            hit1 = true;
        }
        if(count02 == 20)
        {
            
            hit2 = true;
        }
        if(count1 == 20)
        {
            
            pressed1 = true;
        }
        if(count2 == 20)
        {
            
            pressed2 = true;
        }
        
        
        count1++;
        count2++;
        count01++;
        count02++;
        
        bullet1.fire();
        bullet2.fire();
        
        
        
        
        
        
        //////////////////////////////////
        
        
        if(tank1.health <= 0&&show)
        {
           JOptionPane.showMessageDialog(null, "player 2 wins!",
                                    "Winner!", JOptionPane.NO_OPTION);
                 show = false; 
        }
        if(tank2.health <= 0&&show)
        {
            JOptionPane.showMessageDialog(null, "player 1 wins!",
                                    "Winner!", JOptionPane.NO_OPTION);
                 show = false;
        }
        
        Thread.sleep(50);
        
        repaint();
    }
    }
    catch (InterruptedException e)
    {}
    }
    
    
}
