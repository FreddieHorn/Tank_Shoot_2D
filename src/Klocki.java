
import java.awt.Rectangle;
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
    
    public int[][] mapa = new int[12][13];
    public static int solidBricksXPos[] = {150,350,150,500,450,300,600,400,350,200,0,200,500};
	
    public static int solidBricksYPos[] = {0,0,50,100,150,200,200,250,300,350,400,400,450};

    private Vector<Integer> klocki_on = new Vector<>();

    private Music muzyka = new Music();
    


    public Klocki()
    { 
    for (int i=0; i<42; i++)
    {
        klocki_on.add(1);
    }
    rysujmapke();
    }

    public Vector<Integer> getklocki_on() {return klocki_on;}
    public int[] getklockiX() {return klockiXPos;}
    public int[] getklockiY() {return klockiYPos;}
    public int[] getmocneklockiX() {return solidBricksXPos;}
    public int[] getmocneklockiY() {return solidBricksYPos;}
	public void setklockion(Vector<Integer> x) {
        klocki_on = x;
    }
    public void rysujmapke(){
        int x;
        int y;
        for (int i=0; i < klockiXPos.length; i++)
        {
            x = klockiXPos[i]/50;
            y = klockiYPos[i]/50;
            mapa[y][x] = 1;
        }
        for (int i=0; i < solidBricksXPos.length; i++)
        {
            x = solidBricksXPos[i]/50;
            y = solidBricksYPos[i]/50;
            mapa[y][x] = 1;
        }
        //boosts.add(new Boost(x,y,id));
    }
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

    public boolean checkCollision(int x, int y)
	{
		boolean collided1 = false;
		for(int i=0; i< klocki_on.size();i++)
		{
            if(klocki_on.get(i)==1)
            {
                if(new Rectangle(x+5, y+5, 40, 40).intersects(new Rectangle(klockiXPos[i], klockiYPos[i], 50, 50)))
                {
                    collided1 = true;
                    break;
                }
            }
		}
		return collided1;
	}

    public boolean checkbulletCollision(int x, int y)
	{
		boolean collided1 = false;
		for(int i=0; i< klocki_on.size();i++)
		{
            if(klocki_on.get(i)==1)
            {
                if(new Rectangle(x, y, 5, 5).intersects(new Rectangle(klockiXPos[i], klockiYPos[i], 50, 50)))
                {
                    muzyka.mPunkt(3);
                    collided1 = true;
                    klocki_on.set(i, 0); 
                    mapa[klockiYPos[i]/50][klockiXPos[i]/50] = 0;
                    break;
                }
            }
		}
		return collided1;
	}

    public boolean checkSolidBulletCollision(int x, int y)
	{
		boolean collided = false;
		for(int i=0; i< solidBricksXPos.length; i++)
		{		
			if(new Rectangle(x, y, 5, 5).intersects(new Rectangle(solidBricksXPos[i], solidBricksYPos[i], 50, 50)))
			{		
                muzyka.mPunkt(3);
				collided = true;
				break;
			}
		}
		return collided;
	}
}
