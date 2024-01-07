package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Toilet_Cabin extends Entity {
    public GENERAL_Toilet_Cabin(GamePanel gamePanel) {
        super(gamePanel);
        name = "Toilet_Cabin";
        ObjectWidth = 84*2+42;
        ObjectHeight = 96*2+48;

        Area = new Rectangle(0, 0, ObjectWidth-14*2-7, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}