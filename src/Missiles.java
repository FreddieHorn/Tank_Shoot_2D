import java.io.Serializable;
import java.util.Vector;

public class Missiles implements Serializable{
    private Vector<Missile> missiles;
    public Missiles() {
        this.missiles = new Vector<Missile>();
    }
    //setter pociskow
    public void setMissiles(Vector<Missile> missiles) {
        this.missiles = missiles;
    }

    //getter pociskow
    public Vector<Missile> getMissiles() {
        return missiles;
    }

    //tworzenie nowych pociskow i dodawanie ich do obecnego wektora pociskow
    public void newMissile(int x,int y,int kierunek, int who_shot){
        missiles.add(new Missile(x,y,kierunek, who_shot));
    }

    public void emptyMissiles(Klocki mur, Tank tank1, Tank tank2, Gameplay gm){
        if(!missiles.isEmpty())
        {
            for(int i=0;i<missiles.size();i++)
            {
                missiles.get(i).moveMissile(mur);
            }
            boolean end=false;
            int i=0;
            int kierunek;
            while(!end)
            {
                kierunek=missiles.get(i).getkierunek();
                switch(kierunek){
                    case 0: 
                        if(missiles.get(i).getX()>=650 || mur.checkbulletCollision(missiles.get(i).getX(),missiles.get(i).getY())==true || 
                        mur.checkSolidBulletCollision(missiles.get(i).getX(),missiles.get(i).getY())==true || gm.CheckbulletandtankCollision(missiles.get(i).getX(),missiles.get(i).getY(), 
                        tank1.getX(), tank1.getY(), tank2.getX(), tank2.getY(), missiles.get(i), tank1, tank2))
                        {
                            missiles.remove(i);
                            i=0;
                        }
                        else
                        {
                            i++;
                        }
                    break;
                    case 1:
                        if(missiles.get(i).getX()<=0 || mur.checkbulletCollision(missiles.get(i).getX(),missiles.get(i).getY())==true ||
                        mur.checkSolidBulletCollision(missiles.get(i).getX(),missiles.get(i).getY())==true || gm.CheckbulletandtankCollision(missiles.get(i).getX(),missiles.get(i).getY(), 
                        tank1.getX(), tank1.getY(), tank2.getX(), tank2.getY(), missiles.get(i), tank1, tank2))
                        {
                            missiles.remove(i);
                            i=0;
                        }
                        else
                        {
                            i++;
                        }
                    break;
                    case 2:
                        if(missiles.get(i).getY()<=0 || mur.checkbulletCollision(missiles.get(i).getX(),missiles.get(i).getY())==true ||
                        mur.checkSolidBulletCollision(missiles.get(i).getX(),missiles.get(i).getY())==true || gm.CheckbulletandtankCollision(missiles.get(i).getX(),missiles.get(i).getY(), 
                        tank1.getX(), tank1.getY(), tank2.getX(), tank2.getY(), missiles.get(i), tank1, tank2))
                        {
                            missiles.remove(i);
                            i=0;
                        }
                        else
                        {
                            i++;
                        }
                    break;
                    case 3:
                        if(missiles.get(i).getY()>=600 || mur.checkbulletCollision(missiles.get(i).getX(),missiles.get(i).getY())==true || 
                        mur.checkSolidBulletCollision(missiles.get(i).getX(),missiles.get(i).getY())==true || gm.CheckbulletandtankCollision(missiles.get(i).getX(),missiles.get(i).getY(), 
                        tank1.getX(), tank1.getY(), tank2.getX(), tank2.getY(), missiles.get(i), tank1, tank2))
                        {
                            missiles.remove(i);
                            i=0;
                        }
                        else
                        {
                            i++;
                        }
                    break;
                }
                
                
                if(i>=missiles.size())
                {
                    end=true;
                }
            }
        }
    }
}
