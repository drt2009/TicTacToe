package drt2009.ticTacToe;

public class Game {

    private Board board;

    public void start() {
        board = new Board();
    }

    public Board getBoard() {
        return board;
    }

    public void addX(int i) {
        board.addX(i);
    }

    public void addO(int i) {
        board.addO(i);
    }
}
