package com.example.mason.problemsolver.puzzle;

import com.example.mason.problemsolver.problem.Mover;
import com.example.mason.problemsolver.problem.State;

/**
 * @author Mason Mollberg
 * Cs 2511(002)
 * Due 10/18/17
 */
public class PuzzleMover extends Mover{
    public static final String SLIDE_1 = "Slide tile 1";
    public static final String SLIDE_2 = "Slide tile 2";
    public static final String SLIDE_3 = "Slide tile 3";
    public static final String SLIDE_4 = "Slide tile 4";
    public static final String SLIDE_5 = "Slide tile 5";
    public static final String SLIDE_6 = "Slide tile 6";
    public static final String SLIDE_7 = "Slide tile 7";
    public static final String SLIDE_8 = "Slide tile 8";

    public PuzzleMover() {
        super.addMove(SLIDE_1, s -> testSlide1(s));
        super.addMove(SLIDE_2, s -> testSlide2(s));
        super.addMove(SLIDE_3, s -> testSlide3(s));
        super.addMove(SLIDE_4, s -> testSlide4(s));
        super.addMove(SLIDE_5, s -> testSlide5(s));
        super.addMove(SLIDE_6, s -> testSlide6(s));
        super.addMove(SLIDE_7, s -> testSlide7(s));
        super.addMove(SLIDE_8, s -> testSlide8(s));
    }

    private State testSlide1(State state) {
        PuzzleState pState = (PuzzleState) state;
        PuzzleState newState;
        PuzzleState.Location loc = canMove(state,1);

        if(loc == null)
            newState = (PuzzleState)illegalMove(state);
        else {
            newState = new PuzzleState(pState,pState.getLocation(1),loc);
        }

        return newState;
    }

    private State testSlide2(State state) {
        PuzzleState pState = (PuzzleState) state;
        PuzzleState newState;
        PuzzleState.Location loc = canMove(state,2);

        if(loc == null)
            newState = (PuzzleState)illegalMove(state);
        else {
            newState = new PuzzleState(pState,pState.getLocation(2),loc);
        }
        return newState;
    }

    private State testSlide3(State state) {
        PuzzleState pState = (PuzzleState) state;
        PuzzleState newState;
        PuzzleState.Location loc = canMove(state,3);

        if(loc == null)
            newState = (PuzzleState)illegalMove(state);
        else {
            newState = new PuzzleState(pState,pState.getLocation(3),loc);
        }

        return newState;
    }

    private State testSlide4(State state) {
        PuzzleState pState = (PuzzleState) state;
        PuzzleState newState;
        PuzzleState.Location loc = canMove(state,4);

        if(loc == null)
            newState = (PuzzleState)illegalMove(state);
        else {
            newState = new PuzzleState(pState,pState.getLocation(4),loc);
        }

        return newState;
    }

    private State testSlide5(State state) {
        PuzzleState pState = (PuzzleState) state;
        PuzzleState newState;
        PuzzleState.Location loc = canMove(state,5);

        if(loc == null)
            newState = (PuzzleState)illegalMove(state);
        else {
            newState = new PuzzleState(pState,pState.getLocation(5),loc);
        }

        return newState;
    }

    private State testSlide6(State state) {
        PuzzleState pState = (PuzzleState) state;
        PuzzleState newState;
        PuzzleState.Location loc = canMove(state,6);

        if(loc == null)
            newState = (PuzzleState)illegalMove(state);
        else {
            newState = new PuzzleState(pState,pState.getLocation(6),loc);
        }

        return newState;
    }

    private State testSlide7(State state) {
        PuzzleState pState = (PuzzleState) state;
        PuzzleState newState;
        PuzzleState.Location loc = canMove(state,7);

        if(loc == null)
            newState = (PuzzleState)illegalMove(state);
        else {
            newState = new PuzzleState(pState,pState.getLocation(7),loc);
        }

        return newState;
    }

    private State testSlide8(State state) {
        PuzzleState pState = (PuzzleState) state;
        PuzzleState newState;
        PuzzleState.Location loc = canMove(state,8);

        if(loc == null)
            newState = (PuzzleState)illegalMove(state);
        else {
            newState = new PuzzleState(pState,pState.getLocation(8),loc);
        }

        return newState;
    }

    private State illegalMove(State state) {
        return null;
    }

    private PuzzleState.Location canMove(State state, int toMove) {
        PuzzleState pState = (PuzzleState) state;
        PuzzleState.Location loc = pState.getLocation(toMove);
        int[][] tiles = pState.getTiles();

        try{
            if(loc.getRow() != 2 && tiles[loc.getRow()+1][loc.getColumn()] == 0)
                loc = new PuzzleState.Location(loc.getRow()+1,loc.getColumn());
            else if(loc.getRow() != 0 && tiles[loc.getRow()-1][loc.getColumn()] == 0)
                loc = new PuzzleState.Location(loc.getRow()-1,loc.getColumn());
            else if(loc.getColumn() != 2 && tiles[loc.getRow()][loc.getColumn()+1] == 0)
                loc = new PuzzleState.Location(loc.getRow(),loc.getColumn()+1);
            else if(loc.getColumn() != 0 && tiles[loc.getRow()][loc.getColumn()-1] == 0)
                loc = new PuzzleState.Location(loc.getRow(),loc.getColumn()-1);
            else
                loc = null;
        }
        catch(ArrayIndexOutOfBoundsException e) {}

        return loc;
    }
}
