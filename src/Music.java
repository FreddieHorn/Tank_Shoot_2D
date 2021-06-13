import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;
import java.io.Serializable;

public class Music implements Serializable {
    //wektor plikow .wav uzytych w programie
    File pliki[] = {new File("muzyka/piu.wav"), new File("muzyka/chtsz.wav"), new File("muzyka/bum.wav"), new File("muzyka/theme.wav"), new File("muzyka/smierc.wav"), 
    new File("muzyka/wzmocnienie.wav")};
    public void mPunkt(int ktory_plik_zagrac){
        File mPath = null;
        //wybranie odpowiedniego pliku z listy na podstawie danych przeslanych do klasy
        if(ktory_plik_zagrac==1) mPath = pliki[0];
        if(ktory_plik_zagrac==2) mPath = pliki[1];
        if(ktory_plik_zagrac==3) mPath = pliki[2];
        if(ktory_plik_zagrac==4) mPath = pliki[3];
        if(ktory_plik_zagrac==5) mPath = pliki[4];
        if(ktory_plik_zagrac==6) mPath = pliki[5];
        try{
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(mPath);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInput);
            FloatControl gainControl =
                    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-10.0f);
            clip.start();
            if(ktory_plik_zagrac==4) 
            {
            clip.loop(Clip.LOOP_CONTINUOUSLY); 
            FloatControl gainControl1 =
            (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl1.setValue(-15.0f);
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}