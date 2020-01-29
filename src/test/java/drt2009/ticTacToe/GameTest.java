package drt2009.ticTacToe;


import drt2009.ticTacToe.exception.GameAlreadyFull;
import drt2009.ticTacToe.exception.NotEnoughPlayersException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    private static final int X = 1;
    private static final int O = 2;

    private Player player1;
    private Player player2;

    Game game;

    @BeforeEach
    public void setup(){
        player1 = new Player("Player1");
        player2 = new Player("Player2");
        game = new Game();


        game.addPlayer(player1);
        game.addPlayer(player2);

        game.start();
    }

    @Test
    public void testStartGame(){
        game.start();
        assertEquals(new Board(), game.getBoard());
    }

    @Test
    public void testStartGameWithNotEnoughPlayers(){
        Game gameNoPlayers = new Game();
        assertThrows(NotEnoughPlayersException.class, ()-> {gameNoPlayers.start();});
    }

    @Test
    public void addPlayerToEmptyList(){
        Game gamePlayerTest = new Game();
        Player expected = new Player("Expected");
        gamePlayerTest.addPlayer(expected);

        assertTrue(gamePlayerTest.getPlayers().contains(expected));
    }

    @Test
    public void addPlayerToListWithOneOtherPlayer(){
        Game gamePlayerTest = new Game();
        gamePlayerTest.addPlayer(new Player("I am Already Here"));
        Player expected = new Player("Expected");
        gamePlayerTest.addPlayer(expected);

        assertTrue(gamePlayerTest.getPlayers().contains(expected));
        assertEquals(2,gamePlayerTest.getPlayers().size());
    }

    @Test
    public void testAddPlayerToFullGame(){
        Game gamePlayerTest = new Game();
        gamePlayerTest.addPlayer(new Player("I am Already Here"));
        gamePlayerTest.addPlayer(new Player("I am Here too"));
        assertThrows(GameAlreadyFull.class, () -> {gamePlayerTest.addPlayer(new Player("Why can't I Play"));});
    }

    @Test
    public void testAddXToBoardSpot0(){
        Board expected = new Board();
        expected.addToBoard(X,0);

        game.start();
        game.addToBoard(X, 0);

        assertEquals(expected, game.getBoard());
    }

    @Test
    public void testAddOToBoardSpot0(){
        Board expected = new Board();
        expected.addToBoard(O,0);

        game.start();
        game.addToBoard(O,0);

        assertEquals(expected, game.getBoard());
    }

    @Test
    public void testStartNewBoard(){
        game.start();
        game.addToBoard(X,0);
        game.start();

        Board expected = new Board();

        assertEquals(expected, game.getBoard());
    }

    @Test
    public void testIsGameWonByXAcrossTop(){
        game.start();
        game.addToBoard(X,0);
        game.addToBoard(X,1);
        game.addToBoard(X,2);

        assertTrue(game.isWon());
    }

}
