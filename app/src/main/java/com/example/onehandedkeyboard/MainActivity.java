package com.example.onehandedkeyboard;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button_left, button_right;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_left = findViewById(R.id.button_left);
        button_right = findViewById(R.id.button_right);




        button_left.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LeftActivity.class));
            }
        });
        button_right.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,  RightActivity.class));
            }
        });
    }
}
