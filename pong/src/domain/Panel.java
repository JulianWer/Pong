package domain;

import javax.swing.JPanel;

import persistence.PersistenceService;

import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.*;

public class Panel extends JPanel implements ActionListener{
 
	//private static final long serialVersionUID = 1L;
	
	//Objects
    private Rectangle P1 = new Rectangle(20,200,30,100);
    private Rectangle P2 = new Rectangle(750,200,30,100);
    private  PersistenceService ps = new PersistenceService();
    public Timer timer = new Timer(10,this);
    private final Ball ball = new Ball();
    
    //attributes
	private final int input;
    private static final Color BLACK = Color.BLACK;
    private static final Color WHITE = Color.WHITE;
    public Panel(int input){
    	this.input = input;
        this.timer.start();

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    	//drawing the game

        this.setBackground(BLACK);
        drawDashedLine(g, 400, 0, 400, 400);
        g.setColor(WHITE);
        g.fillRect(P1.x, P1.y, 20, 100);
        g.fillRect(P2.x, P2.y, 20, 100);
        g.setColor(Ball.colorChange);
        ball.draw(g);
        g.setColor(WHITE);
        g.setFont(new Font("Tahoma", Font.BOLD, 35));
        g.drawString(String.valueOf(Ball.counterP1), 200, 100);
        g.drawString(String.valueOf(Ball.counterP2), 600, 100);
        g.setFont(new Font("Tahoma", Font.BOLD, 15));
        
        try {
			g.drawString(ps.loadData().get(1).getName(), 20, 20);
			g.drawString(ps.loadData().get(0).getName(), 750, 20);
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        

    }
    
    public void drawDashedLine(Graphics g, int x1, int y1, int x2, int y2){

    	  // Create a copy of the Graphics instance
    	  Graphics2D g2 = (Graphics2D) g.create();
    	  g2.setColor(WHITE);
    	  // Set the stroke of the copy, not the original 
    	  Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL,
    	                                  0, new float[]{9}, 0);
    	  g2.setStroke(dashed);

    	  // Draw to the copy
    	  g2.drawLine(x1, y1, x2, y2);

    	  // Get rid of the copy
    	  g2.dispose();
    	}

	//Player movement
    public void moveUpP1(){
        P1.y -=20;
        this.repaint();
    }
    
    public void moveDownP1(){
        P1.y +=20;
        this.repaint();
    }
    
    public void moveUpP2(){
        P2.y -=20;
        this.repaint();
    }
    
    public void moveDownP2(){
        P2.y +=20;
        this.repaint();
    }
    
    //animation of the ball
    public void actionPerformed(ActionEvent e) {
        ball.movement(P1, P2, timer, this.input);
        repaint();
    }


}
