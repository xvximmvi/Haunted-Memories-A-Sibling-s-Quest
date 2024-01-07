package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_Divider_Short_F extends Entity {
    public HOSPITAL_Divider_Short_F(GamePanel gamePanel){
        super(gamePanel);

        name = "Divider_Short_F";
        ObjectWidth = 32*2+16;
        ObjectHeight = 64*2+32;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}
