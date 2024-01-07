package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Exit_Green_Light extends Entity {
    public GENERAL_Exit_Green_Light(GamePanel gamePanel) {
        super(gamePanel);
        name = "Exit_Green_Light";
        ObjectWidth = 47*2+23;
        ObjectHeight = 37*2+18;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}