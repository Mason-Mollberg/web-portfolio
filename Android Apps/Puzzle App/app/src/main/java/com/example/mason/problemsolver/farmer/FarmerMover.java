package com.example.mason.problemsolver.farmer;


import com.example.mason.problemsolver.problem.Mover;
import com.example.mason.problemsolver.problem.State;

/**
 * @author Mason Mollberg
 * Cs 2511(002)
 * Due 10/18/17
 */
public class FarmerMover extends Mover{
    public static final String GOES_ALONE = "Farmer goes Alone";
    public static final String TAKES_WOLF = "Farmer takes Wolf";
    public static final String TAKES_GOAT = "Farmer takes Goat";
    public static final String TAKES_CABBAGE = "Farmer takes Cabbage";

    public FarmerMover() {
        super.addMove(GOES_ALONE, s -> goesAlone(s));
        super.addMove(TAKES_WOLF, s -> takesWolf(s));
        super.addMove(TAKES_GOAT, s -> takesGoat(s));
        super.addMove(TAKES_CABBAGE, s -> takesCabbage(s));
    }

    private State goesAlone(State state) {
        FarmerState fState = (FarmerState) state;
        FarmerState newState;

        if(fState.getGoatLocation().equals(fState.getCabbageLocation()))
            newState = (FarmerState) illegalMove(state);
        else if(fState.getGoatLocation().equals(fState.getWolfLocation()))
            newState = (FarmerState) illegalMove(state);
        else
        {
            if(fState.getFarmerLocation().equals("West"))
                newState = new FarmerState("East",fState.getWolfLocation(),fState.getGoatLocation(),fState.getCabbageLocation());
            else
                newState = new FarmerState("West",fState.getWolfLocation(),fState.getGoatLocation(),fState.getCabbageLocation());
        }

        return newState;
    }

    private State takesWolf(State state) {
        FarmerState fState = (FarmerState) state;
        FarmerState newState;

        if(fState.getGoatLocation().equals(fState.getCabbageLocation()))
            newState = (FarmerState) illegalMove(state);
        else if(fState.getFarmerLocation().equals(fState.getWolfLocation()))
        {
            if(fState.getFarmerLocation().equals("West"))
                newState = new FarmerState("East","East",fState.getGoatLocation(),fState.getCabbageLocation());
            else
                newState = new FarmerState("West","West",fState.getGoatLocation(),fState.getCabbageLocation());
        }
        else
            newState = (FarmerState) illegalMove(state);

        return newState;
    }

    private State takesGoat(State state) {
        FarmerState fState = (FarmerState) state;
        FarmerState newState;
        if(fState.getFarmerLocation().equals(fState.getGoatLocation()))
        {
            if(fState.getFarmerLocation().equals("West"))
                newState = new FarmerState("East",fState.getWolfLocation(),"East",fState.getCabbageLocation());
            else
                newState = new FarmerState("West",fState.getWolfLocation(),"West",fState.getCabbageLocation());
        }
        else
            newState = (FarmerState) illegalMove(state);

        return newState;
    }

    private State takesCabbage(State state) {
        FarmerState fState = (FarmerState) state;
        FarmerState newState;

        if(fState.getGoatLocation().equals(fState.getWolfLocation()))
            newState = (FarmerState) illegalMove(state);
        else if(fState.getFarmerLocation().equals(fState.getCabbageLocation()))
        {
            if(fState.getFarmerLocation().equals("West"))
                newState = new FarmerState("East",fState.getWolfLocation(),fState.getGoatLocation(),"East");
            else
                newState = new FarmerState("West",fState.getWolfLocation(),fState.getGoatLocation(),"West");
        }
        else
            newState = (FarmerState) illegalMove(state);

        return newState;
    }

    private State illegalMove(State state) {
        return null;
    }
}
