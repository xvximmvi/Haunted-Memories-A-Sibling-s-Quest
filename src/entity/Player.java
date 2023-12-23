package entity;

import main.GamePanel;
import main.Handler;
import main.Utility;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player  extends Entity {
    GamePanel gamePanel;
    Handler handler;
    public final int ScreenX, ScreenY;  //Coordinate of Screen

    // PLAYER CONSTRUCTOR
    public Player(GamePanel gamePanel, Handler handler) {
        this.gamePanel = gamePanel;
        this.handler = handler;

        ScreenX = gamePanel.ScreenWidth/2;      //Center of screen
        ScreenY = gamePanel.ScreenHeight/2;     //Center of screen


        Area = new Rectangle();     //create area of collision within the player character
        //4 parameter (x, y, width, height) of player character: which part of the character has collision detection
        Area.x = 0;
        Area.y = 60;
        Area.width = gamePanel.tileSize;    //48 pixels for 1 tile: is to precisely -> difficult to go through
        Area.height = 36;

        setDefaultValues();     //call setDefaultValues()
        playerImage();              //call playerImage()
    }

    public void setDefaultValues() {
        MapX = gamePanel.ScreenWidth/2 - gamePanel.tileSize/2;  //Middle of Map (for starters)
        MapY = gamePanel.ScreenHeight/2 - gamePanel.tileSize/2;
        Speed = 5;
        direction = "DOWN";
    }

    // PLAYER IMAGES
    public void playerImage(){
        UP1 = setup("Simba_Back_1");
        UP2 = setup("Simba_Back_2");
        UP3 = setup("Simba_Back_3");

        DOWN1 = setup("Simba_Front_1");
        DOWN2 = setup("Simba_Front_2");
        DOWN3 = setup("Simba_Front_3");

        LEFT1 = setup("Simba_Left_1");
        LEFT2 = setup("Simba_Left_2");
        LEFT3 = setup("Simba_Left_3");

        RIGHT1 = setup("Simba_Right_1");
        RIGHT2 = setup("Simba_Right_2");
        RIGHT3 = setup("Simba_Right_3");
    }

    // PLAYER IMAGE SETUP
    public BufferedImage setup(String imageName){
        //scale Image so that Graphics2D can skip that part and draw faster
        Utility utility = new Utility();
        BufferedImage scaledImage = null;

        try{
            scaledImage = ImageIO.read(Objects.requireNonNull(getClass().getResource("/Simba/Walking/" + imageName + ".png")));
            scaledImage = utility.scaleImage(scaledImage, gamePanel.tileSize, gamePanel.tileSize+24);

        } catch(IOException e){
            e.printStackTrace();
        }
        return scaledImage;
    }

    // UPDATE PLAYER POSITION
    public void update() {
        //update current position of player

        // PLAYER DIRECTION
        if(handler.UP || handler.DOWN || handler.LEFT || handler.RIGHT){    //move if any key is pressed
            if(handler.UP)      direction = "UP";   //if W (UP) is pressed (=true) -> change direction of position
            if(handler.DOWN)    direction = "DOWN";
            if(handler.LEFT)    direction = "LEFT";
            if(handler.RIGHT)   direction = "RIGHT";

            // CHECK TILE COLLISION
            collisionOn = false;    //Default as false
            //player Class is a subclass of the Entity class
            gamePanel.collisionDetection.DetectTile(this);  //CollisionDetection receives Player class as Entity


            // CHECK OBJECT COLLISION
            //int objectIndex = gamePanel.collisionDetection.DetectObject(this, true);
            //Interaction(objectIndex);     //interaction with object

            // if Collision is false, Player can move
            if(!collisionOn) {
                switch (direction) {
                    case "UP" -> MapY -= Speed;    //if W (going UP) is pressed -> Y-Coordinate changes (-Speed)
                    case "DOWN" -> MapY += Speed;
                    case "LEFT" -> MapX -= Speed;
                    case "RIGHT" -> MapX += Speed;
                }
            }

            spriteCounter++;                //continue counting
            if(spriteCounter>10){           //How fast to change (only change Sprite when number 12 has reached)
                if (spriteNum == 1)         spriteNum = 2;
                else if (spriteNum == 2)    spriteNum = 3;
                else if (spriteNum == 3)    spriteNum = 4;
                else if (spriteNum == 4)    spriteNum = 1;
                spriteCounter = 0;          //Reset spriteCounter
            }
        } else spriteNum = 1;               //if He stops moving -> go to basic position (Standing Position 2)

    }

    public void draw(Graphics2D graphics2d) {
        //draw object with current information

        // Prototype Character (Just white Block)
        //graphics2d.setColor(Color.WHITE);
        //graphics2d.fillRect(MapX,MapY,gamePanel.tileSize,gamePanel.tileSize);


        // DRAW SPRITE IMAGE
        BufferedImage image = null;

        switch (direction) {         //each possible direction
            case "UP" -> {
                if (spriteNum == 1 || spriteNum == 3) image = UP2;
                if (spriteNum == 2) image = UP1;
                if (spriteNum == 4) image = UP3;
            }
            case "DOWN" -> {
                if (spriteNum == 1 || spriteNum == 3) image = DOWN2;
                if (spriteNum == 2) image = DOWN1;
                if (spriteNum == 4) image = DOWN3;
            }
            case "LEFT" -> {
                if (spriteNum == 1 || spriteNum == 3) image = LEFT2;
                if (spriteNum == 2) image = LEFT1;
                if (spriteNum == 4) image = LEFT3;
            }
            case "RIGHT" -> {
                if (spriteNum == 1 || spriteNum == 3) image = RIGHT2;
                if (spriteNum == 2) image = RIGHT1;
                if (spriteNum == 4) image = RIGHT3;
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

        //ScreenX and ScreenY don't change
        graphics2d.drawImage(image, x, y, null);    //null: image observer  +8 to make character bigger
    }
}
