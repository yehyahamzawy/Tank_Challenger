/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tank.challenger;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author yehya_000
 */
public class BattleMode extends JFrame{
    
    String path = "D:\\test\\Tank\\map.jpg";
     BattleGame ba = new BattleGame();
     Thread t1=new Thread(ba);
    public BattleMode() {
         setSize(600, 500);
        setLayout(null);
        add(ba,BorderLayout.CENTER);
        ba.setBounds(0, 0, 600, 500);
        ba.setFocusable(true);
        ba.setVisible(true);
                       
        t1.start();
    }
    
}
