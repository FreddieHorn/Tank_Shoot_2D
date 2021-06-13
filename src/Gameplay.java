import java.awt.Rectangle;

public class Gameplay {
    private long timepassed;

    public boolean CheckTankCollision(int x1, int y1, int x2, int y2){

    boolean collided = false;
	
    if(new Rectangle(x1+5, y1+5, 40, 40).intersects(new Rectangle(x2+5, y2+5, 40, 40)))
    {		
        collided = true;
    }

	return collided;
	}


    public boolean CheckbulletandtankCollision(int x1, int y1, int x2, int y2, int x3, int y3, Missile missile, Tank tank1, Tank tank2){

        boolean collided = false;
        if(missile.getshooter()==0)
        {
            if(new Rectangle(x1, y1, 5, 5).intersects(new Rectangle(x2, y2, 40, 40)))
            {		
                collided = true;
                tank1.setHealth(1);
            }
        }
        else if(missile.getshooter()==1)
        {
            if(new Rectangle(x1, y1, 5, 5).intersects(new Rectangle(x3, y3, 40, 40)))
            {		
                collided = true;
                tank2.setHealth(1);
            }
        }
        return collided;
        }
    
    public long gettimepassed(){
        return this.timepassed/1000;
    }
}


