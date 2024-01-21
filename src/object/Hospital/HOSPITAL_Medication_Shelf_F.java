package object.Hospital;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class HOSPITAL_Medication_Shelf_F extends Entity {

    GamePanel gamePanel;

    public HOSPITAL_Medication_Shelf_F(GamePanel gamePanel) {
        super(gamePanel);

        name = "Medication_Shelf_F";
        ObjectWidth = 56*2+28;
        ObjectHeight = 78*2+39;

        Area = new Rectangle(0, 0, ObjectWidth, ObjectHeight);
        DOWN1 = setup("/Objects/Hospital/" + name + ".png", ObjectWidth, ObjectHeight);

        collision = true;

        setDialogues();
    }

    public void setDialogues() {
        dialogues[0][0] = "Ah, yes!\nThe Anti-Depressions I need to finish this code.";
        dialogues[1][0] = "I already have enough..\nWhy would I need more?";
    }

   /* public boolean use(Entity entity) {
        gamePanel.GameState == gamePanel.dialogueState;
    }*/
}