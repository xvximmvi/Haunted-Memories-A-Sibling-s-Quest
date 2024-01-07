package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Paper_Trash_Bloody extends Entity {
    public GENERAL_Paper_Trash_Bloody(GamePanel gamePanel) {
        super(gamePanel);
        name = "Paper_Trash_Bloody";
        ObjectWidth = 31*2+15;
        ObjectHeight = 26*2+13;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}