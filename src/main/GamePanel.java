package main;

import entity.Entity;
import entity.Player;
import sound.Sound;
import sound.SoundEffect;
import tile.Manager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class GamePanel extends JPanel implements Runnable{
    final int originalTileSize = 48;//16x16px tile (Standard size for retro 2D Games)
    //48x48 to small on modern screens (due to much higher resolution)
    //final int scale = 2;            //multiply by 3
    //48*2 = 96 -> 96x96    --> To Big
    public int tileSize = originalTileSize+24;      //72px
    public final int maxScreenCol = 18;             //tiles displayed horizontally
    public final int maxScreenRow = 12;             //tiles displayed vertically
    public final int ScreenWidth = tileSize*maxScreenCol;  //768px
    public final int ScreenHeight = tileSize*maxScreenRow; //576px

    // MAP SETTINGS
    public final int maxMap = 10;
    public int currentMap = 0;
    public int maxMapCol = 30;
    public int maxMapRow = 30;
    public int MapWidth = tileSize*maxMapCol;
    public int MapHeight = tileSize*maxMapRow;
    public int TransitionMap, TransitionX, TransitionY;
    public String TransitionDirection;

    // FPS
    int FPS = 60;

    // SYSTEM
    Handler handler = new Handler(this);    //add Handler
    Manager manager = new Manager(this);
    Sound sound = new Sound();
    SoundEffect soundEffect = new SoundEffect();
    public CollisionDetection collisionDetection = new CollisionDetection(this);    //public for Player
    public SetAsset asset = new SetAsset(this);
    public UserInterface ui = new UserInterface(this);
    Thread thread;      //implements Runnable (in public class)


    // ENTITY AND OBJECT
    public Player player = new Player(this, this.handler);          //public for Manager
    //handler.setPlayer(player);
    public Entity[][] object = new Entity[maxMap][50];
    public Entity[][] NPC = new Entity[maxMap][10];
    ArrayList<Entity> entityList = new ArrayList<>();

    // GAME STATE
    public int GameState;
    public final int titleState = 0;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int dialogueState = 3;
    public final int GameWonState = 4;
    public final int GameOverState = 5;
    public final int characterState = 6;
    public final int transitionState = 7;
    public final int transitionOutState = 8;
    public final int optionState = 9;
    public final int menuOptionState = 10;
    public final int howToPlayState = 11;
    public final int creditsState = 12;


    // GAME PANEL CONSTRUCTOR
    public GamePanel() {
        this.setPreferredSize(new Dimension(ScreenWidth, ScreenHeight));    //set the size of the class (JPanel)
        this.setBackground(Color.BLACK);                                    //Background color
        this.setDoubleBuffered(true);   //If set to true, all the drawing from this component will be done in an off-screen painting buffer
        //enabling his can improve games rendering performance

        this.addKeyListener(handler);   //Panel can recognise Keyboard Input
        this.setFocusable(true);
    }

    // SETUP GAME
    public void setUpGame(){
        asset.setObject_HOSPITAL_ICU();
        asset.setNPC_HOSPITAL_ICU();
        //playMusic(0);
        GameState = titleState;
    }

    // THREAD
    public void startThread(){          //Thread
        thread = new Thread(this);
        thread.start();
    }

    @Override   // From implements Runnable
    public void run() {
        //when thread started, it automatically calls run()
        //GAME LOOP (core of game)

        // FPS
        double timeInterval = (double) 1000000000 /FPS;   //1000000000n Nanoseconds = 1 Second -> 1/FPS= 0.01666 sec
        double nextTime = System.nanoTime()+timeInterval;   //next time is 0.01666 seconds later

        // THREAD
        while(thread != null){  //as long as thread exists: Repeat!
            //System.out.println("Running...");     //testing loop

            // UPDATE & REPAINT
            update();   //Update information (f.e. as character position)
            repaint();      //Repaint screen with new information

            //https://www.geeksforgeeks.org/thread-sleep-method-in-java-with-examples/
            try {   //Thread.sleep can't take long variables (optional solution from java)
                double remainingTime = nextTime - System.nanoTime();    //Updating game is too fast -> Sleep Methode
                remainingTime = remainingTime/1000000;      //nano sec -> milli sec

                if(remainingTime < 0){      //if updating took more Time than "timeInterval" than no Time is remains
                    remainingTime=0;        //no need for Thread to sleep
                }
                Thread.sleep((long) remainingTime); //let thread sleep through remainingTime
                nextTime += timeInterval;           //0.01666 sec later
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // UPDATE
    public void update(){
        if(GameState == playState){
            // PLAYER
            player.update();        //update Player position

            // NPC
            for(int i = 0; i < NPC[1].length; i++){
                if(NPC[currentMap][i] != null) {
                    NPC[currentMap][i].update();
                }
            }

            if(ui.playTime <= 0){   //if Play Time is up
                GameState = GameOverState;
                //playSoundEffect(1);
            }

        }
    }

    // DRAW
    public void paintComponent(Graphics graphics) {
        //class that has many functions to draw objects on screen
        super.paintComponent(graphics);     //"paintComponent" building method from Java (not a name)

        //"Graphics2D" provides more function for graphic (color, geometry,...)
        Graphics2D graphics2d = (Graphics2D)graphics;

        // TITLE SCREEN
        if(GameState == titleState){
            ui.draw(graphics2d);
        }

        // OTHER
        else {
            // TILE
            manager.draw(graphics2d);   //draw manager tiles

            // ADD ENTITIES TO THE LIST

            // PLAYER
            entityList.add(player);

            // NPC
            for(int i = 0; i < NPC[1].length; i++)
                if(NPC[currentMap][i] != null)
                    entityList.add(NPC[currentMap][i]);

            // OBJECT
            for(int i = 0; i < object[1].length; i++)
                if(object[currentMap][i] != null)
                    entityList.add(object[currentMap][i]);

            // SORT
            entityList.sort(new Comparator<Entity>() {
                @Override
                public int compare(Entity e1, Entity e2) {
                    return Integer.compare(e1.MapY, e2.MapY);
                }
            });

            // DRAW ENTITIES
            for (Entity entity : entityList) entity.draw(graphics2d);

            // EMPTY ENTITY LIST
            entityList.clear();

            // UI
            ui.draw(graphics2d);
        }

        graphics2d.dispose();
    }

    // MUSIC AND SOUND EFFECT
    public void playMusic(int i){
        sound.setFile(i);   //choose file
        sound.play();       //play file
        sound.loop();       //continue/repeat in loop
    }
    public void stopMusic(){
        sound.stop();   //stop current music
    }
    public void playSoundEffect(int i){
        soundEffect.play(i);       //only play once (no loop)
    }
}
