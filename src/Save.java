import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.io.Serializable;

public class Save implements Serializable{
    
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
    public void saveBricks(Vector<Integer> help){
        try {
            //konieczne zamienianie wektora asteroid na listę pomocnicza
            List<Integer> helper = Collections.list(help.elements());
            FileOutputStream fos = new FileOutputStream("saved_bricks.tmp");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(helper);
            oos.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void saveTankcoords(int x, int y, int x1, int y1, int h1, int h2, int k1, int k2)
    {
        try {

            FileOutputStream fos = new FileOutputStream("saved_tank_coords.tmp");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            Vector<Integer> vec = new Vector<>();

            vec.add(x);
            vec.add(y);
            vec.add(x1);
            vec.add(y1);
            vec.add(k1);
            vec.add(k2);
            vec.add(h1);
            vec.add(h2);

            
            List<Integer> list = Collections.list(vec.elements());
            oos.writeObject(list);
            oos.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void saveTank1(Tank help){
        try {
            FileOutputStream fos = new FileOutputStream("saved_tank1.tmp");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(help);
            
            oos.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }


    public void saveTank2(Tank help){
        try {
            FileOutputStream fos = new FileOutputStream("saved_tank2.tmp");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(help);
            
            oos.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void saveboost(Boosts boost){
        try {
            //konieczne zamienianie wektora asteroid na listę pomocnicza
            List<Boost> helper = Collections.list(boost.getBoosts().elements());
            FileOutputStream fos = new FileOutputStream("saved_boosts.tmp");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(helper);
            oos.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
