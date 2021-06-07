import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Collections;
import java.util.List;
import java.util.Vector;


public class Load {
    public Missiles loadMissiles(){
        try {
            Missiles missiles_list = new Missiles();
            FileInputStream fis = new FileInputStream("saved_missiles.tmp");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Vector<Missile> missile_vector = new Vector<Missile>((List) ois.readObject());
            missiles_list.setMissiles(missile_vector);
            ois.close();
            return missiles_list;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }


    public Tank loadTanks(){
        try {
            Tank tank1 = new Tank(tank1.getX(),tank1.getY());
            Tank tank2 = new Tank(tank2.getX(),tank2.getY());
            FileInputStream fis = new FileInputStream("saved_tanks.tmp");
            ObjectInputStream ois = new ObjectInputStream(fis);
            tank1 = (Tank) ois.readObject();
            tank2 = (Tank) ois.readObject();
            ois.close();
            return tank1;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}

