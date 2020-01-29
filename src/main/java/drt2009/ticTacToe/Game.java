package drt2009.ticTacToe;

import drt2009.ticTacToe.exception.GameAlreadyFull;
import drt2009.ticTacToe.exception.NotEnoughPlayersException;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Board board;

    private int currentTurn;

    private List<Player> players;

    public Game(){
        currentTurn = 0;
        players = new ArrayList<>();

    }

    public void addPlayer(Player player){
        if(players.size()<2){
            players.add(player);
        } else {
            throw new GameAlreadyFull();
        }
    }

    public void start() {
        if(players.size()!=2){
            throw new NotEnoughPlayersException();
        }
        board = new Board();
    }

    public Board getBoard() {
        return board;
    }

    public void addToBoard(int xOrO, int boardPosition) {
        board.addToBoard(xOrO, boardPosition);
    }

    public boolean isWon() {
        return board.isWon(1);
    }

    public List<Player> getPlayers() {
        return players;
    }
}
