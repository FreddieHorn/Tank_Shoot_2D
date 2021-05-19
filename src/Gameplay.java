import java.awt.Rectangle;
public class Gameplay {

    public boolean CheckTankCollision(int x1, int y1, int x2, int y2){

    boolean collided = false;
	
    if(new Rectangle(x1+5, y1+5, 40, 40).intersects(new Rectangle(x2+5, y2+5, 40, 40)))
    {		
        collided = true;
    }

	return collided;
	}

}
