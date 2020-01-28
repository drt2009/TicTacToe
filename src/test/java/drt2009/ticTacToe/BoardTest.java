package drt2009.ticTacToe;


import drt2009.ticTacToe.exception.SpaceAlreadyFilledException;
import drt2009.ticTacToe.exception.SpaceDoesNotExist;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    private static final int X = 1;

    Board testBoard;

    @BeforeEach
    public void setup(){
        testBoard = new Board();
    }

    @Test
    public void testBoardsEqual(){
        assertEquals(new Board(), testBoard);
    }

    @Test
    public void testAddXToBoardSpace0(){
        testBoard.addX(0);
        assertEquals(Integer.valueOf(1), testBoard.getBoard()[0]);
    }

    @Test
    public void testSpaceNotOnBoardWhenAddingX(){
        assertThrows(SpaceDoesNotExist.class, ()->{testBoard.addX(-1);});
        assertThrows(SpaceDoesNotExist.class, ()->{testBoard.addX(9);});
    }

    @Test
    public void testCannotOverwriteBoardSpaceWhenAddingX(){
        testBoard.addX(0);

        assertThrows(SpaceAlreadyFilledException.class, ()->{testBoard.addX(0);});
    }

    @Test
    public void testAddOToBoardSpace0(){
        testBoard.addO(0);
        assertEquals(Integer.valueOf(2), testBoard.getBoard()[0]);
    }

    @Test
    public void testSpaceNotOnBoardWhenAddingO(){
        assertThrows(SpaceDoesNotExist.class, ()->{testBoard.addO(-1);});
        assertThrows(SpaceDoesNotExist.class, ()->{testBoard.addO(9);});
    }

    @Test
    public void testCannotOverwriteBoardSpaceWhenAddingO(){
        testBoard.addO(0);

        assertThrows(SpaceAlreadyFilledException.class, ()->{testBoard.addO(0);});
    }

    @Test
    public void testGameWonAcrossTop(){
        testBoard.addX(0);
        testBoard.addX(1);
        testBoard.addX(2);

        assertTrue(testBoard.isWon(X));
    }

    @Test
    public void testGameWonAcrossMiddle(){
        testBoard.addX(3);
        testBoard.addX(4);
        testBoard.addX(5);

        assertTrue(testBoard.isWon(X));
    }

    @Test
    public void testGameWonAcrossBottom(){
        testBoard.addX(6);
        testBoard.addX(7);
        testBoard.addX(8);

        assertTrue(testBoard.isWon(X));
    }

    @Test
    public void testGameWonDownLeft(){
        testBoard.addX(0);
        testBoard.addX(3);
        testBoard.addX(6);

        assertTrue(testBoard.isWon(X));
    }

    @Test
    public void testGameWonDownMiddle(){
        testBoard.addX(1);
        testBoard.addX(4);
        testBoard.addX(7);

        assertTrue(testBoard.isWon(X));
    }

    @Test
    public void testGameWonDownRight(){
        testBoard.addX(2);
        testBoard.addX(5);
        testBoard.addX(8);

        assertTrue(testBoard.isWon(X));
    }

    @Test
    public void testGameWonTopLeftToBottomRight(){
        testBoard.addX(0);
        testBoard.addX(4);
        testBoard.addX(8);

        assertTrue(testBoard.isWon(X));
    }

    @Test
    public void testGameWonTopRightToBottomLeft(){
        testBoard.addX(2);
        testBoard.addX(4);
        testBoard.addX(6);

        assertTrue(testBoard.isWon(X));
    }

    @Test
    public void testGameNotWon(){
        testBoard.addX(0);
        testBoard.addX(1);
        testBoard.addX(3);
        testBoard.addX(5);
        testBoard.addX(7);
        testBoard.addX(8);

        assertFalse(testBoard.isWon(X));
    }


    @Test
    public void testBoardsHash(){
        assertEquals(new Board().hashCode(), testBoard.hashCode());
    }
}
