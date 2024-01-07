package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_CCTV_R extends Entity {
    public GENERAL_CCTV_R(GamePanel gamePanel) {
        super(gamePanel);
        name = "CCTV_R";
        ObjectWidth = 31*2+15;
        ObjectHeight = 35*2+17;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}