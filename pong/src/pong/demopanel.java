package pong;
import javax.swing.JPanel;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.*;

public class demopanel extends JPanel implements ActionListener{
    
    
    Rectangle P1 = new Rectangle(20,200,30,100);
    Rectangle P2 = new Rectangle(750,200,30,100);
    Timer timer = new Timer(10,this);
   
    int x = 400;
    int y = 200;
    int vely = 3;
    int velx = 3;
    int counterP1 = 0;
    int counterP2 = 0;
    
    public demopanel(){
        timer.start();
    }
    public void paint(Graphics g){
        this.setBackground(Color.BLACK);
        g.setColor(Color.WHITE);
        g.fillRect(P1.x, P1.y, 20, 100);
        g.fillRect(P2.x, P2.y, 20, 100);
        g.fillOval(x, y, 15, 15);
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

    @Override
        public void actionPerformed(ActionEvent e) {
            if(y >= 375){
                vely = -vely;
            }
            if(y <= 0){
                vely = -vely;
            }

            if(y>= P2.y && y<= P2.y+100 && x>= P2.x && x<= P2.x +20){
                velx = -velx;
            }
            if(y>= P1.y && y<= P1.y+100 && x<= P1.x+20 && x>= P1.x){
                velx = -velx;
            }
            if(x >= 800){
                counterP1 += 1;
                x = 400;
                y= 200;
                timer.stop();
            }
            if(x <= 0){
                counterP2 +=1;
                x = 400;
                y= 200;
                timer.stop();
                
            }

            if(counterP1 == 10 || counterP2 == 10){
                System.exit(1);
            }
            
            
            x = x + velx;
            y = y +vely;
            repaint();
        }
    
}
