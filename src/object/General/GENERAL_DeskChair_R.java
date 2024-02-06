package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_DeskChair_R extends Entity {
    public GENERAL_DeskChair_R(GamePanel gamePanel) {
        super(gamePanel);
        name = "DeskChair_R";
        ObjectWidth = 20*3+10;
        ObjectHeight = 32*3+16;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}