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
public class TimerAnimation extends JPanel implements Runnable{
    
    int count = 0;

    public TimerAnimation() {
        setSize(100,100);
        setBackground(Color.red);
        
        
    }
    
    public void  paintComponent(Graphics g)
    {
         
    g.clearRect(0, 0, 600, 600);
     
     
    g.setColor(Color.red);
      g.fillOval(0,35,30,30);
      
      if (count == 2)
      {
          g.fillOval(40,35,30,30);
      }
      if (count == 3)
      {
          g.fillOval(40,35,30,30);
          g.fillOval(80,35,30,30);
      }
      if (count == 4)
      {
          g.fillOval(40,35,30,30);
          g.fillOval(80,35,30,30);
          g.setColor(Color.green);
          g.fillOval(120,35,30,30);
      }

    }
    @Override
    public void run() {
        try
    {
    while(true)
    {
        if(count > 4)
            count = 1;
        count++;
        Thread.sleep(1000);
        repaint();
    }
    }
    catch (InterruptedException e)
    {}
    } 
}
    

