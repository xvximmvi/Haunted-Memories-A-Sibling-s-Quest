package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_Sink_L extends Entity {
    public HOSPITAL_Sink_L(GamePanel gamePanel) {
        super(gamePanel);
        name = "Sink_L";
        ObjectWidth = 32*2+16;
        ObjectHeight = 126*2+63;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}