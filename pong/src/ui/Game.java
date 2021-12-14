package ui;

import domain.Panel;
import domain.Key_pressed;

import javax.swing.JFrame;

public class Game extends  JFrame{

	public Game(int input) {
		this.game(input);
	}


	public void game(int input) {
    	setTitle("Pong game");
		Panel panel = new Panel(input);
		addKeyListener(new Key_pressed(panel));
		add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 400);
		setLocationRelativeTo(null);
		setVisible(true);
    }
}
