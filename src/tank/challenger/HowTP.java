/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tank.challenger;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.Timer;


/**
 *
 * @author yehya_000
 */
public class HowTP extends JFrame {
    private int count = 1;
    String tex;
    JButton next = new JButton("Next");
    JButton prev = new JButton("Previous");
    String path = "D:\\test\\Tank\\TankS.jpg";
     RotateAnimation tan= new RotateAnimation();
     TimerAnimation tim = new TimerAnimation();
     RandTarget ran = new RandTarget();
     Thread t1=new Thread(tan);
     Thread t2=new Thread(tim);
     Thread t3=new Thread(ran);
     JTextArea tot = new JTextArea();
    public Point pos=new Point();
    public HowTP()
    {
        pos.x = 0;
        pos.y = 0;
        setSize(600, 300);
        setLayout(null);
        add(next);
        add(prev);
        next.setBounds(480, 230, 100, 20);
        prev.setBounds(next.getBounds().x-next.getBounds().width-10, next.getBounds().y, next.getBounds().width, next.getBounds().height);
        prev.setVisible(false);
        next.addActionListener(new myHandler());
        prev.addActionListener(new myHandler());
         add(tan,BorderLayout.CENTER);
         add(tim,BorderLayout.CENTER);
         add(ran,BorderLayout.CENTER);
                       tan.setBounds(385, 150, 200, 70);
                       tan.setFocusable(true);
                       tan.setVisible(true);
                       t1.start();
                       tan.setVisible(false);
                       tim.setBounds(385, 150, 200, 70);
                       tim.setFocusable(true);
                       tim.setVisible(true);
                       t2.start();
                       ran.setBounds(385, 150, 200, 70);
                       ran.setFocusable(true);
                       ran.setVisible(true);
                       t3.start();
                       tim.setVisible(true);
                       ran.setVisible(false);
                       tot.setEditable(false);
                       add(tot);
                       tot.setBounds(0, 0, 600, 300);
                       tex = "How to play duel:\n";
                       tex += "\n";
                       tex += "this mode is about reaction time and speed, this mode is very simple.\n";
                       tex += "two players face each other to duel, there is a timer, who ever shoots first wins.\n";
                       tex += "but be careful! if you fire before the green light you lose!\n";
                       tex += "P1 controls: fire:A\n";
                       tex += "P2 controls: fire:L\n";
                       
                       tot.setText(tex);

                      
        
       
    }
    private void howBattle(boolean con)
    {
       tan.setVisible(con);
       
    }
   
  
    
     private class myHandler implements ActionListener
     {
         

        @Override
        public void actionPerformed(ActionEvent e)
            {
                Object buttonPressed = e.getSource();
                ///////////////////////////////////////////// NEXT
               if(buttonPressed.equals(next))
                {
                    
                    count++;
                   
                                       
                    ////_______________________________________
                    if(count == 3)
                    {
                        next.setVisible(false);
                    }
                    if(count > 1)
                    {
                        prev.setVisible(true);
                    }
                    ////________________________________________|
                   if(count == 2)
                   {
                    
                       
                       
                       tex = "How to play battle:\n";
                       tex += "\n";
                       tex += "this mode is about aiming and speed, dodging enemy's missiles and shooting them in the same time. \n";
                       tex += "you can rotate your tank, and move left and right. \n";
                       tex += "each player has his own health bar, so you must keep shooting your enemy's till their health bar is empty \n";
                       tex += "P1 controls: move left:A ,move right:D, fire rockets: W, rotate CW: E, rotate anti-CW: Q\n";
                       tex += "P2 controls (Num keybad): move left: 4,move right:6, fire rockets: 8 \nrotate CW: 9, rotate anti-CW: 7\n";
                       tot.setText(tex);
                       tan.setVisible(true);
                       tim.setVisible(false);
                       
                   }
                   if(count == 3)
                   {
                       ran.setVisible(true);
                       tex = "How to play race:\n";
                       tex += "\n";
                       tex += "this mode is about speed, shooting the targets before your opponent to increase your score. \n";
                       tex += "the player with the highest score when the match ends wins. \n";
                       tex += "there is a timer and targets appear in random positions, so be as fast as you can! \n";
                       tex += "P1 controls: move left:A ,move right:D, fire missile: S\n";
                       tex += "P2 controls (Num keybad): move left: 4,move right:6, fire missile: 5\n";
                       tot.setText(tex);
                   }
                   if (count == 3 || count == 1)
                   {
                       
                       tan.setVisible(false);
                       
                   }
                   
                }
               ///////////////////////////////////////////////// PREVIOUS
               else if(buttonPressed.equals(prev))
                {
                    count--;
                     
                    ////_______________________________________
                    if(count == 1)
                    {
                        prev.setVisible(false);
                    }
                   
                    if(count < 3)
                    {
                        next.setVisible(true);
                       
                    }
                    ////________________________________________|
                    
                    if(count == 1)
                    {
                         tex = "How to play duel:\n";
                       tex += "\n";
                       tex += "this mode is about reaction time and speed, this mode is very simple. \n";
                       tex += "two players face each other to duel, there is a timer, who ever shoots first wins. \n ";
                       tex += "but be careful! if you fire before the green light you lose!\n";
                       tex += "P1 controls: fire:A\n";
                       tex += "P2 controls: fire:L\n";
                       tim.setVisible(true);
                       tot.setText(tex);

                    }
                    if(count == 2)
                   {
                       tex = "How to play battle:\n";
                       tex += "\n";
                       tex += "this mode is about aiming and speed, dodging enemy's missiles and shooting them in the same time. \n";
                       tex += "you can rotate your tank, and move left and right. \n";
                       tex += "each player has his own health bar, so you must keep shooting your enemy's till their health bar is empty \n";
                       tex += "P1 controls: move left:A ,move right:D, fire rockets: W, rotate CW: E, rotate anti-CW: Q\n";
                       tex += "P2 controls (Num keybad): move left: 4,move right:6, fire rockets: 8 \nrotate CW: 9, rotate anti-CW: 7\n";
                       tot.setText(tex);
                       
                      tim.setVisible(false);
                      tan.setVisible(true);
                      ran.setVisible(false);
                   }
                   if (count == 3 || count == 1)
                   {
                       
                       tan.setVisible(false);
                       
                   }
                   
                }
                
                
            }
         
     }
}
