package edu.ucsd.cse110.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        loadProfile();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        saveProfile();
    }

    public void loadProfile(){
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        String name = preferences.getString("name", "default_if_not_found");
        String status = preferences.getString("status", "default_if_not_found");

        TextView nameView = findViewById(R.id.nameView);
        TextView statusView = findViewById(R.id.statusView);

        nameView.setText(name);
        statusView.setText(status);
    }

    public void saveProfile(){
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        TextView nameView = findViewById(R.id.nameView);
        TextView statusView = findViewById((R.id.statusView));

        editor.putString("name", nameView.getText().toString());
        editor.putString("status", statusView.getText().toString());
        editor.apply();
    }

    public void onGoBackClicked(View view) {
        finish();
    }


}