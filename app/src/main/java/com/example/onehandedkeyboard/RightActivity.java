package com.example.onehandedkeyboard;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class RightActivity extends AppCompatActivity {
    ImageView image, smallimage;
    EditText Text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_right);
        image = (ImageView) findViewById(R.id.imageView1);
        smallimage = (ImageView) findViewById(R.id.imageView2);
        Text = (EditText) findViewById(R.id.editText);
        Text.requestFocus();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Text.setShowSoftInputOnFocus(false);
        }
        Text.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            public void onClick(View v) {

                image = (ImageView) findViewById(R.id.imageView1);
                image.setVisibility(View.VISIBLE);
            }
        });
    }
}
