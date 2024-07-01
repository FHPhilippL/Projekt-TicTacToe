package game;

public class Board {
    private int size = 3; //Number of Rows and Columns
    private String[][] field; // Playing-field
    private int moveCounter = 0; // Counter for the Number of moves

    public Board() { // default constructor
        field = new String[3][3];
        reset();
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
    }

    public int getMoveCounter() { //returns the current number of moves
        return moveCounter;
    }

    public void reset(){ // Resets the Game, to start a new one
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                field[row][col] = " ";
            }
        }
        moveCounter = 0;
    }

    /**
     * Adds the Symbol to the game if the position is still empty
     * @param symbol the given Symbol to insert
     * @param row the row in which the symbol should be added, must be positive and lower than 3
     * @param col the column in which the symbol should be added, must be positive and lower than 3
     * @return true if success, false otherwise
     */
    public boolean addSymbol(String symbol, int row, int col){
        if(row >= size || row < 0) return false;
        if(col >= size || col < 0) return false;
        if(field[row][col].equals(" ")){
            field[row][col]=symbol;
            moveCounter++;
            return true;
        }
        return false;
    }

    public boolean checkForWin(String symbol){
        for(int i = 0; i < size; i++){
            if(symbol.equals(field[i][0])&&symbol.equals(field[i][1])&&symbol.equals(field[i][2])) return true;
        }

        for(int i = 0; i < size; i++){
            if(symbol.equals(field[0][i])&&symbol.equals(field[1][i])&&symbol.equals(field[2][i])) return true;
        }

        if(symbol.equals(field[0][0])&&symbol.equals(field[1][1])&&symbol.equals(field[2][2])) return true;

        if(symbol.equals(field[0][2])&&symbol.equals(field[1][1])&&symbol.equals(field[2][0])) return true;

        return false;
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
