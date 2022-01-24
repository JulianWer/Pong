package domain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.*;

public class Ball  extends Rectangle{

	 private static int x = 400;
	 private static int y = 200;
     private static int vely = 3;
	 private static int velx = 3;
     public static int counterP1 = 0;
	 public static int counterP2 = 0;
	 public static int counterRally = 0;
	 public static int howManyPoints = 1;
	 public static Color colorChange = Color.WHITE;
     static Rectangle ball ;


	public void draw(Graphics g) {
		//draw ball
		g.fillOval(x, y, 15, 15);
	}
	    
	public void movement(Rectangle P1, Rectangle P2, int in) {
        ball = new Rectangle(x,y,15,15);

		//collision
        collision(P1, P2);

        //reset and count points
        extras(in);

        // x and y velocity 
        x = x + velx;
        y = y +vely;

	}

    private static void collision(Rectangle P1, Rectangle P2){
        if(y >= 375){
            vely = -vely;
        }

        if(y <= 0){
            vely = -vely;
        }

        if(ball.intersects(P2) ){
            counterRally ++; // pro Ballwechsel
            velx = -velx;
        }

        if(ball.intersects(P1)){
            velx = -velx;
        }
    }

    private void extras(int in){
        if(x >= 800){
            counterP1 += howManyPoints;
            counterRally = 0;
            colorChange = Color.WHITE;
            howManyPoints = 1;
            x = 400;
            y= 200;
            //timer.stop();
        }

        if(x <= 0){
            counterP2 += howManyPoints;
            counterRally = 0;
            colorChange = Color.WHITE;
            howManyPoints = 1;
            x = 400;
            y= 200;
            //timer.stop();
        }

        if(counterP1 == in || counterP2 == in){
            System.exit(1);
        }


        if(counterRally >= 2) {
            howManyPoints = 2;
            colorChange = Color.RED;
        }
    }

}
