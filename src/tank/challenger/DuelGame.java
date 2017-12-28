/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tank.challenger;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author yehya_000
 */
public  class  DuelGame extends JPanel implements Runnable {

    int count = -1;
    int taym = 1000;
    boolean tim = false;
    Random rand =  new Random();
    public DuelGame()
    {
        repaint();
    }
    
     public void  paintComponent(Graphics g)
    {
         
    
     g.clearRect(0, 0, 600, 600);
     g.setColor(Color.gray);
     g.fillRect(0, 0, 600, 600);
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
    public void run() 
    {
     try
    {
    while(true)
    {
        if(count == 2)
        {
            taym = rand.nextInt(5000);
        }
        if(count == 3)
            tim = true;
        if(count < 4)
        count++;
        Thread.sleep(taym);
        repaint();
    }
    }
    catch (InterruptedException e)
    {}
    }
    
}
