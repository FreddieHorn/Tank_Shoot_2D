
import java.io.Serializable;



public class Boost implements Serializable{
    
    private int x;
    private int y;
    private int id;
    public Boost(int g_x, int g_y, int g_id){
        this.x = g_x;
        this.y = g_y;
        this.id = g_id;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getID(){
        return id;
    }
}
