package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_Chair_B extends Entity {
    public HOSPITAL_Chair_B(GamePanel gamePanel) {
        super(gamePanel);

        name = "Chair_B";
        ObjectWidth = 24*2+12;
        ObjectHeight = 36*2+18;

        Area.width = ObjectWidth;
        Area.height = ObjectHeight/2+10;
        Area.x = 0;
        Area.y = ObjectHeight-Area.height;
        AreaDefaultX = Area.x;
        AreaDefaultY = Area.y;

        //Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}