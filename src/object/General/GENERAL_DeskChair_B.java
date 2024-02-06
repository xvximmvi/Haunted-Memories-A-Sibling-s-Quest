package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_DeskChair_B extends Entity {
    public GENERAL_DeskChair_B(GamePanel gamePanel) {
        super(gamePanel);
        name = "DeskChair_B";
        ObjectWidth = 19*3+9;
        ObjectHeight = 24*3+12;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}