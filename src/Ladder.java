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

public class Ladder {
    private int fromPosition;
    private int toPosition;

    public Ladder(int fromPosition, int toPosition){
        this.fromPosition = fromPosition;
        this.toPosition = toPosition;
    }

    public void setFromPosition(int x){
        this.fromPosition = x;
    }

    public void setToPosition(int y){
        this.toPosition = y;
    }

    public int getFromPosition(){
        return fromPosition;
    }

    public int getToPosition(){
        return toPosition;
    }
}