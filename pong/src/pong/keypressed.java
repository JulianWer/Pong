package pong;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

class keypress extends KeyAdapter {

    
    demopanel panel;
    public keypress(demopanel panel){
        this.panel = panel;
    }

    
    public void keyPressed(KeyEvent evt) {

        if (evt.getKeyChar() == 's') {
            panel.moveDownP1();
        }
        if (evt.getKeyChar() == 'w') {
            panel.moveUpP1();
        }
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            panel.moveDownP2();
        }
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            panel.moveUpP2();
        }
        if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
            panel.timer.start();
        }  
    }  
}