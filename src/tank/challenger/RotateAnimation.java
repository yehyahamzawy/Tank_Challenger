/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tank.challenger;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author yehya_000
 */
public class RotateAnimation extends JPanel implements Runnable{

    String path = "D:\\test\\Tank\\TankS.jpg";
    double rot = 0;
    double speed = 0.1;
    int health = 100;

    public RotateAnimation() {
        setSize(100,100);
        setBackground(Color.red);
        
        
    }
    
    public void  paintComponent(Graphics g)
    {
         
    g.clearRect(0, 0, 600, 600);
     
     BufferedImage imgtank = null;
        AffineTransform tran = new AffineTransform();
        tran.translate(160,35);
        tran.rotate(rot);
        tran.scale(0.3, 0.3);
        try
        {
        imgtank = ImageIO.read(new File(path));
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
        tran.translate(-imgtank.getWidth()/2, -imgtank.getHeight()/2);
        Graphics2D g2d = (Graphics2D) g;
       
        g2d.drawImage(imgtank, tran, null);
        if(health <40)
        {
            g.setColor(Color.red);
        }
       else if(health <70)
        {
            g.setColor(Color.orange);
        }
        else
         g.setColor(Color.green);
         
    
      g.fillRect(0,35,health,20);
      

    }
    @Override
    public void run() {
        try
    {
    while(true)
    {
      if(rot > 1)
          speed = -speed;
      else if(rot < -1)
          speed = -speed;
        
      rot = rot + speed;
      if(health < 30)
          health = 100;
      health -= 1;
        Thread.sleep(50);
        repaint();
    }
    }
    catch (InterruptedException e)
    {}
    } 
}
    

