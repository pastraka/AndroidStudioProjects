package com.hfad.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class StopWatchActivity extends AppCompatActivity {

    //    record the number of seconds passed
    private int seconds = 0;

    //    is the stopwatch running
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
    }

    //    start the stopwatch when the button start is clicked
    public void onClickStart(View view) {
        running = true;

    }

    //    stop the stopwatch when the button start is clicked
    public void onClickStop(View view) {
        running = false;
    }

    //    reset the stopwatch when the button start is clicked
    public void onClickReset(View view) {
        running = false;
        seconds = 0;
    }

    private void runTimer() {
        final TextView timeView = findViewById(R.id.time_view);


        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        int secs = seconds % 60;
        String time = String.format(Locale.getDefault(), "%d:%2d:%2d", hours, minutes, secs);
        timeView.setText(time);
        if (running) {
            seconds++;
        }
    }
}
