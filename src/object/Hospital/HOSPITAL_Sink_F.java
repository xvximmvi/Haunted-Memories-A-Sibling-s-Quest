package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_Sink_F extends Entity {
    public HOSPITAL_Sink_F(GamePanel gamePanel) {
        super(gamePanel);
        name = "Sink_F";
        ObjectWidth = 128*2+64;
        ObjectHeight = 76*2+38;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}