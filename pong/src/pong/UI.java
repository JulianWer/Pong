package pong;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class UI {
	
	

	private Scanner sc = new Scanner(System.in);
	private int input;
	public boolean gameTime = false;
	
	
	public UI() {
		this.ask();
	}
	
	public void ask() {
		JFrame popUp = new JFrame("Beginning");
    	popUp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	JTextField txt = new JTextField();
    	//set size of the text box
    	txt.setBounds(50, 100, 100, 30);
    	JButton button = new JButton(" >> CLICK ME <<");
		button.setBounds(40, 40, 200, 40);
    	popUp.add(txt);
    	popUp.add(button);
    	button.addActionListener(new ActionListener() {

    	    public void actionPerformed(ActionEvent e) {
    	        //your actions
    	    	input = Integer.parseInt(txt.getText());
    	    	System.out.println(input);
    	    	//Game wird nach dem pressen und eingeben aufgerufen
    	    	Game win = new Game(input);
    	    	
    	    }
    	});
    	popUp.setSize(400,200);
    	popUp.setLayout(null);
    	popUp.setVisible(true);
	}

	
}