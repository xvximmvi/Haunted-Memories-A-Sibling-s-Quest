package tile;

import main.GamePanel;
import main.Utility;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class Manager {
    GamePanel panel;                //draw the panel
    public Tile[] tile;             //use tiles  (public for CollisionDetection)
    public int[][][] mapTilesNum;     //which tile to use  (public for CollisionDetection)

    // MANAGER CONSTRUCTOR
    public Manager(GamePanel panel) {
        this.panel = panel;
        tile = new Tile[70];    //how many kinds of tiles

        mapTilesNum = new int[panel.maxMap][panel.maxMapCol][panel.maxMapRow];     //[panel.maxScreenCol][panel.maxScreenRow] -> Map Size as Screen Size
        //Edit: now maxMapCol/Row -> Map Size

        tileImage();                            //call tileImage()
        loadMap("/Maps/Hospital/ICU.txt", 0);     //call loadMap() of first Map (Simbas Patient Room)
        loadMap("/Maps/Hospital/3F_Hall.txt", 1);
        loadMap("/Maps/Hospital/Toilet_Blue.txt", 2);
        loadMap("/Maps/Hospital/Toilet_Green.txt", 3);
    }

    // TILE IMAGE
    public void tileImage() {
        setup(0, "/Black", false);

        // HOSPITAL
        setup(1, "/Hospital/Floor_GraySquareEvenClean_M", false);
        setup(2, "/Hospital/Floor_GraySquareEvenClean_T", false);
        setup(3, "/Hospital/Floor_GraySquareEvenDirt_M", false);
        setup(4, "/Hospital/Floor_GraySquareEvenDirt_T", false);
        setup(5, "/Hospital/Floor_GraySquareUnevenClean_M", false);
        setup(6, "/Hospital/Floor_GraySquareUnevenClean_T", false);
        setup(7, "/Hospital/Floor_GraySquareUnevenDirt_M", false);
        setup(8, "/Hospital/Floor_GraySquareUnevenDirt_T", false);
        setup(9, "/Hospital/Floor_GrayUniClean_M", false);
        setup(10, "/Hospital/Floor_GrayUniClean_T", false);
        setup(11, "/Hospital/Floor_GrayUniDirt_M", false);
        setup(12, "/Hospital/Floor_GrayUniDirt_T", false);
        setup(13, "/Hospital/Floor_GreenSquareEvenClean_M", false);
        setup(14, "/Hospital/Floor_GreenSquareEvenClean_T", false);
        setup(15, "/Hospital/Floor_GreenSquareEvenDirt_M", false);
        setup(16, "/Hospital/Floor_GreenSquareEvenDirt_T", false);
        setup(17, "/Hospital/Floor_GreenUniClean_M", false);
        setup(18, "/Hospital/Floor_GreenUniClean_T", false);
        setup(19, "/Hospital/Floor_GreenUniDirt_M", false);
        setup(20, "/Hospital/Floor_GreenUniDirt_T", false);
        setup(21, "/Hospital/Floor_WhiteSquareEvenClean_M", false);
        setup(22, "/Hospital/Floor_WhiteSquareEvenClean_T", false);
        setup(23, "/Hospital/Floor_WhiteSquareEvenDirt_M", false);
        setup(24, "/Hospital/Floor_WhiteSquareEvenDirt_T", false);
        setup(25, "/Hospital/Floor_WhiteSquareUnevenClean_M", false);
        setup(26, "/Hospital/Floor_WhiteSquareUnevenClean_T", false);
        setup(27, "/Hospital/Floor_WhiteSquareUnevenDirt_M", false);
        setup(28, "/Hospital/Floor_WhiteSquareUnevenDirt_T", false);
        setup(29, "/Hospital/Floor_WhiteUniClean_M", false);
        setup(30, "/Hospital/Floor_WhiteUniClean_T", false);
        setup(31, "/Hospital/Floor_WhiteUniDirt_M", false);
        setup(32, "/Hospital/Floor_WhiteUniDirt_T", false);
        setup(33, "/Hospital/Outline_BL", true);
        setup(34, "/Hospital/Outline_BR", true);
        setup(35, "/Hospital/Outline_T", true);
        setup(36, "/Hospital/Outline_L", true);
        setup(37, "/Hospital/Outline_R", true);
        setup(38, "/Hospital/Outline_B", true);
        setup(39, "/Hospital/Outline_TL", true);
        setup(40, "/Hospital/Outline_TR", true);
        setup(41, "/Hospital/Wall_White_B", true);
        setup(42, "/Hospital/Wall_White_M", true);
        setup(43, "/Hospital/Wall_White_T", true);
        setup(44, "/Hospital/Wall_WhiteDirt_B", true);
        setup(45, "/Hospital/Wall_WhiteDirt_M", true);
        setup(46, "/Hospital/Wall_WhiteDirt_T", true);
        setup(47, "/Hospital/Wall_WhiteGreen_B", true);
        setup(48, "/Hospital/Wall_WhiteGreenDirt_B", true);

        setup(49, "/Hospital/Floor_BlackWhiteClean_M", false);
        setup(50, "/Hospital/Floor_BlackWhiteClean_T", false);
        setup(51, "/Hospital/Floor_BlackWhiteDirt_M", false);
        setup(52, "/Hospital/Wall_Blue_B", true);
        setup(53, "/Hospital/Wall_WhiteBlue_M", true);
        setup(54, "/Hospital/Wall_WhiteWhite_T", true);
        setup(55, "/Hospital/Outline_BL2", true);
    }

    // TILE IMAGE SETUP
    public void setup(int index, String imageName, boolean collision) {
        //scale image so that Graphics2D doesn't have to do it and can draw faster
        // Edited afterward due to space redundancy in code
        Utility utility = new Utility();
        BufferedImage image = null;

        try {
            tile[index] = new Tile();   // Create new Tile
            tile[index].image = ImageIO.read(Objects.requireNonNull(getClass().getResource("/Background" + imageName + ".png"))); //all tiles are from same Folder -> just name is different
            tile[index].image = utility.scaleImage(tile[index].image, panel.tileSize, panel.tileSize);  //size for every tile the same
            tile[index].collision = collision;  //ask if collision needed or not

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // LOAD MAP
    public void loadMap(String filePath, int Map){

        //if you want to load a different Map, just call different loadMap
        //int Map -> to know in which Map we are (Identify the Map Number)
        try{
            InputStream is = getClass().getResourceAsStream(filePath);   //Input Mapping
            assert is != null;      //means "a passed parameter must not be null": if it is null then the test case fails (Javas suggestion)
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));  // Read Input (Map-Text)

            int col = 0;    //Column of Map
            int row = 0;    //Row of Map

            while(col < panel.maxMapCol && row < panel.maxMapRow){    //run while there ar still numbers to read
                String line = bufferedReader.readLine();

                while(col < panel.maxMapCol){
                    String[] numbers = line.split(" ");    //Space " " separates numbers in Map -> go to next Column

                    int num = Integer.parseInt(numbers[col]);   //Number of current Column

                    mapTilesNum[Map][col][row] = num;                //Map-Matrix
                    col++;                                      //Go to next Column
                }
                if(col == panel.maxMapCol){                     //If Column reached the end...
                    col = 0;                                    //... then reset Column back to beginning ...
                    row++;                                      //... but next Row
                }
            }
            bufferedReader.close();     //After Matrix ended -> stop reading

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // DRAW MAP
    public void draw(Graphics2D graphics2D){
        int MapCol = 0;
        int MapRow = 0;

        while(MapCol < panel.maxMapCol && MapRow < panel.maxMapRow)  //instead of writing every tile
        {
            int tileNum = mapTilesNum[panel.currentMap][MapCol][MapRow];        //Draw number of each read Map-Matrix

            // PLAYER ALWAYS AT CENTER OF SCREEN
            //Needed: 1. Tile image / 2. Where to draw on the screen (find X & Y)
            int MapX = MapCol*panel.tileSize;
            int MapY = MapRow*panel.tileSize;
            int ScreenX = MapX - panel.player.MapX + panel.player.ScreenX; //coordinates to get to a specific tile; compared to the player where is the tile
            int ScreenY = MapY - panel.player.MapY + panel.player.ScreenY;

            // STOP CAMERA AT EDGE
            //Left Side / Top Side
            if(panel.player.ScreenX > panel.player.MapX) ScreenX = MapX;
            if(panel.player.ScreenY > panel.player.MapY) ScreenY = MapY;

            //Right Side / Bottom Side
            int RightOffset = panel.ScreenWidth - panel.player.ScreenX;
            if(RightOffset > panel.MapWidth - panel.player.MapX)
                ScreenX = panel.ScreenWidth - (panel.MapWidth - MapX);

            int BottomOffset = panel.ScreenHeight - panel.player.ScreenY;
            if(BottomOffset > panel.MapHeight - panel.player.MapY)
                ScreenY = panel.ScreenHeight - (panel.MapHeight - MapY);

            if(MapX + panel.tileSize > panel.player.MapX - panel.player.ScreenX
                    && MapX - panel.tileSize < panel.player.MapX + panel.player.ScreenX
                    && MapY + panel.tileSize > panel.player.MapY - panel.player.ScreenY
                    && MapY - panel.tileSize < panel.player.MapY + panel.player.ScreenY)   //create boundary -> only draw tiles within the boundary
                graphics2D.drawImage(tile[tileNum].image, ScreenX, ScreenY, null); //draw

            else if(panel.player.ScreenX > panel.player.MapX
                    || panel.player.ScreenY > panel.player.MapY
                    || RightOffset > panel.MapWidth - panel.player.MapX
                    || BottomOffset > panel.MapHeight - panel.player.MapY)         //if at edge fill Screen with tiles
                graphics2D.drawImage(tile[tileNum].image, ScreenX, ScreenY, null); //draw

            //graphics2D.drawImage(tile[tileNum].image, ScreenX, ScreenY, null);
            MapCol++;                           //draw next tile
            if(MapCol == panel.maxMapCol){   //if col finished go to next row and repeat
                MapCol = 0;         //reset MapCol
                MapRow++;           //go to next Row
            }
        }
    }
}
