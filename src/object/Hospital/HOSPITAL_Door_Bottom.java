package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_Door_Bottom extends Entity {
    public HOSPITAL_Door_Bottom(GamePanel gamePanel){
        super(gamePanel);

        name = "Door_Bottom";
        ObjectWidth = gamePanel.tileSize*2;
        ObjectHeight = gamePanel.tileSize/2;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}
