package main;

import entity.Player;
import tile.Manager;

import javax.swing.*;
import java.awt.*;

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
    public final int maxMap = 4;
    public int currentMap = 0;
    public int maxMapCol = 20;
    public int maxMapRow = 20;
    public int MapWidth = tileSize*maxMapCol;
    public int MapHeight = tileSize*maxMapRow;
    public int TransitionMap, TransitionX, TransitionY;

    // FPS
    int FPS = 60;

    // SYSTEM
    Handler handler = new Handler(this);    //add Handler
    Manager manager = new Manager(this);
    //Sound sound = new Sound();
    //SoundEffect soundEffect = new SoundEffect();
    public CollisionDetection collisionDetection = new CollisionDetection(this);    //public for Player
    //public SetAsset asset = new SetAsset(this);
    //public UserInterface ui = new UserInterface(this);
    Thread thread;      //implements Runnable (in public class)


    // ENTITY AND OBJECT
    public Player player = new Player(this, this.handler);          //public for Manager
    //handler.setPlayer(player);
   // public GameObject[][] object = new GameObject[maxMap][30];

    // GAME STATE
    /*public int GameState;
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
    public final int creditsState = 12;*/


    // GAME PANEL CONSTRUCTOR
    public GamePanel() {
        this.setPreferredSize(new Dimension(ScreenWidth, ScreenHeight));    //set the size of the class (JPanel)
        this.setBackground(Color.BLACK);                                    //Background color
        this.setDoubleBuffered(true);   //If set to true, all the drawing from this component will be done in an off-screen painting buffer
        //enabling his can improve games rendering performance

        this.addKeyListener(handler);   //Panel can recognise Keyboard Input
        this.setFocusable(true);
    }

    // THREAD
    public void startThread(){          //Thread
        thread = new Thread(this);
        thread.start();
    }
    @Override               // From implements Runnable
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
        player.update();
    }

    // DRAW
    public void paintComponent(Graphics graphics) {
        //class that has many functions to draw objects on screen
        super.paintComponent(graphics);     //"paintComponent" building method from Java (not a name)

        //"Graphics2D" provides more function for graphic (color, geometry,...)
        Graphics2D graphics2d = (Graphics2D)graphics;



        // TILE
        manager.draw(graphics2d);   //draw manager tiles

        player.draw(graphics2d);

        graphics2d.dispose();
    }
}
