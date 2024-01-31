package main;

// CLASS CONTENT
/*
    ASSET CONSTRUCTOR
    SET OBJECT for every Room
    SET NPC for every Room
*/

import entity.ArcadeEmployee;
import entity.Entity;
import entity.NPC_Doctor_Female_1;
import object.General.*;
import object.Hospital.*;

public class SetAsset {
    GamePanel panel;

    // ASSET CONSTRUCTOR
    public SetAsset(GamePanel panel){
        this.panel = panel;
    }

    // SET OBJECT ------------------------------------------------------------------------------------------------------
    // SET OBJECT UTILITY
    public void setObjects(Entity object, int MapX, int MapY, int MapIndex, int ObjectIndex){
        panel.object[MapIndex][ObjectIndex] = object;  //subclass of Object Class -> instantiate as one of this array
        panel.object[MapIndex][ObjectIndex].MapX = MapX;
        panel.object[MapIndex][ObjectIndex].MapY = MapY;
        //first [] for current Map/Room
        //second [] to know at which object we are
    }

    // SET OBJECT
    public void setObject_HOSPITAL_ICU() {
        //instantiate default objects
        //Play around with variables till it fits

        setObjects(new HOSPITAL_Bed_Green_B(panel), panel.tileSize*10, panel.tileSize*19-10, 0, 0);
        setObjects(new HOSPITAL_Bed_NoSheets_B(panel), panel.tileSize*14, panel.tileSize*19-10, 0, 1);
        setObjects(new HOSPITAL_Bed_Green_B(panel), panel.tileSize*18, panel.tileSize*19-10, 0, 2);

        setObjects(new HOSPITAL_Bed_Green_F(panel), panel.tileSize*9, panel.tileSize*9-24, 0, 3);
        setObjects(new HOSPITAL_Bed_Green_F(panel), panel.tileSize*13, panel.tileSize*9-24, 0, 4);

        setObjects(new HOSPITAL_Medication_Shelf_F(panel), panel.tileSize*16+30, panel.tileSize*7, 0, 5);
        setObjects(new HOSPITAL_Door(panel), panel.tileSize*19, panel.tileSize*7, 0, 6);
        setObjects(new HOSPITAL_Chair_L(panel), panel.tileSize*11+24, panel.tileSize*10, 0,7);
        setObjects(new HOSPITAL_TalkLight(panel), panel.tileSize*7, panel.tileSize*7, 0, 8);
        setObjects(new HOSPITAL_Clock(panel), panel.tileSize*9, panel.tileSize*7-24, 0,9);
        setObjects(new HOSPITAL_ICU(panel), panel.tileSize*11, panel.tileSize*7, 0,10);
        setObjects(new HOSPITAL_LungImage_T(panel), panel.tileSize*15, panel.tileSize*7,0,11 );
        setObjects(new HOSPITAL_LungImage_B(panel), panel.tileSize*15, panel.tileSize*7+(24*2+12),0,12 );
        setObjects(new HOSPITAL_Nightstand_F(panel), panel.tileSize*7+35, panel.tileSize*8+24, 0,13);
        setObjects(new HOSPITAL_Shelf_L(panel), panel.tileSize*6, panel.tileSize*12, 0,14);
        setObjects(new HOSPITAL_Shelf_R(panel), panel.tileSize*22+5, panel.tileSize*12,0, 15);
        setObjects(new HOSPITAL_Nightstand_F(panel), panel.tileSize*11+35, panel.tileSize*8+24, 0,16);
        setObjects(new HOSPITAL_Nightstand_Books_AddOn(panel), panel.tileSize*11+35, panel.tileSize*8+24,0,17);
        setObjects(new HOSPITAL_Nightstand_Flowers_B(panel), panel.tileSize*9-35, panel.tileSize*19+24, 0, 18);
        setObjects(new HOSPITAL_IV_Stand_Blood(panel), panel.tileSize*15+30, panel.tileSize*19-24, 0,19);
        setObjects(new HOSPITAL_Tissues(panel), panel.tileSize*13, panel.tileSize*20,0,20 );
        setObjects(new HOSPITAL_Tissues(panel), panel.tileSize*15, panel.tileSize*18,0,21 );
        setObjects(new HOSPITAL_Talking(panel), panel.tileSize*21, panel.tileSize*7+24, 0, 22);
        setObjects(new HOSPITAL_Sink_R(panel), panel.tileSize*22-4, panel.tileSize*17-25, 0,23);
    }
    public void setObject_HOSPITAL_HALL3F(){
        setObjects(new HOSPITAL_Door_Right(panel), 0, 15* panel.tileSize, 1, 0);
        setObjects(new HOSPITAL_Door_Right(panel), 0, 24* panel.tileSize, 1, 1);
        setObjects(new HOSPITAL_3F(panel), panel.tileSize*2, panel.tileSize*2, 1,2);
        setObjects(new HOSPITAL_Elevator(panel), 4* panel.tileSize+ panel.tileSize/2, 2* panel.tileSize-5, 1, 3);
        setObjects(new HOSPITAL_Wheelchair_L(panel), panel.tileSize+24, 5* panel.tileSize,1,4);
        setObjects(new HOSPITAL_Wheelchair_L(panel), panel.tileSize+24, 7* panel.tileSize,1,5);
        setObjects(new HOSPITAL_IV_Stand(panel), 10* panel.tileSize-24, 3* panel.tileSize, 1,6);
        setObjects(new HOSPITAL_Chair_R(panel), 10* panel.tileSize, 6* panel.tileSize, 1, 7);
        setObjects(new HOSPITAL_Chair_R(panel), 10* panel.tileSize, 7* panel.tileSize, 1, 8);

        setObjects(new HOSPITAL_Chair_R(panel), 10* panel.tileSize, 12* panel.tileSize, 1, 9);
        setObjects(new HOSPITAL_Chair_R(panel), 10* panel.tileSize, 13* panel.tileSize, 1, 10);

        setObjects(new GENERAL_Plant_Long_3(panel), 9* panel.tileSize-20, 16* panel.tileSize,1,11);
        setObjects(new GENERAL_Machine_3(panel), 12* panel.tileSize, 18* panel.tileSize,1,12);
        setObjects(new HOSPITAL_Door_Lock_Right(panel), 15* panel.tileSize, 19* panel.tileSize-5,1,13);
        setObjects(new HOSPITAL_Door(panel), 20* panel.tileSize,19* panel.tileSize-5, 1,14);
        setObjects(new HOSPITAL_Door_Lock_Right(panel), 25* panel.tileSize, 19* panel.tileSize-5,1,15);
        setObjects(new HOSPITAL_Couch_B(panel), 15* panel.tileSize,27* panel.tileSize+40,1,16);
        setObjects(new HOSPITAL_TrashBin_Red(panel), 18* panel.tileSize, 20* panel.tileSize,1,17);
        setObjects(new HOSPITAL_TrashBin_Green(panel), 23* panel.tileSize,20* panel.tileSize+10,1,18);
        setObjects(new HOSPITAL_Chair_B(panel), 3* panel.tileSize, 27* panel.tileSize+40,1,19);
        setObjects(new HOSPITAL_Clock(panel), 18* panel.tileSize, 18* panel.tileSize+40,1,20);
        setObjects(new HOSPITAL_MedKit_Red_Wall(panel), 23* panel.tileSize, 18* panel.tileSize+40,1,21);
        setObjects(new HOSPITAL_Tissues(panel), 5* panel.tileSize, 25* panel.tileSize,1,22);
        setObjects(new HOSPITAL_Wheelchair_R(panel), 27* panel.tileSize, 27* panel.tileSize,1,23);
        setObjects(new HOSPITAL_IV_Stand(panel), 27* panel.tileSize, 25* panel.tileSize,1,24);
    }
    public void setObject_HOSPITAL_TOILET(){        // MAP 3
        setObjects(new GENERAL_Toilet_Cabin(panel), 6* panel.tileSize,11* panel.tileSize,3, 0);
        setObjects(new GENERAL_Toilet_Cabin(panel), 6* panel.tileSize+(84*2+42-14*2-11),11* panel.tileSize,3, 1);
        setObjects(new GENERAL_Toilet_Cabin(panel), 6* panel.tileSize+(84*2+42-14*2-11)*2,11* panel.tileSize,3, 2);

        setObjects(new GENERAL_Toilet_Urinary_1(panel), 15* panel.tileSize, 11* panel.tileSize, 3, 3);
        setObjects(new GENERAL_Toilet_Urinary_1(panel), 16* panel.tileSize, 11* panel.tileSize, 3, 4);
        setObjects(new GENERAL_Toilet_Urinary_1(panel), 17* panel.tileSize, 11* panel.tileSize, 3, 5);

        setObjects(new GENERAL_Toilet_Sink(panel), 21* panel.tileSize-40, 11* panel.tileSize, 3, 6);

        setObjects(new GENERAL_Toilet_Cabin_Bottom(panel), 6* panel.tileSize,20* panel.tileSize-7,3, 7);
        setObjects(new GENERAL_Toilet_Cabin_Bottom(panel), 6* panel.tileSize+(84*2+42-14*2-11),20* panel.tileSize-7,3, 8);
        setObjects(new GENERAL_Toilet_Cabin_Bottom(panel), 6* panel.tileSize+(84*2+42-14*2-11)*2,20* panel.tileSize-7,3, 9);

        setObjects(new HOSPITAL_Door_Left(panel), 24* panel.tileSize+36, 16* panel.tileSize,3,10);
    }


    // SET NPC ---------------------------------------------------------------------------------------------------------
    // SET NPC UTILITY
    public void setNPC(Entity entity, int MapX, int MapY, int MapIndex, int NPCIndex){
        panel.NPC[MapIndex][NPCIndex] = entity;  //subclass of Entity Class -> instantiate as one of this array
        panel.NPC[MapIndex][NPCIndex].MapX = MapX;
        panel.NPC[MapIndex][NPCIndex].MapY = MapY;
        //first [] for current Map/Room
        //second [] to know at which object we are
    }

    //SET NPC
    public void setNPCs() {
        setNPC(new ArcadeEmployee(panel), panel.tileSize*12, panel.tileSize*15, 3,0);
        setNPC(new NPC_Doctor_Female_1(panel), panel.tileSize*12, panel.tileSize*12, 0,1);
        setNPC(new NPC_Doctor_Female_1(panel), panel.tileSize*4, panel.tileSize*5, 1,2);
    }
}
