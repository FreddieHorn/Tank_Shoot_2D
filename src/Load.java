import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.io.Serializable;
import java.nio.file.Files;

import java.nio.file.Path;

public class Load implements Serializable{
    public Vector<Missile> loadMissiles(){
        try {
            Missiles missiles_list = new Missiles();
            FileInputStream fis = new FileInputStream("saved_missiles.tmp");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Vector<Missile> missile_vector = new Vector<Missile>((List)ois.readObject());
            missiles_list.setMissiles(missile_vector);
            ois.close();
            fis.close();
            return missile_vector;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }


    public Vector<Boost> loadBoosts(){
        try {
            FileInputStream fis = new FileInputStream("saved_boosts.tmp");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Vector<Boost> boost_vector = new Vector<Boost>((List)ois.readObject());
            ois.close();
            fis.close();
            return boost_vector;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Vector<Integer> loadbricks(){
        try {
            FileInputStream fis = new FileInputStream("saved_bricks.tmp");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Vector<Integer> bricks_vector = new Vector<Integer>((List)ois.readObject());
            ois.close();
            return bricks_vector;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Vector<Integer> loadtankcoords(){
        try {
           
            FileInputStream fis = new FileInputStream("saved_tank_coords.tmp");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Vector<Integer> tank_vector = new Vector<Integer>((List)ois.readObject());
            ois.close();
            return tank_vector;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }



    public Tank loadTank1(int x,int y){
        try {
            Tank tank1 = new Tank(x, y);
            FileInputStream fis = new FileInputStream("saved_tank1.tmp");
            ObjectInputStream ois = new ObjectInputStream(fis);
            tank1 = (Tank) ois.readObject();
            ois.close();
            return tank1;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Tank loadTank2(int x, int y){
        try {
            Tank tank2 = new Tank(x, y);
            FileInputStream fis = new FileInputStream("saved_tank2.tmp");
            ObjectInputStream ois = new ObjectInputStream(fis);
            tank2 = (Tank) ois.readObject();
            ois.close();
            return tank2;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}

