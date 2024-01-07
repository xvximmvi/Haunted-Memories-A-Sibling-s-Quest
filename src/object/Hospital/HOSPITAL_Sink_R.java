
package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_Sink_R extends Entity {
    public HOSPITAL_Sink_R(GamePanel gamePanel) {
        super(gamePanel);
        name = "Sink_r";
        ObjectWidth = 30*2+15;
        ObjectHeight = 126*2+63;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}