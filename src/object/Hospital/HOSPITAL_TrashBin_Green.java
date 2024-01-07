package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_TrashBin_Green extends Entity {
    public HOSPITAL_TrashBin_Green(GamePanel gamePanel) {
        super(gamePanel);
        name = "TrashBin_Green";
        ObjectWidth = 22*3;
        ObjectHeight = 29*3;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}