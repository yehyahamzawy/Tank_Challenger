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
public class Tank {
    public int health;
    public String path;
    public Point pos=new Point();
    public int sped;
     public Tank (String pic)
    {
        sped=5;
        path = pic;
    }
    
}
