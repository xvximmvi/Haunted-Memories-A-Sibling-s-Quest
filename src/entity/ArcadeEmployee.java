package entity;

import main.GamePanel;

import java.util.Random;

public class ArcadeEmployee extends Entity{
    public ArcadeEmployee(GamePanel gamePanel) {
        super(gamePanel);

        name = "ArcadeEmployee";


        ObjectWidth = gamePanel.tileSize+12;
        ObjectHeight = gamePanel.tileSize*2;

        Area.width = ObjectWidth;
        Area.height = ObjectHeight/2-ObjectHeight/9;
        Area.x = 0;
        Area.y = ObjectHeight-Area.height;
        AreaDefaultX = Area.x;
        AreaDefaultY = Area.y;

        AttackArea.width = gamePanel.tileSize;
        AttackArea.height = gamePanel.tileSize;

        setDefault();
        NPCImage();
        NPCFightImage();
        NPCBlockImage();
        Dialogues();
    }

    public void setDefault(){
        direction = "DOWN";
        defaultSpeed = 4;
        Speed = defaultSpeed;
        AttackSpeed = 20;
        Boss = true;

        attack = 4;
        defense = 0;

        life = 20;
    }

    // NPC IMAGES
    public void NPCImage(){
        UP1 = setup("/NPC/Arcade/"+name+"/Walking/"+name+"_Back_1.png", gamePanel.tileSize, gamePanel.tileSize+12);
        UP2 = setup("/NPC/Arcade/"+name+"/Walking/"+name+"_Back_2.png", gamePanel.tileSize, gamePanel.tileSize+12);
        UP3 = setup("/NPC/Arcade/"+name+"/Walking/"+name+"_Back_3.png", gamePanel.tileSize, gamePanel.tileSize+12);

        DOWN1 = setup("/NPC/Arcade/"+name+"/Walking/"+name+"_Front_1.png", gamePanel.tileSize, gamePanel.tileSize+12);
        DOWN2 = setup("/NPC/Arcade/"+name+"/Walking/"+name+"_Front_2.png", gamePanel.tileSize, gamePanel.tileSize+12);
        DOWN3 = setup("/NPC/Arcade/"+name+"/Walking/"+name+"_Front_3.png", gamePanel.tileSize, gamePanel.tileSize+12);

        LEFT1 = setup("/NPC/Arcade/"+name+"/Walking/"+name+"_Left_1.png", gamePanel.tileSize, gamePanel.tileSize+12);
        LEFT2 = setup("/NPC/Arcade/"+name+"/Walking/"+name+"_Left_2.png", gamePanel.tileSize, gamePanel.tileSize+12);
        LEFT3 = setup("/NPC/Arcade/"+name+"/Walking/"+name+"_Left_3.png", gamePanel.tileSize, gamePanel.tileSize+12);

        RIGHT1 = setup("/NPC/Arcade/"+name+"/Walking/"+name+"_Right_1.png", gamePanel.tileSize, gamePanel.tileSize+12);
        RIGHT2 = setup("/NPC/Arcade/"+name+"/Walking/"+name+"_Right_2.png", gamePanel.tileSize, gamePanel.tileSize+12);
        RIGHT3 = setup("/NPC/Arcade/"+name+"/Walking/"+name+"_Right_3.png", gamePanel.tileSize, gamePanel.tileSize+12);

        DEAD_1 = setup("/NPC/Arcade/"+name+"/Dead/"+name+"_Dead_1.png", gamePanel.tileSize, gamePanel.tileSize+12);
        DEAD_2 = setup("/NPC/Arcade/"+name+"/Dead/"+name+"_Dead_2.png", gamePanel.tileSize, gamePanel.tileSize+12);

    }
    public void NPCFightImage(){
        HIT_UP1 = setup("/NPC/Arcade/"+name+"/Fighting/"+name+"_Fight_Back_1.png", gamePanel.tileSize, gamePanel.tileSize+12);
        HIT_UP2 = setup("/NPC/Arcade/"+name+"/Fighting/"+name+"_Fight_Back_2.png", gamePanel.tileSize, gamePanel.tileSize+12);

        HIT_DOWN1 = setup("/NPC/Arcade/"+name+"/Fighting/"+name+"_Fight_Front_1.png", gamePanel.tileSize, gamePanel.tileSize+12);
        HIT_DOWN2 = setup("/NPC/Arcade/"+name+"/Fighting/"+name+"_Fight_Front_2.png", gamePanel.tileSize, gamePanel.tileSize+12);

        HIT_LEFT1 = setup("/NPC/Arcade/"+name+"/Fighting/"+name+"_Fight_Left_1.png", gamePanel.tileSize+40, gamePanel.tileSize+12);
        HIT_LEFT2 = setup("/NPC/Arcade/"+name+"/Fighting/"+name+"_Fight_Left_2.png", gamePanel.tileSize+40, gamePanel.tileSize+12);

        HIT_RIGHT1 = setup("/NPC/Arcade/"+name+"/Fighting/"+name+"_Fight_Right_1.png", gamePanel.tileSize+40, gamePanel.tileSize+12);
        HIT_RIGHT2 = setup("/NPC/Arcade/"+name+"/Fighting/"+name+"_Fight_Right_2.png", gamePanel.tileSize+40, gamePanel.tileSize+12);
    }
    public void NPCBlockImage(){
        BLOCK_UP = setup("/NPC/Arcade/"+name+"/Block/"+name+"_Block_Back.png", gamePanel.tileSize, gamePanel.tileSize+12);
        BLOCK_DOWN = setup("/NPC/Arcade/"+name+"/Block/"+name+"_Block_Front.png", gamePanel.tileSize, gamePanel.tileSize+12);
        BLOCK_LEFT = setup("/NPC/Arcade/"+name+"/Block/"+name+"_Block_Left.png", gamePanel.tileSize, gamePanel.tileSize+12);
        BLOCK_RIGHT = setup("/NPC/Arcade/"+name+"/Block/"+name+"_Block_Right.png", gamePanel.tileSize, gamePanel.tileSize+12);

    }
    // NPC DIALOGUES
    public void Dialogues(){

        dialogues[0][0] = "KILL ME!";

    }

    // NPC ACTION
    public void Action() {

        // FOLLOW PLAYER
        int goalCol = (gamePanel.player.MapX + gamePanel.player.Area.x) / gamePanel.tileSize;
        int goalRow = (gamePanel.player.MapY + gamePanel.player.Area.y) / gamePanel.tileSize;

        searchPath(goalCol, goalRow);

        actionCounter++;

        if (actionCounter == 120) {
            Random random = new Random();
            int i = random.nextInt(100) + 1;      //get random Number from 1 to 100 (added 1 because it picks from 0 to 99 (personal preference 1- 100)

            if (i <= 25)            direction = "UP";
            if (i > 25 && i <= 50)  direction = "DOWN";
            if (i > 50 && i <= 75)  direction = "LEFT";
            if (i > 75)             direction = "LEFT";

            actionCounter = 0;
        }
    }

    public void Speak() {
        // Do this character specific stuff

        super.Speak();
    }
}
