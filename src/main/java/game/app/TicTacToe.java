package game.app;

import game.entities.Board;
import game.entities.Player;

import java.util.Scanner;

public class TicTacToe {
    private static Player p1;
    private static Player p2;
    private static final Scanner sc = new Scanner(System.in);
    private static Board board;
    private static int completed;
    private static int starting;
    private static boolean isOver = false;

    public static void main(String[] args) {
        init();
        runGame();
    }

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

    public static void runGame(){
        int p1c, p1r, p2c, p2r;
        do{
            do{
                System.out.println(board.printGameBoard());
                System.out.println("Player 1: "+ p1.getName() + "s turn: ");
                System.out.println("Which Row would you like?");
                p1r = sc.nextInt();
                System.out.println("Which Column would you like?");
                p1c = sc.nextInt();
            } while (!board.addSymbol(p1.getSymbol(), p1r, p1c));

            if(board.getMoveCounter()>=4){
                if(board.checkForWin(p1.getSymbol())){
                    victory(p1);
                }else if(board.getMoveCounter() == 9) draw();
            }

            if(!isOver){
                do{
                    System.out.println(board.printGameBoard());
                    System.out.println("Player 2: "+ p2.getName() + "s turn: ");
                    System.out.println("Which Row would you like?");
                    p2r = sc.nextInt();
                    System.out.println("Which Column would you like?");
                    p2c = sc.nextInt();
                } while (!board.addSymbol(p2.getSymbol(), p2r, p2c));

                if(board.getMoveCounter()>=4){
                    if(board.checkForWin(p2.getSymbol())){
                        victory(p2);
                    }else if(board.getMoveCounter() == 9) draw();
                }
            }
        }while (!isOver);
        newGame();
    }

    public static void victory(Player p){
        System.out.println("Congratulations: Player " + p.getName() + " won");
        System.out.println(board.printGameBoard());
        isOver = true;
    }

    public static void draw() {
        System.out.println("The Game Ended in a Draw");
        System.out.println(board.printGameBoard());
        isOver = true;
    }

    public static void newGame(){
        System.out.print("\n\nDo you want to play a new Game? (y/n): ");
        String s = sc.next();
        s = s.toLowerCase();

        switch (s) {
            case ("y"), ("yes") -> {
                board.reset();
                isOver = false;
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
