package domain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.Timer;

public class Ball {
	
	 private int x = 400;
	 private int y = 200;
	 private int vely = 3;
	 private int velx = 3;
	 public static int counterP1 = 0;
	 public static int counterP2 = 0;
	 public static int counterRally = 0;
	 public static int howManyPoints = 1;
	 static Color colorChange = Color.WHITE;
	 
	public void draw(Graphics g) {
		//draw ball
		g.fillOval(x, y, 15, 15);
	}
	    
	public void movement(Rectangle P1, Rectangle P2, Timer timer, int in) {
		
		//collision
		if(y >= 375){
            vely = -vely;
        }
		
        if(y <= 0){
            vely = -vely;
        }

        if(y>= P2.y && y<= P2.y+100 && x+15> P2.x ){
        	counterRally ++;
            velx = -velx;
        }
        
        if(y>= P1.y && y<= P1.y+100 && x<= P1.x+17.5){
            velx = -velx;
        }
        
        //reset and count points
        if(x >= 800){
            counterP1 += howManyPoints;
            counterRally = 0;
            colorChange = Color.WHITE;
            howManyPoints = 1;
            x = 400;
            y= 200;
            timer.stop();
        }
        
        if(x <= 0){
            counterP2 += howManyPoints;
            counterRally = 0;
            colorChange = Color.WHITE;
            howManyPoints = 1;
            x = 400;
            y= 200;
            timer.stop(); 
        }

        if(counterP1 == in || counterP2 == in){
            System.exit(1);
        }
        
        
        if(counterRally >= 2) {
        	howManyPoints = 2;
        	colorChange = Color.RED;
        }

        // x and y velocity 
        x = x + velx;
        y = y +vely;
		
	}
}
