package pong;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

class Key_pressed extends KeyAdapter {
	
	//obj
    private Panel panel;
    
    //Konstruktor
    public Key_pressed(Panel panel){
        this.panel = panel;
    }
    // event 
    public void keyPressed(KeyEvent evt) {
    	//für Buchstaben 
        switch (evt.getKeyChar()) {
            case 's' -> panel.moveDownP1();
            case 'w' -> panel.moveUpP1();
        }
        //für pfeiltasten
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_DOWN -> panel.moveDownP2();
            case KeyEvent.VK_UP -> panel.moveUpP2();
            case KeyEvent.VK_SPACE -> panel.timer.start();
        }
    }  
}


