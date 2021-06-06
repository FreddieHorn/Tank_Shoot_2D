import java.awt.*;
public class Missile {
    private int x;
    private int y;
    private int kierunek;
    private Klocki mur;

    public Missile(int given_tank_x, int given_tank_y, int given_tank_kierunek)
    {
        this.x = given_tank_x;
        this.y = given_tank_y;
        this.kierunek = given_tank_kierunek;
        if (this.kierunek == 0)
        {
            this.x = given_tank_x + 45;
            this.y = given_tank_y + 23;
        }
        else if (this.kierunek == 1)
        {
            this.y = given_tank_y + 23;
        }
        else if (this.kierunek == 2)
        {
            this.x = given_tank_x + 23;
        }
        else
        {
            this.x = given_tank_x + 23;
            this.y = given_tank_y + 45;
        }
    }

    public void moveMissile(Klocki mur)
    {
        switch(kierunek){
        case 0:
            //if(mur.checkbulletCollision(this.x+2,this.y)==false)
                this.x = this.x+2;
        break;
        case 1:
            //if(mur.checkbulletCollision(this.x-2,this.y)==false)
                this.x = this.x-2;
        break;
        case 2:
            //if(mur.checkbulletCollision(this.x,this.y-2)==false)
                this.y = this.y-2;    
        break;
        case 3:
            //if(mur.checkbulletCollision(this.x,this.y+2)==false)
                this.y = this.y+2;
        break;
        }
    }
    public int getX() {return this.x;}
    public int getY() {return this.y;}
    public int getkierunek() {return kierunek;}
}
