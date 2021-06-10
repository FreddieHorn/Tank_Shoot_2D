import java.io.Serializable;
import java.util.Vector;

public class Boosts {
    private Vector<Boost> boosts;
    private Tank tank1;
    private Tank tank2;
    public Boosts(){
        this.boosts = new Vector<>();
    }

    public void setBoosts(Vector<Boost> boosts) {
        this.boosts = boosts;
    }

    public Vector<Boost> getBoosts(){
        return this.boosts;
    }

    public void newboost(int x, int y, int id){
        //tutaj damy losowanie na podstawie mapy którą zrobimy. 
        boosts.add(new Boost(x,y,id));
    }

    public void collisoncheck(Tank tank1, Tank tank2){
    
    }

}
