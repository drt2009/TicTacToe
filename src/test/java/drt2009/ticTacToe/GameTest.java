package drt2009.ticTacToe;


import drt2009.ticTacToe.exception.GameAlreadyFull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

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
    public void testAddXToBoardSpot0(){
        Board expected = new Board();
        expected.addX(0);

        game.start();
        game.addX(0);

        assertEquals(expected, game.getBoard());
    }

    @Test
    public void testAddOToBoardSpot0(){
        Board expected = new Board();
        expected.addO(0);

        game.start();
        game.addO(0);

        assertEquals(expected, game.getBoard());
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
    public void testStartNewBoard(){
        game.start();
        game.addX(0);
        game.start();

        Board expected = new Board();

        assertEquals(expected, game.getBoard());
    }

    @Test
    public void testIsGameWonByXAcrossTop(){
        game.start();
        game.addX(0);
        game.addX(1);
        game.addX(2);

        assertTrue(game.isWon());
    }


}
