package pong;

import java.util.Scanner;

public class UI {
	
	private Scanner sc = new Scanner(System.in);
	private int input;
	
	public UI() {
		this.ask();
	}
	
	public void ask() {
	System.out.println("Welcome to Pong!");
	System.out.println("Player one controls the bat with 'w' and 's '  \nPlayer two controls the bat with 'UP' and 'DOWN'");
	System.out.println("Wenn Sie 10 Ballwechsel erreichen dann wird der Ball rot und zählt 2 Punkte");
	System.out.print("Win number: ");
	input = sc.nextInt();
	sc.close();
	}
	
	public int getInput() {
		return input;
	}
	
	
}
