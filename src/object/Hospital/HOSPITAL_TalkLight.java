package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_TalkLight extends Entity {
    public HOSPITAL_TalkLight(GamePanel gamePanel) {
        super(gamePanel);
        name = "TalkLight";
        ObjectWidth = 28*2+14;
        ObjectHeight = 20*2+10;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}