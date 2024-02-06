package object.General;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class GENERAL_Paper_Bin_Knocked extends Entity {
    public GENERAL_Paper_Bin_Knocked(GamePanel gamePanel) {
        super(gamePanel);
        name = "Paper_Bin_Knocked";
        ObjectWidth = 48*2+24;
        ObjectHeight = 30*2+15;

        Area.width = ObjectWidth/2-20;
        Area.height = ObjectHeight-25;
        Area.x = 0;
        Area.y = 25;
        AreaDefaultX = Area.x;
        AreaDefaultY = Area.y;
        //Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        BOTTOM = true;
        collision = true;
    }
}