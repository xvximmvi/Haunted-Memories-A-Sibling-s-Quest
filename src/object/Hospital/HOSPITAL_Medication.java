package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_Medication extends Entity {

    GamePanel gamePanel;

    public HOSPITAL_Medication(GamePanel gamePanel) {
        super(gamePanel);

        this.gamePanel = gamePanel;

        name = "Medication";
        ObjectWidth = 23*2+12;
        ObjectHeight = 18*2+9;

        description = "[" + name + "]\nA medicine or a chemical\ncompound used to treat\nor cure illness.";

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;
        setDialogue();
    }

    public void setDialogue() {
        dialogues[0][0] = "He needs it more than me!";
        dialogues[1][0] = "Wtf are you doing with your life?\nSo desperate and sad that you try to overdose me?\nPathetic.";
    }

    public boolean use(Entity entity) {

        int objectIndex = getDetect(entity, gamePanel.object, "Nightstand_Flowers_B");

        if (objectIndex != 999) {
            startDialogue(this,0);
            gamePanel.player.GiveMeds = true;
            return true;
        } else {
            startDialogue(this, 1);
            return false;
        }
    }
}