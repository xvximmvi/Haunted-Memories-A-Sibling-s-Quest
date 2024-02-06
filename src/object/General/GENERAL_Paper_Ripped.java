package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Paper_Ripped extends Entity {
    public GENERAL_Paper_Ripped(GamePanel gamePanel) {
        super(gamePanel);
        name = "Paper_Ripped";
        ObjectWidth = 28*2+14;
        ObjectHeight = 26*2+13;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = false;
    }
}