package com.example.mason.problemsolver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mason.problemsolver.farmer.FarmerProblem;

public class FarmerIntro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_intro);
        TextView tv = findViewById(R.id.farmerDescription);
        tv.setText("You must move all 4 elements across the river. The Wolf can't be left alone with the goat, and the goat can't be left alone with the cabbage.");
    }

    public void moveToFSolve(View view ) {
        Intent intent = new Intent(this,FarmerSolver.class);
        startActivity(intent);
    }

    public void moveBack(View view) {
        Intent intent = new Intent(this,MainSelection.class);
        startActivity(intent);
    }
}
