import java.awt.*;




public class Tank {
    public int x;
    public int y;
    public int kierunek;

    public Tank(int given_x, int given_y)
    {
        this.x = given_x;
        this.y = given_y;
        this.kierunek = 2;
    }
    public void ruchPrawo()
    {
        
        this.x = x+1;
        if(x>600) x = 600;
        this.kierunek = 0;
    }
      public void ruchLewo()
    {
        
        this.x = x-1;
        if(x<0) x = 0;
        this.kierunek=1;
        
    }
    public void ruchGora()
    {
        
        this.y = y-1;
        if(y<0) y = 0;
        this.kierunek=2;
        
    }
    public void ruchDol()
    {
        
        this.y = y+1;
        if(y>600) y = 600;
        this.kierunek=3;
    }
    public int getX() {return x;}
    public int getY() {return y;}
    public int getkierunek() {return kierunek;}
    public Rectangle getwymiary(){
        return new Rectangle(this.x,this.y,50,50);
    }
}
