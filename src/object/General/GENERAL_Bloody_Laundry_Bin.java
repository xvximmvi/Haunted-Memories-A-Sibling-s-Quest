package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Bloody_Laundry_Bin extends Entity {
    public GENERAL_Bloody_Laundry_Bin(GamePanel gamePanel) {
        super(gamePanel);
        name = "Bloody_Laundry_Bin";
        ObjectWidth = 31*2+15;
        ObjectHeight = 42*2+21;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}