package pong;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

import javax.swing.*;

public class UI extends JFrame {
	
	

	private Scanner sc = new Scanner(System.in);
	private int input;

	
	public UI() {
		this.ask();
	}
	
	public void ask() {

		JLabel label = new JLabel("Bis zu welchem Punktestand soll das Spiel gehen?");
		label.setBounds(30,50, 400,40);
    	JTextField txt = new JTextField();
    	//set size of the text box
    	txt.setBounds(50, 100, 200, 40);
    	JButton button = new JButton("play");
		button.setBounds(250, 100, 70, 40);
    	add(txt);
    	add(button);
		add(label);
		addKeyListener(new UIkeypressed());
    	bAction(button,txt);
    	setSize(400,200);
		setLocationRelativeTo(null);
    	setLayout(null);
    	setVisible(true);
	}

	public void bAction(JButton button, JTextField txt){
		button.addActionListener(e -> {
			//your actions
			input = Integer.parseInt(txt.getText());
			System.out.println(input);
			//Game wird nach dem pressen und eingeben aufgerufen
			Game win = new Game(input);

		});
	}


}
