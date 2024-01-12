package entity;

import main.GamePanel;

import java.awt.*;
import java.util.Random;

public class NPC_Doctor_Female_1 extends Entity{

    public NPC_Doctor_Female_1(GamePanel gamePanel) {
        super(gamePanel);

        direction = "DOWN";
        Speed = 1;

        ObjectWidth = gamePanel.tileSize+12;
        ObjectHeight = gamePanel.tileSize*2;

        Area.width = ObjectWidth;
        Area.height = ObjectHeight/2-ObjectHeight/9;
        Area.x = 0;
        Area.y = ObjectHeight-Area.height;
        AreaDefaultX = Area.x;
        AreaDefaultY = Area.y;

        NPCImage();
        Dialogues();
    }

    // PLAYER IMAGES
    public void NPCImage(){
        UP1 = setup("/NPC/Hospital/Doctor_Female_1/Doctor_Female_1_Back_1.png", gamePanel.tileSize, gamePanel.tileSize+24);
        UP2 = setup("/NPC/Hospital/Doctor_Female_1/Doctor_Female_1_Back_2.png", gamePanel.tileSize, gamePanel.tileSize+24);
        UP3 = setup("/NPC/Hospital/Doctor_Female_1/Doctor_Female_1_Back_3.png", gamePanel.tileSize, gamePanel.tileSize+24);

        DOWN1 = setup("/NPC/Hospital/Doctor_Female_1/Doctor_Female_1_Front_1.png", gamePanel.tileSize, gamePanel.tileSize+24);
        DOWN2 = setup("/NPC/Hospital/Doctor_Female_1/Doctor_Female_1_Front_2.png", gamePanel.tileSize, gamePanel.tileSize+24);
        DOWN3 = setup("/NPC/Hospital/Doctor_Female_1/Doctor_Female_1_Front_3.png", gamePanel.tileSize, gamePanel.tileSize+24);

        LEFT1 = setup("/NPC/Hospital/Doctor_Female_1/Doctor_Female_1_Left_1.png", gamePanel.tileSize, gamePanel.tileSize+24);
        LEFT2 = setup("/NPC/Hospital/Doctor_Female_1/Doctor_Female_1_Left_2.png", gamePanel.tileSize, gamePanel.tileSize+24);
        LEFT3 = setup("/NPC/Hospital/Doctor_Female_1/Doctor_Female_1_Left_3.png", gamePanel.tileSize, gamePanel.tileSize+24);

        RIGHT1 = setup("/NPC/Hospital/Doctor_Female_1/Doctor_Female_1_Right_1.png", gamePanel.tileSize, gamePanel.tileSize+24);
        RIGHT2 = setup("/NPC/Hospital/Doctor_Female_1/Doctor_Female_1_Right_2.png", gamePanel.tileSize, gamePanel.tileSize+24);
        RIGHT3 = setup("/NPC/Hospital/Doctor_Female_1/Doctor_Female_1_Right_3.png", gamePanel.tileSize, gamePanel.tileSize+24);
    }

    // NPC DIALOGUES
    public void Dialogues(){
        int i = 0;

        dialogues[i] = "This fucking NPC took me 8 hours.";     i++;
        dialogues[i] = "It does nothing but walk and talk.";     i++;
        dialogues[i] = "8 hours for walking and talking... \nStill I am so proud..";     i++;
        dialogues[i] = "Please kill me...";     i++;
        dialogues[i] = "I hate this game...";     i++;
        dialogues[i] = "I am going to kill Simba and myself when this game is done!\nI'm going to be a Real-Life Dieter A. Keller just you wait!";
    }

    // NPC ACTION
    public void Action() {

        actionCounter++;

        if(actionCounter == 120) {
            Random random = new Random();
            int i = random.nextInt(100) + 1;      //get random Number from 1 to 100 (added 1 because it picks from 0 to 99 (personal preference 1- 100)

            if (i <= 25) direction = "UP";
            if (i > 25 && i <= 50) direction = "DOWN";
            if (i > 50 && i <= 75) direction = "LEFT";
            if (i > 75) direction = "LEFT";

            actionCounter = 0;
        }

    }

    public void Speak() {
        // Do this character specific stuff

        super.Speak();
    }
}
