package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_Labor_Big_Glas_Broken extends Entity {
    public HOSPITAL_Labor_Big_Glas_Broken(GamePanel gamePanel) {
        super(gamePanel);

        name = "Labor_Big_Glas";
        ObjectWidth = 32*2+16;
        ObjectHeight = 96*2+48;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}