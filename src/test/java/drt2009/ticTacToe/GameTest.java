package drt2009.ticTacToe;


import drt2009.ticTacToe.exception.GameAlreadyFull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    private static final int X = 1;
    private static final int O = 2;

    Game game;

    @BeforeEach
    public void setup(){
            game = new Game();
    }

    @Test
    public void testStartGame(){
        game.start();
        assertEquals(new Board(), game.getBoard());
    }

    @Test
    public void addPlayerToEmptyList(){
        Player expected = new Player("Expected");
        game.addPlayer(expected);

        assertTrue(game.getPlayers().contains(expected));
    }

    @Test
    public void addPlayerToListWithOneOtherPlayer(){
        game.addPlayer(new Player("I am Already Here"));
        Player expected = new Player("Expected");
        game.addPlayer(expected);

        assertTrue(game.getPlayers().contains(expected));
        assertEquals(2,game.getPlayers().size());
    }

    @Test
    public void testAddPlayerToFullGame(){
        game.addPlayer(new Player("I am Already Here"));
        game.addPlayer(new Player("I am Here too"));
        assertThrows(GameAlreadyFull.class, () -> {game.addPlayer(new Player("Why can't I Play"));});
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
