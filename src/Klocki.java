import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.util.Vector;

public class Klocki {




    public static int klockiXPos[] = {50,350,450,550,50,300,350,450,550,150,150,450,550,
        250,50,100,150,550,250,350,450,550,50,250,350,550,
        50,150,250,300,350,550,50,150,250,350,450,550,50,
        250,350,550};

    public static int klockiYPos[] = {50,50,50,50,100,100,100,100,100,150,200,200,200,250,
        300,300,300,300,350,350,350,350,400,400,400,400,450,
        450,450,450,450,450,500,500,500,500,500,500,550,550,
        550,550};


    private Vector<Integer> klocki_on = new Vector<>();

    
    


    public Klocki()
    { 
    for (int i=0; i<42; i++)
    {
        klocki_on.add(1);
    }
    }

    public Vector<Integer> getklocki_on() {return klocki_on;}
    public static int[] getklockiX() {return klockiXPos;}
    public static int[] getklockiY() {return klockiYPos;}

}
