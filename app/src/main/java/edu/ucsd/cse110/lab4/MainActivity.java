package edu.ucsd.cse110.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Optional;

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

    public void onShowCounterClicked(View view) {
//        Utilities.showAlert(this, "This button doesn't do anything yet!");
        Intent intent = new Intent(this, CounterActivity.class);

        TextView maxCountView = findViewById(R.id.counter);
        String maxCountStr = maxCountView.getText().toString();

        Optional<Integer> maybeMaxCount = Utilities.parseCount(maxCountStr);

        if(!maybeMaxCount.isPresent()) {
            Utilities.showAlert(this, "That isn't a number!");
            return;
        }

        int maxCount = maybeMaxCount.get();

        if(maxCount <= 0) {
            Utilities.showAlert(this, "Please enter a positive number!");
            return;
        }

//        Utilities.showAlert(this, String.format("I got the number %d", maxCount));
        intent.putExtra("max_count", maxCount);
        startActivity(intent);
    }

}

/*
1.  For the main UI thread to be blocked, it means that there's a work that takes
    a long time to finish is running on the main UI thread. This disables the user
    from interacting with the UI, and the UI can't be redrawn until the work is
    finished. We need to avoid blocking the main thread to prevent our app from
    being unresponsive.

2.  Example 1: Calculator app
    Example 2: Show/hide name from lab 1
 */