package drt2009.ticTacToe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

    Player player;

    @BeforeEach
    public void setup(){
        player = new Player("Test Player");
    }

    @Test
    public void testAddWinIncreasesWinCount(){
        player.addWin();
        assertEquals(1,player.getNumberOfWinsInGame());
        player.addWin();
        assertEquals(2,player.getNumberOfWinsInGame());
    }
}
