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

    private Image pocisk;
    private Image klocek;
    private Image klocek_mocny;
    private Image tlo;
    private Image tank_up;
    private Image tank_down;
    private Image tank_left;
    private Image tank_right;
    private Image tank2_up;
    private Image tank2_down;
    private Image tank2_left;
    private Image tank2_right;
    private Image shield;
    public Klocki mur;
    private Timer zegar; 
    private boolean klawisze[];
    public Tank tank1;
    public Tank tank2;
    private Missiles pociski;
    private Gameplay gra;
    private int licznik1 = 0;
    private int licznik2 = 0;
    private int licznik3 = 0;
    private int licznik4 = 0;
    private boolean zatrzask1 = false;
    private boolean zatrzask2 = false;
    private Boost boost;  
    private boolean koniec_gry = false;
    private boolean halt = false;
    private boolean halt1 = false;
    public class Zadanie extends TimerTask{
        public void run(){

        if (halt == false)
        {
            if(klawisze[0]) 
            {
                tank1.setkierunek(2);
                tank1.ruchGora(tank2.getX(),tank2.getY(),mur,gra); 
            }
            if(klawisze[1])
            {
                tank1.setkierunek(3);
                tank1.ruchDol(tank2.getX(),tank2.getY(),mur,gra);
            }
            if(klawisze[2])
            {
                tank1.setkierunek(1);
                tank1.ruchLewo(tank2.getX(),tank2.getY(),mur,gra);
            }
            if(klawisze[3])
            {
                tank1.setkierunek(0);
                tank1.ruchPrawo(tank2.getX(),tank2.getY(),mur,gra);
            }
            
            if(klawisze[4]) 
            {
                tank2.setkierunek(2);
                tank2.ruchGora(tank1.getX(),tank1.getY(),mur,gra); 
            }
            if(klawisze[5])
            {
                tank2.setkierunek(3);
                tank2.ruchDol(tank1.getX(),tank1.getY(),mur,gra);
                
            }
            if(klawisze[6])
            {
                tank2.setkierunek(1);
                tank2.ruchLewo(tank1.getX(),tank1.getY(),mur,gra);
            }
            if(klawisze[7])
            {
                tank2.setkierunek(0);
                tank2.ruchPrawo(tank1.getX(),tank1.getY(),mur,gra);
            }

            if (klawisze[8] && zatrzask1==false)
            {
                pociski.newMissile(tank2.getX(),tank2.getY(),tank2.getkierunek(), 0);
                zatrzask1 = true;
            }

            if (klawisze[9] && zatrzask2 == false)
            {
                pociski.newMissile(tank1.getX(),tank1.getY(),tank1.getkierunek(), 1);
                zatrzask2 = true;
            }

            if (zatrzask2 == true)
            {
                licznik2 += 1;
                if (licznik2 == 50)
                {
                    zatrzask2 = false;
                    licznik2 = 0;
                }
            }

            if (zatrzask1 == true)
            {
                licznik1 += 1;
                if (licznik1 == 50)
                {
                    zatrzask1 = false;
                    licznik1 = 0;
                }
            }
            
            boost.collisoncheck(tank1);
            boost.collisoncheck(tank2);

            ///gra.checkboostduration(tank1, licznik3);
            //gra.checkboostduration(tank2, licznik4);
            if(tank1.getspeed_boost())
            {
                
        
                    licznik3 += 1;
                    if (licznik3 == 1000)
                    {
                        tank1.setspeed_boost(false);
                        licznik3 = 0;
                    }
                
            }

            if(tank2.getspeed_boost())
            {
                
        
                    licznik4 += 1;
                    if (licznik4 == 1000)
                    {
                        tank2.setspeed_boost(false);
                        licznik4 = 0;
                    }
                
            }

            pociski.emptyMissiles(mur, tank1, tank2, gra);

            if (!halt)
            {
                if(!koniec_gry)
                    repaint();
            }
        }
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
        

        pocisk = new ImageIcon("obrazki/pocisk.png").getImage();
        klocek = new ImageIcon("obrazki/klocek.jpg").getImage();
        tlo = new ImageIcon("obrazki/tlo.jpg").getImage();
        klocek_mocny = new ImageIcon("obrazki/klocek_mocny.jpg").getImage();
        tank_up = new ImageIcon("obrazki/tank1_up.png").getImage();
        tank_down = new ImageIcon("obrazki/tank1_down.png").getImage();
        tank_left = new ImageIcon("obrazki/tank1_left.png").getImage();
        tank_right = new ImageIcon("obrazki/tank1_right.png").getImage();
        tank2_up = new ImageIcon("obrazki/tank2_up.png").getImage();
        tank2_down = new ImageIcon("obrazki/tank2_down.png").getImage();
        tank2_left = new ImageIcon("obrazki/tank2_left.png").getImage();
        tank2_right = new ImageIcon("obrazki/tank2_right.png").getImage();
        shield = new ImageIcon("obrazki/shield.jpg").getImage();
        mur = new Klocki();
        tank1 = new Tank(400,550);
        tank2 = new Tank(200,550);
        gra = new Gameplay();
        klawisze = new boolean[14];
        
        pociski = new Missiles();
        boost = new Boost(100, 50, 2);
    
        zegar = new Timer();
        zegar.scheduleAtFixedRate(new Zadanie(),0,10);
        
        this.addKeyListener(new KeyListener(){

            public void keyPressed(KeyEvent e){
               
                switch(e.getKeyCode()){
                    case KeyEvent.VK_UP:      klawisze[0] = true;
                    break;
                    case KeyEvent.VK_DOWN:    klawisze[1] = true;
                    break;
                    case KeyEvent.VK_LEFT:    klawisze[2] = true;
                    break;
                    case KeyEvent.VK_RIGHT:   klawisze[3] = true;
                    break;
                    case KeyEvent.VK_W:      klawisze[4] = true;
                    break;
                    case KeyEvent.VK_S:    klawisze[5] = true;
                    break;
                    case KeyEvent.VK_A:    klawisze[6] = true;
                    break;
                    case KeyEvent.VK_D:   klawisze[7] = true;
                    break;
                    case KeyEvent.VK_SPACE:   klawisze[8] = true;
                    break;
                    case KeyEvent.VK_M:   klawisze[9] = true;
                    break;
                    case KeyEvent.VK_R:   klawisze[10] = true;
                    Kontrola okno = new Kontrola();
                    okno.repaint();
                    dispose();
                    
                    break;
                    case KeyEvent.VK_P:   klawisze[11] = true;
                            halt = !halt;
                            repaint();
                       
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
                    case KeyEvent.VK_SPACE:   klawisze[8] = false; break;
                    case KeyEvent.VK_M:   klawisze[9] = false; break;
                    case KeyEvent.VK_R:   klawisze[10] = false; break;
                    case KeyEvent.VK_P:   klawisze[11] = false;
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
        g2d.drawString("Zdrowie gracza 2: " + String.valueOf(tank2.getHealth()), 670, 80);
        g2d.drawString("boost aktywny: " + boost.getactive(), 670, 150);
        g2d.drawString("ulepszenie gracza 1: " + tank1.getspeed_boost(), 670, 160);
        g2d.drawString("ulepszenie gracza 2: " + tank2.getspeed_boost(), 670, 180);
        //g2d.drawString("Zdrowie gracza 2: " + String.(gra.gettimepassed(), 670, 80);


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
            g2d.drawImage(tank2_right, tank2.getX(),tank2.getY(),null);
        }
        else if(tank2.getkierunek()==1)
        {
            g2d.drawImage(tank2_left, tank2.getX(),tank2.getY(),null);
        }
        else if(tank2.getkierunek()==2)
        {
            g2d.drawImage(tank2_up, tank2.getX(),tank2.getY(),null);
        }
        else if(tank2.getkierunek()==3)
        {
            g2d.drawImage(tank2_down, tank2.getX(),tank2.getY(),null);
        }

        for (int i = 0; i < pociski.getMissiles().size(); i++)
            g2d.drawImage(pocisk, pociski.getMissiles().get(i).getX(),pociski.getMissiles().get(i).getY(),null);
        //rysowanie tarczy
        if(boost.getactive())
            g2d.drawImage(shield, boost.getX(), boost.getY(), null);
        g2d.setColor(Color.white);

        g2d.setColor(Color.RED);
        g2d.setFont(new Font("Arial", Font.BOLD, 40));

        if(tank1.getHealth() == 0)
        {
            g2d.drawString("Koniec gry. Wygrał gracz 2", 100, 160);
            koniec_gry = true;
        }
        else if(tank2.getHealth()==0)
        {
            g2d.drawString("Koniec gry. Wygrał gracz 2", 100, 160);
            koniec_gry = true;
        }

        if(halt)
        {
            g2d.drawString("PAUSED", 100, 160);
            
        }
        g2d.setColor(Color.white);
        bstrategy.show();
    }
}