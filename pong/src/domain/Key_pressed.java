package domain;
import domain.Panel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class Key_pressed extends KeyAdapter {
	
	//obj
    private final Panel panel;
    
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

        }
    }  
}


