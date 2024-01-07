package object.Hospital;

import entity.Entity;
import main.GamePanel;
import java.awt.*;

public class HOSPITAL_Doctor_Wall_Deco extends Entity {
    public HOSPITAL_Doctor_Wall_Deco(GamePanel gamePanel) {
        super(gamePanel);

        name = "Doctor_Wall_Deco";
        ObjectWidth = 62*2+31;
        ObjectHeight = 56*2+28;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}