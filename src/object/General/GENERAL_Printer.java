package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Printer extends Entity {
    public GENERAL_Printer(GamePanel gamePanel) {
        super(gamePanel);
        name = "Printer";
        ObjectWidth = 58*2+24;
        ObjectHeight = 50*2+15;

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