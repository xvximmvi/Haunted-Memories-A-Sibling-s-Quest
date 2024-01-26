package entity;

import main.GamePanel;
import main.Utility;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

//TODO: Add new Object-Classes to the /src/Object/ directory.
// 1.   The Name of the image should be unique and understandable e.g. Chair that faces Left = "Chair_L"
// 1.1  Names usually used: Direction: Left = "_L", Right = "_R", Up = "_B", Down = "_F";
// 2.   Add image to the designated resource folder in "/resource/Objects/" e.g. "/Objects/Hospital/" for hospital objects/Items
// 3.   Copy an already existing Object-Class and Type the name of the Class:
// 3.1  Add the name of the Location/Directory before the Class-name of the Object like e.g. "HOSPITAL_Chair_L" for hospital objects.
// 3.2  The name of the objects (the "name" String in the Class) should be the same as the name of the image file. (because of setup()-Methode)
// ------------------------------------------------------------------------------------------------------------------------------------------------------------
//TODO: Add new NPC-Classes to the /src/Entity/ directory.
// 1.   The Name of the image should be unique and understandable e.g Female Doctor/Nurse Nr.1 = "Doctor_Female_1"
// 1.1  Image name need 4 direction with 3 images per direction!
// 1.2  1st image "_1":  right foot front (NPCs view); 2nd image "_2":  both feet in the middle; 3rd image "_3": left foot (NPCs view)
// 1.3  Names usually used: Direction: Left = "_Left", Right = "_Right", Up = "_Back", Down = "_Front";
// 1.4  Names should be e.g. (NPC = Female Doctor; Direction = going up; Image = 3) --> "Doctor_Female_1_Back_3"
// 2.   Add image to the designated resource folder in "/resource/NPC/" e.g. "/NPC/Hospital/" for hospital NPCs
// 3.   Copy an already existing NPC-Class and Type the name of the Class:
// 3.1  Add the kind of Entity before the Class-name of the NPC like e.g. "NPC_Chair_L" for normal NPC.
// 3.2  The name of the NPC (the "name" String in the Class) should be the same as the name of the image file without the directions. (because of setup()-Methode)
// 3.3  e.g. name = "Doctor_Female_1"
// 4.   Add Dialogues in the Dialogues()-Methode:
// 4.1  Principle should stay the same! Start with:     int i = 0;
// 4.2  Continue to add dialogues like this:            dialogues[i] = "---TEXT---";     i++;
// 4.3  Maximum Dialogues that each NPC can have is 20. If more are needed just change the Dialogue-Attributes in the Entity-Class (from 20 to any number needed)

// ABSTRACT CLASS
public class Entity {

    GamePanel gamePanel;

    // MAP COORDINATES
    public int MapX, MapY, Speed;

    // PLAYER DIRECTION & IMAGES --------------------------------------------------------------------------
    //BufferedImage: Image with an accessible buffer of image data (to store our image files)
    public BufferedImage UP1, UP2, UP3, DOWN1, DOWN2, DOWN3, LEFT1, LEFT2, LEFT3, RIGHT1, RIGHT2, RIGHT3;
    public BufferedImage HIT_UP1, HIT_UP2, HIT_DOWN1, HIT_DOWN2, HIT_LEFT1, HIT_LEFT2, HIT_RIGHT1, HIT_RIGHT2;
    public BufferedImage BLOCK_UP, BLOCK_DOWN, BLOCK_LEFT, BLOCK_RIGHT;
    public BufferedImage DEAD_1, DEAD_2;

    public String direction = "DOWN";        //direction of character moving (Default Direction: Down)

    public int spriteCounter = 0;   //count up to change position
    public int spriteNum = 2;       //number of sprite

    BufferedImage drawImage = null;


    // COLLISION ------------------------------------------------------------------------------------------
    public Rectangle Area = new Rectangle();          //Collision Area

    public int AreaDefaultX, AreaDefaultY;
    public boolean collisionPlayer = false;
    public boolean collisionOn = false;

    public int actionCounter = 0;

    public boolean untouchable = false;
    public int untouchableCounter = 0;

    // DIALOGUES ATTRIBUTES -------------------------------------------------------------------------------
    public String[][] dialogues = new String[20][20];
    public int dialogueIndex = 0;
    public int dialogueSet = 0;

    // OBJECTS ATTRIBUTES ---------------------------------------------------------------------------------
    public String name;
    public int ObjectWidth;
    public int ObjectHeight;
    public boolean collision = false;

    // ITEM ATTRIBUTES ------------------------------------------------------------------------------------
    public String description = "";

    // CHARACTER ATTRIBUTES -------------------------------------------------------------------------------
    public int FullCompletion = 56;
    Boolean[] complete = new Boolean[FullCompletion+1];
    public int maxLife, life;
    public int defaultSpeed;
    public int attack, defense;
    public boolean Boss = false;
    public boolean Snitch = false;
    public int AttackSpeed = 0;
    public BufferedImage image, image2;

    public final String CharacterName = "Simba Yamamoto";
    public final String CharacterAge = "10";
    public final String Level = "1";
    public final String Location1 = "Hospital";

    // STATE ----------------------------------------------------------------------------------------------
    public Rectangle AttackArea = new Rectangle(0, 0, 0, 0);
    public boolean Attack = false;
    public boolean Defense = false;
    public int DefenseCounter = 0;
    public boolean Alive = true;
    public boolean Dead = false;
    public int DeathCounter = 0;
    public boolean knockBack = false;
    int knockBackCounter = 0;


    public Entity(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    // PLAYER IMAGE SETUP
    public BufferedImage setup(String imagePath, int Width, int Height){
        //scale Image so that Graphics2D can skip that part and draw faster
        Utility utility = new Utility();
        BufferedImage scaledImage = null;

        try{
            scaledImage = ImageIO.read(Objects.requireNonNull(getClass().getResource(imagePath)));
            scaledImage = utility.scaleImage(scaledImage, Width, Height);

        } catch(IOException e){
            e.printStackTrace();
        }
        return scaledImage;
    }

    public void Action() {


    }
    public void Speak(){

    }

    public void startDialogue(Entity entity, int setNum){
        gamePanel.GameState = gamePanel.dialogueState;
        gamePanel.ui.NPC = entity;
        dialogueSet = setNum;
    }
    public void facePlayer(){
        switch (gamePanel.player.direction) {
            case "UP" -> direction = "DOWN";
            case "DOWN" -> direction = "UP";
            case "LEFT" -> direction = "RIGHT";
            case "RIGHT" -> direction = "LEFT";
        }
    }

    public void detectCollision() {
        collisionOn = false;
        gamePanel.collisionDetection.DetectTile(this);          // Pass this Class each NPC-Class as an Entity
        gamePanel.collisionDetection.DetectObject(this, false);
        gamePanel.collisionDetection.DetectPlayer(this);

    }

    public void update(){

        if(knockBack){
            detectCollision();

            if(collisionOn) {
                knockBackCounter = 0;
                knockBack = false;
                Speed = defaultSpeed;
            } else {
                switch (gamePanel.player.direction) {
                    case "UP" -> MapY -= Speed;
                    case "DOWN" -> MapY += Speed;
                    case "LEFT" -> MapX -= Speed;
                    case "RIGHT" -> MapX += Speed;
                }
            }

            knockBackCounter++;
            if (knockBackCounter == 4) {
                knockBackCounter = 0;
                knockBack = false;
                Speed = defaultSpeed;
            }
        }

        else if(Attack) attacking();
        else if(Defense) defending();
        else {
            defense = 0;
            Action();

            if(Boss)    AttackingDetection(30, gamePanel.tileSize*4, gamePanel.tileSize);

            detectCollision();  // Detect all Collisions

            // if Collision is false, Player can move
            if (!collisionOn) {
                switch (direction) {
                    case "UP" -> MapY -= Speed;    //if going UP -> Y-Coordinate changes (-Speed)
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

        }
        // This needs to be outside of key if statement!
        if (untouchable) {
            untouchableCounter++;
            if (untouchableCounter > 40) {
                untouchable = false;
                untouchableCounter = 0;
            }
        }
    }

    // DRAW ENTITY
    public void draw(Graphics2D graphics2D) {

        int screenX = MapX - gamePanel.player.MapX + gamePanel.player.ScreenX;
        int screenY = MapY - gamePanel.player.MapY + gamePanel.player.ScreenY;

        // STOP MOVING CAMERA
        if(gamePanel.player.MapX < gamePanel.player.ScreenX) {
            screenX = MapX;
        }
        if(gamePanel.player.MapY < gamePanel.player.ScreenY) {
            screenY = MapY;
        }
        int rightOffset = gamePanel.ScreenWidth - gamePanel.player.ScreenX;
        if(rightOffset > gamePanel.MapWidth - gamePanel.player.MapX) {
            screenX = gamePanel.ScreenWidth - (gamePanel.MapWidth - MapX);
        }
        int bottomOffset = gamePanel.ScreenHeight - gamePanel.player.ScreenY;
        if(bottomOffset > gamePanel.MapHeight - gamePanel.player.MapY) {
            screenY = gamePanel.ScreenHeight - (gamePanel.MapHeight - MapY);
        }

        if(!Dead) {
            switch (direction) {         //each possible direction
                case "UP" -> {
                    if (!Attack && !Defense) {
                        if (spriteNum == 1 || spriteNum == 3) drawImage = UP2;
                        if (spriteNum == 2) drawImage = UP1;
                        if (spriteNum == 4) drawImage = UP3;
                    } else {
                        if (Defense)    drawImage = BLOCK_UP;
                        else {
                            if (spriteNum == 1) drawImage = HIT_UP1;
                            if (spriteNum == 2) drawImage = HIT_UP2;
                        }
                    }
                }
                case "DOWN" -> {
                    if (!Attack && !Defense) {
                        if (spriteNum == 1 || spriteNum == 3) drawImage = DOWN2;
                        if (spriteNum == 2) drawImage = DOWN1;
                        if (spriteNum == 4) drawImage = DOWN3;
                    } else {
                        if (Defense) drawImage = BLOCK_DOWN;
                        else {
                            if (spriteNum == 1) drawImage = HIT_DOWN1;
                            if (spriteNum == 2) drawImage = HIT_DOWN2;
                        }
                    }
                }
                case "LEFT" -> {
                    if (!Attack && !Defense) {
                        if (spriteNum == 1 || spriteNum == 3) drawImage = LEFT2;
                        if (spriteNum == 2) drawImage = LEFT1;
                        if (spriteNum == 4) drawImage = LEFT3;
                    } else {
                        if (Defense) drawImage = BLOCK_LEFT;
                        else {
                            if (spriteNum == 1) drawImage = HIT_LEFT1;
                            if (spriteNum == 2) drawImage = HIT_LEFT2;
                        }
                    }
                }
                case "RIGHT" -> {
                    if (!Attack && !Defense) {
                        if (spriteNum == 1 || spriteNum == 3) drawImage = RIGHT2;
                        if (spriteNum == 2) drawImage = RIGHT1;
                        if (spriteNum == 4) drawImage = RIGHT3;
                    } else {
                        if (Defense) drawImage = BLOCK_RIGHT;
                        else {
                            if (spriteNum == 1) drawImage = HIT_RIGHT1;
                            if (spriteNum == 2) drawImage = HIT_RIGHT2;
                        }
                    }
                }
            }
        }

        if(untouchable) graphics2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));

        if(Dead)   DeathAnimation(graphics2D);

        if(Attack && Boss && (Objects.equals(direction, "LEFT") || Objects.equals(direction, "RIGHT")))  graphics2D.drawImage(drawImage, screenX, screenY, ObjectWidth+40, ObjectHeight, null);
        else graphics2D.drawImage(drawImage, screenX, screenY, ObjectWidth, ObjectHeight, null);

        graphics2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));

    }

    // ATTACK & DEFENSE
    public void attacking() {
        spriteCounter++;
        if (spriteCounter <= AttackSpeed)     spriteNum = 1;
        else if (spriteCounter <= AttackSpeed*2) {
            spriteNum = 2;

            // Save the current MapX, MapY, Area
            int currentMapX = MapX;
            int currentMapY = MapY;
            int AreaWidth = Area.width;
            int AreaHeight = Area.height;

            // Adjust Player's MapX/Y for the AttackArea
            switch (direction) {
                case "UP" -> MapY -= AttackArea.height;
                case "DOWN" -> MapY += AttackArea.height;
                case "LEFT" -> MapX -= AttackArea.width;
                case "RIGHT" -> MapX += AttackArea.width;
            }

            // AttackArea becomes Area
            Area.width = AttackArea.width;
            Area.height = AttackArea.height;

            /*if(Boss)
                if(Attack)
                    if(collisionPlayer)
                        damagePlayer(attack);*/

            if(!Boss) {
                // Check Enemy/NPC collision with the updated MapX, MapY and Area
                int EnemyIndex = gamePanel.collisionDetection.DetectEntity(this, gamePanel.NPC);
                gamePanel.player.damageEnemy(EnemyIndex);
            }

            // After checking collision, restore the original data
            MapX = currentMapX;
            MapY = currentMapY;
            Area.width = AreaWidth;
            Area.height = AreaHeight;
        }
        else {
            spriteNum = 1;
            spriteCounter = 0;
            if(Boss)    Attack = false;
            else        gamePanel.player.handler.ATTACK = false;
        }
    }
    public void defending() {
        int addCounter = new Random().nextInt(5);
        DefenseCounter += addCounter;

        if(DefenseCounter < 100) {
            defense = 3;
        } else {
            defense = 0;
            DefenseCounter = 0;
            Defense = false;
        }
    }

    public void damagePlayer(int attack) {

        if(!gamePanel.player.untouchable) {
            // we can give damage
            // SOUND FX
            // knockBack(gamePanel.player);

            if(Attack)  gamePanel.playSoundEffect(4);

            int damage = attack - gamePanel.player.defense;
            if(damage < 0) damage = 0;

            gamePanel.player.life -= damage;
            if(damage > 0) gamePanel.player.untouchable = true;

            if(gamePanel.player.life <= 0)  gamePanel.player.Dead = true;
        }
    }

    // FOLLOWING ENTITY
    public int getXDistance(Entity target) {
        return Math.abs(MapX - target.MapX);
    }
    public int getYDistance(Entity target) {
        return Math.abs(MapY - target.MapY);
    }


    public void AttackingDetection(int rate, int straight, int horizontal) {
        boolean targetInRange = false;
        int xDistance = getXDistance(gamePanel.player);
        int yDistance = getYDistance(gamePanel.player);

        switch(direction) {
            case "UP" -> {
                if(gamePanel.player.MapY < MapY && yDistance < straight && xDistance < horizontal) targetInRange = true;
            }
            case "DOWN" -> {
                if(gamePanel.player.MapY > MapY && yDistance < straight && xDistance < horizontal) targetInRange = true;
            }
            case "LEFT" -> {
                if(gamePanel.player.MapX < MapX && xDistance < straight && yDistance < horizontal) targetInRange = true;
            }
            case "RIGHT" -> {
                if(gamePanel.player.MapX > MapX && xDistance < straight && yDistance < horizontal) targetInRange = true;
            }
        }

        if(targetInRange) {
            // Check if it initiates an attack
            int i = new Random().nextInt(rate);
            if(i == 1){
                Attack = true;
                spriteNum = 1;
                spriteCounter = 0;
            }
            if(i == 2){
                Defense = true;
            }
        } else {
            Attack = false;
            Defense = false;
        }
    }
    public void DeathAnimation(Graphics2D graphics2D) {
        DeathCounter++;
        int i = 5;
        if(DeathCounter <= i*4) {
            changeAlpha(graphics2D, 1f);
            drawImage = DEAD_1;
        }
        if(DeathCounter > i*4 && DeathCounter <= i*8) {
            changeAlpha(graphics2D, 1f);
            drawImage = DEAD_2;
        }
        if(DeathCounter > i*8 && DeathCounter >= i*9)   changeAlpha(graphics2D, 0f);
        if(DeathCounter > i*10 && DeathCounter >= i*11) changeAlpha(graphics2D, 1f);
        if(DeathCounter > i*12 && DeathCounter >= i*13) changeAlpha(graphics2D, 0f);
        if(DeathCounter > i*14 && DeathCounter >= i*15) changeAlpha(graphics2D, 1f);
        if(DeathCounter > i*16 && DeathCounter >= i*17) changeAlpha(graphics2D, 0f);
        if(DeathCounter > i*18 && DeathCounter >= i*19) changeAlpha(graphics2D, 1f);
        if(DeathCounter > i*19 && DeathCounter >= i*20) changeAlpha(graphics2D, 0f);
        if(DeathCounter > i*20 && DeathCounter >= i*22) changeAlpha(graphics2D, 1f);
        if(DeathCounter > i*22) {
            untouchable = false;
            Dead = false;
            Alive = false;
        }
    }

    public void knockBack(Entity entity) {
        entity.direction = direction;
        entity.Speed += 10;
        entity.knockBack = true;
    }

    public void changeAlpha(Graphics2D graphics2D, float alpha) {
        graphics2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
    }

    public void searchPath(int goalCol, int goalRow) {
        int startCol = (MapX + Area.x) / gamePanel.tileSize;
        int startRow = (MapY + Area.y) / gamePanel.tileSize;

        gamePanel.pathFinder.setNodes(startCol, startRow, goalCol, goalRow, this);

        if(gamePanel.pathFinder.search()) {
            // Next MapX & MapY
            int nextX = gamePanel.pathFinder.pathList.get(0).col * gamePanel.tileSize;
            int nextY = gamePanel.pathFinder.pathList.get(0).row * gamePanel.tileSize;

            // Entity's Area position
            int entityLeftX = MapX + Area.x;
            int entityRightX = MapX + Area.x + Area.width;
            int entityTopY = MapY + Area.y;
            int entityBottomY = MapY + Area.y + Area.height;

            if(entityTopY > nextY && entityLeftX >= nextX && entityRightX < nextX + gamePanel.tileSize)
                direction = "UP";

            else if(entityTopY < nextY && entityLeftX >= nextX && entityRightX < nextX + gamePanel.tileSize)
                direction = "DOWN";

            else if(entityTopY >= nextY && entityBottomY < nextY + gamePanel.tileSize) {
                // LEFT or RIGHT
                if (entityLeftX > nextX) direction = "LEFT";
                if (entityLeftX < nextX) direction = "RIGHT";
            }

            else if(entityTopY > nextY && entityLeftX > nextX) {
                // UP or LEFT
                direction = "UP";
                detectCollision();
                if(collisionOn)     direction = "LEFT";
            }

            else if(entityTopY > nextY && entityLeftX < nextX) {
                // UP or RIGHT
                direction = "UP";
                detectCollision();
                if(collisionOn)     direction = "RIGHT";
            }

            else if(entityTopY < nextY && entityLeftX > nextX) {
                // DOWN or LEFT
                direction = "DOWN";
                detectCollision();
                if(collisionOn)     direction = "LEFT";
            }

            else if(entityTopY < nextY && entityLeftX < nextX) {
                // DOWN or RIGHT
                direction = "DOWN";
                detectCollision();
                if(collisionOn)     direction = "RIGHT";
            }

            // If reaches the goal, stop the search
            /*int nextCol = gamePanel.pathFinder.pathList.get(0).col;
            int nextRow = gamePanel.pathFinder.pathList.get(0).row;

            if(nextCol == goalCol && nextRow == goalRow)    onPath = false;*/
        }
    }

    public int getLeftX(){ return MapX + Area.x;}
    public int getRightX(){ return MapX + Area.x + Area.width;}
    public int getTopY(){ return MapY + Area.y;}
    public int getBottomY(){ return MapY + Area.y + Area.height;}
    public int getCol() {return (MapX + Area.x)/ gamePanel.tileSize;}
    public int getRow() {return (MapY + Area.y)/ gamePanel.tileSize;}


    public boolean use(Entity entity) {return false;}
    public int getDetect(Entity user, Entity[][] target, String targetName) {
        int index = 999;

        // Check the surrounding object
        int nextMapX = user.getLeftX();
        int nextMapY = user.getTopY();

        switch (user.direction) {
            case "UP" -> nextMapY = user.getTopY()-1;
            case "DOWN" -> nextMapY = user.getBottomY()+1;
            case "LEFT" -> nextMapY = user.getLeftX()-1;
            case "RIGHT" -> nextMapY = user.getRightX()+1;
        }

        int col = nextMapX / gamePanel.tileSize;
        int row = nextMapY / gamePanel.tileSize;

        for(int i = 0; i < target[1].length; i++) {
            if(target[gamePanel.currentMap][i] != null) {
                if(target[gamePanel.currentMap][i].getCol() == col &&
                        target[gamePanel.currentMap][i].getRow() == row &&
                        target[gamePanel.currentMap][i].name.equals(targetName)) {
                    index = 1;
                    break;
                }
            }
        }
        return index;
    }

}
