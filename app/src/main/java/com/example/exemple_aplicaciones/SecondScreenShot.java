package com.example.exemple_aplicaciones;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class SecondScreenShot extends Activity {

    public String TAG = "SecondScreen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_screen);
        Log.d(TAG, "onCreate");
    }
}
