package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_TrashBin_Red extends Entity {
    public HOSPITAL_TrashBin_Red(GamePanel gamePanel) {
        super(gamePanel);
        name = "TrashBin_Red";
        ObjectWidth = 26*3;
        ObjectHeight = 31*3;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}