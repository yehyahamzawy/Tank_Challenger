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
public class BattleTank {
    int speed = 20;
    int health = 100;
    Point pos = new Point();
    String path="D:\\test\\tank\\TankS.png";
    public BattleTank()
    {
      pos.x = 50;
      pos.y = 50;
    }
    public void moveR()
    {
        pos.x += speed;
    }
    public void moveL()
    {
        pos.x -= speed;
    }
    public void hit(int dmg)
    {
        health -= dmg;
    }
    
}
