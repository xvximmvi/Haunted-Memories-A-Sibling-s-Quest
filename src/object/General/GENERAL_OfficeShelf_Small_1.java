package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_OfficeShelf_Small_1 extends Entity {
    public GENERAL_OfficeShelf_Small_1(GamePanel gamePanel) {
        super(gamePanel);
        name = "OfficeShelf_Small_1";
        ObjectWidth = 48*3+24;
        ObjectHeight = 62*3+31;

        Area.width = ObjectWidth;
        Area.height = ObjectHeight/2+ObjectHeight/21;
        Area.x = 0;
        Area.y = ObjectHeight-Area.height;
        AreaDefaultX = Area.x;
        AreaDefaultY = Area.y;
        //Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}