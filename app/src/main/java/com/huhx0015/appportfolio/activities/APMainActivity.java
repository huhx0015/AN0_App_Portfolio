package com.huhx0015.appportfolio.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.huhx0015.appportfolio.intent.APIntent;
import com.huhx0015.appportfolio.ui.APUnbind;
import com.huhx0015.com.appportfolio.R;

/** -----------------------------------------------------------------------------------------------
 *  [APMainActivity] CLASS
 *  DEVELOPER: Michael Yoon Huh
 *  DESCRIPTION: APMainActivity class is the primary activity class for this application. It
 *  displays a set of buttons in which a user can launch other Android Nanodegree developed
 *  applications.
 *  -----------------------------------------------------------------------------------------------
 */

public class APMainActivity extends AppCompatActivity {

    /** ACTIVITY LIFECYCLE METHODS _____________________________________________________________ **/

    // onCreate(): The initial function that is called when the activity is run. onCreate() only
    // runs when the activity is first started.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ap_main_activity);

        setUpButtons(); // Sets up the buttons for the activity.
    }

    // onPause(): Called when the activity is suspended.
    @Override
    protected void onPause() {
        super.onPause();
        finish(); // Finishes the activity when app is paused.
    }

    // onDestroy(): This function runs when the activity has terminated and is being destroyed.
    // Calls recycleMemory() to free up memory allocation.
    @Override
    public void onDestroy() {
        recycleMemory(); // Recycles all services and View objects to free up memory resources.
        super.onDestroy();
    }

    /** LAYOUT METHODS _________________________________________________________________________ **/

    // setUpButtons(): Sets up the button and button listeners for the activity.
    private void setUpButtons() {

        Button spotifyButton = (Button) findViewById(R.id.spotify_app_button);
        Button footballButton = (Button) findViewById(R.id.football_app_button);
        Button libraryButton = (Button) findViewById(R.id.library_app_button);
        Button biggerButton = (Button) findViewById(R.id.bigger_app_button);
        Button xyzButton = (Button) findViewById(R.id.xyz_app_button);
        Button capstoneButton = (Button) findViewById(R.id.capstone_button);

        // SPOTIFY APP Button Listener: Launches the Spotify Streamer application.
        spotifyButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                APIntent.launchExternalIntent("com.huhx0015.spotifystreamer", APMainActivity.this);
            }
        });

        // FOOTBALL APP Button Listener:
        footballButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(APMainActivity.this, "This button will launch my Football Scores app!", Toast.LENGTH_SHORT).show();
            }
        });

        // LIBRARY APP Button Listener:
        libraryButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(APMainActivity.this, "This button will launch my Library app!", Toast.LENGTH_SHORT).show();
            }
        });

        // BIGGER APP Button Listener:
        biggerButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(APMainActivity.this, "This button will launch my Build It Bigger app!", Toast.LENGTH_SHORT).show();
            }
        });

        // XYZ APP Button Listener:
        xyzButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(APMainActivity.this, "This button will launch my XYZ Reader app!", Toast.LENGTH_SHORT).show();
            }
        });

        // CAPSTONE APP Button Listener:
        capstoneButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(APMainActivity.this, "This button will launch my Capstone app!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /** RECYCLE METHODS ________________________________________________________________________ **/

    // recycleMemory(): Recycles background services and View objects to clear up resources prior to
    // Activity destruction.
    private void recycleMemory() {

        try {

            // Unbinds all Drawable objects attached to the current layout.
            APUnbind.unbindDrawables(findViewById(R.id.main_activity_layout));
        }

        // NullPointerException error handler.
        catch (NullPointerException e) {
            e.printStackTrace(); // Prints error message.
        }
    }
}
