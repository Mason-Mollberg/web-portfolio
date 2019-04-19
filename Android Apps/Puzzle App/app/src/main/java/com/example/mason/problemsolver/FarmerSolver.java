package com.example.mason.problemsolver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mason.problemsolver.problem.SolvingAssistant;
import com.example.mason.problemsolver.farmer.FarmerProblem;

public class FarmerSolver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_solver);
        puzzle = new FarmerProblem();
        solveAssist = new SolvingAssistant(puzzle);
        warning = findViewById(R.id.warningf);
        warning.setText(" ");
        display = findViewById(R.id.stateViewf);
        display.setText(puzzle.getInitialState().toString());
    }

    private void update(int butNum) {
        solveAssist.tryMove(puzzle.getMover().getMoveNames().get(butNum-1));

        if(!solveAssist.isMoveLegal())
            warning.setText("Illegal update");
        else {
            warning.setText(" ");
            puzzle.setCurrentState(solveAssist.getProblem().getCurrentState());
            display.setText(puzzle.getCurrentState().toString());
            if(solveAssist.isProblemSolved())
                warning.setText("Congratulations, You solved the problem in " + solveAssist.getMoveCount() + " Moves!");
        }
    }

    public void Alone(View view) {
        update(1);
    }
    public void Wolf(View view) {
        update(2);
    }
    public void Goat(View view) {
        update(3);
    }
    public void Cabbage(View view) {
        update(4);
    }
    public void Reset(View view) {
        solveAssist.reset();
        puzzle.setCurrentState(puzzle.getInitialState());
        warning.setText(" ");
        display.setText(puzzle.getCurrentState().toString());
    }

    private TextView warning;
    private TextView display;
    private FarmerProblem puzzle;
    private SolvingAssistant solveAssist;
}

