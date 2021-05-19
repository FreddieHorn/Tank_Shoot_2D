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
    private Tank tank2;
    private Gameplay gra;
    class Zadanie extends TimerTask{
        public void run(){

        if(klawisze[0]) 
        {
            if(!mur.checkSolidCollision(tank1.getX(), tank1.getY()-1) && !mur.checkCollision(tank1.getX(), tank1.getY()-1) && !gra.CheckTankCollision(tank1.getX(), tank1.getY()-1, tank2.getX(), tank2.getY()))
            {
            tank1.ruchGora(); 
            }
        }
        if(klawisze[1])
        {
            if(!mur.checkSolidCollision(tank1.getX(), tank1.getY()+1) && !mur.checkCollision(tank1.getX(), tank1.getY()+1) && !gra.CheckTankCollision(tank1.getX(), tank1.getY()+1, tank2.getX(), tank2.getY()))
            {
            tank1.ruchDol();
            }
        }
        if(klawisze[2])
        {
            if(!mur.checkSolidCollision(tank1.getX()-1, tank1.getY()) && !mur.checkCollision(tank1.getX()-1, tank1.getY()) && !gra.CheckTankCollision(tank1.getX()-1, tank1.getY(), tank2.getX(), tank2.getY()))
            {
            tank1.ruchLewo();
            }
        }
        if(klawisze[3])
        {
            if(!mur.checkSolidCollision(tank1.getX()+1, tank1.getY()) && !mur.checkCollision(tank1.getX()+1, tank1.getY()) && !gra.CheckTankCollision(tank1.getX()+1, tank1.getY(), tank2.getX(), tank2.getY()))
            {
            tank1.ruchPrawo();
            }
        }
        if(klawisze[4]) 
        {
            if(!mur.checkSolidCollision(tank2.getX(), tank2.getY()-1) && !mur.checkCollision(tank2.getX(), tank2.getY()-1) && !gra.CheckTankCollision(tank1.getX(), tank1.getY(), tank2.getX(), tank2.getY()-1))
            {
            tank2.ruchGora(); 
            }
        }
        if(klawisze[5])
        {
            if(!mur.checkSolidCollision(tank2.getX(), tank2.getY()+1) && !mur.checkCollision(tank2.getX(), tank2.getY()+1) && !gra.CheckTankCollision(tank1.getX(), tank1.getY(), tank2.getX(), tank2.getY()+1))
            {
            tank2.ruchDol();
            }
        }
        if(klawisze[6])
        {
            if(!mur.checkSolidCollision(tank2.getX()-1, tank2.getY()) && !mur.checkCollision(tank2.getX()-1, tank2.getY()) && !gra.CheckTankCollision(tank1.getX(), tank1.getY(), tank2.getX()-1, tank2.getY()))
            {
            tank2.ruchLewo();
            }
        }
        if(klawisze[7])
        {
            if(!mur.checkSolidCollision(tank2.getX()+1, tank2.getY()) && !mur.checkCollision(tank2.getX()+1, tank2.getY()) && !gra.CheckTankCollision(tank1.getX(), tank1.getY(), tank2.getX()+1, tank2.getY()))
            {
            tank2.ruchPrawo();
            }
        }
            repaint();
        }
    }
    Kontrola(){
        super("Tank_Shoot 2D");
        setBounds(40,40,800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.black);
        setResizable(false);
        setVisible(true);
        createBufferStrategy(2);
        
        klocek = new ImageIcon("obrazki/klocek.jpg").getImage();
        tlo = new ImageIcon("obrazki/tlo.jpg").getImage();
        klocek_mocny = new ImageIcon("obrazki/klocek_mocny.jpg").getImage();
        tank_up = new ImageIcon("obrazki/tank1_up.png").getImage();
        tank_down = new ImageIcon("obrazki/tank1_down.png").getImage();
        tank_left = new ImageIcon("obrazki/tank1_left.png").getImage();
        tank_right = new ImageIcon("obrazki/tank1_right.png").getImage();
        mur = new Klocki();
        tank1 = new Tank(200,550);
        tank2 = new Tank(400,550);
        klawisze = new boolean[8];
        gra = new Gameplay();
    
    
        zegar = new Timer();
        zegar.scheduleAtFixedRate(new Zadanie(),0,10);

        this.addKeyListener(new KeyListener(){

            public void keyPressed(KeyEvent e){
               
                switch(e.getKeyCode()){
                    case KeyEvent.VK_UP:      klawisze[0] = true;
                    //tank1.ruchGora();
                    break;
                    case KeyEvent.VK_DOWN:    klawisze[1] = true;
                    //tank1.ruchDol();
                    break;
                    case KeyEvent.VK_LEFT:    klawisze[2] = true;
                    //tank1.ruchLewo();
                    break;
                    case KeyEvent.VK_RIGHT:   klawisze[3] = true;
                    //tank1.ruchPrawo();
                    break;
                    case KeyEvent.VK_W:      klawisze[4] = true;
                    //tank1.ruchGora();
                    break;
                    case KeyEvent.VK_S:    klawisze[5] = true;
                    //tank1.ruchDol();
                    break;
                    case KeyEvent.VK_A:    klawisze[6] = true;
                    //tank1.ruchLewo();
                    break;
                    case KeyEvent.VK_D:   klawisze[7] = true;
                    //tank1.ruchPrawo();
                    break;
                }
            }

            public void keyReleased(KeyEvent e){
                switch(e.getKeyCode()){
                    case KeyEvent.VK_UP:      klawisze[0] = false; break;
                    case KeyEvent.VK_DOWN:    klawisze[1] = false; break;
                    case KeyEvent.VK_LEFT:    klawisze[2] = false; break;
                    case KeyEvent.VK_RIGHT:   klawisze[3] = false; break;
                    case KeyEvent.VK_W:      klawisze[4] = false; break;
                    case KeyEvent.VK_S:    klawisze[5] = false; break;
                    case KeyEvent.VK_A:    klawisze[6] = false; break;
                    case KeyEvent.VK_D:   klawisze[7] = false; break;
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

        //rysowanie HUDu
        g2d.setColor(Color.DARK_GRAY);
        g2d.fillRect(660, 0, 140, 600);

        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Arial", Font.BOLD, 10));
        g2d.drawString("Zdrowie gracza 1: " + String.valueOf(tank1.getHealth()), 670, 50);
        g2d.drawString("Zdrowie gracza 2: " + String.valueOf(tank1.getHealth()), 670, 80);


        //rysowanie mapy
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
        
        if(tank1.getkierunek()==0)
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
        }
        if(tank2.getkierunek()==0)
        {
            g2d.drawImage(tank_right, tank2.getX(),tank2.getY(),null);
        }
        else if(tank2.getkierunek()==1)
        {
            g2d.drawImage(tank_left, tank2.getX(),tank2.getY(),null);
        }
        else if(tank2.getkierunek()==2)
        {
            g2d.drawImage(tank_up, tank2.getX(),tank2.getY(),null);
        }
        else if(tank2.getkierunek()==3)
        {
            g2d.drawImage(tank_down, tank2.getX(),tank2.getY(),null);
        }
        g2d.setColor(Color.white);
        //g2d.drawString((String.valueOf(tank1.getkierunek())), 120, 120);
        //g2d.drawImage(tank_up,tank1.getX(),tank1.getY(),null);
        g2d.drawString((String.valueOf(tank1.getX())), 70, 120);
        g2d.drawString((String.valueOf(tank1.getY())), 90, 120);
        g2d.drawString((String.valueOf(tank2.getX())), 70, 140);
        g2d.drawString((String.valueOf(tank2.getY())), 90, 140);
        //g2d.drawImage(tank_up,tank1.getX(),tank1.getY(),null);
        g2d.setColor(Color.white);
        bstrategy.show();
    }


}