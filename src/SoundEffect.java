import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.IOException;

public class SoundEffect {
public static void playSound(String soundFile) {
    try {
        File file = new File(soundFile);
        Clip clip = AudioSystem.getClip();
        clip.open(AudioSystem.getAudioInputStream(file));
        clip.start();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
