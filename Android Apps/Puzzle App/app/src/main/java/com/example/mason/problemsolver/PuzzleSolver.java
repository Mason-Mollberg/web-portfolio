package com.example.mason.problemsolver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mason.problemsolver.problem.SolvingAssistant;
import com.example.mason.problemsolver.puzzle.PuzzleProblem;

public class PuzzleSolver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_solver);
        puzzle = new PuzzleProblem();
        solveAssist = new SolvingAssistant(puzzle);
        warning = findViewById(R.id.warningp);
        warning.setText(" ");
        display = findViewById(R.id.stateViewp);
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

    public void Button1(View view) {
        update(1);
    }
    public void Button2(View view) {
        update(2);
    }
    public void Button3(View view) {
        update(3);
    }
    public void Button4(View view) {
        update(4);
    }
    public void Button5(View view) {
        update(5);
    }
    public void Button6(View view) {
        update(6);
    }
    public void Button7(View view) {
        update(7);
    }
    public void Button8(View view) {
        update(8);
    }
    public void Reset(View view) {
        solveAssist.reset();
        puzzle.setCurrentState(puzzle.getInitialState());
        warning.setText(" ");
        display.setText(puzzle.getCurrentState().toString());
    }

    private TextView warning;
    private TextView display;
    private PuzzleProblem puzzle;
    private SolvingAssistant solveAssist;
}
