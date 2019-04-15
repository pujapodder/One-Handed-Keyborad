package com.example.onehandedkeyboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.pixplicity.easyprefs.library.Prefs;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        ((TextView)findViewById(R.id.timeNewKeyboard)).setText(""+(Float.parseFloat(String.valueOf(Prefs.getLong("newKeyboardTime", 0)/60000)))+" minute(s)");
        ((TextView)findViewById(R.id.timeOldKeyboard)).setText(""+(Float.parseFloat(String.valueOf(Prefs.getLong("oldKeyboardTime", 0)/60000)))+" minute(s)");
        ((TextView)findViewById(R.id.wrongNewKeyboard)).setText(""+Prefs.getInt("wrongNewKeyboard", 0));
        ((TextView)findViewById(R.id.wrongDefaultKeyboard)).setText(""+Prefs.getInt("wrongOldKeyboard", 0));

        int wnewkeyboard = Prefs.getInt("wrongNewKeyboard", 0);
        if (wnewkeyboard == 0) {
            wnewkeyboard = 1;
        }
        int woldkeyboard = Prefs.getInt("wrongOldKeyboard", 0);
        if (woldkeyboard == 0) {
            woldkeyboard = 1;
        }
        float newaccuracy  = Float.parseFloat(String.valueOf(wnewkeyboard))/76 * 100.0f;
        float oldaccuracy =  Float.parseFloat(String.valueOf(woldkeyboard))/76 * 100.0f;
       if (newaccuracy < 0) {
           newaccuracy  = 0;
        }
        if (newaccuracy > 100) {
            newaccuracy = 100;
        }
        if (oldaccuracy < 0) {
            oldaccuracy  = 0;
        }
        if (oldaccuracy > 100) {
            oldaccuracy = 100;
        }
        ((TextView)findViewById(R.id.accuracy)).setText("New Keyboard's Accuracy"+newaccuracy+"%" +"\n" +"Old Keyboard's Accuracy"+oldaccuracy+"%");

    }
}
