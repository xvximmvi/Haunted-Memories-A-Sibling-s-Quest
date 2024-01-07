package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_Tissues_Bloody extends Entity {
    public HOSPITAL_Tissues_Bloody(GamePanel gamePanel) {
        super(gamePanel);
        name = "Tissues_Bloody";
        ObjectWidth = 30*2+15;
        ObjectHeight = 20*2+10;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = false;
    }
}