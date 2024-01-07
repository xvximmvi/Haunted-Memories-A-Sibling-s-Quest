package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Wall_Office_Deco_2 extends Entity {
    public GENERAL_Wall_Office_Deco_2(GamePanel gamePanel) {
        super(gamePanel);
        name = "Wall_Office_Deco_2";
        ObjectWidth = 60*2+30;
        ObjectHeight = 52*2+26;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}