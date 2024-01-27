package main;

// CLASS CONTENT
/*
    COLLISION DETECTION
        - Constructor
        -Receive from Panel

    TILE DETECTION
        - Find Coordinates of Collision Area
        - Check if Tile & Player/NPC Area collide
        - CollisionOn -> used in Player/NPC Class

    OBJECT DETECTION
        - Set index
        - Scan current object's area
        - get entity's and object's collision area position
        - Check if Entity (Player/NPC) and Object are touching (Intersection)
        - Return Index (if Player is Colliding) - if NPC we just stop it from moving there

    NPC DETECTION
        - Set index
        - Scan current object's area
        - get entity's and target's collision area position
        - Check if NPC is touching anything
        - Return Index

    PLAYER DETECTION
        - Find Coordinates of Collision Area
        - Check if Player and NPC Area collide
        - CollisionOn -> used in NPC Class
 */

import entity.Entity;

import java.awt.*;

public class CollisionDetection {
    GamePanel panel;

    //COLLISION DETECTION
    public CollisionDetection(GamePanel panel){
        this.panel = panel;
    }

    // TILE DETECTION
    public void DetectTile(Entity entity){
        /*not Player! Entity
        //use methode to check not only player but also Enemy's, NPCs, ...
        1. need to know Map-position of collision Area (not player position)
        Area.x = 8;
        Area.y = 16;
        Area.width = 32;
        Area.height = 32;*/

        int CollisionLeft = entity.MapX + entity.Area.x;
        int CollisionRight = entity.MapX + entity.Area.x + entity.Area.width;
        int CollisionTop = entity.MapY + entity.Area.y;
        int CollisionBottom = entity.MapY + entity.Area.y + entity.Area.height;

        //find coordinates based on tiles   -> Column & Row numbers
        int LeftCol = CollisionLeft/panel.tileSize; //collision in px divided with tileSize
        int RightCol = CollisionRight/panel.tileSize;
        int TopRow = CollisionTop/panel.tileSize;
        int BottomRow = CollisionBottom/panel.tileSize;

        int tileNum1, tileNum2;

        switch (entity.direction) {
            case "UP" -> {
                TopRow = (CollisionTop - entity.Speed) / panel.tileSize;  //-Speed: predict where player will be next
                tileNum1 = panel.manager.mapTilesNum[panel.currentMap][LeftCol][TopRow];  //TopLeft Corner of collision
                tileNum2 = panel.manager.mapTilesNum[panel.currentMap][RightCol][TopRow]; //TopRight Corner of collision
                if (panel.manager.tile[tileNum1].collision || panel.manager.tile[tileNum2].collision)   //if either of the corners (one or both) hit the wall
                    entity.collisionOn = true;
            }
            case "DOWN" -> {
                BottomRow = (CollisionBottom + entity.Speed) / panel.tileSize;
                tileNum1 = panel.manager.mapTilesNum[panel.currentMap][LeftCol][BottomRow];
                tileNum2 = panel.manager.mapTilesNum[panel.currentMap][RightCol][BottomRow];
                if (panel.manager.tile[tileNum1].collision || panel.manager.tile[tileNum2].collision)
                    entity.collisionOn = true;
            }
            case "LEFT" -> {
                LeftCol = (CollisionLeft - entity.Speed) / panel.tileSize;
                tileNum1 = panel.manager.mapTilesNum[panel.currentMap][LeftCol][TopRow];
                tileNum2 = panel.manager.mapTilesNum[panel.currentMap][LeftCol][BottomRow];
                if (panel.manager.tile[tileNum1].collision || panel.manager.tile[tileNum2].collision)
                    entity.collisionOn = true;
            }
            case "RIGHT" -> {
                RightCol = (CollisionRight + entity.Speed) / panel.tileSize;
                tileNum1 = panel.manager.mapTilesNum[panel.currentMap][RightCol][TopRow];
                tileNum2 = panel.manager.mapTilesNum[panel.currentMap][RightCol][BottomRow];
                if (panel.manager.tile[tileNum1].collision || panel.manager.tile[tileNum2].collision)
                    entity.collisionOn = true;
            }
        }
    }

    // OBJECT DETECTION
    public int DetectObject(Entity entity, boolean player){     //Player or NPCs
        int objectIndex = 999;        //If Player is touching Object -> we return Index (can be any number)

        // Reason for "panel.object[2].length;" and its Number "2": IDK. It won't fucking work without it. Kill me.
        for(int i = 0; i < panel.object[2].length; i++){   //scan current object's Area
            if(panel.object[panel.currentMap][i] != null){                //Check if it is null -> if not than continue

                //get entity's collision area position
                entity.Area.x = entity.MapX + entity.Area.x;
                entity.Area.y = entity.MapY + entity.Area.y;

                //get the object's collision area position
                panel.object[panel.currentMap][i].Area.x = panel.object[panel.currentMap][i].MapX + panel.object[panel.currentMap][i].Area.x; //no need for coordinates like in TileDetection
                panel.object[panel.currentMap][i].Area.y = panel.object[panel.currentMap][i].MapY + panel.object[panel.currentMap][i].Area.y;

                if(!entity.still || !player) {
                    switch (entity.direction) {
                        case "UP" -> {
                            entity.Area.y -= entity.Speed;      //when going UP -> Y-Coordinate - Speed (4 px)

                            //automatically checks if entity.Area & panel.object[panel.currentMap][i].Area have intersection
                            if (entity.Area.intersects(panel.object[panel.currentMap][i].Area)) {     //A intersection B
                                if (panel.object[panel.currentMap][i].collision)  //collision == true -> if Object is solid (has collision Area)...
                                    entity.collisionOn = true;  //then collision is happening

                                if (player)                     //player == true (player from boolean)
                                    objectIndex = i;                  //if it is player, we return the index, if it is an NPC we ignore
                            }
                        }
                        case "DOWN" -> {
                            entity.Area.y += entity.Speed;
                            if (entity.Area.intersects(panel.object[panel.currentMap][i].Area)) {
                                if (panel.object[panel.currentMap][i].collision) {  //collision == true
                                    entity.collisionOn = true;
                                }
                                if (player) {                     //player == true
                                    objectIndex = i;
                                }
                            }
                        }
                        case "LEFT" -> {
                            entity.Area.x -= entity.Speed;
                            if (entity.Area.intersects(panel.object[panel.currentMap][i].Area)) {
                                if (panel.object[panel.currentMap][i].collision) {  //collision == true
                                    entity.collisionOn = true;
                                }
                                if (player) {                     //player == true
                                    objectIndex = i;
                                }
                            }
                        }
                        case "RIGHT" -> {
                            entity.Area.x += entity.Speed;
                            if (entity.Area.intersects(panel.object[panel.currentMap][i].Area)) {
                                if (panel.object[panel.currentMap][i].collision) {  //collision == true
                                    entity.collisionOn = true;
                                }
                                if (player) {                     //player == true
                                    objectIndex = i;
                                }
                            }
                        }
                    }
                }//This methode works better on objects than tiles, because there are to many tiles and just a few objects.
                  //If we'd use this method and check every tile for each direction, it would take more time and can cause problems

                else {
                    // Check for nearby objects when standing still
                    if (isNearObject(entity, panel.object[panel.currentMap][i])) {
                        if (player) {
                            objectIndex = i;
                        }
                    }
                }

                    //reset Areas -> otherwise entity.MapX and entity.MapY keep increasing
                entity.Area.x = entity.AreaDefaultX;
                entity.Area.y = entity.AreaDefaultY;
                panel.object[panel.currentMap][i].Area.x = panel.object[panel.currentMap][i].AreaDefaultX;
                panel.object[panel.currentMap][i].Area.y = panel.object[panel.currentMap][i].AreaDefaultY;
            }
        }
        return objectIndex;       //return index
    }

    private boolean isNearObject(Entity entity, Entity object) {
        int proximity = 5; // Adjust this value based on how close you want to check

        // Create an expanded area around the player's current area
        Rectangle expandedArea = new Rectangle(entity.Area);
        expandedArea.grow(proximity, proximity);

        // Check if the expanded area intersects with the object's area
        return expandedArea.intersects(object.Area);
    }

    // NPC DETECTION
    public int DetectEntity(Entity entity, Entity[][] target){
        int entityIndex = 999;        //If Player is touching Entity -> we return Index (can be any number)

        for(int i = 0; i < target.length; i++){   //scan current Entity's Area
            if(target[panel.currentMap][i] != null){                //Check if it is null -> if not than continue

                //get entity's collision area position
                entity.Area.x = entity.MapX + entity.Area.x;
                entity.Area.y = entity.MapY + entity.Area.y;

                //get the NPC's collision area position
                target[panel.currentMap][i].Area.x = target[panel.currentMap][i].MapX + target[panel.currentMap][i].Area.x; //no need for coordinates like in TileDetection
                target[panel.currentMap][i].Area.y = target[panel.currentMap][i].MapY + target[panel.currentMap][i].Area.y;


                if(!entity.still) {
                    switch (entity.direction) {
                        case "UP" -> {
                            entity.Area.y -= entity.Speed;      //when going UP -> Y-Coordinate - Speed (4 px)

                            //automatically checks if entity.Area & target[panel.currentMap][i].Area have intersection
                            if (entity.Area.intersects(target[panel.currentMap][i].Area)) {     //A intersection B
                                entity.collisionOn = true;  //then collision is happening
                                entityIndex = i;                  //if it is player, we return the index, if it is an NPC we ignore
                            }
                        }
                        case "DOWN" -> {
                            entity.Area.y += entity.Speed;
                            if (entity.Area.intersects(target[panel.currentMap][i].Area)) {
                                entity.collisionOn = true;
                                entityIndex = i;
                            }
                        }
                        case "LEFT" -> {
                            entity.Area.x -= entity.Speed;
                            if (entity.Area.intersects(target[panel.currentMap][i].Area)) {
                                entity.collisionOn = true;
                                entityIndex = i;
                            }
                        }
                        case "RIGHT" -> {
                            entity.Area.x += entity.Speed;
                            if (entity.Area.intersects(target[panel.currentMap][i].Area)) {
                                entity.collisionOn = true;
                                entityIndex = i;
                            }
                        }
                    }
                }

                else {
                    // Check for nearby objects when standing still
                    if (isNearNPC(entity, target[panel.currentMap][i])) {
                            entityIndex = i;
                    }
                }

                //reset Areas -> otherwise entity.MapX and entity.MapY keep increasing (Line 99 & 100)
                entity.Area.x = entity.AreaDefaultX;
                entity.Area.y = entity.AreaDefaultY;
                target[panel.currentMap][i].Area.x = target[panel.currentMap][i].AreaDefaultX;
                target[panel.currentMap][i].Area.y = target[panel.currentMap][i].AreaDefaultY;
            }
        }
        return entityIndex;       //return index
    }

    private boolean isNearNPC(Entity entity, Entity npc) {
        int proximity = 5; // Adjust this value based on how close you want to check

        // Create an expanded area around the player's current area
        Rectangle expandedArea = new Rectangle(entity.Area);
        expandedArea.grow(proximity, proximity);

        // Check if the expanded area intersects with the npc's area

        return expandedArea.intersects(npc.Area);
    }

    // PLAYER DETECTION
    public void DetectPlayer(Entity entity) {
        // Detect if NPC is colliding with NPC

        //get entity's collision area position
        entity.Area.x = entity.MapX + entity.Area.x;
        entity.Area.y = entity.MapY + entity.Area.y;

        //get the object's collision area position
        panel.player.Area.x = panel.player.MapX + panel.player.Area.x; //no need for coordinates like in TileDetection
        panel.player.Area.y = panel.player.MapY + panel.player.Area.y;

        int touchDamage = 2;
        switch (entity.direction) {
            case "UP" -> {
                entity.Area.y -= entity.Speed;      //when going UP -> Y-Coordinate - Speed (4 px)
                //automatically checks if entity.Area & panel.player.Area have intersection
                if (entity.Area.intersects(panel.player.Area)) {
                    if(entity.Snitch){
                       /* if(panel.player.done) {
                            panel.GameState = panel.transitionState;
                            panel.player.resetGame();
                            panel.player.done = false;
                        } else*/ panel.player.startDialogue(entity, entity.dialogueSet);
                    }
                    if(entity.Boss) {   // If Entity is the Boss, damage Player
                        entity.collisionPlayer = true;
                        if(entity.Attack)  entity.damagePlayer(entity.attack);
                        else {
                            entity.damagePlayer(touchDamage); // If Entity is the Boss, damage Player
                        }
                    }
                    entity.collisionOn = true;  //A intersection B -> then collision is happening
                }
            }
            case "DOWN" -> {
                entity.Area.y += entity.Speed;
                if (entity.Area.intersects(panel.player.Area)){
                    if(entity.Snitch){
                        /*if(panel.player.done) {
                            panel.GameState = panel.transitionState;
                            panel.player.resetGame();
                            panel.player.done = false;
                        } else */panel.player.startDialogue(entity, entity.dialogueSet);
                    }
                    if(entity.Boss) {   // If Entity is the Boss, damage Player
                        entity.collisionPlayer = true;
                        if(entity.Attack)  entity.damagePlayer(entity.attack);
                        else {
                            //entity.AttackingDetection(30, panel.tileSize*4, panel.tileSize);
                            entity.damagePlayer(touchDamage); // If Entity is the Boss, damage Player
                        }                    }

                    entity.collisionOn = true;
                }
            }
            case "LEFT" -> {
                entity.Area.x -= entity.Speed;
                if (entity.Area.intersects(panel.player.Area)) {
                    if(entity.Snitch){
                       /* if(panel.player.done) {
                            panel.GameState = panel.transitionState;
                            panel.player.resetGame();
                            panel.player.done = false;
                        } else*/ panel.player.startDialogue(entity, entity.dialogueSet);
                    }
                    if(entity.Boss) {   // If Entity is the Boss, damage Player
                        entity.collisionPlayer = true;
                        if(entity.Attack)  entity.damagePlayer(entity.attack);
                        else {
                            //entity.AttackingDetection(30, panel.tileSize*4, panel.tileSize);
                            entity.damagePlayer(touchDamage); // If Entity is the Boss, damage Player
                        }
                    }
                    entity.collisionOn = true;
                }
            }
            case "RIGHT" -> {
                entity.Area.x += entity.Speed;
                if (entity.Area.intersects(panel.player.Area)){
                    if(entity.Snitch){
                       /* if(panel.player.done) {
                            panel.GameState = panel.transitionState;
                            panel.player.resetGame();
                            panel.player.done = false;
                        } else*/ panel.player.startDialogue(entity, entity.dialogueSet);
                    }
                    if(entity.Boss) {   // If Entity is the Boss, damage Player
                        entity.collisionPlayer = true;
                        if(entity.Attack)  entity.damagePlayer(entity.attack);
                        else {
                            //entity.AttackingDetection(30, panel.tileSize*4, panel.tileSize);
                            entity.damagePlayer(touchDamage); // If Entity is the Boss, damage Player
                        }                    }
                    entity.collisionOn = true;
                }
            }
        }

        //reset Areas -> otherwise entity.MapX and entity.MapY keep increasing (Line 99 & 100)
        entity.Area.x = entity.AreaDefaultX;
        entity.Area.y = entity.AreaDefaultY;
        panel.player.Area.x = panel.player.AreaDefaultX;
        panel.player.Area.y = panel.player.AreaDefaultY;

    }

    // OBJECT DETECTION
}

