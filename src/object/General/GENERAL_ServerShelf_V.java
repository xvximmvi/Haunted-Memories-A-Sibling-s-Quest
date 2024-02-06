package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_ServerShelf_V extends Entity {
    public GENERAL_ServerShelf_V(GamePanel gamePanel) {
        super(gamePanel);
        name = "ServerShelf_V";
        ObjectWidth = 32*2+16;
        ObjectHeight = 120*2+60;

        Area.width = ObjectWidth;
        Area.height = ObjectHeight/2+ObjectHeight/5;
        Area.x = 0;
        Area.y = ObjectHeight-Area.height;
        AreaDefaultX = Area.x;
        AreaDefaultY = Area.y;
        //Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}