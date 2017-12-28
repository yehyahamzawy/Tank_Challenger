/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tank.challenger;

import java.awt.Point;

/**
 *
 * @author yehya_000
 */
public class BattleRocket {
    String path = "D:\\test\\tank\\rocket.gif";
    Point pos = new Point();
    double rot = 0;
    int speed = 30;
    
    public void shoot(Point loc, double rota)
    {
        pos.x = loc.x;
        pos.y = loc.y;
        rot = rota;
       
    }
    public void fire()
    {
        
        pos.x -= (int)(speed*Math.sin(rot));
        pos.y += (int)(speed*Math.cos(rot));
    }
    
    
}
