package gui;

import domain.Ball;
import persistence.PersistenceService;

import java.awt.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.*;

public class UI extends JFrame implements Serializable {
	private Ball ball = new Ball();
	private int input;
	private  PersistenceService ps = new PersistenceService();

	public UI() {
		this.ask();
	}
	
	public void ask() {
		getContentPane().setBackground(Color.lightGray);
		try{
			System.out.println(ps.loadData().getName());

		} catch (IOException  | ClassNotFoundException e) {
			System.err.println("nix");
		}
		JLabel label = new JLabel("Bis zu welchem Punktestand soll das Spiel gehen?");
		label.setFont(new Font("SansSerif", Font.PLAIN, 15));
		label.setBounds(30,50, 400,40);
    	JTextField txt = new JTextField();
		JTextField plyr1 = new JTextField();
		JTextField plyr2 = new JTextField();
    	//set size of the text box
    	txt.setBounds(50, 100, 200, 40);
		plyr1.setBounds(50, 200, 100, 40);
		plyr2.setBounds(200, 200, 100, 40);

		JButton button = new JButton("play");
		button.setBackground(new Color(59, 89, 182));
		button.setForeground(Color.WHITE);
		button.setFocusPainted(false);
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		//button.setForeground(Color.GRAY);
		button.setBounds(250, 100, 70, 40);
    	add(txt);
		add(plyr1);
		add(plyr2);
    	add(button);
		getRootPane().setDefaultButton(button);
		add(label);
    	bAction(button,txt,plyr1,plyr2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setSize(400,400);



		setLocationRelativeTo(null);
    	setLayout(null);
    	setVisible(true);

	}

	public void bAction(JButton button, JTextField txt ,JTextField plyr1,JTextField plyr2 ) {
		button.addActionListener(e -> {
			//your actions
			input = Integer.parseInt(txt.getText());
			Player pl = new Player(plyr1.getText());
			Player pl2 = new Player(plyr2.getText());

			//Domain.Game wird nach dem pressen und eingeben aufgerufen
			new Game(input);
			System.out.println(pl.getName());
			namenSpeichern(pl);
			System.out.println(pl2.getName());
			namenSpeichern(pl2);
			dispose();

		});

	}

	public void namenSpeichern(Player pl){
		try{
			ps.playerSave(pl);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
