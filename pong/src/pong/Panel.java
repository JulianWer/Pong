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
    private Rectangle P1 = new Rectangle(20,200,30,100);
    private Rectangle P2 = new Rectangle(750,200,30,100);
    public Timer timer = new Timer(10,this);
    private Ball ball = new Ball();
    
    //attributes
	private int input;
    private static final Color BLACK = Color.BLACK;
    private static final Color WHITE = Color.WHITE;
    public Panel(int input){
    	this.input = input;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    	//drawing the game

        this.setBackground(BLACK);
        g.setColor(WHITE);
        g.fillRect(P1.x, P1.y, 20, 100);
        g.fillRect(P2.x, P2.y, 20, 100);
        g.setColor(Ball.colorChange);
        ball.draw(g);
        g.setColor(WHITE);
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
        ball.movement(P1, P2, timer, this.input);
        repaint();
    }
    
}
