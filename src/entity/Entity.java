package entity;

import main.GamePanel;
import main.Utility;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

// ABSTRACT CLASS
public class Entity {

    GamePanel gamePanel;

    // MAP COORDINATES
    public int MapX, MapY, Speed;

    // PLAYER DIRECTION & IMAGES
    //BufferedImage: Image with an accessible buffer of image data (to store our image files)
    public BufferedImage UP1, UP2, UP3, DOWN1, DOWN2, DOWN3, LEFT1, LEFT2, LEFT3, RIGHT1, RIGHT2, RIGHT3;
    public String direction = "DOWN";        //direction of character moving (Default Direction: Down)

    public int spriteCounter = 0;   //count up to change position
    public int spriteNum = 2;       //number of sprite

    // COLLISION
    public Rectangle Area = new Rectangle(0, 44, 84, 100);          //Collision Area
    public int AreaDefaultX, AreaDefaultY;
    public boolean collisionOn = false;

    public int actionCounter = 0;

    // DIALOGUES ATTRIBUTES
    String[] dialogues = new String[20];
    int dialogueIndex = 0;

    // OBJECTS ATTRIBUTES
    public BufferedImage image;
    public String name;
    public int ObjectWidth;
    public int ObjectHeight;
    public boolean collision = false;

    // ITEM ATTRIBUTES
    public String description = "";

    // CHARACTER ATTRIBUTES
    public int FullCompletion = 56;
    Boolean[] complete = new Boolean[FullCompletion+1];

    public final String CharacterName = "Simba Yamamoto";
    public final String CharacterAge = "10";
    public final String Level = "1";
    public final String Location1 = "Hospital";


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
        if(dialogues[dialogueIndex] == null)    dialogueIndex = 0;
        gamePanel.ui.currentDialogue = dialogues[dialogueIndex];
        dialogueIndex++;

        switch (gamePanel.player.direction) {
            case "UP" -> direction = "DOWN";
            case "DOWN" -> direction = "UP";
            case "LEFT" -> direction = "RIGHT";
            case "RIGHT" -> direction = "LEFT";
        }
    }

    public void update(){
        Action();

        collisionOn = false;
        gamePanel.collisionDetection.DetectTile(this);          // Pass this Class each NPC-Class as an Entity
        gamePanel.collisionDetection.DetectObject(this, false);
        gamePanel.collisionDetection.DetectPlayer(this);


        // if Collision is false, Player can move
        if(!collisionOn) {
            switch (direction) {
                case "UP" -> MapY -= Speed;    //if going UP -> Y-Coordinate changes (-Speed)
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
    }

    // DRAW ENTITY
    public void draw(Graphics2D graphics2D) {

        BufferedImage image = null;
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

        graphics2D.drawImage(image, screenX, screenY, ObjectWidth, ObjectHeight, null);
    }

}
