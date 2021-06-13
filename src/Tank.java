


public class Tank {
    private int x;
    private int y;
    private int x2;
    private int y2;
    private int kierunek;
    private Klocki mur;
    private Gameplay gra;
    private int health;
    private int score;
    private boolean shot_boost;
    private boolean fire_rate_up;


    public Tank(int given_x, int given_y)
    {
        this.x = given_x;
        this.y = given_y;
        this.kierunek = 2;
        this.health = 5;
        this.score = 0;
        this.shot_boost = false;
        this.fire_rate_up = false;
    }

    public void setHealth(int h)
    {
        if(this.health>0&&this.health<=5&&shot_boost==false)
            this.health -= h; 
    }

    public void up_score(int h)
    {
        this.score+=1; 
    }

    public int getHealth()
    {
        return this.health;
    }

    public void setkierunek(int x)
    {
        this.kierunek = x;
    }

    public void setHealthstronk(int x)
    {
        this.health = x;
    }

    public void ruchPrawo(int x_of_second_tank, int y_of_second_tank, Klocki given_mur, Gameplay given_gra)
    {
        this.mur = given_mur;
        this.gra = given_gra;
        this.x2 = x_of_second_tank;
        this.y2 = y_of_second_tank;
        if(!mur.checkSolidCollision(this.x+1, this.y) && !mur.checkCollision(this.x+1, this.y) && !gra.CheckTankCollision(this.x+1, this.y, this.x2, this.y2))
        {
            mur.checkCollision(this.x+1, this.y);
            this.x = x+1;
            if(x>600) x = 600;
        }
    }
      public void ruchLewo(int x_of_second_tank, int y_of_second_tank, Klocki given_mur, Gameplay given_gra)
    {
        this.mur = given_mur;
        this.gra = given_gra;
        this.x2 = x_of_second_tank;
        this.y2 = y_of_second_tank;
        if(!mur.checkSolidCollision(this.x-1, this.y) && !mur.checkCollision(this.x-1, this.y) && !gra.CheckTankCollision(this.x-1, this.y, this.x2, this.y2))
        {
            mur.checkCollision(this.x-1, this.y);
            this.x = x-1;
            if(x<0) x = 0;
        }
        
    }
    public void ruchGora(int x_of_second_tank, int y_of_second_tank, Klocki given_mur, Gameplay given_gra)
    {
        this.mur = given_mur;
        this.gra = given_gra;
        this.x2 = x_of_second_tank;
        this.y2 = y_of_second_tank;
        if(!mur.checkSolidCollision(this.x, this.y-1) && !mur.checkCollision(this.x, this.y-1) && !gra.CheckTankCollision(this.x, this.y-1, this.x2, this.y2))
        {
            mur.checkCollision(this.x, this.y-1);
            this.y = y-1;
            if(y<0) y = 0;
        }

    }
    public void ruchDol(int x_of_second_tank, int y_of_second_tank, Klocki given_mur, Gameplay given_gra)
    {
        this.mur = given_mur;
        this.gra = given_gra;
        this.x2 = x_of_second_tank;
        this.y2 = y_of_second_tank;
        if(!mur.checkSolidCollision(this.x, this.y+1) && !mur.checkCollision(this.x, this.y+1) && !gra.CheckTankCollision(this.x, this.y+1, this.x2, this.y2))
        {
            mur.checkCollision(this.x, this.y+1);
            this.y = y+1;
            if(y>550) y = 550;
        }
    }
    public int getX() {return x;}
    public int getY() {return y;}
    public void setX(int x1) {
        this.x = x1;
    }

    public void setY(int y1) {
        this.y = y1;
    }
    public int getkierunek() {return kierunek;}
    public void setspeed_boost(boolean trufal) {this.shot_boost = trufal;}
    public void setfirerate_boost(boolean trufal) {this.fire_rate_up = trufal;}
    public boolean getspeed_boost() {return shot_boost;}
    public boolean getfireupgrade() {return fire_rate_up;}

}
