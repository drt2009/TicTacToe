package drt2009.ticTacToe;


import drt2009.ticTacToe.exception.SpaceAlreadyFilledException;
import drt2009.ticTacToe.exception.SpaceDoesNotExist;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    private static final int X = 1;
    private static final int O = 2;

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
        testBoard.addToBoard(X,0);
        assertEquals(Integer.valueOf(1), testBoard.getBoard()[0]);
    }

    @Test
    public void testSpaceNotOnBoardWhenAdding(){
        assertThrows(SpaceDoesNotExist.class, ()->{testBoard.addToBoard(X,-1);});
        assertThrows(SpaceDoesNotExist.class, ()->{testBoard.addToBoard(O,9);});
    }

    @Test
    public void testCannotOverwriteBoardSpaceWhenAddingX(){
        testBoard.addToBoard(X,0);

        assertThrows(SpaceAlreadyFilledException.class, ()->{testBoard.addToBoard(O,0);});
    }
    
    @Test
    public void testGameWonAcrossTop(){
        testBoard.addToBoard(X,0);
        testBoard.addToBoard(X,1);
        testBoard.addToBoard(X,2);

        assertTrue(testBoard.isWon(X));
    }

    @Test
    public void testGameWonAcrossMiddle(){
        testBoard.addToBoard(X,3);
        testBoard.addToBoard(X,4);
        testBoard.addToBoard(X,5);

        assertTrue(testBoard.isWon(X));
    }

    @Test
    public void testGameWonAcrossBottom(){
        testBoard.addToBoard(X,6);
        testBoard.addToBoard(X,7);
        testBoard.addToBoard(X,8);

        assertTrue(testBoard.isWon(X));
    }

    @Test
    public void testGameWonDownLeft(){
        testBoard.addToBoard(X,0);
        testBoard.addToBoard(X,3);
        testBoard.addToBoard(X,6);

        assertTrue(testBoard.isWon(X));
    }

    @Test
    public void testGameWonDownMiddle(){
        testBoard.addToBoard(X,1);
        testBoard.addToBoard(X,4);
        testBoard.addToBoard(X,7);

        assertTrue(testBoard.isWon(X));
    }

    @Test
    public void testGameWonDownRight(){
        testBoard.addToBoard(X,2);
        testBoard.addToBoard(X,5);
        testBoard.addToBoard(X,8);

        assertTrue(testBoard.isWon(X));
    }

    @Test
    public void testGameWonTopLeftToBottomRight(){
        testBoard.addToBoard(X,0);
        testBoard.addToBoard(X,4);
        testBoard.addToBoard(X,8);

        assertTrue(testBoard.isWon(X));
    }

    @Test
    public void testGameWonTopRightToBottomLeft(){
        testBoard.addToBoard(X,2);
        testBoard.addToBoard(X,4);
        testBoard.addToBoard(X,6);

        assertTrue(testBoard.isWon(X));
    }

    @Test
    public void testGameNotWon(){
        testBoard.addToBoard(X,0);
        testBoard.addToBoard(X,1);
        testBoard.addToBoard(X,3);
        testBoard.addToBoard(X,5);
        testBoard.addToBoard(X,7);
        testBoard.addToBoard(X,8);

        assertFalse(testBoard.isWon(X));
    }


    @Test
    public void testBoardsHash(){
        assertEquals(new Board().hashCode(), testBoard.hashCode());
    }
}
