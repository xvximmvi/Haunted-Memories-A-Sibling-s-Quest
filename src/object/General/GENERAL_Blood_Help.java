package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Blood_Help extends Entity {
    public GENERAL_Blood_Help(GamePanel gamePanel) {
        super(gamePanel);
        name = "Blood_Help";
        ObjectWidth = 61*2+30;
        ObjectHeight = 41*2+20;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}