package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Food_2 extends Entity {
    public GENERAL_Food_2(GamePanel gamePanel) {
        super(gamePanel);
        name = "Food_2";
        ObjectWidth = 29*3+14;
        ObjectHeight = 31*3+15;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        TOP = true;
        collision = true;
    }
}