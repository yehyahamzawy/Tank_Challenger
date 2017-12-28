/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tank.challenger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author yehya_000
 */
public class Menu extends JFrame{
    JButton battle = new JButton("Battle");
    JButton race = new JButton("Race");
    JButton duel = new JButton("Duel!");
    JButton how = new JButton("How to play");
    public Menu()
    {
        setSize(260, 350);
        add(battle);
        add(race);
        add(duel);
        add(how);
        /////////////////////////////////
        battle.setBounds(20, 20, 200, 50);
        race.setBounds(battle.getBounds().x, battle.getBounds().y+10 + battle.getBounds().height, battle.getBounds().width, battle.getBounds().height);
        duel.setBounds(race.getBounds().x, race.getBounds().y+10+race.getBounds().height, race.getBounds().width, race.getBounds().height);
        how.setBounds(duel.getBounds().x, duel.getBounds().y+10+duel.getBounds().height, duel.getBounds().width, duel.getBounds().height);
        battle.addActionListener(new myHandler());
        race.addActionListener(new myHandler());
        duel.addActionListener(new myHandler());
        how.addActionListener(new myHandler());
        
        setLayout(null);
    }
     private class myHandler implements ActionListener
     {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object buttonPressed = e.getSource();
            if(buttonPressed.equals(how))
            {
                HowTP h = new HowTP();
                h.setVisible(true);
            }
            else if(buttonPressed.equals(duel))
            {
                GameMap d = new GameMap();
                d.setVisible(true);
            }
            else if(buttonPressed.equals(race))
            {
                RaceMode d = new RaceMode();
                d.setVisible(true);
            }
            else if(buttonPressed.equals(battle))
            {
                BattleMode d = new BattleMode();
                d.setVisible(true);
            }
            
            
        }
         
     }
}
