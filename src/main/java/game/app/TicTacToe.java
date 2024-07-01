package game.app;

import game.entities.Player;

import java.util.Scanner;

public class TicTacToe {
    private static Player p1;
    private static Player p2;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        init();
    }

    public static void init(){
        System.out.print("Please enter the Name for Player 1: ");
        String name1 = sc.next();
        System.out.print("Please enter the Symbol you would like to chose: ");
        String symbol1 = sc.next();
        p1 = addPlayer(name1, symbol1);

        System.out.println("");

        System.out.print("Please enter the Name for Player 2: ");
        String name2 = sc.next();
        System.out.print("Please enter the Symbol you would like to chose: ");
        String symbol2 = sc.next();
        p2 = addPlayer(name2, symbol2);
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
            addPlayer(name, sn);
        }catch (Exception e){
            System.err.println("An unknown error occurred");
            System.out.println("Please try again: ");
            System.out.print("Symbol: ");
            String sn = sc.next();
            addPlayer(name, sn);
        }
        return p;
    }
}
