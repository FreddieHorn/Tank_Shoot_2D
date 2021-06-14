import java.io.Serializable;
import java.util.Vector;
import java.util.Random;
import java.awt.Rectangle;

public class Boosts implements Serializable{
    private Vector<Boost> boosts;
    private Music muzyka = new Music();
    public Boosts(){
        this.boosts = new Vector<>();
    }

    public void setBoosts(Vector<Boost> boosts) {
        this.boosts = boosts;
    }

    public Vector<Boost> getBoosts(){
        return this.boosts;
    }
    //losowanie pozycji na mapie w której ma się pojawić wzmocnienie
    public void newboost(Klocki mur, int id){
        int x = 0;
        int y = 0;
        int ilosc = 0;
        int dalej = 0;
        for (int i = 0; i < 12; i++)
        {
            for (int j = 0; j < 13; j++)
            {
                if (mur.mapa[i][j] == 0)
                ilosc++;
            }
        }
        Random rand = new Random(); 
        int int_random = rand.nextInt(ilosc+1); 

        for (int i = 0; i < 12; i++)
        {
            for (int j = 0; j < 13; j++)
            {
                if (mur.mapa[i][j] == 0)
                {
                    dalej++;
                    if (dalej==int_random)
                    {
                        x = j*50;
                        y = i*50;
                    }
                }
            }
        }
        boosts.add(new Boost(x,y,id));
    }
    //sprawdzanie kolizji czołgu ze wzmocnieniem oraz aktywowanie danego wzmocnienia dla czołgu który je zebrał
    public boolean collisoncheck(Tank tank1, Tank tank2, int x, int y){
        boolean collided = false;
        for(int i=0;i<boosts.size();i++)
        {
            
                if(new Rectangle(x, y, 50, 50).intersects(new Rectangle(tank1.getX(), tank1.getY(), 40, 40)))
                {
                    
                    if(boosts.get(i).getID()==0)
                        tank1.setshield_boost(true);
                    else if(boosts.get(i).getID()==1)
                        tank1.setfirerate_boost(true);
                    collided = true;
                    muzyka.mPunkt(6);
                }
            
            else if (new Rectangle(x, y, 50, 50).intersects(new Rectangle(tank2.getX(), tank2.getY(), 40, 40)))
            {
                    if(boosts.get(i).getID()==0)
                        tank2.setshield_boost(true);
                    else if(boosts.get(i).getID()==1)
                        tank2.setfirerate_boost(true);
                    collided = true;
                    muzyka.mPunkt(6);
            }
        }

        
        return collided;
    }
    //przeszukiwanie i aktywowanie za pomocą collisoncheck wzmocnień oraz ich usuwanie
    public void emptyBoosts(Tank tank1, Tank tank2){
        if(!boosts.isEmpty())
        {
            
            boolean end=false;
            int i=0;
            while(!end)
            {

                if(collisoncheck(tank1, tank2, boosts.get(i).getX(), boosts.get(i).getY())==true)
                {
                    boosts.remove(i);
                    i=0;
                }
                else
                {
                    i++;
                }

                if(i>=boosts.size())
                {
                    end=true;
                }
            }
        }
    }

}
