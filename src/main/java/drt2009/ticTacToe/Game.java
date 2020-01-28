package drt2009.ticTacToe;

import drt2009.ticTacToe.exception.GameAlreadyFull;

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

    public boolean isWon() {
        return board.isWon(1);
    }

    public List<Player> getPlayers() {
        return players;
    }
}
