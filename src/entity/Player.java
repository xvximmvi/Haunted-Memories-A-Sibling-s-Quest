package entity;

import main.GamePanel;
import main.Handler;
import object.General.GENERAL_Card_2;
import object.Hospital.HOSPITAL_Medication;
import object.Hospital.HOSPITAL_Scalpel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Objects;

public class Player  extends Entity {
    Handler handler;
    public final int ScreenX, ScreenY;  //Coordinate of Screen

    int InteractionCounter=0;           //InteractionCounter: slower interaction with objects
    int ObjectCounter = 0;
    int untouchableBlink = 0;

    public ArrayList<Entity> Inventory = new ArrayList<>();
    public final int InventorySize = 20;

    // PLAYER CONSTRUCTOR
    public Player(GamePanel gamePanel, Handler handler) {
        super(gamePanel);           //Calling Constructor of the Super-Class of this Class

        this.handler = handler;

        ScreenX = gamePanel.ScreenWidth/2;      //Center of screen
        ScreenY = gamePanel.ScreenHeight/2;     //Center of screen


        Area = new Rectangle();     //create area of collision within the player character
        //4 parameter (x, y, width, height) of player character: which part of the character has collision detection
        Area.width = gamePanel.tileSize;    //48 pixels for 1 tile: is to precisely -> difficult to go through
        Area.height = 36;
        Area.x = 0;
        Area.y = gamePanel.tileSize+24-Area.height;

        //Default collision for Player Reset
        AreaDefaultX = Area.x;
        AreaDefaultY = Area.y;

        AttackArea.width = gamePanel.tileSize;
        AttackArea.height = gamePanel.tileSize;


        setDefaultValues();     //call setDefaultValues()

        // CALL IMAGES
        PlayerWalkingImage();
        PlayerFightImage();
        PlayerDeadImage();
        PlayerBlockImage();

        setItems();
        setDialogues();
    }

    public void setDefaultValues() {
        MapX = gamePanel.tileSize*13;       //Begin next to Simbas ICU Bed
        MapY = gamePanel.tileSize*18+24;

        attack = 1;
        defense = 0;
        AttackSpeed = 10;

        defaultSpeed = 5;
        Speed = defaultSpeed;
        direction = "DOWN";

        // PLAYER STATUS
        maxLife = 10;
        life = maxLife;
    }

    public void setItems() {
        Inventory.add(new HOSPITAL_Medication(gamePanel));
        Inventory.add(new HOSPITAL_Scalpel(gamePanel));
        Inventory.add(new GENERAL_Card_2(gamePanel));

    }

    // PLAYER IMAGES
    public void PlayerWalkingImage(){
        UP1 = setup("/Simba/Walking/Simba_Back_1.png", gamePanel.tileSize, gamePanel.tileSize+24);
        UP2 = setup("/Simba/Walking/Simba_Back_2.png", gamePanel.tileSize, gamePanel.tileSize+24);
        UP3 = setup("/Simba/Walking/Simba_Back_3.png", gamePanel.tileSize, gamePanel.tileSize+24);

        DOWN1 = setup("/Simba/Walking/Simba_Front_1.png", gamePanel.tileSize, gamePanel.tileSize+24);
        DOWN2 = setup("/Simba/Walking/Simba_Front_2.png", gamePanel.tileSize, gamePanel.tileSize+24);
        DOWN3 = setup("/Simba/Walking/Simba_Front_3.png", gamePanel.tileSize, gamePanel.tileSize+24);

        LEFT1 = setup("/Simba/Walking/Simba_Left_1.png", gamePanel.tileSize, gamePanel.tileSize+24);
        LEFT2 = setup("/Simba/Walking/Simba_Left_2.png", gamePanel.tileSize, gamePanel.tileSize+24);
        LEFT3 = setup("/Simba/Walking/Simba_Left_3.png", gamePanel.tileSize, gamePanel.tileSize+24);

        RIGHT1 = setup("/Simba/Walking/Simba_Right_1.png", gamePanel.tileSize, gamePanel.tileSize+24);
        RIGHT2 = setup("/Simba/Walking/Simba_Right_2.png", gamePanel.tileSize, gamePanel.tileSize+24);
        RIGHT3 = setup("/Simba/Walking/Simba_Right_3.png", gamePanel.tileSize, gamePanel.tileSize+24);
    }
    public void PlayerFightImage(){
        HIT_UP1 = setup("/Simba/Fight/Simba_Fight_Back_1.png", gamePanel.tileSize, gamePanel.tileSize+40);
        HIT_UP2 = setup("/Simba/Fight/Simba_Fight_Back_2.png", gamePanel.tileSize, gamePanel.tileSize+40);

        HIT_DOWN1 = setup("/Simba/Fight/Simba_Fight_Front_1.png", gamePanel.tileSize, gamePanel.tileSize+40);
        HIT_DOWN2 = setup("/Simba/Fight/Simba_Fight_Front_2.png", gamePanel.tileSize, gamePanel.tileSize+40);

        HIT_LEFT1 = setup("/Simba/Fight/Simba_Fight_Left_1.png", gamePanel.tileSize+40, gamePanel.tileSize+24);
        HIT_LEFT2 = setup("/Simba/Fight/Simba_Fight_Left_2.png", gamePanel.tileSize+40, gamePanel.tileSize+24);

        HIT_RIGHT1 = setup("/Simba/Fight/Simba_Fight_Right_1.png", gamePanel.tileSize+40, gamePanel.tileSize+24);
        HIT_RIGHT2 = setup("/Simba/Fight/Simba_Fight_Right_2.png", gamePanel.tileSize+40, gamePanel.tileSize+24);
    }
    public void PlayerDeadImage(){
        DEAD_1 = setup("/Simba/Dead/Simba_Dead_1.png", gamePanel.tileSize, gamePanel.tileSize+24);
        DEAD_2 = setup("/Simba/Dead/Simba_Dead_2.png", gamePanel.tileSize, gamePanel.tileSize+24);
    }
    public void PlayerBlockImage(){
        BLOCK_UP = setup("/Simba/Block/Simba_Block_Back.png", gamePanel.tileSize, gamePanel.tileSize+24);
        BLOCK_DOWN = setup("/Simba/Block/Simba_Block_Front.png", gamePanel.tileSize, gamePanel.tileSize+24);
        BLOCK_LEFT = setup("/Simba/Block/Simba_Block_Left.png", gamePanel.tileSize, gamePanel.tileSize+24);
        BLOCK_RIGHT = setup("/Simba/Block/Simba_Block_Right.png", gamePanel.tileSize, gamePanel.tileSize+24);

    }

    // UPDATE PLAYER POSITION
    public void update() {
        //update current position of player
        if(!Dead) {
            // ATTACK
            if (handler.ATTACK) {
                attacking();
                Attack = true;
            }
            if (handler.DEFENSE) defense = 2;


            if (!handler.ATTACK && !handler.DEFENSE) {
                defense = 0;
                // PLAYER DIRECTION
                if (handler.UP || handler.DOWN || handler.LEFT || handler.RIGHT) {    //move if any key is pressed
                    if (handler.UP) direction = "UP";   //if W (UP) is pressed (=true) -> change direction of position
                    if (handler.DOWN) direction = "DOWN";
                    if (handler.LEFT) direction = "LEFT";
                    if (handler.RIGHT) direction = "RIGHT";


                    // COLLISION DETECTION -------------------------------------------------------------------------------------
                    collisionOn = false;    //Default as false

                    // CHECK TILE COLLISION
                    //player Class is a subclass of the Entity class
                    gamePanel.collisionDetection.DetectTile(this);  //CollisionDetection receives Player class as Entity


                    // CHECK OBJECT COLLISION
                    int objectIndex = gamePanel.collisionDetection.DetectObject(this, true);
                    InteractionObject(objectIndex);     //interaction with object

                    // CHECK NPC COLLISION
                    int NPCIndex = gamePanel.collisionDetection.DetectEntity(this, gamePanel.NPC);
                    InteractionNPC(NPCIndex);
                    contactBoss(NPCIndex);


                    // if Collision is false, Player can move
                    if (!collisionOn) {
                        switch (direction) {
                            case "UP" -> MapY -= Speed;    //if W (going UP) is pressed -> Y-Coordinate changes (-Speed)
                            case "DOWN" -> MapY += Speed;
                            case "LEFT" -> MapX -= Speed;
                            case "RIGHT" -> MapX += Speed;
                        }
                    }

                    spriteCounter++;                //continue counting
                    if (spriteCounter > 10) {           //How fast to change (only change Sprite when number 12 has reached)
                        if (spriteNum == 1) spriteNum = 2;
                        else if (spriteNum == 2) spriteNum = 3;
                        else if (spriteNum == 3) spriteNum = 4;
                        else if (spriteNum == 4) spriteNum = 1;
                        spriteCounter = 0;          //Reset spriteCounter
                    }
                } else spriteNum = 1;               //if He stops moving -> go to basic position (Standing Position 2)
            }

            // This needs to be outside of key if statement!
            if (untouchable) {
                untouchableCounter++;
                if (untouchableCounter > 60) {
                    untouchable = false;
                    untouchableCounter = 0;
                }
            }
        }
    }


    // OBJECT INTERACTION
    public void InteractionObject(int index) {
        // Index as confirmation of collision
        if(index != 999) {   //if index isn't 999, then we haven't touched an object
            //panel.object[index] = null;     //if object is touched, then delete it -> "Pick it up"

            String ObjectName = gamePanel.object[gamePanel.currentMap][index].name;   //Which object is touched

            InteractionCounter++;       //Key-press takes to long -> interact more than once at a time
            if (InteractionCounter > 9) {  //count to 9 than do next interaction
                if (handler.INTERACT) {
                    switch (gamePanel.currentMap) {
                        case 0 -> {
                            switch (ObjectName) {
                                 case "Door" -> {
                                    //gamePanel.playSoundEffect(4);
                                    switchMap(1, 2, 25, "RIGHT");
                                }
                                case "Medication_Shelf_F" -> {
                                    gamePanel.GameState = gamePanel.dialogueState;
                                    gamePanel.ui.currentDialogue = dialogues[0];
                                    pickUpObject(new HOSPITAL_Medication(gamePanel), 0);
                                }
                            }
                        }
                        case 1 -> {
                            switch (ObjectName) {
                                case "Door_Right" -> {
                                    if (MapY > 18*gamePanel.tileSize) {
                                        //gamePanel.playSoundEffect(4);
                                        switchMap(0, 20, 10, "DOWN");
                                    } else {
                                        switchMap(3, 24, 17, "LEFT");
                                    }
                                }
                            }
                        }
                        case 3 -> {
                            switch (ObjectName) {
                                case "Door_Left" -> {
                                    switchMap(1, 2, 16, "RIGHT");
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    public void pickUpObject(Entity object, int soundFX) {
        if(Inventory.size() != InventorySize) {
            Inventory.add(object);
            //gamePanel.playSoundEffect(soundFX);
        }
    }
    public void useObject(Entity object, int soundFX) {
        Inventory.remove(object);
        //gamePanel.playSoundEffect(soundFX);
    }

    public void setDialogues(){
        int i = 0;

        // ICU
        dialogues[i]="Ah, yes!\nThe Anti-Depressions I need to finish this code.";
    }

    // NPC INTERACTION
    public void InteractionNPC(int index) {
        if(index != 999) {
            if(handler.INTERACT) {
                gamePanel.GameState = gamePanel.dialogueState;
                gamePanel.NPC[gamePanel.currentMap][index].Speak();
            }
        }
    }
    public void contactBoss(int index) {
        if(index != 999) {
            if(gamePanel.NPC[gamePanel.currentMap][index].Boss) {
                if (!untouchable) {
                    if(gamePanel.NPC[gamePanel.currentMap][index].Attack)
                        damagePlayer(gamePanel.NPC[gamePanel.currentMap][index].attack);
                    else    gamePanel.NPC[gamePanel.currentMap][index].damagePlayer(2); // If Entity is the Boss, damage Player
                }
            }
        }
    }
    public void damageEnemy(int index) {
        if(index != 999) {
            if (gamePanel.NPC[gamePanel.currentMap][index].Boss) {

                //TODO: gamePanel.playSoundEffect(soundFX);

                knockBack(gamePanel.NPC[gamePanel.currentMap][index]);

                if (!gamePanel.NPC[gamePanel.currentMap][index].untouchable) {
                    int damage = attack - gamePanel.NPC[gamePanel.currentMap][index].defense;

                    if(damage < 0) damage = 0;

                    gamePanel.NPC[gamePanel.currentMap][index].life -= damage;
                    if(damage > 0) gamePanel.NPC[gamePanel.currentMap][index].untouchable = true;

                    if (gamePanel.NPC[gamePanel.currentMap][index].life <= 0) {
                        gamePanel.NPC[gamePanel.currentMap][index].Dead = true;
                    }
                }
            } //else System.out.println("MISS!"); // DEBUG
        }
    }




    public void draw(Graphics2D graphics2d) {
        //draw object with current information

        // Prototype Character (Just white Block)
        //graphics2d.setColor(Color.WHITE);
        //graphics2d.fillRect(MapX,MapY,gamePanel.tileSize,gamePanel.tileSize);


        // DRAW SPRITE IMAGE
        BufferedImage image = null;
        if(!Dead) {
            switch (direction) {         //each possible direction
                case "UP" -> {
                    if (!handler.ATTACK && !handler.DEFENSE) {
                        if (spriteNum == 1 || spriteNum == 3) drawImage = UP2;
                        if (spriteNum == 2) drawImage = UP1;
                        if (spriteNum == 4) drawImage = UP3;
                    } else {
                        if (handler.DEFENSE) drawImage = BLOCK_UP;
                        else {
                            if (spriteNum == 1) drawImage = HIT_UP1;
                            if (spriteNum == 2) drawImage = HIT_UP2;
                        }
                    }
                }
                case "DOWN" -> {
                    if (!handler.ATTACK && !handler.DEFENSE) {
                        if (spriteNum == 1 || spriteNum == 3) drawImage = DOWN2;
                        if (spriteNum == 2) drawImage = DOWN1;
                        if (spriteNum == 4) drawImage = DOWN3;
                    } else {
                        if (handler.DEFENSE) drawImage = BLOCK_DOWN;
                        else {
                            if (spriteNum == 1) drawImage = HIT_DOWN1;
                            if (spriteNum == 2) drawImage = HIT_DOWN2;
                        }
                    }
                }
                case "LEFT" -> {
                    if (!handler.ATTACK && !handler.DEFENSE) {
                        if (spriteNum == 1 || spriteNum == 3) drawImage = LEFT2;
                        if (spriteNum == 2) drawImage = LEFT1;
                        if (spriteNum == 4) drawImage = LEFT3;
                    } else {
                        if (handler.DEFENSE) drawImage = BLOCK_LEFT;
                        else {
                            if (spriteNum == 1) drawImage = HIT_LEFT1;
                            if (spriteNum == 2) drawImage = HIT_LEFT2;
                        }
                    }
                }
                case "RIGHT" -> {
                    if (!handler.ATTACK && !handler.DEFENSE) {
                        if (spriteNum == 1 || spriteNum == 3) drawImage = RIGHT2;
                        if (spriteNum == 2) drawImage = RIGHT1;
                        if (spriteNum == 4) drawImage = RIGHT3;
                    } else {
                        if (handler.DEFENSE) drawImage = BLOCK_RIGHT;
                        else {
                            if (spriteNum == 1) drawImage = HIT_RIGHT1;
                            if (spriteNum == 2) drawImage = HIT_RIGHT2;
                        }
                    }
                }
            }
        }

        /// STOP SCREEN AT EDGE OF MAP
        int x = ScreenX;
        int y = ScreenY;

        //Left Side / Top Side of Map
        if(ScreenX > MapX)  //If Screen at the edge of Map -> Player no more in center of Map
            x = MapX;       //Player Position is new Map Position instead of Screen Position
        if(ScreenY > MapY)
            y = MapY;


        //Right Side / Bottom Side of Map (same as in Manager Class)
        int RightOffset = gamePanel.ScreenWidth - ScreenX;
        if(RightOffset > gamePanel.MapWidth - MapX)
            x = gamePanel.ScreenWidth - (gamePanel.MapWidth - MapX);

        int BottomOffset = gamePanel.ScreenHeight - ScreenY;
        if(BottomOffset > gamePanel.MapHeight - MapY)
            y = gamePanel.ScreenHeight - (gamePanel.MapHeight - MapY);

        if(untouchable) graphics2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));

        if(Dead)   DeathAnimation(graphics2d);


        //ScreenX and ScreenY don't change
        graphics2d.drawImage(drawImage, x, y, null);    //null: image observer  +8 to make character bigger
        graphics2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));

    }

    // SWITCH ROOMS/MAPS
    public void switchMap(int Map, int x, int y, String direction) {
        gamePanel.TransitionMap = Map;
        gamePanel.TransitionX = x;
        gamePanel.TransitionY = y;
        gamePanel.TransitionDirection = direction;
        gamePanel.GameState = gamePanel.transitionState;
    }


}
