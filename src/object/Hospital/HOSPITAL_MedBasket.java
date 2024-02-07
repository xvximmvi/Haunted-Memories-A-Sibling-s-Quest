package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_MedBasket extends Entity {
    public HOSPITAL_MedBasket(GamePanel gamePanel) {
        super(gamePanel);

        name = "MedBasket";
        ObjectWidth = 20*2+10;
        ObjectHeight = 20*2+10;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        TOP = true;
        collision = true;
    }
}