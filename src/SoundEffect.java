/**
 * -----------------------------------------------------
 * ES234211 - Programming Fundamental
 * Genap - 2023/2024
 * Group Capstone Project: Snake and Ladder Game
 * -----------------------------------------------------
 * Class    : C
 * Group    : 03
 * Members  :
 * 1. 5026231016 - Fathan Maulana Prasetya
 * 2. 5026231031 - Marco Indrajaya
 * 3. 5026231174 - Muhammad Razan Parisya Putra
 * ------------------------------------------------------
 */

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