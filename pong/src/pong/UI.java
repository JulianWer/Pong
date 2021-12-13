package pong;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

import javax.swing.*;

public class UI extends JFrame {

	private int input;

	
	public UI() {
		this.ask();
	}
	
	public void ask() {
		getContentPane().setBackground(Color.lightGray);

		JLabel label = new JLabel("Bis zu welchem Punktestand soll das Spiel gehen?");
		label.setFont(new Font("SansSerif", Font.PLAIN, 15));
		label.setBounds(30,50, 400,40);
    	JTextField txt = new JTextField();
    	//set size of the text box
    	txt.setBounds(50, 100, 200, 40);
    	JButton button = new JButton("play");
		button.setBackground(Color.BLACK);
		//button.setForeground(Color.GRAY);
		button.setBounds(250, 100, 70, 40);
    	add(txt);
    	add(button);
		getRootPane().setDefaultButton(button);
		add(label);
    	bAction(button,txt);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setSize(400,200);

		setLocationRelativeTo(null);
    	setLayout(null);
    	setVisible(true);

	}

	public void bAction(JButton button, JTextField txt){
		button.addActionListener(e -> {
			//your actions
			input = Integer.parseInt(txt.getText());
			//Game wird nach dem pressen und eingeben aufgerufen
			Game win = new Game(input);
			setVisible(false);
		});
	}
}
