package gui;

import domain.Player;
import persistence.PersistenceService;

import java.awt.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.lang.*;

import javax.swing.*;

public class UI extends JFrame implements Serializable {
	private int input;
	private  PersistenceService ps = new PersistenceService();
	private ArrayList<Player> players = new ArrayList<>();

	public UI() throws ClassNotFoundException, IOException {
		
		this.setTitle("Pong");
		this.ask();
	}
	
	public void ask() throws ClassNotFoundException, IOException {
	
		
		
		
    	JTextField txt = new JTextField();
    	txt.setBounds(50, 350, 200, 40);
    	JTextField plyr1 = new JTextField();
		plyr1.setBounds(50, 200, 100, 40);
		JTextField plyr2 = new JTextField();
		plyr2.setBounds(200, 200, 100, 40);
		
    	
    	JButton button = new JButton("play");
		button.setBackground(new Color(59, 89, 182));
		button.setForeground(Color.WHITE);
		button.setFocusPainted(false);
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		button.setBounds(250, 350, 70, 40);
    	
		
		
		add(createLabel("PONG", 150, 20, 400, 40,30));
		try {
			add(createLabel("Leztes Spiel: " + ps.loadData().get(1).getName() + ", " + ps.loadData().get(0).getName(), 30, 100, 400, 40, 15));
		}catch(Exception e ) {
			System.out.println("Konnte namen nicht laden. error : " + e);
		}
		add(createLabel("Player 1" ,70, 170, 100, 40,15));
		add(createLabel("Player 2" ,220, 170, 100, 40,15));
    	add(txt);
		add(plyr1);
		add(plyr2);
    	add(button);
		getRootPane().setDefaultButton(button);
		add(createLabel("Bis zu welchem Punktestand soll das Spiel gehen?", 30,300, 400,40,15));
    	bAction(button,txt,plyr1,plyr2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setSize(400,450);
    	getContentPane().setBackground(Color.BLACK);
		setLocationRelativeTo(null);
    	setLayout(null);
    	setVisible(true);
    	

	}
	
	public JLabel createLabel(String input,int x ,int y, int w, int h, int tall) {
		JLabel label = new JLabel(input) ;
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial", Font.PLAIN, tall));
		label.setBounds(x,y, w,h);
		return label;
	}

	public void bAction(JButton button, JTextField txt ,JTextField plyr1,JTextField plyr2 ) {
		button.addActionListener(e -> {
			//your actions
			input = Integer.parseInt(txt.getText());
			Player pl = new Player(plyr1.getText());
			Player pl2 = new Player(plyr2.getText());

			new Game(input);
			System.out.println(pl.getName());
			System.out.println(pl2.getName());
			players.add(pl2);
			players.add(pl);
			namenSpeichern();
			dispose(); 

		});

	}

	public void namenSpeichern(){
		try{
			ps.playerSave(players);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
