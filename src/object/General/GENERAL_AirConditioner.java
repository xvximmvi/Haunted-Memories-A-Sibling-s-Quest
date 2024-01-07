package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_AirConditioner extends Entity {
    public GENERAL_AirConditioner(GamePanel gamePanel) {
        super(gamePanel);
        name = "AirConditioner";
        ObjectWidth = 48*2+24;
        ObjectHeight = 29*2+15;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}