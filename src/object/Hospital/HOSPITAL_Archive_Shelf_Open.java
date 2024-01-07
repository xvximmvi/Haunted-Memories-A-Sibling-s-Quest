package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_Archive_Shelf_Open extends Entity {
    public HOSPITAL_Archive_Shelf_Open(GamePanel gamePanel) {
        super(gamePanel);

        name = "Archive_Shelf_Open";
        ObjectWidth = 62*2+31;
        ObjectHeight = 56*2+28;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}