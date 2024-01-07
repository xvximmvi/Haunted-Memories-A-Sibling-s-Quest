package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Window_Blinds extends Entity {
    public GENERAL_Window_Blinds(GamePanel gamePanel) {
        super(gamePanel);
        name = "Window_Blinds";
        ObjectWidth = 80*2+40;
        ObjectHeight = 44*2+22;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}