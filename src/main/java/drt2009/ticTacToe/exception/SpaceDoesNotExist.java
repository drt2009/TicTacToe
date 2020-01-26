package drt2009.ticTacToe.exception;

public class SpaceDoesNotExist extends RuntimeException{
    public SpaceDoesNotExist() {
        super("That is not a valid board space.  Please pick a space between 0 and 8");
    }
}
