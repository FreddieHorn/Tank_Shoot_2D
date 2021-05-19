public class Gameplay {
    public void jazda(Tank tank,Boolean klawisze[]){



        if(klawisze[0]) 
        {
            tank.ruchGora();
        }
        else if(klawisze[1])
        {
            tank.ruchDol();
        }
        else if(klawisze[2])
        {
            tank.ruchLewo();
        }
        else if(klawisze[3])
        {
            tank.ruchPrawo();
        }
    }
}
