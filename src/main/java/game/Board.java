package game;

public class Board {
    private int size = 3; //Number of Rows and Columns; Default is 3
    private String[][] field = new String[3][3]; // Playing-field
    private int moveCounter = 0; // Counter for the Number of moves

    public Board() { // default constructor
        setSize(3);
        moveCounter = 0;
        field = new String[3][3];
        reset();
    }

    public Board(int size) { // Constructor with a passed over variable "size"
        setSize(size);
        moveCounter = 0;
        field = new String[this.size][this.size];
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

    public String[][] getField() { //returns the current field
        return field;
    }

    /**
     * For Test Purpose
     * will be removed after another Methode has been implemented
     */
    public void setFieldTest(){
        field[0][1] = "X";
        field[0][2] = "O";
        field[1][0] = "X";
        field[1][1] = "O";
        field[1][2] = "X";
        field[2][0] = "O";
    }

    public void reset(){ // Resets the Game, to start a new one
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                field[row][col] = " ";
            }
        }
    }

    public int getMoveCounter() { //returns the current number of moves
        return moveCounter;
    }



    public String printGameBoard(){ // returns a String of the current GameBoard
        String s = "";
        for(int row = 0; row < size; row++){
            s += (field[row][0] + "|" + field[row][1] + "|" + field[row][2]+"");
            if(row < 2) s+= "\n-----\n";
        }
        return s;
    }
}
