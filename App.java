import javax.swing.*;
import java.awt.Color;

public class App {
    public static void main(String[] args) {
        JFrame frame = new JFrame("ping pong");
  
        //*********************************FRAME 
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.add(new Mypanel());
        
        //*********************************PANEL 
       
        //*********************************LABEL
    
        

    }
    
}
