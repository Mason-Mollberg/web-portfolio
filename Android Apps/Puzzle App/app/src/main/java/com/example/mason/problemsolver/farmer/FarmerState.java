package com.example.mason.problemsolver.farmer;

import com.example.mason.problemsolver.problem.State;

/**
 * @author Mason Mollberg
 * Cs 2511(002)
 * Due 10/18/17
 */
public class FarmerState implements State {

    public FarmerState(String fLoc, String wLoc, String gLoc, String cLoc) {
        farmerLocation = fLoc;
        wolfLocation = wLoc;
        goatLocation = gLoc;
        cabbageLocation = cLoc;
    }

    @Override
    public boolean equals(Object other) {
        FarmerState otherFarmer = (FarmerState) other;
        boolean isEqual = true;

        try{
            if(!farmerLocation.equals(otherFarmer.getFarmerLocation()))
                isEqual = false;
            else if(!wolfLocation.equals(otherFarmer.getWolfLocation()))
                isEqual = false;
            else if(!goatLocation.equals(otherFarmer.getGoatLocation()))
                isEqual = false;
            else if(!cabbageLocation.equals(otherFarmer.getCabbageLocation()))
                isEqual = false;
        }
        catch(NullPointerException npe){
            isEqual = false;
        }

        return isEqual;
    }

    @Override
    public String toString() {
        StringBuilder outString = new StringBuilder();
        outString.append("   |  |   \n");
        //Farmer Level
        if(farmerLocation.equals("West"))
            outString.append(" F |  |   \n");
        else if(farmerLocation.equals("East"))
            outString.append("   |  | F \n");
        else
            outString.append("FARMER ERROR \n");
        //Wolf Level
        if(wolfLocation.equals("West"))
            outString.append(" W |  |   \n");
        else if(wolfLocation.equals("East"))
            outString.append("   |  | W \n");
        else
            outString.append("WOLF ERROR \n");
        //Goat Level
        if(goatLocation.equals("West"))
            outString.append(" G |  |   \n");
        else if(goatLocation.equals("East"))
            outString.append("   |  | G \n");
        else
            outString.append("GOAT ERROR \n");
        //Cabbage Level
        if(cabbageLocation.equals("West"))
            outString.append(" C |  |   \n");
        else if(cabbageLocation.equals("East"))
            outString.append("   |  | C \n");
        else
            outString.append("Cabbage ERROR \n");

        outString.append("   |  |   ");
        return outString.toString();
    }


    public String getFarmerLocation(){
        return farmerLocation;
    }
    public String getWolfLocation(){
        return wolfLocation;
    }
    public String getGoatLocation(){
        return goatLocation;
    }
    public String getCabbageLocation(){
        return cabbageLocation;
    }

    private final String farmerLocation;
    private final String wolfLocation;
    private final String goatLocation;
    private final String cabbageLocation;
}
