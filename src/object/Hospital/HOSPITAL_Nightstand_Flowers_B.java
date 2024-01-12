package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_Nightstand_Flowers_B extends Entity {
    public HOSPITAL_Nightstand_Flowers_B(GamePanel gamePanel) {
        super(gamePanel);
        name = "Nightstand_Flowers_B";
        ObjectWidth = 32*2+16;
        ObjectHeight = 50*2+25;

        Area.width = ObjectWidth;
        Area.height = ObjectHeight/2+30;
        Area.x = 0;
        Area.y = ObjectHeight-Area.height;
        AreaDefaultX = Area.x;
        AreaDefaultY = Area.y;
        //Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}