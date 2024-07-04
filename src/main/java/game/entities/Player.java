package game.entities;

public class Player {
    private final String name; //The name of the Player
    private String symbol = null; // the Symbol the PLayer uses

    public Player(String name, String symbol) {
        this.name = name;
        setSymbol(symbol);
    }

    /**
     * Returns the Name of the Player
     * @return name of Player
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the Symbol, the Player uses
     * @return the Symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Sets the given Symbol as the Symbol the Player uses
     * @param symbol the new Symbol
     * @throws IllegalArgumentException when the String is either null, empty or blank
     * @throws IllegalArgumentException when the String is longer than one Character long
     */
    public void setSymbol(String symbol) {
        if(symbol == null || symbol.isEmpty() || symbol.isBlank())
            throw new IllegalArgumentException("The Symbol can neither be null, empty or blank");
        if(symbol.length()>1)
            throw new IllegalArgumentException("The Symbol can only consist of 1 Character");
        this.symbol = symbol.toUpperCase();
    }
}
