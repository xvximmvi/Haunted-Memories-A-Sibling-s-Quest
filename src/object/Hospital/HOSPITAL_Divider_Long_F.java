package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_Divider_Long_F extends Entity {
    public HOSPITAL_Divider_Long_F(GamePanel gamePanel){
        super(gamePanel);

        name = "Divider_Long_F";
        ObjectWidth = 60*2+30;
        ObjectHeight = 64*2+32;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}
