package com.example.mason.problemsolver.puzzle;

import com.example.mason.problemsolver.problem.Problem;

/**
 * @author Mason Mollberg
 * Cs 2511(002)
 * Due 10/18/17
 */
public class PuzzleProblem extends Problem {

    public PuzzleProblem() {
        super();
        super.setName("8-Puzzle");
        super.setIntroduction(INTRO);
        super.setMover(new PuzzleMover());
        super.setInitialState(new PuzzleState(initialStateArray));
        super.setCurrentState(super.getInitialState());
        super.setFinalState(new PuzzleState(finalStateArray));
    }

    private static final String INTRO =
            "Your goal is to reach the final state. " +
                    "The final state is:\n" +
                    "+---+---+---+\n" +
                    "| 1 | 2 | 3 |\n" +
                    "+---+---+---+\n" +
                    "| 8 |   | 4 |\n" +
                    "+---+---+---+\n" +
                    "| 7 | 6 | 5 |\n" +
                    "+---+---+---+\n";

    private final int[][] initialStateArray = {{2,8,3},{1,6,4},{7,0,5}};
    private final int[][] finalStateArray = {{1,2,3},{8,0,4},{7,6,5}};

}