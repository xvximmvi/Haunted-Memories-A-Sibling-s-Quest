package main;

import entity.Entity;
import object.Attributes.Life;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;

// CLASS CONTENT
/*
    UI CONSTRUCTOR
        - Define Imported Font

    PRINT
        - TITLE SCREEN STATE
            > Title Screen
            > Menu Option Screen
            > How To Play Screen
            > Credits Screen
        - PLAY STATE
            > Time
            > Message
            > Tutorial
        - PAUSE STATE
            > Pause Screen
        - DIALOGUE STATE
            > Dialogue Window
        - GAME WON STATE
            > Game Won Screen
        - GAME OVER STATE
            > Game Over Screen
        - TRANSITION STATE
            > Transition ON-Screen
            > Transition OFF-Screen
        - CHARACTER STATE
            > Character Screen
        - OPTION STATE
            > Option Screen
            > Settings
            > How To Play
            > Restart Game
            > Exit Game
            > Main Menu
        - OTHER
            > Window
            > Center X Text
            > Center Window X Text

    METHODS FOR EACH!
 */

public class UserInterface {
    GamePanel panel;
    Graphics2D graphics2D;
    Font Retro_Gaming;              // Imported Font
    public int command = 0;         // Choose Option

    // DIALOGUE AND TEXT
    public String currentDialogue = "";
    public boolean MessageOn = false;
    public String Message = "";
    int MessageCounter = 0;
    int charIndex = 0;
    String combinedText = "";

    public int CompletionOfGame = 0;

    int TransitionCounter = 0;

    public boolean TutorialOn = true;
    public boolean Goal = false;
    public boolean Boss = true;
    public boolean Boss2 = false;
    int TutorialCounter = 0;

    // PLAY TIME
    public boolean Timer = false;
    public double playTime=100;      //100 sec Countdown
    //public double DefaultPlayTime = playTime;
    DecimalFormat decimalFormat = new DecimalFormat("#0.00");  //minimize decimals
    DecimalFormat decimalForCharacter = new DecimalFormat("#0.0");  //minimize decimals

    public int optionState = 0;
    public int menuState = 0;

    // INVENTORY
    public int slotCol = 0;
    public int slotRow = 0;

    // PLAYER LIFE
    BufferedImage Life_Full, Life_Lost;

    public Entity NPC;

    // UI CONSTRUCTOR
    public UserInterface(GamePanel panel){
        this.panel = panel;

        // IMPORTED FONT FILE
        InputStream is = getClass().getResourceAsStream("/Font/Retro Gaming.ttf");
        try {
            assert is != null;  //Javas Suggestion
            Retro_Gaming = Font.createFont(Font.TRUETYPE_FONT, is); //TRUE TYPE FONT due to imported Font
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        // CREATE HUD OBJECT
        Entity Life = new Life(panel);
        Life_Full = Life.image;
        Life_Lost = Life.image2;
    }

    // PRINT
    public void draw(Graphics2D graphics2D){

        this.graphics2D = graphics2D;
        graphics2D.setFont(Retro_Gaming);
        graphics2D.setColor(Color.white);

        // TITLE STATE  ------------------------------------------------------------------
        if(panel.GameState == panel.titleState){
            TitleScreen();
        }

        // PLAY STATE   ------------------------------------------------------------------
        if(panel.GameState == panel.playState) {

            graphics2D.setFont(Retro_Gaming);
            graphics2D.setColor(Color.white);


            // TIME ------------------------------------------------------------------
            if(Timer) {
                playTime -= (double) 1 / 60;    //add 1/60 to the loop (60 Frames per sec)
                graphics2D.setFont(graphics2D.getFont().deriveFont(Font.PLAIN, 20F));
                // SHADOW
                graphics2D.setColor(Color.BLACK);
                graphics2D.drawString("Time: " + decimalFormat.format(playTime), panel.tileSize * 15+30, 60 + 2);
                graphics2D.setColor(Color.WHITE);
                graphics2D.drawString("Time: " + decimalFormat.format(playTime), panel.tileSize * 15+30, 60);
            }

            // MESSAGE ------------------------------------------------------------------
            if (MessageOn) {
                graphics2D.drawString(Message, panel.tileSize, panel.tileSize + 90);

                MessageCounter++;
                if (MessageCounter > 120) {   //120 Frames (60 Frames per sec -> 2 sec)
                    MessageCounter = 0;
                    MessageOn = false;
                }
            }

            // TUTORIAL ------------------------------------------------------------------
            if (TutorialOn) {
                graphics2D.setFont(graphics2D.getFont().deriveFont(Font.PLAIN, 20F));
                graphics2D.setColor(Color.BLACK);
                graphics2D.drawString("Move: WASD", panel.tileSize+2, panel.tileSize+2);
                graphics2D.drawString("Interact: E", panel.tileSize+2, panel.tileSize + 30+2);
                graphics2D.drawString("Option: O", panel.tileSize+2, panel.tileSize + 60+2);
                graphics2D.drawString("Pause/Play: P", panel.tileSize+2, panel.tileSize + 90+2);
                graphics2D.setColor(Color.WHITE);
                graphics2D.drawString("Move: WASD", panel.tileSize, panel.tileSize);
                graphics2D.drawString("Interact: E", panel.tileSize, panel.tileSize + 30);
                graphics2D.drawString("Option: O", panel.tileSize, panel.tileSize + 60);
                graphics2D.drawString("Pause/Play: P", panel.tileSize, panel.tileSize + 90);

                TutorialCounter++;
                if (TutorialCounter > 420) {   //240 Frames (60 Frames per sec -> 4 sec)
                    TutorialCounter = 0;
                    TutorialOn = false;
                    Goal = true;
                }
            }
            else if (Goal) {
                graphics2D.setFont(graphics2D.getFont().deriveFont(Font.PLAIN, 20F));
                graphics2D.setColor(Color.BLACK);
                graphics2D.drawString("Find the CARD!", panel.tileSize+2, panel.tileSize+2);
                graphics2D.drawString("Escape the Hospital!", panel.tileSize+2, panel.tileSize + 32);
                graphics2D.setColor(Color.WHITE);
                graphics2D.drawString("Find the CARD!", panel.tileSize, panel.tileSize);
                graphics2D.drawString("Escape the Hospital!", panel.tileSize, panel.tileSize + 30);

                TutorialCounter++;
                if (TutorialCounter > 300) {
                    TutorialCounter = 0;
                    Goal = false;
                }
            }
            else if (Boss) {
                graphics2D.setFont(graphics2D.getFont().deriveFont(Font.PLAIN, 20F));
                graphics2D.setColor(Color.BLACK);
                graphics2D.drawString("Hit: J", panel.tileSize+2, panel.tileSize+2+40);
                graphics2D.drawString("Block: K", panel.tileSize+2, panel.tileSize + 30+2+40);
                graphics2D.setColor(Color.WHITE);
                graphics2D.drawString("Hit: J", panel.tileSize, panel.tileSize+40);
                graphics2D.drawString("Block: K", panel.tileSize, panel.tileSize + 30+40);

                TutorialCounter++;
                if (TutorialCounter > 300) {
                    TutorialCounter = 0;
                    Boss = false;
                }
            }
            else if (Boss2) {
                graphics2D.setFont(graphics2D.getFont().deriveFont(Font.PLAIN, 20F));
                graphics2D.setColor(Color.BLACK);
                graphics2D.drawString("Defeat the Enemy!", panel.tileSize + 2, panel.tileSize + 2+40);
                graphics2D.setColor(Color.WHITE);
                graphics2D.drawString("Defeat the Enemy!", panel.tileSize, panel.tileSize+40);

                TutorialCounter++;
                if (TutorialCounter > 240) {   //240 Frames (60 Frames per sec -> 4 sec)
                    TutorialCounter = 0;
                    Boss2 = false;
                }
            }

            if (panel.player.BOSS_FIGHT){
                drawPlayerLife();
                drawNPCLife();
            }
        }

        // PAUSE STATE  ------------------------------------------------------------------
        if(panel.GameState == panel.pauseState){
            if(panel.player.BOSS_FIGHT) {
                drawPlayerLife();
                drawNPCLife();
            }
            PauseScreen();
        }

        // DIALOGUE STATE   ------------------------------------------------------------------
        if(panel.GameState == panel.dialogueState){
            if(panel.player.BOSS_FIGHT) {
                drawPlayerLife();
                drawNPCLife();
            }
            DialogueWindow();
        }

        // GAME WON STATE   ------------------------------------------------------------------
        if(panel.GameState == panel.GameWonState){
            GameWonScreen();
        }

        // GAME OVER STATE  ------------------------------------------------------------------
        if(panel.GameState == panel.GameOverState){
            GameOverScreen();
        }

        // CHARACTER STATE  ------------------------------------------------------------------
        if(panel.GameState == panel.characterState){
            CharacterScreen();
        }

        // TRANSITION STATE ------------------------------------------------------------------
        if(panel.GameState == panel.transitionState){
            drawTransitionInState();
        }
        if(panel.GameState == panel.transitionOutState){
            drawTransitionOutState();
        }

        // OPTION STATE ------------------------------------------------------------------
        if(panel.GameState == panel.optionState){
            OptionScreen();
        }


        // MENU OPTION STATE ------------------------------------------------------------------
        if(panel.GameState == panel.menuOptionState){
            MenuOptionScreen();
        }

        // HOW TO PLAY STATE ------------------------------------------------------------------
        if(panel.GameState == panel.howToPlayState){
            HowToPlayScreen();
        }

        // CREDITS STATE
        if(panel.GameState == panel.creditsState){
            CreditsScreen();

        }

        // INVENTORY STATE
        if(panel.GameState == panel.inventoryState){
            InventoryScreen();
            CharacterScreen();
        }
    }


    // TILE SCREEN
    public void TitleScreen(){

        // BACKGROUND COLOR
        //graphics2D.setColor(new Color(81,113,145));
        //graphics2D.fillRect(0, 0, panel.ScreenWidth, panel.ScreenHeight);

        // GAME TITLE       ------------------------------------------------------------------
        graphics2D.setFont(graphics2D.getFont().deriveFont(Font.BOLD, 96F));
        String Text = "Haunted Memories";
        int x = CenterXText(Text);
        int y = panel.tileSize * 3;

        // SHADOW
        graphics2D.setColor(Color.GRAY);
        graphics2D.drawString(Text, x + 5, y + 5);

        // MAIN COLOR
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawString(Text, x, y);
        graphics2D.setFont(graphics2D.getFont().deriveFont(Font.BOLD, 60F));
        Text = "A Sibling's Quest";
        x = CenterXText(Text);
        y += panel.tileSize;

        // SHADOW
        graphics2D.setColor(Color.GRAY);
        graphics2D.drawString(Text, x + 5, y + 5);

        // MAIN COLOR
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawString(Text, x, y);


        // PLAYER CHARACTER   ------------------------------------------------------------------
        x = panel.ScreenWidth / 2 - (panel.tileSize);
        y += panel.tileSize;
        graphics2D.drawImage(panel.player.DOWN2, x, y, panel.tileSize * 2, panel.tileSize * 2+48, null);


        // NEW GAME     ------------------------------------------------------------------
        graphics2D.setFont(graphics2D.getFont().deriveFont(Font.BOLD, 32F));
        Text = "PLAY";
        x = CenterXText(Text);
        y += panel.tileSize * 4;

        // SHADOW
        graphics2D.setColor(Color.GRAY);
        graphics2D.drawString(Text, x + 3, y + 3);

        // MAIN COLOR
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawString(Text, x, y);

        // CHOOSE OPTION
        if (command == 0) {
            graphics2D.setColor(Color.GRAY);
            graphics2D.drawString(">", x - 30, y + 3);
            graphics2D.setColor(Color.WHITE);
            graphics2D.drawString(">", x - 30, y);
        }

        // SETTINGS   ------------------------------------------------------------------
        graphics2D.setFont(graphics2D.getFont().deriveFont(Font.BOLD, 32F));
        Text = "SETTINGS";
        x = CenterXText(Text);
        y += 36;

        // SHADOW
        graphics2D.setColor(Color.GRAY);
        graphics2D.drawString(Text, x + 3, y + 3);

        // MAIN COLOR
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawString(Text, x, y);

        // CHOOSE OPTION
        if (command == 1) {
            graphics2D.setColor(Color.GRAY);
            graphics2D.drawString(">", x - 30, y + 3);
            graphics2D.setColor(Color.WHITE);
            graphics2D.drawString(">", x - 30, y);
            if (panel.handler.Enter) {
                panel.handler.Enter = false;
                menuState = 1;
                command = 0;
            }
        }

        // HOW TO PLAY    ------------------------------------------------------------------
        graphics2D.setFont(graphics2D.getFont().deriveFont(Font.BOLD, 32F));
        Text = "HOW TO PLAY";
        x = CenterXText(Text);
        y += 36;

        // SHADOW
        graphics2D.setColor(Color.GRAY);
        graphics2D.drawString(Text, x + 3, y + 3);

        // MAIN COLOR
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawString(Text, x, y);

        // CHOOSE OPTION
        if (command == 2) {
            graphics2D.setColor(Color.GRAY);
            graphics2D.drawString(">", x - 30, y + 3);
            graphics2D.setColor(Color.WHITE);
            graphics2D.drawString(">", x - 30, y);
            if (panel.handler.Enter) {
                menuState = 2;
                command = 0;
            }
        }

        // CREDITS    ------------------------------------------------------------------
        graphics2D.setFont(graphics2D.getFont().deriveFont(Font.BOLD, 32F));
        Text = "CREDITS";
        x = CenterXText(Text);
        y += 36;

        // SHADOW
        graphics2D.setColor(Color.GRAY);
        graphics2D.drawString(Text, x + 3, y + 3);

        // MAIN COLOR
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawString(Text, x, y);

        // CHOOSE OPTION
        if (command == 3) {
            graphics2D.setColor(Color.GRAY);
            graphics2D.drawString(">", x - 30, y + 3);
            graphics2D.setColor(Color.WHITE);
            graphics2D.drawString(">", x - 30, y);
        }

        // EXIT GAME     ------------------------------------------------------------------
        graphics2D.setFont(graphics2D.getFont().deriveFont(Font.BOLD, 32F));
        Text = "EXIT GAME";
        x = CenterXText(Text);
        y += 36;

        // SHADOW
        graphics2D.setColor(Color.GRAY);
        graphics2D.drawString(Text, x + 3, y + 3);

        // MAIN COLOR
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawString(Text, x, y);

        // CHOOSE OPTION
        if (command == 4) {
            graphics2D.setColor(Color.GRAY);
            graphics2D.drawString(">", x - 30, y + 3);
            graphics2D.setColor(Color.WHITE);
            graphics2D.drawString(">", x - 30, y);
        }
    }
    public void MenuOptionScreen(){

        graphics2D.setColor(Color.BLACK);
        graphics2D.fillRect(0, 0, panel.ScreenWidth, panel.ScreenHeight);

        // SETTINGS       ------------------------------------------------------------------
        graphics2D.setFont(graphics2D.getFont().deriveFont(Font.BOLD, 70F));
        String Text = "SETTINGS";
        int x = CenterXText(Text);
        int y = panel.tileSize * 3;
        graphics2D.setColor(Color.GRAY);
        graphics2D.drawString(Text, x + 5, y + 5);
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawString(Text, x, y);

        // MUSIC       ------------------------------------------------------------------
        graphics2D.setFont(graphics2D.getFont().deriveFont(Font.BOLD, 32F));
        Text = "Music";
        x = panel.tileSize*2;
        y += (int) (panel.tileSize * 2.5);
        graphics2D.setColor(Color.GRAY);
        graphics2D.drawString(Text, x + 3, y + 3);
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawString(Text, x, y);
        if (command == 0) {
            graphics2D.setColor(Color.GRAY);
            graphics2D.drawString(">", x - 30, y + 3);
            graphics2D.setColor(Color.WHITE);
            graphics2D.drawString(">", x - 30, y);
        }

        // SOUND FX       ------------------------------------------------------------------
        Text = "SOUND FX";
        y += 36;
        graphics2D.setColor(Color.GRAY);
        graphics2D.drawString(Text, x + 3, y + 3);
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawString(Text, x, y);
        if (command == 1) {
            graphics2D.setColor(Color.GRAY);
            graphics2D.drawString(">", x - 30, y + 3);
            graphics2D.setColor(Color.WHITE);
            graphics2D.drawString(">", x - 30, y);
        }

        // TIMER ON/OFF      ------------------------------------------------------------------
        Text = "Timer ON/OFF";
        y += 36;
        graphics2D.setColor(Color.GRAY);
        graphics2D.drawString(Text, x + 3, y + 3);
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawString(Text, x, y);
        if (command == 2) {
            graphics2D.setColor(Color.GRAY);
            graphics2D.drawString(">", x - 30, y + 3);
            graphics2D.setColor(Color.WHITE);
            graphics2D.drawString(">", x - 30, y);
            if(panel.handler.Enter){
                panel.handler.Enter = false;
                Timer = ! Timer;
            }
        }

        // BACK       ------------------------------------------------------------------
        Text = "Back";
        x = CenterXText(Text);
        y = panel.ScreenHeight-panel.tileSize*2;
        graphics2D.setColor(Color.GRAY);
        graphics2D.drawString(Text, x + 3, y + 3);
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawString(Text, x, y);
        if (command == 3) {
            graphics2D.setColor(Color.GRAY);
            graphics2D.drawString(">", x - 30, y + 3);
            graphics2D.setColor(Color.WHITE);
            graphics2D.drawString(">", x - 30, y);
            if(panel.handler.Enter){
                panel.GameState = panel.titleState;
                command = 1;
                panel.handler.Enter=false;
            }
        }

        // RIGHT SIDE       ------------------------------------------------------------------

        // MUSIC VOLUME BAR ------------------------
        x = panel.tileSize*9;
        y = panel.tileSize*5-5;
        graphics2D.drawRoundRect(x,y,153, 22, 6, 6);
        int volumeWidth = 29*panel.sound.volumeScale;
        graphics2D.fillRoundRect(x+4,y+4,volumeWidth, 14, 3, 3); //145:5 = 29

        // SOUND FX BAR ------------------------
        y += 40;
        graphics2D.drawRoundRect(x,y,153, 22, 6, 6);
        volumeWidth = 29*panel.soundEffect.volumeScale;
        graphics2D.fillRoundRect(x+4,y+4,volumeWidth, 14, 3, 3);


        // TIMER CHECKBOX  ------------------------
        y += 38;
        x = panel.tileSize*10+12;
        graphics2D.setStroke(new BasicStroke(3));
        graphics2D.drawRoundRect(x, y,28, 28, 8, 8);
        if(Timer){
            graphics2D.fillRoundRect(x+4,y+4,20, 20, 3, 3);
        }
    }
    public void HowToPlayScreen(){
        graphics2D.setColor(Color.BLACK);
        graphics2D.fillRect(0, 0, panel.ScreenWidth, panel.ScreenHeight);

        // RIGHT SIDE       ------------------------------------------------------------------
        graphics2D.setFont(graphics2D.getFont().deriveFont(Font.BOLD, 70F));
        String Text = "HOW TO PLAY";
        int x = CenterXText(Text);
        int y = (int) (panel.tileSize * 2.5);
        graphics2D.setColor(Color.GRAY);
        graphics2D.drawString(Text, x + 5, y + 5);
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawString(Text, x, y);

        graphics2D.setFont(graphics2D.getFont().deriveFont(Font.BOLD, 32F));
        Text = "Move ";
        x = panel.tileSize * 3;
        y += (int) (panel.tileSize * 2.5);
        graphics2D.setColor(Color.GRAY);
        graphics2D.drawString(Text, x + 3, y + 3);
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawString(Text, x, y);
        Text = "Interaction";
        y += 36;
        graphics2D.setColor(Color.GRAY);
        graphics2D.drawString(Text, x + 3, y + 3);
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawString(Text, x, y);
        Text = "Open / CLose Inventory";
        y += 36;
        graphics2D.setColor(Color.GRAY);
        graphics2D.drawString(Text, x + 3, y + 3);
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawString(Text, x, y);
        Text = "Hit";
        y += 36;
        graphics2D.setColor(Color.GRAY);
        graphics2D.drawString(Text, x + 3, y + 3);
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawString(Text, x, y);
        Text = "Block";
        y += 36;
        graphics2D.setColor(Color.GRAY);
        graphics2D.drawString(Text, x + 3, y + 3);
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawString(Text, x, y);
        Text = "Select / Continue";
        y += 36;
        graphics2D.setColor(Color.GRAY);
        graphics2D.drawString(Text, x + 3, y + 3);
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawString(Text, x, y);
        Text = "Settings";
        y += 36;
        graphics2D.setColor(Color.GRAY);
        graphics2D.drawString(Text, x + 3, y + 3);
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawString(Text, x, y);
        Text = "Pause / Play";
        y += 36;
        graphics2D.setColor(Color.GRAY);
        graphics2D.drawString(Text, x + 3, y + 3);
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawString(Text, x, y);
        Text = "Game- & Character-Info";
        y += 36;
        graphics2D.setColor(Color.GRAY);
        graphics2D.drawString(Text, x + 3, y + 3);
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawString(Text, x, y);

        // BOTTOM       ------------------------------------------------------------------
        Text = "Back with ESC";
        x = CenterXText(Text);
        y = panel.ScreenHeight-panel.tileSize-24;
        graphics2D.setColor(Color.GRAY);
        graphics2D.drawString(Text, x + 3, y + 3);
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawString(Text, x, y);

        // LEFT SIDE       ------------------------------------------------------------------

        Text = "W A S D ";
        x = panel.tileSize * 12-4;
        y = panel.tileSize * 5;
        graphics2D.setColor(Color.GRAY);
        graphics2D.drawString(Text, x + 3, y + 3);
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawString(Text, x, y);
        Text = "     E";
        y += 36;
        x = panel.tileSize * 12;
        graphics2D.setColor(Color.GRAY);
        graphics2D.drawString(Text, x + 3, y + 3);
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawString(Text, x, y);
        Text = "     I";
        y += 36;
        graphics2D.setColor(Color.GRAY);
        graphics2D.drawString(Text, x + 3, y + 3);
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawString(Text, x, y);
        Text = "     J";
        y += 36;
        graphics2D.setColor(Color.GRAY);
        graphics2D.drawString(Text, x + 3, y + 3);
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawString(Text, x, y);
        Text = "     K";
        y += 36;
        graphics2D.setColor(Color.GRAY);
        graphics2D.drawString(Text, x + 3, y + 3);
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawString(Text, x, y);
        Text = "ENTER";
        y += 36;
        graphics2D.setColor(Color.GRAY);
        graphics2D.drawString(Text, x + 3, y + 3);
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawString(Text, x, y);
        Text = "     O";
        y += 36;
        graphics2D.setColor(Color.GRAY);
        graphics2D.drawString(Text, x + 3, y + 3);
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawString(Text, x, y);
        Text = "     P";
        y += 36;
        graphics2D.setColor(Color.GRAY);
        graphics2D.drawString(Text, x + 3, y + 3);
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawString(Text, x, y);
        Text = "     C";
        y += 36;
        graphics2D.setColor(Color.GRAY);
        graphics2D.drawString(Text, x + 3, y + 3);
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawString(Text, x, y);
    }
    public void CreditsScreen(){
        // BACKGROUND COLOR
        graphics2D.setColor(new Color(0,0,0));
        graphics2D.fillRect(0, 0, panel.ScreenWidth, panel.ScreenHeight);

        int y = panel.handler.y;

        // GAME TITLE       ------------------------------------------------------------------
        graphics2D.setFont(graphics2D.getFont().deriveFont(Font.BOLD, 96F));
        String Text = "WAY OUT";
        int x = CenterXText(Text);
        y += panel.tileSize * 3;
        graphics2D.setColor(Color.GRAY);
        graphics2D.drawString(Text, x + 5, y + 5);
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawString(Text, x, y);
        y += panel.tileSize * 3;

        graphics2D.setFont(graphics2D.getFont().deriveFont(Font.PLAIN, 22F));

        // CREDITS
        String credits = """
                Game by

                Klea Kupi-Herbst
                Kevin Schmid
                





                Program Supervision
                
                Klea Kupi-Herbst
                





                Music by

                Kevin Schmid






                Art by

                Klea Kupi-Herbst






                Gameplay by

                Klea Kupi-Herbst
                Kevin Schmid






                FH Campus Wien
                University of Applied Sciences

                Computer Science and Digital Communication
                Year Group: CE25

                2024""";

        for(String line : credits.split("\n")){
            x = CenterXText(line);
            graphics2D.drawString(line, x,y);
            y += 24;
        }

        // SCROLL
        String text;
        text = "Scroll:\n  W/S";
        x = 24;
        y = panel.ScreenHeight- panel.tileSize;
        for(String line : text.split("\n")){
            graphics2D.drawString(line, x,y);
            y += 24;
        }

        // BACK WITH ESC
        text = "Back with ESC";
        int TextLength = (int)graphics2D.getFontMetrics().getStringBounds(text, graphics2D).getWidth();
        x = panel.ScreenWidth-TextLength-24;
        y = panel.ScreenHeight- 26;
        graphics2D.drawString(text, x,y);
    }

    // LIFE
    public void drawPlayerLife(){
        int x = panel.tileSize;
        int y = panel.tileSize/2;
        int i = 0;

        // DRAW BLANK LIFE (LOST LIFE)
        while(i < panel.player.maxLife) {
            graphics2D.drawImage(Life_Lost, x, y, null);
            i++;
            x += 28;
        }

        // RESET
        x = panel.tileSize;
        y = panel.tileSize/2;
        i = 0;

        // DRAW CURRENT LIFE
        while (i < panel.player.life) {
            graphics2D.drawImage(Life_Full, x, y, null);
            i++;
            x += 28;
        }
    }
    public void drawNPCLife() {

        if (panel.NPC[3][0] != null) {

            int x = panel.ScreenWidth - panel.tileSize - 602;
            int y = panel.tileSize;
            graphics2D.setColor(new Color(35, 35, 35));
            graphics2D.fillRoundRect(x - 2, y - 2, 600+4, 24, 5,5);

            graphics2D.setColor(new Color(200, 0, 30));
            graphics2D.fillRoundRect(x+600-(30*panel.NPC[3][0].life), y, 30*panel.NPC[3][0].life, 20, 5,5);

            graphics2D.setFont(graphics2D.getFont().deriveFont(Font.PLAIN, 22f));
            graphics2D.setColor(Color.WHITE);
            graphics2D.drawString("Rapist", panel.ScreenWidth- panel.tileSize*3+40, y - 10);
        }
    }

    // PAUSE SCREEN
    public void PauseScreen(){

        // Background Transparency (little darker than actual background image)
        graphics2D.setColor(new Color(0,0,0,100));
        graphics2D.fillRect(0,0,panel.ScreenWidth,panel.ScreenHeight);

        graphics2D.setFont(graphics2D.getFont().deriveFont(Font.PLAIN, 45F));
        String Text = "PAUSED";

        int x = CenterXText(Text);
        int y= panel.ScreenHeight/2;

        // SHADOW
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawString(Text,x+3,y+3);

        // MAIN COLOR
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawString(Text, x, y);
    }

    // GENERAL WINDOW
    public void Window(int x, int y, int width, int height){
        // WINDOW for Dialogue, Character & Options
        //Set color for Window (not 100% black; little transparency)
        Color color = new Color(0, 0, 0,205);       //RGB Number for Black (r, g, b, transparency) Color + transparency
        graphics2D.setColor(color);

        graphics2D.fillRoundRect(x, y, width, height, 35, 35);  //fill Round Rectangle

        // WHITE OUTLINES
        color = new Color(255,255,255, 215);         //RGB Number for White
        graphics2D.setColor(color);
        graphics2D.setStroke(new BasicStroke(5));
        //setStroke(new BasicStroke(int)) -> defines the width of the outlines of graphics which are rendered with a Graphics2D

        //Draw Round Rect vs. Fill Round Rect:   Fill - filled Rectangle / Draw - draw only outlines without filled area
        graphics2D.drawRoundRect(x+5,y+5,width-10,height-10,25,25);
    }

    // DIALOGUE SCREEN
    public void DialogueWindow(){
        // WINDOW
        int width = panel.ScreenWidth - (panel.tileSize*4);
        int height = panel.tileSize*3;
        int x = panel.ScreenWidth/2 - width/2;      //Window in Center of Screen
        int y = panel.ScreenHeight - height - panel.tileSize/2;

        Window(x, y, width, height);    // call Window() Methode to draw wanted Window

        // DIALOGUE TEXT WITHIN WINDOW
        graphics2D.setFont(graphics2D.getFont().deriveFont(Font.PLAIN, 24));
        x += panel.tileSize;    // little more to the left than where the dialogue starts
        y += panel.tileSize;
        //graphics2D.drawString(currentDialogue, x, y); //Write Dialogue


        if(NPC.dialogueSet == -1)  NPC.dialogueSet = 2;
        if(NPC.dialogues[NPC.dialogueSet][NPC.dialogueIndex] != null) {
 //           currentDialogue = NPC.dialogues[NPC.dialogueSet][NPC.dialogueIndex];

            char characters[] = NPC.dialogues[NPC.dialogueSet][NPC.dialogueIndex].toCharArray();

            if(charIndex < characters.length) {

                // TODO:
                //panel.playSoundEffect(SOUNDFX);
                String string = String.valueOf(characters[charIndex]);
                combinedText = combinedText + string;
                currentDialogue = combinedText;

                charIndex++;
            }

            if(panel.handler.Enter) {

                charIndex = 0;
                combinedText = "";

                if(panel.GameState == panel.dialogueState) {
                    NPC.dialogueIndex++;
                    panel.handler.Enter = false;
                }
            }

        } else {    //If no text in the array
            NPC.dialogueIndex = 0;
            if(NPC.Snitch) {
                panel.player.reset = true;
                panel.GameState = panel.transitionState;
            }
            else if(panel.GameState == panel.dialogueState)  panel.GameState = panel.playState;
        }

        //Problem: Dialogue to long to fit -> create more Strings to separate dialogue in pieces
        for(String line : currentDialogue.split("\n")){ // .split("\n")  -> knows when to split each dialogue
            //without .split("\n") the drawString doesn't know what \n means and just keeps going without inserting a new line
            graphics2D.drawString(line, x, y);
            y += 30;    //know where to draw the new String Text
        }
    }

    // CHARACTER SCREEN
    public void CharacterScreen(){

        // WINDOW
        final int characterWindowX = panel.tileSize;
        final int characterWindowY = panel.tileSize;
        final int characterWindowWidth = panel.tileSize*8;
        final int characterWindowHeight = panel.tileSize*5;
        Window(characterWindowX, characterWindowY, characterWindowWidth, characterWindowHeight);

        // TEXT
        graphics2D.setColor(Color.WHITE);
        graphics2D.setFont(graphics2D.getFont().deriveFont(Font.PLAIN, 24F));

        int textX = characterWindowX + panel.tileSize/2;
        int textY = characterWindowY+ panel.tileSize+30;
        final int lineHeight = 24;      //same as Font Size


        // GAME TITLE       ------------------------------------------------------------------
        String title = "Haunted Memories";
        int titleX = CenterWindowXText(title, characterWindowWidth, characterWindowX);
        graphics2D.drawString(title, titleX, textY-20);

        title = "A Sibling's Quest";
        titleX = CenterWindowXText(title, characterWindowWidth, characterWindowX);
        graphics2D.drawString(title, titleX, textY);


        // LEFT SIDE       ------------------------------------------------------------------

        textY += lineHeight*3;

        graphics2D.drawString("Name", textX, textY);
        textY += lineHeight;

        graphics2D.drawString("Age", textX, textY);
        textY += lineHeight;

        graphics2D.drawString("Level", textX, textY);
        textY += lineHeight;

        graphics2D.drawString("Location", textX, textY);
        textY += lineHeight;

        graphics2D.drawString("Complete", textX, textY);
        textY += lineHeight;

        if(Timer) {     //Only show time if Timer is ON
            graphics2D.drawString("Time Left", textX, textY);
        }


        // RIGHT SIDE       ------------------------------------------------------------------

        String Info = panel.player.CharacterName;
        textY = characterWindowY+ panel.tileSize+30 + lineHeight*3;

        int InfoX = (characterWindowX+characterWindowWidth) - (int)graphics2D.getFontMetrics().getStringBounds(Info, graphics2D).getWidth() - 20;
        graphics2D.drawString(Info, InfoX, textY);
        textY += lineHeight;

        Info = panel.player.CharacterAge;
        InfoX = (characterWindowX+characterWindowWidth) - (int)graphics2D.getFontMetrics().getStringBounds(Info, graphics2D).getWidth() - 20;
        graphics2D.drawString(Info, InfoX, textY);
        textY += lineHeight;

        Info = panel.player.Level;
        InfoX = (characterWindowX+characterWindowWidth) - (int)graphics2D.getFontMetrics().getStringBounds(Info, graphics2D).getWidth() - 20;
        graphics2D.drawString(Info, InfoX, textY);
        textY += lineHeight;

        Info = panel.player.Location1;
        InfoX = (characterWindowX+characterWindowWidth) - (int)graphics2D.getFontMetrics().getStringBounds(Info, graphics2D).getWidth() - 20;
        graphics2D.drawString(Info, InfoX, textY);
        textY += lineHeight;

        Info = (CompletionOfGame*100/panel.player.FullCompletion) + " %";
        InfoX = (characterWindowX+characterWindowWidth) - (int)graphics2D.getFontMetrics().getStringBounds(Info, graphics2D).getWidth() - 20;
        graphics2D.drawString(Info, InfoX, textY);
        textY += lineHeight;

        if(Timer) {     // only show Time if Timer is ON
            Info = decimalForCharacter.format(playTime) + " s";
            InfoX = (characterWindowX + characterWindowWidth) - (int) graphics2D.getFontMetrics().getStringBounds(Info, graphics2D).getWidth() - 20;
            graphics2D.drawString(Info, InfoX, textY);
        }
    }

    // INVENTORY SCREEN
    public void InventoryScreen() {
        // INVENTOR WINDOW
        final int characterWindowX = panel.tileSize*11;
        final int characterWindowY = panel.tileSize;
        final int characterWindowWidth = panel.tileSize*6;
        final int characterWindowHeight = panel.tileSize*5;
        Window(characterWindowX, characterWindowY, characterWindowWidth, characterWindowHeight);

        // SLOT
        final int slotXStart = characterWindowX + panel.tileSize/2;
        final int slotYStart = characterWindowY + panel.tileSize/2;
        int slotX = slotXStart;
        int slotY = slotYStart;

        // DRAW PLAYER'S ITEMS
        for(int i = 0; i < panel.player.Inventory.size(); i++){
            graphics2D.drawImage(panel.player.Inventory.get(i).DOWN1, slotX+(panel.tileSize - panel.player.Inventory.get(i).ObjectWidth)/2, slotY+(panel.tileSize - panel.player.Inventory.get(i).ObjectHeight)/2, null);

            slotX += panel.tileSize;

            if(i == 4 || i == 9 || i == 14){
                slotX = slotXStart;
                slotY += panel.tileSize;
            }
        }

        // CURSOR
        int cursorX = slotXStart + (panel.tileSize*slotCol);
        int cursorY = slotYStart + (panel.tileSize*slotRow);
        int cursorWidth = panel.tileSize;
        int cursorHeight = panel.tileSize;

        // DRAW CURSOR
        graphics2D.setColor(Color.WHITE);
        graphics2D.setStroke(new BasicStroke(3));   // make cursor not that thick
        graphics2D.drawRoundRect(cursorX, cursorY, cursorWidth, cursorHeight, 10, 10);


        // DESCRIPTION WINDOW
        final int descriptionWindowY = characterWindowY + characterWindowHeight + panel.tileSize/2;
        final int descriptionWindowHeight = panel.tileSize*3;
        // Description Window should show always even when no Item is in the selected slot
        //Window(characterWindowX, descriptionWindowY, characterWindowWidth, descriptionWindowHeight);


        //DRAW DESCRIPTION TEXT
        int textX = characterWindowX + panel.tileSize/2;
        int textY = descriptionWindowY + panel.tileSize;
        graphics2D.setFont(graphics2D.getFont().deriveFont(20F));

        int itemIndex = getItemIndexOnSlot();

        if(itemIndex < panel.player.Inventory.size()) {

            // Description Window should show ONLY when an Item is in the selected slot
            Window(characterWindowX, descriptionWindowY, characterWindowWidth, descriptionWindowHeight);

            for(String line: panel.player.Inventory.get(itemIndex).description.split("\n")) {
                graphics2D.drawString(line, textX, textY);
                textY += 32;
            }
        }
    }
    public int getItemIndexOnSlot() {
        return slotCol + slotRow*5;
    }

    // MAP TRANSITION
    public void drawTransitionInState(){
        if(!panel.player.reset) {
            TransitionCounter++;        // Count up
            graphics2D.setColor(new Color(0, 0, 0, 3 * TransitionCounter + 5)); // gets darker the more it counts up
            graphics2D.fillRect(0, 0, panel.ScreenWidth, panel.ScreenHeight);      //fill screen darker and darker

            if (TransitionCounter >= 30) {   //when reached certain point

                panel.currentMap = panel.TransitionMap;                         // Which Map to Switch to
                if (panel.TransitionMap == 0)
                    panel.asset.setObject_HOSPITAL_ICU();   //Set object to corresponding map
                if (panel.TransitionMap == 1) panel.asset.setObject_HOSPITAL_HALL3F();
                if (panel.TransitionMap == 2) panel.asset.setObject_HOSPITAL_TOILET();
                if (panel.TransitionMap == 3) panel.asset.setObject_HOSPITAL_TOILET();

                panel.player.direction = panel.TransitionDirection;

                panel.player.MapX = panel.tileSize * panel.TransitionX - (panel.tileSize / 2);     // X-Coordinate of Spawn point
                panel.player.MapY = panel.tileSize * panel.TransitionY - (panel.tileSize / 2);     // Y-Coordinate of Spawn point

                TransitionCounter = 0;    //set counter back to zero for next Transition
                panel.GameState = panel.transitionOutState;

            }
        } else  {
            TransitionCounter++;        // Count up
            graphics2D.setColor(new Color(0, 0, 0, 5 * TransitionCounter + 5)); // gets darker the more it counts up
            graphics2D.fillRect(0, 0, panel.ScreenWidth, panel.ScreenHeight);      //fill screen darker and darker
            if (TransitionCounter == 50) {   //when reached certain point
                panel.player.resetGame();
                TransitionCounter = 0;    //set counter back to zero for next Transition
                panel.GameState = panel.transitionOutState; // go to next step (Make screen lighter again; same transition just backwards)
            }
        }

    }
    public void drawTransitionOutState(){
        int t = 30;
        int out = 95;
        if(panel.player.reset) {
            t = 50;
            out = 255;
        }

        TransitionCounter++;
        graphics2D.setColor(new Color(0, 0, 0, out - 3 * TransitionCounter));    //the certain which was reached in if(TransitionCounter == 40) from methode above
        graphics2D.fillRect(0, 0, panel.ScreenWidth, panel.ScreenHeight);        //show new screen transparency


        if (TransitionCounter == t) {    //when its lighten enough
            TransitionCounter = 0;      //set TransitionCounter back for next needed Transition
            panel.GameState = panel.playState;  //switch back to player state
            panel.player.reset = false;
        }
    }

    // OPTION SCREEN
    public void OptionScreen(){
        // WINDOW
        final int optionWindowX = panel.tileSize;
        final int optionWindowY = panel.tileSize;
        final int optionWindowWidth = panel.tileSize*8;
        final int optionWindowHeight = panel.tileSize*10;
        Window(optionWindowX, optionWindowY, optionWindowWidth, optionWindowHeight);

        // TEXT
        graphics2D.setColor(Color.WHITE);
        graphics2D.setFont(graphics2D.getFont().deriveFont(Font.PLAIN, 24F));

        int textY = optionWindowY+ 2*panel.tileSize;

        // TITLE
        String title = "Settings";
        int titleX = CenterWindowXText(title, optionWindowWidth, optionWindowX);
        graphics2D.drawString(title, titleX, textY-40);

        // OPTION STATE
        switch (optionState) {
            case 0 -> Settings(optionWindowX, optionWindowY, optionWindowHeight, optionWindowWidth);
            case 1 -> HowToPlay(optionWindowX, optionWindowY, optionWindowHeight, optionWindowWidth);
            case 2 -> ExitGame(optionWindowX, optionWindowY, optionWindowWidth);
            case 3 -> RestartGame(optionWindowX, optionWindowY, optionWindowWidth);
            case 4 -> MainMenu(optionWindowX, optionWindowY, optionWindowWidth);
        }

        panel.handler.Enter = false;
    }
    public void Settings(int optionWindowX, int optionWindowY, int optionWindowHeight, int optionWindowWidth){

        graphics2D.setFont(graphics2D.getFont().deriveFont(Font.PLAIN, 22F));

        int textX = optionWindowX + panel.tileSize-10;
        int textY = optionWindowY+ 2*panel.tileSize+12;
        final int lineHeight = 36;


        // LEFT SIDE       ------------------------------------------------------------------
        // TIMER
        graphics2D.drawString("Timer", textX, textY);
        if(command==0){
            graphics2D.drawString(">",textX-20, textY);
            if(panel.handler.Enter){
                Timer = !Timer;
            }
        }

        // MUSIC
        textY += lineHeight;
        graphics2D.drawString("Music", textX, textY);
        if(command==1){
            graphics2D.drawString(">",textX-20, textY);
        }

        // SOUND FX
        textY += lineHeight;
        graphics2D.drawString("Sound FX", textX, textY);
        if(command==2){
            graphics2D.drawString(">",textX-20, textY);
        }

        // HOW TO PLAY
        textY += lineHeight;
        graphics2D.drawString("How to play", textX, textY);
        if(command==3){
            graphics2D.drawString(">",textX-20, textY);
            if(panel.handler.Enter){
                optionState = 1;
                command = 0;
            }
        }

        // RESTART
        textY += lineHeight;
        graphics2D.drawString("Restart", textX, textY);
        if(command==4){
            graphics2D.drawString(">",textX-20, textY);
            if(panel.handler.Enter){
                optionState = 3;
                command = 0;
            }
        }

        // MAIN MENU
        textY += lineHeight;
        graphics2D.drawString("Main Menu", textX, textY);
        if(command==5){
            graphics2D.drawString(">",textX-20, textY);
            if(panel.handler.Enter){
                optionState = 4;
                command = 0;
            }
        }

        // EXIT GAME
        textY += lineHeight;
        graphics2D.drawString("Exit Game", textX, textY);
        if(command==6){
            graphics2D.drawString(">",textX-20, textY);
            if(panel.handler.Enter){
                optionState = 2;
                command = 0;
            }
        }

        // RIGHT SIDE       ------------------------------------------------------------------
        textY = optionWindowY+optionWindowHeight- 30;
        textX = (optionWindowX+optionWindowWidth) - (int)graphics2D.getFontMetrics().getStringBounds("Back", graphics2D).getWidth() - 24;
        graphics2D.drawString("Back", textX, textY);
        if(command==7){
            graphics2D.setFont(graphics2D.getFont().deriveFont(Font.BOLD, 22F));
            graphics2D.drawString(".",textX-20, textY-5);
            if(panel.handler.Enter){
                panel.GameState = panel.playState;
                command = 0;
            }
        }

        // TIMER ON/OFF
        textY = optionWindowY+ 2*panel.tileSize-2;
        graphics2D.setStroke(new BasicStroke(3));
        graphics2D.drawRoundRect(textX,textY,20, 20, 8, 8);
        if(Timer){
            graphics2D.fillRoundRect(textX+4,textY+4,12, 12, 3, 3);
        }

        // MUSIC VOLUME
        textY += lineHeight-1;
        textX = (optionWindowX+optionWindowWidth)-153-24;
        graphics2D.drawRoundRect(textX,textY,153, 16, 6, 6);
        int volumeWidth = 29*panel.sound.volumeScale;
        graphics2D.fillRoundRect(textX+4,textY+4,volumeWidth, 8, 3, 3); //145:5 = 29

        // SOUND FX
        textY += lineHeight;
        graphics2D.drawRoundRect(textX,textY,153, 16, 6, 6);
        volumeWidth = 29*panel.soundEffect.volumeScale;
        graphics2D.fillRoundRect(textX+4,textY+4,volumeWidth, 8, 3, 3);
    }
    public void HowToPlay(int optionWindowX, int optionWindowY, int optionWindowHeight, int optionWindowWidth){
        graphics2D.setFont(graphics2D.getFont().deriveFont(Font.PLAIN, 20F));

        int textX = optionWindowX + panel.tileSize-10;
        int textY = optionWindowY+ 3*panel.tileSize;
        final int lineHeight = 36;      //same as Font Size

        // TITLE       ------------------------------------------------------------------
        String title = "How to play";
        int titleX = CenterWindowXText(title, optionWindowWidth, optionWindowX);
        graphics2D.drawString(title, titleX, textY-40);


        // LEFT SIDE       ------------------------------------------------------------------
        textY +=lineHeight;
        graphics2D.drawString("Move", textX, textY);

        textY += lineHeight;
        graphics2D.drawString("Interaction", textX, textY);

        textY += lineHeight;
        graphics2D.drawString("Open / Close Inventory", textX, textY);

        textY +=lineHeight;
        graphics2D.drawString("Hit", textX, textY);

        textY +=lineHeight;
        graphics2D.drawString("Block", textX, textY);

        textY += lineHeight;
        graphics2D.drawString("Select / Continue", textX, textY);

        textY += lineHeight;
        graphics2D.drawString("Settings", textX, textY);

        textY += lineHeight;
        graphics2D.drawString("Pause / Play", textX, textY);

        textY += lineHeight;
        graphics2D.drawString("Game- & Character-Info", textX, textY);






        // BOTTOM       ------------------------------------------------------------------
        textY = optionWindowY+optionWindowHeight- 30;
        textX = (optionWindowX+optionWindowWidth) - (int)graphics2D.getFontMetrics().getStringBounds("Back", graphics2D).getWidth() - 24;
        graphics2D.drawString("Back", textX, textY);
        if(command==0){
            graphics2D.setFont(graphics2D.getFont().deriveFont(Font.BOLD, 22F));
            graphics2D.drawString(".",textX-20, textY-5);
            if(panel.handler.Enter){
                optionState = 0;
                command = 3;
            }
        }


        // RIGHT SIDE       ------------------------------------------------------------------
        graphics2D.setFont(graphics2D.getFont().deriveFont(Font.PLAIN, 20F));
        textX = (optionWindowX+optionWindowWidth) - (int)graphics2D.getFontMetrics().getStringBounds("W A S D", graphics2D).getWidth() - 24;
        textY = optionWindowY+ 3*panel.tileSize;
        textY +=lineHeight;
        graphics2D.drawString("W A S D", textX-4, textY);
        textY += lineHeight;
        graphics2D.drawString("    E", textX, textY);
        textY += lineHeight;
        graphics2D.drawString("    I", textX, textY);
        textY += lineHeight;
        graphics2D.drawString("    J", textX, textY);
        textY += lineHeight;
        graphics2D.drawString("    K", textX, textY);
        textY += lineHeight;
        graphics2D.drawString("ENTER", textX, textY);
        textY += lineHeight;
        graphics2D.drawString("    O", textX, textY);
        textY += lineHeight;
        graphics2D.drawString("    P", textX, textY);
        textY += lineHeight;
        graphics2D.drawString("    C", textX, textY);

    }
    public void RestartGame(int optionWindowX, int optionWindowY, int optionWindowWidth){

        graphics2D.setFont(graphics2D.getFont().deriveFont(Font.PLAIN, 20F));

        // TITLE
        String title = "Restart";
        int textY = optionWindowY+ 3*panel.tileSize;
        int titleX = CenterWindowXText(title, optionWindowWidth, optionWindowX);
        graphics2D.drawString(title, titleX, textY);

        // CONFIRMATION REQUEST
        textY += panel.tileSize;
        String text = "Are your sure you want to\nrestart the Game?";
        for(String line: text.split("\n")){
            titleX = CenterWindowXText(line, optionWindowWidth, optionWindowX);
            graphics2D.drawString(line, titleX, textY);
            textY += 24;
        }

        // YES
        textY += panel.tileSize;
        text = "Yes";
        int textX = CenterWindowXText(text, optionWindowWidth, optionWindowX);
        graphics2D.drawString(text, textX, textY);
        if(command==0){
            graphics2D.drawString(">",textX-20, textY);
            if(panel.handler.Enter){
                panel.player.reset = true;
                panel.GameState = panel.transitionState;
            }
        }

        // NO
        textY += panel.tileSize;
        text = "No";
        textX = CenterWindowXText(text, optionWindowWidth, optionWindowX);
        graphics2D.drawString(text, textX, textY);
        if(command==1){
            graphics2D.drawString(">",textX-20, textY);
            if(panel.handler.Enter){
                optionState=0;
                command = 4;
            }
        }
    }
    public void ExitGame(int optionWindowX, int optionWindowY, int optionWindowWidth){

        graphics2D.setFont(graphics2D.getFont().deriveFont(Font.PLAIN, 20F));

        // TITLE
        String title = "Exit Game";
        int textY = optionWindowY+ 3*panel.tileSize;
        int titleX = CenterWindowXText(title, optionWindowWidth, optionWindowX);
        graphics2D.drawString(title, titleX, textY);


        // CONFIRMATION REQUEST
        textY += panel.tileSize;
        String text = "Are your sure you want to\nExit the Game?";
        for(String line: text.split("\n")){
            titleX = CenterWindowXText(line, optionWindowWidth, optionWindowX);
            graphics2D.drawString(line, titleX, textY);
            textY += 24;
        }

        // YES
        textY += panel.tileSize;
        text = "Yes";
        int textX = CenterWindowXText(text, optionWindowWidth, optionWindowX);
        graphics2D.drawString(text, textX, textY);
        if(command==0){
            graphics2D.drawString(">",textX-20, textY);
            if(panel.handler.Enter){
                System.exit(0);
            }
        }

        // NO
        textY += panel.tileSize;
        text = "No";
        textX = CenterWindowXText(text, optionWindowWidth, optionWindowX);
        graphics2D.drawString(text, textX, textY);
        if(command==1){
            graphics2D.drawString(">",textX-20, textY);
            if(panel.handler.Enter){
                optionState=0;
                command = 6;
            }
        }
    }
    public void MainMenu(int optionWindowX, int optionWindowY,  int optionWindowWidth){
        graphics2D.setFont(graphics2D.getFont().deriveFont(Font.PLAIN, 20F));

        // TITLE
        String title = "Main Menu";
        int textY = optionWindowY+ 3*panel.tileSize;
        int titleX = CenterWindowXText(title, optionWindowWidth, optionWindowX);
        graphics2D.drawString(title, titleX, textY);

        // CONFIRMATION REQUEST
        String text = "Are your sure you want to\nreturn to main menu?";
        textY += panel.tileSize;
        for(String line: text.split("\n")){
            titleX = CenterWindowXText(line, optionWindowWidth, optionWindowX);
            graphics2D.drawString(line, titleX, textY);
            textY += 24;
        }

        // YES
        textY += panel.tileSize;
        text = "Yes";
        int textX = CenterWindowXText(text, optionWindowWidth, optionWindowX);
        graphics2D.drawString(text, textX, textY);
        if(command==0){
            graphics2D.drawString(">",textX-20, textY);
            if(panel.handler.Enter){
                panel.GameState = panel.titleState;
                //TODO: Add Main menu music
                //panel.stopMusic();
                //panel.playMusic(2);
            }
        }

        // NO
        textY += panel.tileSize;
        text = "No";
        textX = CenterWindowXText(text, optionWindowWidth, optionWindowX);
        graphics2D.drawString(text, textX, textY);
        if(command==1){
            graphics2D.drawString(">",textX-20, textY);
            if(panel.handler.Enter){
                optionState=0;
                command = 5;
            }
        }
    }

    // CENTER OF X-COORDINATE
    public int CenterXText(String Text){
        //gets length of written input string
        int TextLength = (int)graphics2D.getFontMetrics().getStringBounds(Text, graphics2D).getWidth();
        return panel.ScreenWidth/2 - TextLength/2;  // Half of length to get it in center
    }
    public int CenterWindowXText(String Text, int WindowWidth, int WindowX){
        //gets length of written input string
        int TextLength = (int)graphics2D.getFontMetrics().getStringBounds(Text, graphics2D).getWidth();
        return WindowWidth/2 - TextLength/2 + WindowX;  // Half of Window length to get it in center + begin where window begins
    }

    // GAME WON SCREEN
    public void GameWonScreen(){

        // Background Transparency (little darker than actual background image)
        graphics2D.setColor(new Color(0,0,0,140));
        graphics2D.fillRect(0,0,panel.ScreenWidth,panel.ScreenHeight);

        // CONGRATULATIONS  ------------------------------------------------------------------
        graphics2D.setFont(graphics2D.getFont().deriveFont(Font.BOLD, 60F));
        String Text = "CONGRATULATIONS";
        int x = CenterXText(Text);
        int y = panel.tileSize*4;

        // SHADOW
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawString(Text,x+5,y+5);

        // MAIN COLOR
        graphics2D.setColor(Color.YELLOW);
        graphics2D.drawString(Text, x, y);


        // COMPLETION PERCENTAGE    ------------------------------------------------------------------
        Text = "Completed: ";
        graphics2D.setFont(Retro_Gaming);
        graphics2D.setColor(Color.white);
        graphics2D.setFont(graphics2D.getFont().deriveFont(Font.PLAIN, 30F));
        x = CenterXText(Text);
        y += panel.tileSize*2;

        // SHADOW
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawString(Text + (CompletionOfGame*100/panel.player.FullCompletion) + "%",x+3,y+3);

        // MAIN COLOR
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawString(Text + ((CompletionOfGame*100)/panel.player.FullCompletion) + "%", x, y);


        // PLAY AGAIN       ------------------------------------------------------------------
        graphics2D.setFont(graphics2D.getFont().deriveFont(Font.BOLD, 40F));
        Text = "PLAY AGAIN";
        x = CenterXText(Text);
        y += (int) (panel.tileSize*2.5);
        // SHADOW
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawString(Text,x+3,y+3);

        // MAIN COLOR
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawString(Text, x, y);

        // CHOOSE OPTION
        if(command == 0){
            graphics2D.setColor(Color.BLACK);
            graphics2D.drawString(">", x- panel.tileSize+3, y+3);
            graphics2D.setColor(Color.WHITE);
            graphics2D.drawString(">", x- panel.tileSize, y);
        }

        // MAIN MENU        ------------------------------------------------------------------
        graphics2D.setFont(graphics2D.getFont().deriveFont(Font.BOLD, 40F));
        Text = "MAIN MENU";
        x = CenterXText(Text);
        y += panel.tileSize;
        // SHADOW
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawString(Text,x+3,y+3);

        // MAIN COLOR
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawString(Text, x, y);

        // CHOOSE OPTION
        if(command == 1){
            graphics2D.setColor(Color.BLACK);
            graphics2D.drawString(">", x- panel.tileSize+3, y+3);
            graphics2D.setColor(Color.WHITE);
            graphics2D.drawString(">", x- panel.tileSize, y);
        }

        // EXIT GAME         ------------------------------------------------------------------
        graphics2D.setFont(graphics2D.getFont().deriveFont(Font.BOLD, 40F));
        Text = "EXIT GAME";
        x = CenterXText(Text);
        y += panel.tileSize;
        // SHADOW
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawString(Text,x+3,y+3);

        // MAIN COLOR
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawString(Text, x, y);

        // CHOOSE OPTION
        if(command == 2){
            graphics2D.setColor(Color.BLACK);
            graphics2D.drawString(">", x- panel.tileSize+3, y+3);
            graphics2D.setColor(Color.WHITE);
            graphics2D.drawString(">", x- panel.tileSize, y);
        }
    }

    // GAME OVER SCREEN
    public void GameOverScreen(){

        // Background Transparency (little darker than actual background image)
        graphics2D.setColor(new Color(0,0,0,140));
        graphics2D.fillRect(0,0,panel.ScreenWidth,panel.ScreenHeight);

        // GAME OVER  ------------------------------------------------------------------
        graphics2D.setFont(graphics2D.getFont().deriveFont(Font.BOLD, 60F));
        String Text = "GAME OVER!";
        int x = CenterXText(Text);
        int y = panel.tileSize*4;

        // SHADOW
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawString(Text,x+5,y+5);

        // MAIN COLOR
        graphics2D.setColor(Color.RED);
        graphics2D.drawString(Text, x, y);

        // RETRY      ------------------------------------------------------------------
        graphics2D.setColor(Color.WHITE);
        graphics2D.setFont(graphics2D.getFont().deriveFont(Font.BOLD, 40F));
        Text = "RETRY";
        x = CenterXText(Text);
        y += (int) (panel.tileSize*4.5);
        // SHADOW
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawString(Text,x+3,y+3);

        // MAIN COLOR
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawString(Text, x, y);

        // CHOOSE OPTION
        if(command == 0){
            graphics2D.setColor(Color.BLACK);
            graphics2D.drawString(">", x- panel.tileSize+3, y+3);
            graphics2D.setColor(Color.WHITE);
            graphics2D.drawString(">", x- panel.tileSize, y);
        }

        // MAIN MENU        ------------------------------------------------------------------
        graphics2D.setFont(graphics2D.getFont().deriveFont(Font.BOLD, 40F));
        Text = "MAIN MENU";
        x = CenterXText(Text);
        y += panel.tileSize;
        // SHADOW
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawString(Text,x+3,y+3);

        // MAIN COLOR
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawString(Text, x, y);

        // CHOOSE OPTION
        if(command == 1){
            graphics2D.setColor(Color.BLACK);
            graphics2D.drawString(">", x- panel.tileSize+3, y+3);
            graphics2D.setColor(Color.WHITE);
            graphics2D.drawString(">", x- panel.tileSize, y);
        }

        // EXIT GAME         ------------------------------------------------------------------
        graphics2D.setFont(graphics2D.getFont().deriveFont(Font.BOLD, 40F));
        Text = "EXIT GAME";
        x = CenterXText(Text);
        y += panel.tileSize;
        // SHADOW
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawString(Text,x+3,y+3);

        // MAIN COLOR
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawString(Text, x, y);

        // CHOOSE OPTION
        if(command == 2){
            graphics2D.setColor(Color.BLACK);
            graphics2D.drawString(">", x- panel.tileSize+3, y+3);
            graphics2D.setColor(Color.WHITE);
            graphics2D.drawString(">", x- panel.tileSize, y);
        }
    }
}