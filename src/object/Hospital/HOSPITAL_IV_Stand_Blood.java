package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_IV_Stand_Blood extends Entity {
    public HOSPITAL_IV_Stand_Blood(GamePanel gamePanel) {
        super(gamePanel);

        name = "IV_Stand_Blood";
        ObjectWidth = 30*2+15;
        ObjectHeight = 64*2+32;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}