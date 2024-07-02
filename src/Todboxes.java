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

import java.util.Random;

public class Todboxes {
    private int position;
    private String challenge;

    public Todboxes(int position, String challenge){
        this.position = position;
        this.challenge = challenge; 
    }

    // Getters
    public int getPosition(){
        return position;
    }

    public String getChallenge(){
        return challenge;
    }

    public static Todboxes generateRandomToDBox(int boardSize) {
        Random rand = new Random();
        String[] todChallenges = {
            // Truth challenges
            "Truth: Share an embarrassing moment.",
            "Truth: Who is your crush?",
            "Truth: What is your biggest fear?",
            "Truth: What is the most embarrassing thing you've ever done?",
            "Truth: Have you ever lied to get out of trouble? What was it?",
            "Truth: What is your most irrational fear?",
            "Truth: If you could change one thing about yourself, what would it be?",
            "Truth: What is the biggest secret you’ve ever kept from your parents?",
            "Truth: What’s the most ridiculous thing you’ve done because you were bored?",
            "Truth: What is your biggest pet peeve?",
            "Truth: Who was your first crush and why?",
            "Truth: What’s the weirdest thing you’ve ever eaten?",
            "Truth: What’s the most childish thing you still do?",

            // Dare challenges
            "Dare: Do 10 push-ups.",
            "Dare: Sing a song.",
            "Dare: Dance for 30 seconds.",
            "Dare: Imitate your favorite celebrity for 1 minute.",
            "Dare: Speak in an accent for the next 3 turns.",
            "Dare: Try to lick your elbow.",
            "Dare: Let another player draw on your face with a pen.",
            "Dare: Post an embarrassing photo on social media.",
            "Dare: Sing the chorus of your favorite song.",
            "Dare: Do your best chicken dance outside.",
            "Dare: Talk without closing your mouth for the next 2 turns.",
            "Dare: Do an impression of a famous person until another player can guess who you are.",
            "Dare: Let another player redo your hairstyle."
        };

        int position;
        String challenge;

        do {
            position = rand.nextInt(boardSize - 1) + 1; // Random position between 1 and boardSize
        } while (position == 1); // Avoid position 1

        challenge = todChallenges[rand.nextInt(todChallenges.length)];
        return new Todboxes(position, challenge);
    }
}
