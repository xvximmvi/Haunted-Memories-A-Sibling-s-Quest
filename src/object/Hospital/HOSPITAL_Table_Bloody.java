package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_Table_Bloody extends Entity {
    public HOSPITAL_Table_Bloody(GamePanel gamePanel) {
        super(gamePanel);
        name = "Table_Bloody";
        ObjectWidth = 64*2+32;
        ObjectHeight = 49*2+25;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}