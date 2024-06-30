package game;

public class Player {
    private String name;
    private String symbol;

    public Player(String name, String symbol) {
        this.name = name;
        setSymbol(symbol);
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        if(symbol == null || symbol.isEmpty() || symbol.isBlank())
            throw new IllegalArgumentException("The Symbol can neither be null, empty or blank");
        if(symbol.length()>1)
            throw new IllegalArgumentException("The Symbol can only consist of 1 Character");
        this.symbol = symbol.toUpperCase();
    }
}
