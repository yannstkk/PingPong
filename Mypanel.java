import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Mypanel extends JPanel implements KeyListener{
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        int width = 500;
        int height = 500;
        int ballX;
        int ballY;
        int lescor = 0;
        boolean running = false;
	    Timer timer;
        private int ballXSpeed = 2; // ici ya wedi  qu'on ajuste la vitesse horizontale 
        private int ballYSpeed = 3;

        Mypanel(){
        setSize(500,500);
        setLayout(null);
        add(label1);
        add(label2);
        setBackground(Color.black);
        setFocusable(true);
        label1.setBackground(Color.ORANGE); 
        label1.setOpaque(true);
        label2.setBackground(Color.MAGENTA); 
        label2.setOpaque(true);
        label1.setBounds(0, (int)(width/2)-50, 10, 50);
        label2.setBounds(width-25, 0, 10, 500);
        addKeyListener(this);
        startgame();
         }


     protected void paintComponent(Graphics g) {
       super.paintComponent(g);
       g.setColor(Color.RED);
       g.fillOval(ballX, ballY, 25, 25);
      
    }
    
    
        public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()){
                case KeyEvent.VK_UP  : if (label1.getY() > 0) { label1.setLocation(label1.getX(), label1.getY()-20); }
                break;
                case KeyEvent.VK_DOWN : if (label1.getY() < this.getWidth()-50) { label1.setLocation(label1.getX(), label1.getY()+20); System.out.println("get :"+label1.getY()); }
                break;}}
        public void keyReleased(KeyEvent e) {
        }
        @Override
        public void keyTyped(KeyEvent e) {
        }


        public void initialise(){
            ballX =250;
            ballY = 250;
        }


        public void move(){
            ballX += ballXSpeed; // cest la vitesse qu'il faut inverser , quand on atteind 500 on fait 500-1 .. non pas -500 pti con
            ballY += ballYSpeed; 

        // Vérifier les collisions avec les bords horizontaux
        if ( ballX >= 450) { 
            ballXSpeed = -ballXSpeed; // Inverser la direction horizontale
        }

        // Vérifier les collisions avec les bords verticaux
        if (ballY <= 0 || ballY >= height - 50)  {
            ballYSpeed = -ballYSpeed; }
   
        if(ballX <= 20 && ballY + 25 >= label1.getY() && ballY <= label1.getY() + 50){ // pour faire rebondir la balle sur le paddell
                ballXSpeed = -ballXSpeed;
                
            }  
            repaint();
        }

        public void checkCollisions() {
            if (ballX == 0){
                initialise();
                lescor++;
            }
        }

        

        public void startgame() {
            initialise();
            timer = new Timer(1, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    move();
                    checkCollisions();
                    repaint();
                }
            });
            timer.start();
        }
}