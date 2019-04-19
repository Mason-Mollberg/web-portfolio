package com.example.mason.problemsolver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PuzzleIntro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_intro);
        TextView tv = findViewById(R.id.puzzleDescription);
        tv.setText("Your goal is to reach the final state. The final state is:\n" +
                "+---+---+---+\n" +
                "| 1 | 2 | 3 |\n" +
                "+---+---+---+\n" +
                "| 8 |   | 4 |\n" +
                "+---+---+---+\n" +
                "| 7 | 6 | 5 |\n" +
                "+---+---+---+\n");
    }

    public void moveToPSolve(View view ) {
        Intent intent = new Intent(this,PuzzleSolver.class);
        startActivity(intent);
    }

    public void moveBack(View view) {
        Intent intent = new Intent(this,MainSelection.class);
        startActivity(intent);
    }
}
