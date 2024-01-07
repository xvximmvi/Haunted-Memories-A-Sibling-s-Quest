package object.General;

import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class GENERAL_OfficeBin extends Entity {
    public GENERAL_OfficeBin(GamePanel gamePanel) {
        super(gamePanel);
        name = "OfficeBin";
        ObjectWidth = 22*2+11;
        ObjectHeight = 32*2+16;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/General/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}