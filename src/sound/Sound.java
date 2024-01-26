package sound;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.net.URL;

// CLASS CONTENT
/*
    SOUND FILES
    OPEN FILE
        - Open sound file
        - define Volume
    SOUND PLAY / LOOP / STOP
    SET VOLUME
        - choose from -80f (no Sound) to 6f
 */

public class Sound {

    Clip clip;
    URL[] sound = new URL[10];
    FloatControl floatControl;
    public int volumeScale = 3;
    float volume;


    // SOUND FILES
    public Sound(){
        //TODO: Add music files to "/Sound/Music/" Directory. Save as Wave-file.
        // Add new directory for to systemize files for better structure and fast search
        sound[0] = getClass().getResource("/Sound/Music/MainTheme_10m.wav");
        sound[1] = getClass().getResource("/Sound/Music/PianoOutro.wav");
        sound[2] = getClass().getResource("/Sound/Music/MainTheme_4m.wav");
        sound[3] = getClass().getResource("/Sound/Music/HospitalIntro.wav");

    }

    // OPEN FILE
    public void setFile(int i) {
        try{
            //Java format to open sound file
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream((sound[i]));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            // VOLUME
            floatControl = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);    //FloatControl accepts from -80f to 6f (-80 = no sound)
            setVolume();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // SOUND PLAY / LOOP / STOP
    public void play(){
        clip.start();
    }
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(){
        clip.stop();
    }

    public void setVolume(){
        switch (volumeScale) {
            //play with variables till changes seem same
            case 0 -> volume = -80f;
            case 1 -> volume = -20f;
            case 2 -> volume = -12f;
            case 3 -> volume = -5f;
            case 4 -> volume = 1f;
            case 5 -> volume = 6f;
        }
        floatControl.setValue(volume);  //set new Volume
    }
}