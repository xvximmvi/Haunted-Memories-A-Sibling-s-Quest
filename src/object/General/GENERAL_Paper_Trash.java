package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Paper_Trash extends Entity {
    public GENERAL_Paper_Trash(GamePanel gamePanel) {
        super(gamePanel);
        name = "Paper_Trash";
        ObjectWidth = 26*2+13;
        ObjectHeight = 26*2+13;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        TOP = true;
        collision = false;
    }
}