package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Toilet_Sink_Water extends Entity {
    public GENERAL_Toilet_Sink_Water(GamePanel gamePanel) {
        super(gamePanel);
        name = "Toilet_Sink_Water";
        ObjectWidth = 96*2+48;
        ObjectHeight = 32*2+16;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}