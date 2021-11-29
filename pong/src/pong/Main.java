package pong;

import java.util.Scanner;

import javax.swing.JFrame;


public class Main{
    public static void main(String[] args) throws Exception{
    	
    	//Which score to win?
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Welcome to Pong!");
    	System.out.println("Player one controls the bat with 'w' and 's '  \nPlayer two controls the bat with 'UP' and 'DOWN'");
    	System.out.println("Wenn Sie 10 Ballwechsel erreichen dann wird der Ball rot und zählt 2 Punkte");
    	System.out.print("Win number: ");
    	int input = sc.nextInt();
    	sc.close();
        
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