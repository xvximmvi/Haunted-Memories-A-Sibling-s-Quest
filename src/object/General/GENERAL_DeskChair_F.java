package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_DeskChair_F extends Entity {
    public GENERAL_DeskChair_F(GamePanel gamePanel) {
        super(gamePanel);
        name = "DeskChair_F";
        ObjectWidth = 19*2+9;
        ObjectHeight = 30*2+15;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}