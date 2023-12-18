package entity;

import main.GamePanel;
import main.Handler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player  extends Entity {
    GamePanel gamePanel;
    Handler handler;

    // PLAYER CONSTRUCTOR
    public Player(GamePanel gamePanel, Handler handler) {
        this.gamePanel = gamePanel;
        this.handler = handler;

        setDefaultValues();     //call setDefaultValues()
        playerImage();              //call playerImage()
    }

    public void setDefaultValues() {
        MapX = gamePanel.ScreenWidth/2 - gamePanel.tileSize/2;
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
        //scale Image so that Graphics2D can skip that part and draw fasterBufferedImage scaledImage = null;

        BufferedImage scaledImage = null;

        try{
            scaledImage = ImageIO.read(Objects.requireNonNull(getClass().getResource("/Simba/Walking/" + imageName + ".png")));
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


            switch (direction) {
                case "UP" -> MapY -= Speed;    //if W (going UP) is pressed -> Y-Coordinate changes (-Speed)
                case "DOWN" -> MapY += Speed;
                case "LEFT" -> MapX -= Speed;
                case "RIGHT" -> MapX += Speed;
            }

            spriteCounter++;    //continue counting
            if(spriteCounter>12){            //How fast to change (only change Sprite when number 12 has reached)
                if (spriteNum ==2)          spriteNum = 1;
                else if (spriteNum == 1)    spriteNum = 3;
                else if (spriteNum == 3)    spriteNum = 1;
                spriteCounter = 0;          //Reset spriteCounter
            }
        } else spriteNum = 2;               //if He stops moving -> go to basic position (Standing Position 2)

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
                if (spriteNum == 1) image = UP1;
                if (spriteNum == 2) image = UP2;
                if (spriteNum == 3) image = UP3;
            }
            case "DOWN" -> {
                if (spriteNum == 1) image = DOWN1;
                if (spriteNum == 2) image = DOWN2;
                if (spriteNum == 3) image = DOWN3;
            }
            case "LEFT" -> {
                if (spriteNum == 1) image = LEFT1;
                if (spriteNum == 2) image = LEFT2;
                if (spriteNum == 3) image = LEFT3;
            }
            case "RIGHT" -> {
                if (spriteNum == 1) image = RIGHT1;
                if (spriteNum == 2) image = RIGHT2;
                if (spriteNum == 3) image = RIGHT3;
            }
        }

        //ScreenX and ScreenY don't change
        graphics2d.drawImage(image, MapX, MapY, gamePanel.tileSize, gamePanel.tileSize, null);    //null: image observer  +8 to make character bigger

    }

}
