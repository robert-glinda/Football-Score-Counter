package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int foulTeamA = 0;
    int scoreTeamB = 0;
    int foulTeamB = 0;
    int lastAction = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Displays the goals for Team A.
     */
    public void displayGoalForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the fouls for Team A.
     */
    public void displayFoulForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_fouls);
        scoreView.setText(String.valueOf(score));
    }

    public void addGoalToTeamA(View view) {
        scoreTeamA = scoreTeamA + 1;
        displayGoalForTeamA(scoreTeamA);
        lastAction = 1;
    }

    public void addFoulToTeamA(View view) {
        foulTeamA = foulTeamA + 1;
        displayFoulForTeamA(foulTeamA);
        lastAction = 3;
    }

    /**
     * Displays the goals for Team B.
     */
    public void displayGoalForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the fouls for Team B.
     */
    public void displayFoulForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_fouls);
        scoreView.setText(String.valueOf(score));
    }

    public void addGoalToTeamB(View view) {
        scoreTeamB = scoreTeamB + 1;
        displayGoalForTeamB(scoreTeamB);
        lastAction = 2;
    }

    public void addFoulToTeamB(View view) {
        foulTeamB = foulTeamB + 1;
        displayFoulForTeamB(foulTeamB);
        lastAction = 4;
    }

    public void undo(View view) {
        if (lastAction == 1) {
            scoreTeamA = scoreTeamA - 1;
            lastAction = 0;
            displayGoalForTeamA(scoreTeamA);
        } else if (lastAction == 2) {
            scoreTeamB = scoreTeamB - 1;
            lastAction = 0;
            displayGoalForTeamB(scoreTeamB);
        } else if (lastAction == 3) {
            foulTeamA = foulTeamA - 1;
            lastAction = 0;
            displayFoulForTeamA(foulTeamA);
        } else if (lastAction == 4) {
            foulTeamB = foulTeamB - 1;
            lastAction = 0;
            displayFoulForTeamB(foulTeamB);
        }
    }

    public void reset(View v) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        foulTeamA = 0;
        foulTeamB = 0;
        displayGoalForTeamA(scoreTeamA);
        displayFoulForTeamA(foulTeamA);
        displayGoalForTeamB(scoreTeamB);
        displayFoulForTeamB(foulTeamB);
    }

    /**
     * Method for saving data.
     */
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
        // Save the user's current game state
        savedInstanceState.putInt("StateScoreA", scoreTeamA);
        savedInstanceState.putInt("StateFoulsA", foulTeamA);
        savedInstanceState.putInt("StateScoreB", scoreTeamB);
        savedInstanceState.putInt("StateFoulsB", foulTeamB);
    }

    /**
     * Method for restoring and displaying data after switching device orientation.
     */
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if (savedInstanceState != null) {
            scoreTeamA = savedInstanceState.getInt("StateScoreA");
            foulTeamA = savedInstanceState.getInt("StateFoulsA");
            scoreTeamB = savedInstanceState.getInt("StateScoreB");
            foulTeamB = savedInstanceState.getInt("StateFoulsB");
        }
        displayGoalForTeamA(scoreTeamA);
        displayFoulForTeamA(foulTeamA);
        displayGoalForTeamB(scoreTeamB);
        displayFoulForTeamB(foulTeamB);

    }
}
