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


}
