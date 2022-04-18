package edu.ucsd.cse110.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onLaunchProfileClicked(View view) {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }
}

/*
1. For the main UI thread to be blocked, it means that there's a work that takes
    a long time to finish is running on the main UI thread. This disables the user
    from interacting with the UI, and the UI can't be redrawn until the work is
    finished. We need to avoid blocking the main thread to prevent our app from
    being unresponsive.
 */