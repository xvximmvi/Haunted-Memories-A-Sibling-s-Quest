package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Laptop_L extends Entity {
    public GENERAL_Laptop_L(GamePanel gamePanel) {
        super(gamePanel);
        name = "Laptop_L";
        ObjectWidth = 19*3+9;
        ObjectHeight = 41*3+20;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        TOP = true;
        collision = false;
    }
}