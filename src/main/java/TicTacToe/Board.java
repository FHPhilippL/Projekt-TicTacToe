package TicTacToe;

public class Board {
    private int rows = 3; //Anzahl der Zeilen; Default ist 3
    private int collums = 3; // Anzahl der Spalten; Default ist 3
    private int[][] field = new int[3][3]; // Erstellt das 3x3 Spielfeld
    private int moveCounter = 0; // Zähler der Spielzüge
}
