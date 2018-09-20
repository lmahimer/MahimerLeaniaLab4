package com.mahimer.leania.mahimerleanialab4;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("4IT-E", "onCreate() method");
        Button btn1 = (Button) findViewById(R.id.button);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)  {
                Toast.makeText(getBaseContext(), "Back Button is pressed!" , Toast.LENGTH_SHORT ).show();
            }
        });

        Button button = (Button) findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(v,"Next Button is pressed!", Snackbar.LENGTH_LONG);
               snackbar.show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("4IT-E", "onStart() method");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("4IT-E", "onResume() method");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("4IT-E", "onPause() method");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("4IT-E", "onStop() method");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("4IT-E", "onDestroy() method");
    }
}
