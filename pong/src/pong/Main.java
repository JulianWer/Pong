package pong;
import javax.swing.JFrame;


public class Main{
    public static void main(String[] args) throws Exception{
        
        JFrame frame = new JFrame();
        demopanel panel = new demopanel();
        frame.addKeyListener(new keypress(panel));
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,400);
        frame.setVisible(true);
    }
}