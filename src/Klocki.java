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
    
    public static int solidBricksXPos[] = {150,350,150,500,450,300,600,400,350,200,0,200,500};
	
    public static int solidBricksYPos[] = {0,0,50,100,150,200,200,250,300,350,400,400,450};

    private Vector<Integer> klocki_on = new Vector<>();

    
    


    public Klocki()
    { 
    for (int i=0; i<42; i++)
    {
        klocki_on.add(1);
    }
    }

    public Vector<Integer> getklocki_on() {return klocki_on;}
    public int[] getklockiX() {return klockiXPos;}
    public int[] getklockiY() {return klockiYPos;}
    public int[] getmocneklockiX() {return solidBricksXPos;}
    public int[] getmocneklockiY() {return solidBricksYPos;}
	
    public boolean checkSolidCollision(int x, int y)
	{
		boolean collided = false;
		for(int i=0; i< solidBricksXPos.length; i++)
		{		
			if(new Rectangle(x+5, y+5, 40, 40).intersects(new Rectangle(solidBricksXPos[i], solidBricksYPos[i], 50, 50)))
			{		
				collided = true;
				break;
			}
		}
		
		return collided;
	}

    public void checkCollision(int x, int y)
	{
		//boolean collided1 = false;
		for(int i=0; i< klocki_on.size();i++)
		{
            if(klocki_on.get(i)==1)
            {
                if(new Rectangle(x+5, y+5, 40, 40).intersects(new Rectangle(klockiXPos[i], klockiYPos[i], 50, 50)))
                {
                    klocki_on.set(i, 0);
                    //collided1 = true;
                    break;
                }
            }
		}
		
		//return collided1;
	}
}
