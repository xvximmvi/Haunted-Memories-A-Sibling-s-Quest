package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_LaundryBasket extends Entity {
    public GENERAL_LaundryBasket(GamePanel gamePanel) {
        super(gamePanel);
        name = "LaundryBasket";
        ObjectWidth = 48*2+24;
        ObjectHeight = 43*2+21;

        Area.width = ObjectWidth;
        Area.height = ObjectHeight/2+35;
        Area.x = 0;
        Area.y = ObjectHeight-Area.height;
        AreaDefaultX = Area.x;
        AreaDefaultY = Area.y;
        //Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}