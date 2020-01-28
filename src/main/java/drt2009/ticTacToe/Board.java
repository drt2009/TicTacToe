package drt2009.ticTacToe;

import drt2009.ticTacToe.exception.SpaceAlreadyFilledException;
import drt2009.ticTacToe.exception.SpaceDoesNotExist;

import java.util.Arrays;

public class Board {
    private static final int O = 2;
    private static final int X = 1;

    private static final int TOP_LEFT = 0;
    private static final int TOP_MIDDLE = 1;
    private static final int TOP_RIGHT = 2;
    private static final int MIDDLE_LEFT = 3;
    private static final int MIDDLE_MIDDLE = 4;
    private static final int MIDDLE_RIGHT = 5;
    private static final int BOTTOM_LEFT = 6;
    private static final int BOTTOM_MIDDLE = 7;
    private static final int BOTTOM_RIGHT = 8;


    private int[] boardSpaces;

    public Board(){
        boardSpaces = new int[9];
    }

    public void addToBoard(int xOrO, int boardPlace) {
        validateAdd(boardPlace);
        boardSpaces[boardPlace] = xOrO;
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

    public boolean isWon(int player) {
        if(boardSpaces[MIDDLE_MIDDLE]==player){
            if(boardSpaces[TOP_LEFT]==player && boardSpaces[BOTTOM_RIGHT]==player){
                return true;
            }
            if(boardSpaces[TOP_RIGHT]==player && boardSpaces[BOTTOM_LEFT]==player){
                return true;
            }
            if(boardSpaces[MIDDLE_LEFT]==player && boardSpaces[MIDDLE_RIGHT]==player){
                return true;
            }
            if(boardSpaces[TOP_MIDDLE]==player && boardSpaces[BOTTOM_MIDDLE]==player){
                return true;
            }
        }
        if (boardSpaces[TOP_LEFT]==player){
            if(boardSpaces[TOP_MIDDLE]==player && boardSpaces[TOP_RIGHT]==player){
                return true;
            }
            if(boardSpaces[MIDDLE_LEFT]==player && boardSpaces[BOTTOM_LEFT]==player){
                return true;
            }
        }
        if (boardSpaces[BOTTOM_RIGHT]==player) {
            if(boardSpaces[MIDDLE_RIGHT]==player && boardSpaces[TOP_RIGHT]==player){
                return true;
            }
            if(boardSpaces[BOTTOM_MIDDLE]==player && boardSpaces[BOTTOM_LEFT]==player){
                return true;
            }
        }

       return false;
    }


}
