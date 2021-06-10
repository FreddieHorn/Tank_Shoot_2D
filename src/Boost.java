import java.awt.Rectangle;



public class Boost {
    
    private int x;
    private int y;
    private int id;
    private Tank tank1;
    private boolean isactive;
    public Boost(int g_x, int g_y, int g_id){
        this.x = g_x;
        this.y = g_y;
        this.id = g_id;
        this.isactive = true;
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

    public void setactive(boolean trufal){
        this.isactive = trufal;
    }

    public boolean getactive(){
        return this.isactive;
    }

    public boolean collisoncheck(Tank tank)
    {
        boolean collided = false;
        if(new Rectangle(tank.getX(), tank.getY(), 40, 40).intersects(new Rectangle(this.x, this.y, 50, 50)) && isactive)
        {
            collided = true;
            tank.setspeed_boost(true);
            isactive = false;
        }
        return collided;
    }


    
}
