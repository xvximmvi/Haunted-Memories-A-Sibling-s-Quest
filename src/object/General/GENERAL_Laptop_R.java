package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Laptop_R extends Entity {
    public GENERAL_Laptop_R(GamePanel gamePanel) {
        super(gamePanel);
        name = "Laptop_R";
        ObjectWidth = 19*2+9;
        ObjectHeight = 41*2+20;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}