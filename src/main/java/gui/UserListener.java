package gui;

import gui.Menu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class UserListener implements KeyListener {

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e){};
}