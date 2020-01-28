package drt2009.ticTacToe.exception;

public class GameAlreadyFull extends RuntimeException {
    public GameAlreadyFull(){
        super("This game is at the player limit of 2");
    }

}
