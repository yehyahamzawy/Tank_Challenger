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
public class RaceBullet {
    String path = "D:\\test\\tank\\rocket.gif";
    Point pos = new Point();
    int speed = 30;
    public void shoot(Point loc)
    {
        pos.x = loc.x;
        pos.y = loc.y;
       
    }
    public void fire()
    {
        pos.y += speed;
    }
    
    
}
