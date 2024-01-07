package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_Chair_R extends Entity {
    public HOSPITAL_Chair_R(GamePanel gamePanel) {
        super(gamePanel);

        name = "Chair_R";
        ObjectWidth = 24*2+12;
        ObjectHeight = 42*2+21;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}