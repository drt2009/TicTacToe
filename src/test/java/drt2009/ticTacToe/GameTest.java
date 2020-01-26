package drt2009.ticTacToe;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void testIsGameWonByX(){

    }


}
