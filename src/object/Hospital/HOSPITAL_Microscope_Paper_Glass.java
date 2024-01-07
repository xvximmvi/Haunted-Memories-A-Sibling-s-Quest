package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_Microscope_Paper_Glass extends Entity {
    public HOSPITAL_Microscope_Paper_Glass(GamePanel gamePanel) {
        super(gamePanel);

        name = "Microscope_Paper_Glass";
        ObjectWidth = 41*2+20;
        ObjectHeight = 47*2+26;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
    }
}