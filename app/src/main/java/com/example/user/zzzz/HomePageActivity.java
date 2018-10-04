package com.example.user.zzzz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomePageActivity extends AppCompatActivity {
    private Button calC, player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        init();
    }

    private void init() {
        calC = findViewById(R.id.calC);
        calC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomePageActivity.this, "계산기", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HomePageActivity.this, CalCActivity.class);
                startActivity(intent);
            }
        });

        player = findViewById(R.id.player);
        player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomePageActivity.this, "MP3", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HomePageActivity.this, MP3PlayerActivity.class);
                startActivity(intent);
            }
        });
    }
}