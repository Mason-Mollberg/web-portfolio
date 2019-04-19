package com.example.mason.problemsolver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class MainSelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_selection);
    }

    public void moveToPIntro(View view ) {
        Intent intent = new Intent(this,PuzzleIntro.class);
        startActivity(intent);
    }

    public void moveToFIntro(View view) {
        Intent intent = new Intent(this,FarmerIntro.class);
        startActivity(intent);
    }

}
