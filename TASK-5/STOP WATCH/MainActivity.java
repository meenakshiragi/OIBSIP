package com.example.stopwatch;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
;


public class MainActivity extends AppCompatActivity {

    TextView timer;
    Button s1 , p1 ,r1 ;
    long millisecondtime , stime , timebuff ,update=01;
    Handler handler;
    int sec , min , millisec;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timer = (TextView) findViewById(R.id.t);
                s1=(Button) findViewById(R.id.s);
        p1=(Button) findViewById(R.id.p);
        r1=(Button) findViewById(R.id.r);

        handler = new Handler();
        s1.setOnClickListener(new View.OnClickListener() {

           public void onClick(View view) {

               stime = SystemClock.uptimeMillis();
               handler.postDelayed(runnable,0 );
               r1.setEnabled(false);

           }
        });
        p1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                timebuff += millisecondtime;
                handler.removeCallbacks(runnable);
                r1.setEnabled(true);

            }
        });
        r1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                millisecondtime =01;
                stime =01;
                timebuff =01;
                update=01;
                sec=0;
                min=0;
                millisec=0;

            }
        });
    }
    public Runnable runnable = new Runnable()
    {

        public void run() {

            millisecondtime = SystemClock.uptimeMillis() - stime;
            update = timebuff + millisecondtime;
            sec = (int) (update / 1000);
            min = sec / 60;
            sec = sec % 60;
            millisec = (int) (update % 1000);
            timer.setText("" + min + ":"
                   + String.format("%02d", sec) + ":"
                   + String.format("%03d", millisec));

            handler.postDelayed(this, 0);

        }
    };
}