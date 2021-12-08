package pong;
import javax.swing.JPanel;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.*;

public class Panel extends JPanel implements ActionListener{
 
	private static final long serialVersionUID = 1L;
	//Objects
    Rectangle P1 = new Rectangle(20,200,30,100);
    Rectangle P2 = new Rectangle(750,200,30,100);
    Timer timer = new Timer(10,this);
    Ball ball = new Ball();
    
    //attributes
	private int in;
    
    public Panel(int input){
    	this.in = input;
    }
    
    public void paint(Graphics g){
    	//drawing the game
        this.setBackground(Color.BLACK);
        g.setColor(Color.WHITE);
        g.fillRect(P1.x, P1.y, 20, 100);
        g.fillRect(P2.x, P2.y, 20, 100);
        g.setColor(Ball.colorChange);
        ball.draw(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("SansSerif", Font.PLAIN, 20));
        g.drawString(String.valueOf(Ball.counterP1), 200, 100);
        g.drawString(String.valueOf(Ball.counterP2), 600, 100);
      
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
        ball.movement(P1, P2, timer, this.in);
        repaint();
    }
    
}
