package com.example.onehandedkeyboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DefaultKeyboardActivity extends AppCompatActivity {

    EditText Text;

    int currentSentenceIndex = 0;

    public static final String[] sentences =
            {
                    "Winter is coming.",
                    "Summer is here.",
                    "Canada is gold.",
                    "Be your best.",
                    "Focus and win.",

            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default_keyboard);

        PrefUtils.ressetWrongCharCount();
        PrefUtils.registerStartTime();
        Text = findViewById(R.id.editText);
        final TextView sentence = (TextView) findViewById(R.id.textView);
        sentence.setText(sentences[currentSentenceIndex]);

        Text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.e("ALIA", "entered:"+s);
                if (s.length()>0 && s.charAt(s.length()-1) != sentences[currentSentenceIndex].charAt(s.length()-1)) {
                    PrefUtils.addWrongCharCount();
                    Log.e("ALIA", "Wrong detected");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        Button button_next = findViewById(R.id.button_next);
        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentSentenceIndex++;
                if (currentSentenceIndex < sentences.length) {
                    sentence.setText(sentences[currentSentenceIndex]);
                    Text.setText("");
                } else {
                    PrefUtils.registerEndTime();
                    PrefUtils.saveOldKeyboardTime();
                    PrefUtils.saveOldKeyboardWrongCount();
                    startActivity(new Intent(DefaultKeyboardActivity.this, ResultActivity.class));
                }
            }
        });

    }
}
