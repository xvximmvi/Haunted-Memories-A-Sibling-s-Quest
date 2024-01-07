package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Bloody_Hand_Wall_Fall extends Entity {
    public GENERAL_Bloody_Hand_Wall_Fall(GamePanel gamePanel) {
        super(gamePanel);
        name = "Bloody_Hand_Wall_Fall";
        ObjectWidth = 12*2+6;
        ObjectHeight = 22*2+11;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}