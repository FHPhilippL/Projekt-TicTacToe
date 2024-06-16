package game;

public class Board {
    private int size = 3; //Number of Rows and Columns; Default is 3
    private int[][] field = new int[3][3]; // Playing-field
    private int moveCounter = 0; // Counter for the Number of moves

    public Board() { // default constructor
        setSize(3);
        moveCounter = 0;
        field = new int[3][3];
    }

    public Board(int size) { // Constructor with a passed over variable "size"
        setSize(size);
        moveCounter = 0;
        field = new int[this.size][this.size];
    }

    public int getSize() { // returns the size of the playing-field
        return size;
    }

    public void setSize(int size) { // sets the current size to the passed variable
        if(size < 3 ) {          // if size < 3 than the size will be set to 0
            this.size = 3;
        } else {
            this.size = size;
        }

    }

    public int[][] getField() { //returns the current field
        return field;
    }

    public int getMoveCounter() { //returns the current number of moves
        return moveCounter;
    }

}
