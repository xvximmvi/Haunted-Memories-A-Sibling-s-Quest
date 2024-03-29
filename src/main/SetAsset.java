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
    public void setObject_HOSPITAL_STORAGEF3(){
        setObjects(new HOSPITAL_Door_Bottom(panel), 13*panel.tileSize, 21* panel.tileSize- panel.tileSize/2,5,0);
        setObjects(new GENERAL_WashingMachines(panel), 12*panel.tileSize+40, 12* panel.tileSize+20, 5, 1);
        setObjects(new GENERAL_Sink(panel), 16* panel.tileSize, 12* panel.tileSize, 5, 2);
        setObjects(new GENERAL_Locker(panel), 9* panel.tileSize+40, 11* panel.tileSize+20, 5, 3);
        setObjects(new GENERAL_CleaningStuff_1(panel),12* panel.tileSize-20, 11* panel.tileSize, 5, 4);
        setObjects(new GENERAL_LaundryBasket(panel), 11* panel.tileSize, 15* panel.tileSize,5 ,5);
        setObjects(new GENERAL_Box_3_White(panel),10 * panel.tileSize-40, 17* panel.tileSize+30, 5, 6);
        setObjects(new GENERAL_Vent_Small_Round(panel), 18* panel.tileSize, 10* panel.tileSize+20, 5, 7);
        setObjects(new HOSPITAL_Chair_B(panel), 16* panel.tileSize +40, 18* panel.tileSize +40, 5, 8);
        setObjects(new GENERAL_FireExtinguisher_2(panel), 18* panel.tileSize, 15* panel.tileSize, 5, 9);
        setObjects(new GENERAL_SpiderWeb_Full(panel), 9* panel.tileSize, 10* panel.tileSize, 5, 10);
        setObjects(new HOSPITAL_Tissues(panel), 16* panel.tileSize, 17* panel.tileSize, 5, 11);
        setObjects(new HOSPITAL_Tissues(panel), 14 * panel.tileSize-40, 14* panel.tileSize+10, 5, 12);
    }
    public void setObject_HOSPITAL_OFFICE(){
        setObjects(new HOSPITAL_Door_Bottom(panel), 14* panel.tileSize, 21* panel.tileSize- panel.tileSize/2, 6, 0);
        setObjects(new GENERAL_OfficeShelf_1(panel), 8* panel.tileSize- panel.tileSize/2+4, 8* panel.tileSize, 6, 1);
        setObjects(new GENERAL_Table_Small_White(panel), 13* panel.tileSize, 9* panel.tileSize+20, 6, 2);
        setObjects(new GENERAL_Printer(panel), 17* panel.tileSize, 9* panel.tileSize+40, 6, 3);
        setObjects(new GENERAL_CoffeeMaker(panel), 21* panel.tileSize+30, 8* panel.tileSize+40, 6, 4);
        setObjects(new GENERAL_Clock_2(panel), 12* panel.tileSize+50, 8* panel.tileSize-30, 6, 5);
        setObjects(new GENERAL_Desk_PC(panel), 15* panel.tileSize+40, 12* panel.tileSize+40, 6, 6);
        setObjects(new GENERAL_Desk_PC(panel), 17* panel.tileSize+30, 16* panel.tileSize, 6, 7);
        setObjects(new GENERAL_Desk_PC(panel), 10* panel.tileSize-30, 16* panel.tileSize, 6, 8);
        setObjects(new GENERAL_ServerShelf_V(panel), 8* panel.tileSize-40, 12* panel.tileSize, 6, 9);
        setObjects(new GENERAL_Plant_Long(panel), 21* panel.tileSize, 16* panel.tileSize-40, 6, 10);
        setObjects(new GENERAL_DeskChair_B(panel), 16* panel.tileSize, 14* panel.tileSize+30, 6, 11);
        setObjects(new GENERAL_DeskChair_B(panel), 18* panel.tileSize, 18* panel.tileSize, 6, 12);
        setObjects(new GENERAL_DeskChair_R(panel), 10* panel.tileSize, 18* panel.tileSize-30, 6, 13);
        setObjects(new GENERAL_OfficeShelf_Small_1(panel), 19* panel.tileSize, 12* panel.tileSize, 6, 14);
        setObjects(new GENERAL_Wall_Office_Deco_1(panel), 15* panel.tileSize, 8* panel.tileSize-30, 6, 15);
        setObjects(new GENERAL_OfficeStuff(panel), 8* panel.tileSize-15, 8* panel.tileSize-27,6 ,16);
        setObjects(new GENERAL_Food(panel), 14* panel.tileSize+50, 9* panel.tileSize+18,6 ,17);
        setObjects(new GENERAL_Plant_Short_1(panel), 10* panel.tileSize+50, 7* panel.tileSize+18,6 ,18);
        setObjects(new GENERAL_Food_2(panel), 13* panel.tileSize+15, 9* panel.tileSize-12,6 ,19);
        setObjects(new GENERAL_Paper_Bin_Knocked(panel), 13* panel.tileSize, 16* panel.tileSize,6 ,20);
        setObjects(new GENERAL_Paper_1(panel), 11* panel.tileSize, 12* panel.tileSize-40, 6,21);
        setObjects(new GENERAL_Paper_Ripped(panel), 20 * panel.tileSize- panel.tileSize/2, 10* panel.tileSize, 6, 22);
        setObjects(new GENERAL_Wall_Office_Deco_2(panel), 18* panel.tileSize+50, 8* panel.tileSize-30, 6, 23);
    }
    public void setObject_HOSPITAL_APOTHECARY(){
        setObjects(new HOSPITAL_Door_Bottom(panel), 14* panel.tileSize, 21* panel.tileSize- panel.tileSize/2, 4, 0);
        setObjects(new HOSPITAL_Medication_Shelf_F(panel), 8* panel.tileSize- panel.tileSize/2+4, 8* panel.tileSize+panel.tileSize/4, 4, 1);
        setObjects(new HOSPITAL_Medication_Shelf_F(panel), 10* panel.tileSize, 8* panel.tileSize+panel.tileSize/4, 4, 2);
        setObjects(new HOSPITAL_MedicationShelf_White(panel), 20* panel.tileSize, 8* panel.tileSize-panel.tileSize/4,4 ,3);
        setObjects(new HOSPITAL_Shelf_L(panel), 7* panel.tileSize+15, 17* panel.tileSize-40, 4, 4);
        setObjects(new HOSPITAL_LungImage_T(panel), panel.tileSize*12+40, panel.tileSize*8,4,5);
        setObjects(new HOSPITAL_LungImage_B(panel), panel.tileSize*12+40, panel.tileSize*8+(24*2+12),4,6);
        setObjects(new GENERAL_Desk_PC(panel), 17* panel.tileSize+30, 13* panel.tileSize, 4, 7);
        setObjects(new GENERAL_DeskChair_B(panel), 18* panel.tileSize, 15* panel.tileSize, 4, 8);
        setObjects(new GENERAL_Table_Big_White(panel), 9* panel.tileSize+panel.tileSize/2, 12* panel.tileSize+panel.tileSize/2, 4, 9);
        setObjects(new GENERAL_Table_Small_White(panel), 14* panel.tileSize-10, 9* panel.tileSize+20, 4, 10);
        setObjects(new HOSPITAL_MedKit_Green_Wall(panel), 17* panel.tileSize+panel.tileSize/2, 8* panel.tileSize,4, 11);
        setObjects(new HOSPITAL_MedKit_Red_Wall(panel), 18* panel.tileSize+panel.tileSize/2, 8* panel.tileSize,4, 12);
        setObjects(new HOSPITAL_IV_Stand(panel), 21* panel.tileSize+panel.tileSize/2, 18* panel.tileSize-panel.tileSize/2, 4, 13);
        setObjects(new HOSPITAL_Clock(panel), 15* panel.tileSize, 8* panel.tileSize-panel.tileSize/4, 4, 14);
        setObjects(new HOSPITAL_TalkLight(panel), panel.tileSize*7+panel.tileSize/2, panel.tileSize*7+panel.tileSize/2, 4, 15);
        setObjects(new HOSPITAL_Chair_B(panel), 17* panel.tileSize+panel.tileSize/2+10, 18* panel.tileSize+50, 4, 16);
        setObjects(new HOSPITAL_Chair_B(panel), 19* panel.tileSize, 18* panel.tileSize+50, 4, 17);
        setObjects(new GENERAL_Plant_Long_2(panel), 21* panel.tileSize+panel.tileSize/2, 12* panel.tileSize, 4, 18);
        setObjects(new HOSPITAL_Medication(panel), 7* panel.tileSize+20, 19* panel.tileSize+20, 4, 19);
        setObjects(new HOSPITAL_MedBasket(panel), 14* panel.tileSize+15, 9* panel.tileSize+30, 4, 20);
        setObjects(new HOSPITAL_MedKit_White(panel), 15* panel.tileSize+10, 9* panel.tileSize+15, 4, 21);
        setObjects(new GENERAL_Laptop_L(panel), 12* panel.tileSize-25, 12* panel.tileSize+20, 4, 22);
        setObjects(new HOSPITAL_Tissues(panel), 16* panel.tileSize+10, 11* panel.tileSize+15, 4, 23);
        setObjects(new HOSPITAL_MedStuff_1(panel), 10* panel.tileSize-10, 13* panel.tileSize- panel.tileSize/2+10, 4, 24);
        setObjects(new HOSPITAL_MedStuff_2(panel), 11* panel.tileSize-10, 14* panel.tileSize- panel.tileSize/2, 4, 25);
        setObjects(new HOSPITAL_Chair_L(panel), 16* panel.tileSize, 14* panel.tileSize,4, 26);
        setObjects(new HOSPITAL_Tissues(panel), 16* panel.tileSize+50, 16* panel.tileSize-30, 4, 27);
        setObjects(new HOSPITAL_Medication(panel), 11* panel.tileSize, 12* panel.tileSize-60, 4, 28);
        setObjects(new GENERAL_Printer(panel), 10* panel.tileSize, 18* panel.tileSize+30, 4, 29);






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
