package main;

// CLASS CONTENT
/*
    ASSET CONSTRUCTOR
    SET OBJECT for every Room
*/

import object.Hospital.*;
import object._SuperObject;

public class SetAsset {
    GamePanel panel;

    //ASSET CONSTRUCTOR
    public SetAsset(GamePanel panel){
        this.panel = panel;
    }

    public void setObjects(_SuperObject object, int MapX, int MapY, int MapIndex, int ObjectIndex){
        panel.object[MapIndex][ObjectIndex] = object;  //ObjectBed is subclass of Object Class -> instantiate as one of this array
        panel.object[MapIndex][ObjectIndex].MapX = MapX;
        panel.object[MapIndex][ObjectIndex].MapY = MapY;
        //first [] for current Map/Room
        //second [] to know at which object we are
    }

    // SET OBJECT
    public void setObject_HOSPITAL_ICU() {
        //instantiate default objects
        //Play around with variables till it fits

        setObjects(new HOSPITAL_Bed_Green_B(), panel.tileSize*10, panel.tileSize*19-10, 0, 0);
        setObjects(new HOSPITAL_Bed_NoSheets_B(), panel.tileSize*14, panel.tileSize*19-10, 0, 1);
        setObjects(new HOSPITAL_Bed_Green_B(), panel.tileSize*18, panel.tileSize*19-10, 0, 2);

        setObjects(new HOSPITAL_Bed_Green_F(), panel.tileSize*9, panel.tileSize*9-24, 0, 3);
        setObjects(new HOSPITAL_Bed_Green_F(), panel.tileSize*13, panel.tileSize*9-24, 0, 4);

        setObjects(new HOSPITAL_Medication_Shelf_F(), panel.tileSize*16+30, panel.tileSize*7, 0, 5);
        setObjects(new HOSPITAL_Door(), panel.tileSize*19, panel.tileSize*7, 0, 6);
        setObjects(new HOSPITAL_Chair_L(), panel.tileSize*11+24, panel.tileSize*10, 0,7);
        setObjects(new HOSPITAL_TalkLight(), panel.tileSize*7, panel.tileSize*7, 0, 8);
        setObjects(new HOSPITAL_Clock(), panel.tileSize*9, panel.tileSize*7-24, 0,9);
        setObjects(new HOSPITAL_ICU(), panel.tileSize*11, panel.tileSize*7, 0,10);
        setObjects(new HOSPITAL_LungImage_T(), panel.tileSize*15, panel.tileSize*7,0,11 );
        setObjects(new HOSPITAL_LungImage_B(), panel.tileSize*15, panel.tileSize*7+(24*2+12),0,12 );
        setObjects(new HOSPITAL_Nightstand_F(), panel.tileSize*7+35, panel.tileSize*8+24, 0,13);
        setObjects(new HOSPITAL_Shelf_L(), panel.tileSize*6, panel.tileSize*12, 0,14);
        setObjects(new HOSPITAL_Shelf_R(), panel.tileSize*22+5, panel.tileSize*12,0, 15);
        setObjects(new HOSPITAL_Nightstand_F(), panel.tileSize*11+35, panel.tileSize*8+24, 0,16);
        setObjects(new HOSPITAL_Nightstand_Books_AddOn(), panel.tileSize*11+35, panel.tileSize*8+24,0,17);
        setObjects(new HOSPITAL_Nightstand_Flowers_B(), panel.tileSize*9-35, panel.tileSize*19+24, 0, 18);
        setObjects(new HOSPITAL_IV_Stand_Blood(), panel.tileSize*15+30, panel.tileSize*19-24, 0,19);
        setObjects(new HOSPITAL_Tissues(), panel.tileSize*13, panel.tileSize*20,0,20 );
        setObjects(new HOSPITAL_Tissues(), panel.tileSize*15, panel.tileSize*18,0,21 );
        setObjects(new HOSPITAL_Talking(), panel.tileSize*21, panel.tileSize*7+24, 0, 22);
        setObjects(new HOSPITAL_Sink_R(), panel.tileSize*22-4, panel.tileSize*17-25, 0,23);

    }

}
