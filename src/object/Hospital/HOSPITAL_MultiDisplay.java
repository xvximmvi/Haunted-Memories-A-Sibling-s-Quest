package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_MultiDisplay extends Entity {
    public HOSPITAL_MultiDisplay(GamePanel gamePanel) {
        super(gamePanel);

        name = "MultiDisplay";
        ObjectWidth = 160*2+80;
        ObjectHeight = 47*2+23;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}