package drt2009.ticTacToe;

public class Player {
    private final String name;
    private int XorO;
    private int numberOfWinsInGame;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getXorO() {
        return XorO;
    }

    public void setXorO(int xorO) {
        XorO = xorO;
    }

    public int getNumberOfWinsInGame() {
        return numberOfWinsInGame;
    }

    public void addWin() {
        this.numberOfWinsInGame++;
    }
}
