package drt2009.ticTacToe.exception;

public class NotEnoughPlayersException extends RuntimeException {
    public NotEnoughPlayersException(){
        super("Game does not have 2 players and cannot start");
    }
}
