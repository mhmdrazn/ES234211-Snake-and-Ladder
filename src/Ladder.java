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
