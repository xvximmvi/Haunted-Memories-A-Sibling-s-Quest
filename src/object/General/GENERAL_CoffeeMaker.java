package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_CoffeeMaker extends Entity {
    public GENERAL_CoffeeMaker(GamePanel gamePanel) {
        super(gamePanel);
        name = "CoffeeMaker";
        ObjectWidth = 32*2+16;
        ObjectHeight = 64*2+32;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}