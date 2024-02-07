package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Table_Big_White extends Entity {
    public GENERAL_Table_Big_White(GamePanel gamePanel) {
        super(gamePanel);
        name = "Table_Big_White";
        ObjectWidth = 96*2+48;
        ObjectHeight = 84*2+42;

        Area.width = ObjectWidth;
        Area.height = ObjectHeight-20;
        Area.x = 0;
        Area.y = 20;
        AreaDefaultX = Area.x;
        AreaDefaultY = Area.y;
        //Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}