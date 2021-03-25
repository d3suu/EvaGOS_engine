package org.neocities.d3suu.EvaGOS;

import javax.sound.sampled.*;
import java.io.File;

public class AudioPlayer {
    public AudioPlayer(){

    }

    public void playSingle(String soundID){
        try {
            File yourFile;
            AudioInputStream stream;
            AudioFormat format;
            DataLine.Info info;
            Clip clip;

            stream = AudioSystem.getAudioInputStream(new File("C:\\eva\\WAVE\\" + soundID + ".WAV"));
            format = stream.getFormat();
            info = new DataLine.Info(Clip.class, format);
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(stream);
            clip.start();
        }
        catch (Exception e) {
            System.out.println("Sound exception: " + e.toString());
        }
    }
}
