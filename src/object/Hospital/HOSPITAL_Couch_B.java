package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_Couch_B extends Entity {
    public HOSPITAL_Couch_B(GamePanel gamePanel) {
        super(gamePanel);

        name = "Couch_B";
        ObjectWidth = 94*2+47;
        ObjectHeight = 42*2+21;

        Area.width = ObjectWidth;
        Area.height = ObjectHeight-20;
        Area.x = 0;
        Area.y = ObjectHeight-Area.height;
        AreaDefaultX = Area.x;
        AreaDefaultY = Area.y;
        //Area = new Rectangle(0, 0, ObjectWidth-4*2-2, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}