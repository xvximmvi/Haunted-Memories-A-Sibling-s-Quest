package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Sink_R extends Entity {
    public GENERAL_Sink_R(GamePanel gamePanel) {
        super(gamePanel);
        name = "Sink_R";
        ObjectWidth = 22*2+11;
        ObjectHeight = 27*2+13;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}