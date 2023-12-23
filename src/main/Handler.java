package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Handler implements KeyListener {
    GamePanel panel;

    public boolean UP, DOWN, LEFT, RIGHT, INTERACTION;   //Move direction

    // HANDLER CONSTRUCTOR
    public Handler(GamePanel panel){
        this.panel = panel;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_W)   UP = true;      //(=0x57) (if "W" in Keyboard is Pressed -> go UP)
        if (keyCode == KeyEvent.VK_A)   LEFT = true;    //(=0x41)
        if (keyCode == KeyEvent.VK_S)   DOWN = true;    //(=0x53)
        if (keyCode == KeyEvent.VK_D)   RIGHT = true;   //(=0x44)

        if (keyCode == KeyEvent.VK_E)    INTERACTION = true; //Key for interaction
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();

        // MOVE
        if(keyCode == KeyEvent.VK_W)    UP = false;     //(=0x57) (if "W" in Keyboard is not Pressed -> stop UP)
        if(keyCode == KeyEvent.VK_A)    LEFT = false;   //(=0x41)
        if(keyCode == KeyEvent.VK_S)    DOWN = false;   //(=0x53)
        if(keyCode == KeyEvent.VK_D)    RIGHT = false;  //(=0x44)
    }
}
