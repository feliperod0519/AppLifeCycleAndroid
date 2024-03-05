package com.feliperodcoding.applifecycle;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Toast.makeText(this,"onCreate() is Called", Toast.LENGTH_SHORT).show();

        Button btnGoToActivity = findViewById(R.id.button);
        btnGoToActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSecondActivity();
            }
        });

        Button btnWebPage = findViewById(R.id.webpage);
        btnWebPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWebPage();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        //Start animations or UI-Related Tasks
        Toast.makeText(this,"onStart() is Called", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onResume() {
        super.onResume();
        //Start sensors, location updates, etc
        Toast.makeText(this,"onResume() is Called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Release resources, pause on going operations
        Toast.makeText(this,"onPause() is Called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //Release resources, save data, etc
        Toast.makeText(this,"onStop() is Called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //Perform any restart tasks
        Toast.makeText(this,"onRestart() is Called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Last chance to clean up
        Toast.makeText(this,"onDestroy() is Called", Toast.LENGTH_SHORT).show();
    }

    public void goToSecondActivity(){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void openWebPage(){
        Uri webpage = Uri.parse("https://www.google.ca");
        Intent intent = new Intent(Intent.ACTION_VIEW,webpage);
        startActivity(intent);
    }
}