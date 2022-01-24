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
		
		this.setTitle("Setup");
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
		button.setForeground(Color.BLACK);
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
		//Anleitung
		add(createLabel("Spielanleitung " ,20, 400, 400, 40,15));
		add(createLabel("Spieler 1 steuert mit 'w' und 's' seine Schläger" ,20, 420, 400, 40,15));
		add(createLabel("Spieler 2 steuert mit den Pfeiltasten seine Schläger" ,20, 440, 400, 40,15));
		add(createLabel("Das Ziel des Spiels ist es den Ball ins Tor des" ,20, 460, 400, 40,15));
		add(createLabel("anderen Spielers zu schlagen." ,20, 480, 400, 40,15));
		add(createLabel("Bei 2 Ballwechseln wird der Ball rot und zählt 2  " ,20, 500, 400, 40,15));
		add(createLabel("Punkte. Wer als erstes die angegebene Punktzahl" ,20, 520, 400, 40,15));
		add(createLabel("erreicht, gewinnt das Spiel!" ,20, 540, 400, 40,15));

		add(txt);
		add(plyr1);
		add(plyr2);
    	add(button);
		getRootPane().setDefaultButton(button);
		add(createLabel("Bis zu welchem Punktestand soll das Spiel gehen?", 20,300, 400,40,15));
    	bAction(button,txt,plyr1,plyr2);

		//JFrame default
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setSize(400,600); // Size
    	getContentPane().setBackground(Color.WHITE);  //Hintergrund
		setLocationRelativeTo(null);
    	setLayout(null);
    	setVisible(true);
    	

	}
	
	public JLabel createLabel(String input,int x ,int y, int w, int h, int tall) {
		JLabel label = new JLabel(input) ;
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Arial", Font.PLAIN, tall));
		label.setBounds(x,y, w,h);
		return label;
	}

	public void bAction(JButton button, JTextField txt ,JTextField plyr1,JTextField plyr2 ) {
		button.addActionListener(e -> {
			//your actions
			try {
				input = Integer.parseInt(txt.getText());
			}catch (Exception ex){
				System.out.println("Error: " +ex);
				System.out.println("Set default win score! (10)");
				input = 10;
			}
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
