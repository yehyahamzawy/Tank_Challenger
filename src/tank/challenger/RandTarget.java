/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tank.challenger;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author yehya_000
 */
public class RandTarget extends JPanel implements Runnable {
    
    Random rand= new Random();
    Point pos = new Point();
    
    public RandTarget() {
        pos.x = 100;
        pos.y = 35;
        setSize( 200, 70);
        setBackground(Color.red);
        
        
    }
    
    public void  paintComponent(Graphics g)
    {
         
    g.clearRect(0, 0, 600, 600);
     
     
    g.setColor(Color.black);
      g.fillOval(pos.x,pos.y,30,30);
      g.setColor(Color.white);
      g.fillOval(pos.x+5,pos.y+5,20,20);
      g.setColor(Color.red);
      g.fillOval(pos.x+10,pos.y+10,10,10);
      
     

    }
    @Override
    public void run() {
        try
    {
    while(true)
    {
       pos.x = rand.nextInt(140)+30;
       pos.y = rand.nextInt(5)+30;
        Thread.sleep(1000);
        repaint();
    }
    }
    catch (InterruptedException e)
    {}
    } 
    
}
