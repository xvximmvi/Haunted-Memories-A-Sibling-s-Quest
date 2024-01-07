package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_Table extends Entity {
    public HOSPITAL_Table(GamePanel gamePanel) {
        super(gamePanel);
        name = "Table";
        ObjectWidth = 64*2+32;
        ObjectHeight = 39*2+19;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}