package pong;
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
        switch(evt.getKeyChar()) {
        
        case 's':
        	panel.moveDownP1();
        	break;
        	
        case 'w':
        	panel.moveUpP1();
        	break;
        }
        //für pfeiltasten
        switch(evt.getKeyCode() ) {
        
        case KeyEvent.VK_DOWN:
        	panel.moveDownP2();
        	break;
        	
        case KeyEvent.VK_UP:
        	panel.moveUpP2();
        	break;
        	
        case KeyEvent.VK_SPACE:
        	panel.timer.start();
        	break;
        }
    }  
}

class UIkeypressed extends KeyAdapter {

    // event
    public void keyPressed(KeyEvent evt) {
        //für pfeiltasten
        if(evt.getKeyCode() == KeyEvent.VK_UP) {
            System.out.println("hallo");
        }
    }
}

