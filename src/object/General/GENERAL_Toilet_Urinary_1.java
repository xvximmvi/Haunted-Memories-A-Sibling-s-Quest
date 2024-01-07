package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Toilet_Urinary_1 extends Entity {
    public GENERAL_Toilet_Urinary_1(GamePanel gamePanel) {
        super(gamePanel);
        name = "Toilet_Urinary_1";
        ObjectWidth = 24*2+12;
        ObjectHeight = 70*2+35;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}