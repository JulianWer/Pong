package pong;

import javax.swing.JFrame;


public class Main{
    public static void main(String[] args) throws Exception{
    	
    	//Which score to win?
    	UI ui = new UI();
    	int input = ui.getInput();
        
    	//Game
        JFrame frame = new JFrame();
        Panel panel = new Panel(input);
        frame.addKeyListener(new Key_pressed(panel));
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,400);
        frame.setVisible(true);
        
        
    }
}