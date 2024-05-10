import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class AudioPlayer {

    //All desired .wav audio files should be placed in the victim-picker folder
    //This will allow for just the file name and extension to be used as the filepath location value.
    public static void playAudio(String location) {
        try {
            File soundPath = new File(location);

            if (soundPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(soundPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
            } else {

                //For debugging purposes
                throw new RuntimeException("Audio file not found. Location: " + location);

            }

        } catch (Exception e) {

            //This program doesn't accept user input if its broken debug
            System.err.println(e + "\nPlease check file location, name, and type is correct");

        }
    }
}
