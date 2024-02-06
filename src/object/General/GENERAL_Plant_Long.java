package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Plant_Long extends Entity {
    public GENERAL_Plant_Long(GamePanel gamePanel) {
        super(gamePanel);
        name = "Plant_Long";
        ObjectWidth = 32*2+16;
        ObjectHeight = 86*2+43;

        Area.width = ObjectWidth;
        Area.height = ObjectHeight/2+ObjectHeight/17;
        Area.x = 0;
        Area.y = ObjectHeight-Area.height;
        AreaDefaultX = Area.x;
        AreaDefaultY = Area.y;
        //Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}