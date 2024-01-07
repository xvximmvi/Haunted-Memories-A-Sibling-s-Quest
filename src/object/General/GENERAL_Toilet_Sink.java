package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Toilet_Sink extends Entity {
    public GENERAL_Toilet_Sink(GamePanel gamePanel) {
        super(gamePanel);
        name = "Toilet_Sink";
        ObjectWidth = 96*2+48;
        ObjectHeight = 84*2+42;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}