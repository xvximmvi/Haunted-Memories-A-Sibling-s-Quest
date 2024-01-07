package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Laundry_Bin extends Entity {
    public GENERAL_Laundry_Bin(GamePanel gamePanel) {
        super(gamePanel);
        name = "Laundry_Bin";
        ObjectWidth = 30*2+15;
        ObjectHeight = 40*2+20;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}