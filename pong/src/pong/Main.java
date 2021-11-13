package pong;
import javax.swing.JFrame;


public class Main{
    public static void main(String[] args) throws Exception{
    	System.out.println("Welcome to Pong!");
    	System.out.println("Player one controls the bat with 'w' and 's '  \nPlayer two controls the bat with 'UP' and 'DOWN'");
        
        JFrame frame = new JFrame();
        Panel panel = new Panel();
        frame.addKeyListener(new Key_pressed(panel));
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,400);
        frame.setVisible(true);
    }
}