package pong;
import javax.swing.JPanel;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.*;

public class Panel extends JPanel implements ActionListener{
    
    
    Rectangle P1 = new Rectangle(20,200,30,100);
    Rectangle P2 = new Rectangle(750,200,30,100);
    Timer timer = new Timer(10,this);
    
   
    int x = 400;
    int y = 200;
    int vely = 3;
    int velx = 3;
    int counterP1 = 0;
    int counterP2 = 0;
    int counterRally = 0;
    int howManyPoints = 1;
    Color colorChange = Color.WHITE;
	int in;
    
    public Panel(int input){
    	this.in = input;
    }
    public void paint(Graphics g){
        this.setBackground(Color.BLACK);
        g.setColor(Color.WHITE);
        g.fillRect(P1.x, P1.y, 20, 100);
        g.fillRect(P2.x, P2.y, 20, 100);
        g.setColor(colorChange);
        Ball ball = new Ball(g);
        g.setFont(new Font("SansSerif", Font.PLAIN, 20));
        g.drawString(String.valueOf(counterP1), 200, 100);
        g.drawString(String.valueOf(counterP2), 600, 100);
        

    }
    
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

    
    public void actionPerformed(ActionEvent e) {
        //ball.movement(P1, P2, timer, this.in);
        repaint();
    }
    
}
