package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Box_3_White extends Entity {
    public GENERAL_Box_3_White(GamePanel gamePanel) {
        super(gamePanel);
        name = "Box_3_White";
        ObjectWidth = 28*2+14;
        ObjectHeight = 64*2+32;

        Area.width = ObjectWidth;
        Area.height = ObjectHeight/2-10;
        Area.x = 0;
        Area.y = ObjectHeight-Area.height;
        AreaDefaultX = Area.x;
        AreaDefaultY = Area.y;
        //Area = new Rectangle(0, ObjectHeight/2, ObjectWidth, ObjectHeight-(ObjectHeight/2));
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}