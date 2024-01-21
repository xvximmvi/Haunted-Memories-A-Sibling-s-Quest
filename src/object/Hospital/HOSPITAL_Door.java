package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_Door extends Entity {
    public HOSPITAL_Door(GamePanel gamePanel){
        super(gamePanel);

        name = "Door";
        ObjectWidth = 48*2+24;
        ObjectHeight = 64*2+32;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
        setDialogue();
    }

    public void setDialogue() {
        dialogues[0][0] = "I can't leave that poor guy alone! I need to help him.";

    }
}
