package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_IV_Stand extends Entity {
    public HOSPITAL_IV_Stand(GamePanel gamePanel) {
        super(gamePanel);

        name = "IV_Stand";
        ObjectWidth = 30*2+15;
        ObjectHeight = 64*2+32;

        Area.width = ObjectWidth;
        Area.height = ObjectHeight/2-ObjectHeight/9;
        Area.x = 0;
        Area.y = ObjectHeight-Area.height;
        AreaDefaultX = Area.x;
        AreaDefaultY = Area.y;
        //Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}