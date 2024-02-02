package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_FireExtinguisher_2 extends Entity {
    public GENERAL_FireExtinguisher_2(GamePanel gamePanel) {
        super(gamePanel);
        name = "FireExtinguisher_2";
        ObjectWidth = 18*2+9;
        ObjectHeight = 32*2+16;

        Area.width = ObjectWidth;
        Area.height = ObjectHeight/2;
        Area.x = 0;
        Area.y = ObjectHeight-Area.height;
        AreaDefaultX = Area.x;
        AreaDefaultY = Area.y;
        //Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}