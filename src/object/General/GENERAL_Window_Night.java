package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Window_Night extends Entity {
    public GENERAL_Window_Night(GamePanel gamePanel) {
        super(gamePanel);
        name = "Windows_Night";
        ObjectWidth = 93*2+46;
        ObjectHeight = 80*2+40;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}