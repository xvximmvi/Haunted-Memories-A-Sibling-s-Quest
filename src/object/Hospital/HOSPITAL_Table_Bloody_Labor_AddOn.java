package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_Table_Bloody_Labor_AddOn extends Entity {
    public HOSPITAL_Table_Bloody_Labor_AddOn(GamePanel gamePanel) {
        super(gamePanel);
        name = "Table_Bloody_Labor_AddOn";
        ObjectWidth = 64*2+32;
        ObjectHeight = 25*2+12;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}