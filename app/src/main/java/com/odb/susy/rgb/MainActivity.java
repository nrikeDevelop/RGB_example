package com.odb.susy.rgb;

import android.graphics.Color;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int REV = 8;

    RelativeLayout contentColor;
    SeekBar seekBar ;
    TextView revText;
    TextView redText;
    TextView greenText;
    TextView blueText;

    public void setUI(){
        contentColor = (RelativeLayout) findViewById(R.id.content_color);
        revText = (TextView) findViewById(R.id.rev_text);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        redText = (TextView) findViewById(R.id.value_red);
        greenText = (TextView) findViewById(R.id.value_green);
        blueText = (TextView) findViewById(R.id.value_blue);
    }

    public void setOutText(final TextView textView, final String string){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                textView.setText(string);
            }
        });
    }


    public void setOutColor(final RelativeLayout relativeLayout, final int red, final int green, final int blue){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                int selectedColor = Color.rgb(red, green, blue);
                relativeLayout.setBackgroundColor(selectedColor);
            }
        });
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUI();

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                REV = progress;

                //GREEN > YELLOW
                if(REV < 1500){
                    System.out.println((progress*255)/1500);
                    setOutText(revText,String.valueOf(progress + " rev "));
                    setOutColor(contentColor,(progress*255)/1500,255,0);
                }

                if(REV >= 1500 && REV <=3000){
                    System.out.println((progress*255)/1500);
                    setOutText(revText,String.valueOf(progress + " rev "));
                    setOutColor(contentColor,255,255-(progress*255)/1500,0);
                }


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }


}


