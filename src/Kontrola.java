import java.awt.Color;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.Timer;
import java.util.TimerTask;

public class Kontrola extends JFrame {

    private Image klocek;
    private Image klocek_mocny;
    private Image tlo;
    private Image tank_up;
    private Image tank_down;
    private Image tank_left;
    private Image tank_right;
    private Klocki mur;
    private Timer zegar; 
    private boolean klawisze[];
    private Tank tank1;
    
    class Zadanie extends TimerTask{
        public void run(){
            repaint();
        }
    }
    Kontrola(){
        super("Tank_Shoot 2D");
        setBounds(0,0,800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.black);
        setResizable(false);
        setVisible(true);
        createBufferStrategy(2);
        
        klocek = new ImageIcon("obrazki/klocek.jpg").getImage();
        tlo = new ImageIcon("obrazki/tlo.jpg").getImage();
        klocek_mocny = new ImageIcon("obrazki/klocek_mocny.jpg").getImage();
        tank_up = new ImageIcon("obrazki/tank_up.jpg").getImage();
        tank_down = new ImageIcon("obrazki/tank_down.jpg").getImage();
        tank_left = new ImageIcon("obrazki/tank_left.jpg").getImage();
        tank_right = new ImageIcon("obrazki/tank_right.jpg").getImage();
        mur = new Klocki();
        tank1 = new Tank(100,150);
    
    
        zegar = new Timer();
        zegar.scheduleAtFixedRate(new Zadanie(),0,1);

        this.addKeyListener(new KeyListener(){

            public void keyPressed(KeyEvent e){
               
                switch(e.getKeyCode()){
                    case KeyEvent.VK_UP:      klawisze[0] = true; break;
                    case KeyEvent.VK_DOWN:    klawisze[1] = true; break;
                    case KeyEvent.VK_LEFT:    klawisze[2] = true; break;
                    case KeyEvent.VK_RIGHT:   klawisze[3] = true; break;
                }
            }

            public void keyReleased(KeyEvent e){
                switch(e.getKeyCode()){
                    case KeyEvent.VK_UP:      klawisze[0] = false; break;
                    case KeyEvent.VK_DOWN:    klawisze[1] = false; break;
                    case KeyEvent.VK_LEFT:    klawisze[2] = false; break;
                    case KeyEvent.VK_RIGHT:   klawisze[3] = false; break;
                }
            }

            public void keyTyped(KeyEvent e){
            }
        }
);
    }

    
    public static void main(String[] args)
    {
        Kontrola okno = new Kontrola();
        okno.repaint();
    }

    public void paint(Graphics g)
    {

        BufferStrategy bstrategy = this.getBufferStrategy();
        Graphics2D g2d = (Graphics2D)bstrategy.getDrawGraphics();

        g2d.drawImage(tlo, 0, 0, null);
        
        for (int i=0;i<mur.getklocki_on().size();i++)
        {   
            if(mur.getklocki_on().get(i)==1)
            {
                g2d.drawImage(klocek, mur.getklockiX()[i],mur.getklockiY()[i],null);
                
            }
        }
        for (int i=0;i<mur.getmocneklockiX().length;i++)
        {   
            
                g2d.drawImage(klocek_mocny, mur.getmocneklockiX()[i],mur.getmocneklockiY()[i],null);  
            
        }

        //rysowanie statku

        /*if(tank1.getkierunek()==0)
        {
            g2d.drawImage(tank_right, tank1.getX(),tank1.getY(),null);
        }
        else if(tank1.getkierunek()==1)
        {
            g2d.drawImage(tank_left, tank1.getX(),tank1.getY(),null);
        }
        else if(tank1.getkierunek()==2)
        {
            g2d.drawImage(tank_up, tank1.getX(),tank1.getY(),null);
        }
        else if(tank1.getkierunek()==3)
        {
            g2d.drawImage(tank_down, tank1.getX(),tank1.getY(),null);
        }*/
        g2d.drawImage(tank_up,tank1.getX(),tank1.getY(),null);
        g2d.setColor(Color.white);
        bstrategy.show();
    }


}