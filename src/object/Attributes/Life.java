package object.Attributes;

import entity.Entity;
import main.GamePanel;

public class Life extends Entity {
    public Life(GamePanel gamePanel) {
        super(gamePanel);
        name = "Life";
        ObjectWidth = 16+8;
        ObjectHeight = 32+16;

        image = setup("/Attributes/" + name + "_Full.png", ObjectWidth, ObjectHeight);
        image2 = setup("/Attributes/" + name + "_Lost.png", ObjectWidth, ObjectHeight);
    }
}