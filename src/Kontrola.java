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
    private Image tlo;
    private Klocki mur;

    Kontrola(){
        super("Tank_Shoot 2D");
        setBounds(10,10,800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.black);
        setResizable(false);
        setVisible(true);
        createBufferStrategy(2);
        
        klocek = new ImageIcon("obrazki/klocek.jpg").getImage();
        tlo = new ImageIcon("obrazki/tlo.jpg").getImage();
        mur = new Klocki();
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
                g2d.drawImage(klocek, Klocki.getklockiX()[i],Klocki.getklockiY()[i],null);
                
            }
        }
        g2d.setColor(Color.white);
        //g2d.drawString(String.valueOf(Klocki.getklockiX()]), 100, 100);
        //g2d.drawImage(klocek, 50,50,null);
        bstrategy.show();
    }
}