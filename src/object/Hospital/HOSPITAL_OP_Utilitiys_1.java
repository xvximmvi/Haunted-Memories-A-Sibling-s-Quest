package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_OP_Utilitiys_1 extends Entity {
    public HOSPITAL_OP_Utilitiys_1(GamePanel gamePanel) {
        super(gamePanel);
        name = "OP_Utilitys_1";
        ObjectWidth = 20*2+10;
        ObjectHeight = 15*2+7;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}