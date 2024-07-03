package game.app;

import game.entities.Board;
import game.entities.Player;

import java.util.Scanner;

public class TicTacToe {
    private static Player p1;
    private static Player p2;
    private static Scanner sc = new Scanner(System.in);
    private static Board board;
    private static int completed;
    private static int starting = 1;
    private static boolean isOver = false;

    public static void main(String[] args) {
        init();
        runGame();
    }

    /**
     * Initializes the Players as well as the Board
     */
    public static void init(){
        System.out.print("Please enter the Name for Player 1: ");
        String name1 = sc.next();
        System.out.print("Please enter the Symbol you would like to chose: ");
        String symbol1 = sc.next();
        p1 = addPlayer(name1, symbol1);

        System.out.print("\nPlease enter the Name for Player 2: ");
        String name2 = sc.next();
        System.out.print("Please enter the Symbol you would like to chose: ");
        String symbol2 = sc.next();
        p2 = addPlayer(name2, symbol2);

        board = new Board();
    }

    /**
     * Creates a new Player with the given Variables
     * @param name The name of the Player
     * @param symbol The Symbol the player uses
     * @return The created Player
     */
    public static Player addPlayer(String name, String symbol){
        Player p = null;
        try{
            if(p1 != null && p1.getSymbol().equals(symbol)){
                System.err.println("You cannot use the same symbol as Player 1");
                System.out.println("Please try again: ");
                System.out.print("Symbol: ");
                symbol = sc.next();
            }
            p = new Player(name, symbol);
        }catch(IllegalArgumentException e1){
            if(e1.getMessage().equals("The Symbol can neither be null, empty or blank")){
                System.err.println(e1.getMessage());
            }else if(e1.getMessage().equals("The Symbol can only consist of 1 Character")){
                System.err.println(e1.getMessage());
            }
            System.out.println("Please try again: ");
            System.out.print("Symbol: ");
            String sn = sc.next();
            p = addPlayer(name, sn);
        }catch (Exception e){
            System.err.println("An unknown error occurred");
            System.out.println("Please try again: ");
            System.out.print("Symbol: ");
            String sn = sc.next();
            p = addPlayer(name, sn);
        }
        return p;
    }

    /**
     * Starts the Game and runs it
     */
    public static void runGame(){
        int p1c, p1r, p2c, p2r;
        do{
            if(starting == 1 || board.getMoveCounter() > 0){
                addSymbol(p1);
            }

            if(!isOver){
                addSymbol(p2);
            }
        }while (!isOver);
        completed++;
        newGame();
    }

    public static void addSymbol(Player p){
        int row, col;
        do{
            System.out.println(board.printGameBoard());
            System.out.println("Player "+ p.getName() + "s turn: ");
            System.out.println("Which Row would you like?");
            row = sc.nextInt();
            System.out.println("Which Column would you like?");
            col = sc.nextInt();
        } while (!board.addSymbol(p.getSymbol(), row, col));

        if(board.getMoveCounter()>=4){
            if(board.checkForWin(p.getSymbol())){
                victory(p);
            }else if(board.getMoveCounter() == 9) draw();
        }
    }

    /**
     * In case of A Victory prints a Win Message
     * @param p the Player who won
     */
    public static void victory(Player p){
        System.out.println("Congratulations: Player " + p.getName() + " won");
        System.out.println(board.printGameBoard());
        isOver = true;
    }

    /**
     * In case of a draw, prints a Draw Message
     */
    public static void draw() {
        System.out.println("The Game Ended in a Draw");
        System.out.println(board.printGameBoard());
        isOver = true;
    }

    /**
     * Starts a new Game if the Players wish to
     */
    public static void newGame(){
        System.out.print("\n\nDo you want to play a new Game? (y/n): ");
        String s = sc.next();
        s = s.toLowerCase();

        switch (s) {
            case ("y"), ("yes") -> {
                board.reset();
                isOver = false;
                if(completed%2 ==0){
                    starting = 1;
                }else starting = 2;
                runGame();
                return;
            }
            default -> {
            }
        }

        System.out.println("The Game has Ended");
        System.out.println("Thank you for playing");
    }
}
