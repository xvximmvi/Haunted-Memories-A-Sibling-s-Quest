package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Plant_Long_3 extends Entity {
    public GENERAL_Plant_Long_3(GamePanel gamePanel) {
        super(gamePanel);
        name = "Plant_Long_3";
        ObjectWidth = 47*3+23;
        ObjectHeight = 91*3+45;

        Area.width = ObjectWidth;
        Area.height = ObjectHeight/2+65;
        Area.x = 0;
        Area.y = ObjectHeight-Area.height;
        AreaDefaultX = Area.x;
        AreaDefaultY = Area.y;
        //Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}