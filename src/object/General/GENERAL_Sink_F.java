package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Sink_F extends Entity {
    public GENERAL_Sink_F(GamePanel gamePanel) {
        super(gamePanel);
        name = "Sink_F";
        ObjectWidth = 25*2+12;
        ObjectHeight = 25*2+12;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}