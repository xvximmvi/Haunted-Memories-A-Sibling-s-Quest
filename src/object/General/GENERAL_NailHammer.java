package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_NailHammer extends Entity {
    public GENERAL_NailHammer(GamePanel gamePanel) {
        super(gamePanel);
        name = "NailHammer";
        ObjectWidth = 30*2+15;
        ObjectHeight = 22*2+11;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}