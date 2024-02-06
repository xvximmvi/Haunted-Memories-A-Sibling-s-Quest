package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Desk_PC extends Entity {
    public GENERAL_Desk_PC(GamePanel gamePanel) {
        super(gamePanel);
        name = "Desk_PC";
        ObjectWidth = 60*3+30;
        ObjectHeight = 54*3+27;

        Area.width = ObjectWidth;
        Area.height = ObjectHeight/2+ObjectHeight/6;
        Area.x = 0;
        Area.y = ObjectHeight-Area.height;
        AreaDefaultX = Area.x;
        AreaDefaultY = Area.y;
        //Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}