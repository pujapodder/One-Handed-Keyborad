package com.example.onehandedkeyboard;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.pixplicity.easyprefs.library.Prefs;

import java.util.Random;

public class RightActivity extends AppCompatActivity {
    ImageView bigImage, smallImage;
    EditText Text;
    boolean isBig = false;
    int i=0,j=0,k=0;
    boolean firstPoint = false;
    float firstX = 0f;
    float firstY = 0f;
    String EnteredText;

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

        PrefUtils.resetPrefs();
        PrefUtils.registerStartTime();

        setContentView(R.layout.activity_right);
        bigImage = (ImageView) findViewById(R.id.RimageViewBig);
        smallImage = (ImageView) findViewById(R.id.RimageViewSmall);
        Text = (EditText) findViewById(R.id.editText);
        final TextView sentence = (TextView) findViewById(R.id.textView);
        final Button button_next = findViewById(R.id.button_next);

        Text.requestFocus();

        sentence.setText(sentences[currentSentenceIndex]);



        View.OnTouchListener listener = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                      Log.e("ALIA", "evx:"+event.getX());
                      Log.e("ALIA", "evy:"+event.getY());
                    if (firstPoint) {
                        firstX = event.getX();
                        firstY = event.getY();
                        firstPoint = false;
                    } else {
                            Log.e("ALIA", "else if (isPointInside("+firstX+"f, "+event.getY()+"f, "+event.getX()+"f, "+firstY+"f, x, y)) {\n" +
                               "            \n" +
                                  "        }");
                        firstPoint = true;
                    }
                    Log.e("Backspace", "Key:" + getChar(event.getX(), event.getY()));
                    Text.setText(Text.getText() + getChar(event.getX(), event.getY()));
                    Text.setSelection(Text.getText().length());

                    checkCharValidity(getChar(event.getX(), event.getY()));

                    return true;
                }
                return false;
            }
        };

        bigImage.setOnTouchListener(listener);
        smallImage.setOnTouchListener(listener);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Text.setShowSoftInputOnFocus(false);
        }
        Text.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            public void onClick(View v) {

                    bigImage.setVisibility(View.VISIBLE);
                    button_next.setVisibility(View.VISIBLE);


            }
        });

        button_next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                EnteredText = Text.getText().toString();

                currentSentenceIndex++;
                if (currentSentenceIndex < sentences.length) {
                    sentence.setText(sentences[currentSentenceIndex]);
                    Text.setText("");
                } else {
                    PrefUtils.registerEndTime();
                    PrefUtils.saveNewKeyboardTime();
                    PrefUtils.saveNewKeyboardWrongCount();
                    startActivity(new Intent(RightActivity.this, DefaultKeyboardActivity.class));
                }
            }
        });

    }

    private void checkCharValidity(String c) {
        int index = Text.getText().toString().length() - 1;
        if (c.length()>0 && c.charAt(0) != sentences[currentSentenceIndex].charAt(index)) {
            PrefUtils.addWrongCharCount();
            Log.e("ALIA", "Wrong detected");
        }
    }

    boolean isBackspaceRunning = false;
    private String getChar(float x, float y) {

        //Q
        if (isPointInside(8.61f, 920.87f, 189.98f, 1093.15f, x, y)) {
            return isBig ? "q" : "Q";
        }
        //W
        else if (isPointInside(60.91992f, 785.9714f, 230.75427f, 874.2665f , x, y)) {
            return isBig ? "w" : "W";
        }
        //E
        else if (isPointInside(112.44552f,  653.2666f, 305.80258f, 718.1349f, x, y)) {
            return isBig ? "e" : "E";
        }
        //R
        else if (isPointInside(179.37317f, 571.848f,  369.97534f,  595.537f, x, y)) {
            return isBig ? "r" : "R";
        }
        //T
        else if (isPointInside(269.05933f, 466.3246f, 470.27612f, 570.00214f, x, y)) {
            return isBig ? "t" : "T";
        }
        //Y
        else if (isPointInside(392.58923f, 364.0315f, 577.03796f,396.3346f , x, y)) {
            return isBig ? "y" : "Y";
        }
        //U
        else if (isPointInside(523.04175f, 280.9663f, 694.72205f, 341.1117f, x, y)) {
            return isBig ? "u" : "U";
        }
        //I
        else if (isPointInside(662.109f, 218.6676f, 817.6366f, 309.42383f, x, y)) {
            return isBig ? "i" : "I";
        }
        //O
        else if (isPointInside(786.5619f, 160.06055f, 938.859f, 290.81116f, x, y)) {
            return isBig ? "o" : "O";
        }
        //P
        else if (isPointInside(945.6278f, 155.4458f, 1072.8496f, 272.6599f, x, y)) {
            return isBig ? "p" : "P";
        }
        //A
        else if (isPointInside(170.14307f, 955.79333f, 336.4392f, 1094.2351f, x, y)) {
            return isBig ? "a" : "A";
        }
        //S
        else if (isPointInside(190.29553f, 843.50165f, 376.12878f, 917.1835f, x, y)) {
            return isBig ? "s" : "S";

        }
        //D
        else if (isPointInside(244.29175f, 750.8994f, 425.51f, 774.896f, x, y)) {
            return isBig ? "d" : "D";
        }
        //F
        else if (isPointInside(298.4419f, 667.68054f, 485.50586f,  754.28357f, x, y)) {
            return isBig ? "f" : "F";
        }
        //G
        else if (isPointInside(384.74353f, 570.77124f, 564.5773f, 590.92224f, x, y)) {
            return isBig ? "g" : "G";
        }
        //H
        else if (isPointInside(484.7367f, 477.86145f, 644.26404f, 525.5469f, x, y)) {
            return isBig ? "h" : "H";
        }
        //J
        else if (isPointInside(587.345f, 402.79517f, 744.2571f, 464.32495f, x, y)) {
            return isBig ? "j" : "J";
        }

        //K
        else if (isPointInside(705.3368f, 345.2649f, 849.4806f, 439.713f, x, y)) {
            return isBig ? "k" : "K";
        }
        //L
        else if (isPointInside(826.25146f, 315.4231f , 939.47437f, 418.48535f, x, y)) {
            return isBig ? "l" : "L";
        }
        //Z
        else if (isPointInside(339.516f, 906.26196f, 518.2728f, 948.256f, x, y)) {
            return isBig ? "z" : "Z";
        }
        //X
        else if (isPointInside(387.8203f, 835.1951f, 561.3467f, 842.57874f, x, y)) {
            return isBig ? "x" : "X";
        }
        //C
        else if (isPointInside(426.74072f, 746.9f, 602.7285f,774.12695f , x, y)) {
            return isBig ? "c" : "C";
        }
        //V
        else if (isPointInside(491.50537f, 675.98706f, 665.95483f, 720.13464f, x, y)) {
            return isBig ? "v" : "V";
        }
        //B
        else if (isPointInside(564.42346f, 589.2302f, 727.79675f, 666.9114f, x, y)) {
            return isBig ? "b" : "B";
        }
        //N
        else if (isPointInside(658.8784f, 528.00806f, 807.79114f, 624.76355f, x, y)) {
            return isBig ? "n" : "N";
        }
        //M
        else if (isPointInside(751.94885f, 471.8623f, 887.63184f,602.459f , x, y)) {
            return isBig ? "m" :"M" ;
        }
        //.
        else if (isPointInside(469.50696f, 957.6392f, 626.11145f, 1101.0034f, x, y)) {
            return ".";
        }
        //123
        else if (isPointInside(516.7344f, 819.81274f, 726.41223f, 906.26196f, x, y)) {
            return "1";
        }
        //:)
        else if (isPointInside(647.1869f, 736.74756f, 867.4794f, 739.3627f, x, y)) {
            return ":)";
        }
        //newline
        else if (isPointInside(825.6361f, 631.37805f, 1028.0835f, 721.67285f, x, y)) {
            return "\n";
        }
        //Shift
        else if (isPointInside(335.51624f, 995.94147f, 477.8141f, 1097.6193f, x, y)) {
            // shift
            Log.e("ALIA", "Outside "+isBig+i+k);
            k++;
            if(k==3)
            {
                i=0;
                k=0;
            }
            if (isBig==true && i<=1) {

                bigImage.setVisibility(View.GONE);
                smallImage.setVisibility(View.VISIBLE);
                i++;
                if(i<=1)
                {

                    isBig = true;

                }
                else if(i>1)
                {
                    isBig = false;
                    i=0;
                }
            }
            else if ( isBig==false && i<=1) {

                smallImage.setVisibility(View.GONE);
                bigImage.setVisibility(View.VISIBLE);
                i++;
                if(i<=1)
                {

                    isBig = false;
                }
               else if(i>1)
                {
                    isBig = true;
                    i=0;

                }
            }


        }


        //Space
        else if (isPointInside(596.7289f, 741.0547f, 996.7012f, 1101.0034f, x, y)) {
            return " ";
        }
        // backspace
        else if (isPointInside(860.7106f, 448.32715f, 1050.5437f, 585.3845f, x, y)) {
            // backspace
            if (isBackspaceRunning==false && j==0) {

                String currentText = Text.getText().toString();
                if (currentText.length() > 0) {
                    Text.setText(currentText.substring(0, currentText.length()-1));
                    Text.setSelection(Text.getText().length());
                    Log.e("ALIA", "Backspace "+j);
                }

            }
            if(j<=1)
            {

                isBackspaceRunning = true;
                j++;


            }
            else if(j>1)
            {

                isBackspaceRunning =false;
                j=0;
            }


        }


        return "";



    }

    boolean isPointInside(float x1, float y1, float x2,
                          float y2, float x, float y)
    {
        if (x > x1 && x < x2 &&
                y > y1 && y < y2)
            return true;

        return false;
    }
}
