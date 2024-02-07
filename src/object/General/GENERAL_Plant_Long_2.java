package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Plant_Long_2 extends Entity {
    public GENERAL_Plant_Long_2(GamePanel gamePanel) {
        super(gamePanel);
        name = "Plant_Long_2";
        ObjectWidth = 32*2+16;
        ObjectHeight = 96*2+48;

        Area.width = ObjectWidth;
        Area.height = ObjectHeight/2+ObjectHeight/11;
        Area.x = 0;
        Area.y = ObjectHeight-Area.height;
        AreaDefaultX = Area.x;
        AreaDefaultY = Area.y;
        //Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}