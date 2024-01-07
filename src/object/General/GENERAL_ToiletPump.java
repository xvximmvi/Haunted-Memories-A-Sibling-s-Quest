package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_ToiletPump extends Entity {
    public GENERAL_ToiletPump(GamePanel gamePanel) {
        super(gamePanel);
        name = "ToiletPump";
        ObjectWidth = 12*2+6;
        ObjectHeight = 26*2+13;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}