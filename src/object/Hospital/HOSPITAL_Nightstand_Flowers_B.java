package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_Nightstand_Flowers_B extends Entity {

    GamePanel gamePanel;

    public HOSPITAL_Nightstand_Flowers_B(GamePanel gamePanel) {
        super(gamePanel);
        name = "Nightstand_Flowers_B";
        ObjectWidth = 32*2+16;
        ObjectHeight = 50*2+25;

        Area.width = ObjectWidth;
        Area.height = ObjectHeight/2+30;
        Area.x = 0;
        Area.y = ObjectHeight-Area.height;
        AreaDefaultX = Area.x;
        AreaDefaultY = Area.y;
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;

        setDialogue();
    }

    public void setDialogue() {
        dialogues[0][0] = "Seems like the nurse forgot to give him his meds today.\n Just look how sick he lies in his bed. Poor guy.";
    }

}