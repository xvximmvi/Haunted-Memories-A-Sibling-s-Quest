package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_Chair_F extends Entity {
    public HOSPITAL_Chair_F(GamePanel gamePanel) {
        super(gamePanel);

        name = "Chair_F";
        ObjectWidth = 24*2+12;
        ObjectHeight = 44*2+22;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}