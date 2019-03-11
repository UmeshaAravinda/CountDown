package com.abc.countdown;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int counter = 99;
    private static final String CURRENT_COUNTER ="counter";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState!=null){
            counter = savedInstanceState.getInt(CURRENT_COUNTER);
        }
        CountDown();
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(CURRENT_COUNTER,counter);


    }
    private void CountDown(){

        final Handler handler = new Handler();
        handler.post(new Runnable() {

            @Override
            public void run() {
                final TextView textView = findViewById(R.id.textView);
                textView.setText(Integer.toString(counter));
                //Reset the counter
                if(counter==0){
                    counter = 99;
                }

                counter--;
                handler.postDelayed(this,1000);

            }
        });
    }
}
