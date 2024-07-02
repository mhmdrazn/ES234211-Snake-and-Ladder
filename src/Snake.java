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

public class Snake{
    private int fromPosition;
    private int toPosition;

    public Snake(int from, int to){
        this.fromPosition = from;
        this.toPosition = to;
    }

    public void setFromPosition(int fromPosition){
        this.fromPosition = fromPosition;
    }

    public void setToPosition(int toPosition) {
        this.toPosition = toPosition;
    }

    public int getFromPosition(){
        return fromPosition;
    }

    public int getToPosition(){
        return toPosition;
    }
}