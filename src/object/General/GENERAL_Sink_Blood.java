package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Sink_Blood extends Entity {
    public GENERAL_Sink_Blood(GamePanel gamePanel) {
        super(gamePanel);
        name = "Sink_Blood";
        ObjectWidth = 28*2+14;
        ObjectHeight = 56*2+28;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}