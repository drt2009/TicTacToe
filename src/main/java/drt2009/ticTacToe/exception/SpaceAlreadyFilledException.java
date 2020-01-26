package drt2009.ticTacToe.exception;

public class SpaceAlreadyFilledException extends RuntimeException{
    public SpaceAlreadyFilledException() {
        super("That space is already taken");
    }
}
