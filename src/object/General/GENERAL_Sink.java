package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Sink extends Entity {
    public GENERAL_Sink(GamePanel gamePanel) {
        super(gamePanel);
        name = "Sink";
        ObjectWidth = 28*2+14;
        ObjectHeight = 46*2+23;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}