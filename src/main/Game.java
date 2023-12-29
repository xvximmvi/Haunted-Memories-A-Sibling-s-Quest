package main;

import javax.swing.*;
import java.util.Objects;

public class Game {
    public static JFrame window;

    public static void main(String[] args){

        //WINDOW SETTINGS
        window = new JFrame();       //first create window
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //lets the window properly close when user clicks the close ("x") button
        window.setResizable(false);         //no resizing of the window
        window.setTitle("Haunted Memories");      //Title of the Game

        // ICON
        new Game().setIcon();

        // ADD PANEL
        GamePanel panel = new GamePanel();
        window.add(panel);                  //Add Panel Class to Window

        window.pack();   //causes window to be sized to fit preferred size and layouts of "Panel"

        window.setLocationRelativeTo(null); //Not specify the location of the window
        // => window will be displayed at the center of the screen
        window.setVisible(true);            //able to see the window

        // START GAME
        panel.setUpGame();                  //start setting up the Game
        panel.startThread();               //start thread
    }

    // SET ICON
    public void setIcon(){
        ImageIcon imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("Icon.png")));
        window.setIconImage(imageIcon.getImage());
    }
}
