package game.entities;

public class Board {
    private final int size = 3; //Number of Rows and Columns
    private final String[][] field; // Playing-field
    private int moveCounter = 0; // Counter for the Number of moves

    public Board() { // default constructor
        field = new String[3][3];
        reset();
    }

    /**
     * Returns the Current field
     * @return the field
     */
    public String[][] getField() {
        return field;
    }

    /**
     * returns the current moveCounter to either start to check for a win or to call a draw
     * @return the current moveCounter
     */
    public int getMoveCounter() {
        return moveCounter;
    }

    /**
     * Resets the field, so a new Game can be started
     */
    public void reset(){
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
        if(row-1 >= size || row-1 < 0) return false;
        if(col-1 >= size || col-1 < 0) return false;

        if(field[row-1][col-1].equals(" ")){
            field[row-1][col-1]=symbol;
            moveCounter++;
            return true;
        }

        System.err.println("This Position is already used!!");
        return false;
    }

    /**
     * Checks if the current Player has 3 in a row
     * @param symbol the Symbol with that it checks
     * @return true, when won, otherwise false;
     */
    public boolean checkForWin(String symbol){
        for(int i = 0; i < size; i++){
            if(symbol.equals(field[i][0]) && symbol.equals(field[i][1]) &&
                    symbol.equals(field[i][2])){
                return true;
            }
        }

        for(int i = 0; i < size; i++){
            if(symbol.equals(field[0][i]) && symbol.equals(field[1][i]) &&
                    symbol.equals(field[2][i])){
                return true;
            }
        }

        if(symbol.equals(field[0][0]) && symbol.equals(field[1][1]) &&
                symbol.equals(field[2][2])){
            return true;
        } else return symbol.equals(field[0][2]) && symbol.equals(field[1][1]) &&
                symbol.equals(field[2][0]);
    }

    /**
     * Returns a String of the current GameBoard in the TicTacToe Format
     * @return String of current Game
     */
    public String printGameBoard(){
        StringBuilder s = new StringBuilder();
        for(int row = 0; row < size; row++){
            s.append(field[row][0]).append("|").append(field[row][1])
                    .append("|").append(field[row][2]);
            if(row < 2) s.append("\n-----\n");
        }
        return s.toString();
    }
}
