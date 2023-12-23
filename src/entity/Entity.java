package entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

    // MAP COORDINATES
    public int MapX, MapY, Speed;

    // PLAYER DIRECTION & IMAGES
    //BufferedImage: Image with an accessible buffer of image data (to store our image files)
    public BufferedImage UP1, UP2, UP3, DOWN1, DOWN2, DOWN3, LEFT1, LEFT2, LEFT3, RIGHT1, RIGHT2, RIGHT3;
    public String direction;        //direction of character moving

    public int spriteCounter = 0;   //count up to change position
    public int spriteNum = 1;       //number of sprite
    public int InteractionSpriteCounter = 0;
    public int InteractionSpriteNum = 1;

    // COLLISION
    public Rectangle Area;          //Collision Area
    public int AreaDefaultX, AreaDefaultY;
    public boolean collisionOn = false;

}
