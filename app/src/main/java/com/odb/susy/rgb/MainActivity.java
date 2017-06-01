package com.odb.susy.rgb;

import android.graphics.Color;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int TIME = 8;

    RelativeLayout contentColor;
    SeekBar seekBar ;
    TextView redText;
    TextView greenText;
    TextView blueText;

    public void setUI(){
        contentColor = (RelativeLayout) findViewById(R.id.content_color);
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
                TIME = progress/10;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                boolean exit = false;
                while (!exit){
                    //RED +
                    for (int r = 0; r<= 255; r++){
                        try{

                            setOutColor(contentColor,r,0,0);
                            setOutText(redText,String.valueOf(r));

                            Thread.currentThread().sleep(TIME);

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    //GREEN +
                    for (int g = 0; g<= 255; g++){
                        try{

                            setOutColor(contentColor,255,g,0);
                            setOutText(greenText,String.valueOf(g));

                            Thread.currentThread().sleep(TIME);

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    //BLUE +
                    for (int b = 0; b<= 255; b++){
                        try{

                            setOutColor(contentColor,255,255,b);
                            setOutText(blueText,String.valueOf(b));

                            Thread.currentThread().sleep(TIME);

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    //RED -
                    for (int r = 255; r>= 0; r--){
                        try{

                            setOutColor(contentColor,r,255,255);
                            setOutText(redText,String.valueOf(r));

                            Thread.currentThread().sleep(TIME);

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    //GREEN -
                    for (int g = 255; g>= 0; g--){
                        try{

                            setOutColor(contentColor,0,g,255);
                            setOutText(greenText,String.valueOf(g));

                            Thread.currentThread().sleep(TIME);

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    //BLUE +
                    for (int b = 255; b>= 0; b--){
                        try{

                            setOutColor(contentColor,0,0,b);
                            setOutText(blueText,String.valueOf(b));

                            Thread.currentThread().sleep(TIME);

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        });
        thread.start();

    }


}


