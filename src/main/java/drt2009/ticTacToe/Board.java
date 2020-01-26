package drt2009.ticTacToe;

import drt2009.ticTacToe.exception.SpaceAlreadyFilledException;
import drt2009.ticTacToe.exception.SpaceDoesNotExist;

import java.util.Arrays;

public class Board {
    private static final int O = 2;
    private static final int X = 1;

    private int[] boardSpaces;

    public Board(){
        boardSpaces = new int[9];
    }

    public void addX(int boardPlace) {
        validateAdd(boardPlace);
        boardSpaces[boardPlace] = X;
    }

    public void addO(int boardPlace) {
        validateAdd(boardPlace);
        boardSpaces[boardPlace] = O;
    }

    private void validateAdd(int boardPlace) {
        if (boardPlace < 0 || boardPlace > 8) {
            throw new SpaceDoesNotExist();
        }
        if (0 != boardSpaces[boardPlace]) {
            throw new SpaceAlreadyFilledException();
        }
    }

    int[] getBoard(){
        return this.boardSpaces;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return Arrays.equals(boardSpaces, board.boardSpaces);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(boardSpaces);
    }

}
