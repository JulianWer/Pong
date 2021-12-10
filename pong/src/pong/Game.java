package pong;

import javax.swing.JFrame;

public class Game {
	public Game(int input) {
		this.game(input);
	}
	public void game(int input) {
    	JFrame frame = new JFrame("Pong game");
		Panel panel = new Panel(input);
		frame.addKeyListener(new Key_pressed(panel));
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 400);
		frame.setVisible(true);
    }
}
