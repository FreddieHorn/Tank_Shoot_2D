import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.List;

public class Save {
    
    public void saveMissiles(Missiles help){
        try {
            //konieczne zamienianie wektora asteroid na listę pomocnicza
            List<Missile> helper = Collections.list(help.getMissiles().elements());
            FileOutputStream fos = new FileOutputStream("saved_missiles.tmp");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(helper);
            oos.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
    /*public void saveBricks(Klocki help){
        try {
            //konieczne zamienianie wektora asteroid na listę pomocnicza
            List<Missile> helper = Collections.list(help.getklocki_on().elements());
            FileOutputStream fos = new FileOutputStream("asteroidy_zapisane.tmp");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(helper);
            oos.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }*/
    public void saveTank(Tank help, Tank help2){
        try {
            FileOutputStream fos = new FileOutputStream("saved_tanks.tmp");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(help);
            oos.writeObject(help2);
            
            oos.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
