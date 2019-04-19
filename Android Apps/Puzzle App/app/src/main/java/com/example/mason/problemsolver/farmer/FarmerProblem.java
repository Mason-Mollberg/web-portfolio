package com.example.mason.problemsolver.farmer;

import com.example.mason.problemsolver.problem.Problem;

/**
 * @author Mason Mollberg
 * Cs 2511(002)
 * Due 10/18/17
 */
public class FarmerProblem extends Problem {

    public FarmerProblem() {
        super();
        super.setName("Farmer, Wolf, Goat, and Cabbage");
        super.setIntroduction(INTRO);
        super.setMover(new FarmerMover());
        super.setInitialState(new FarmerState("West","West","West","West"));
        super.setCurrentState(super.getInitialState());
        super.setFinalState(new FarmerState("East","East","East","East"));
    }

    private static final String INTRO =
            "You must move all 4 elements across the river. "
                    + "The Wolf can't be left alone with the goat, "
                    + "and the goat can't be left alone with the cabbage.";

}
