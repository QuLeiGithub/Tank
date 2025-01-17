package cn.test.tank.chainofresponsibility;

import cn.test.tank.*;

import java.awt.*;

public class TankWallCollider implements Collider {
    @Override
    public boolean collide(AbstractGameObject go1, AbstractGameObject go2) {
        if(go1 instanceof Tank && go2 instanceof Wall){
            Tank t = (Tank) go1;
            Wall w = (Wall) go2;
            if(t.isLiving()){
                if(t.getRect().intersects(w.getRect())){
                    t.back();
                    return true;
                }
            }

        }else if(go1 instanceof Wall && go2 instanceof Bullet){
           return collide(go2,go1);
        }
        return true;
    }
}
