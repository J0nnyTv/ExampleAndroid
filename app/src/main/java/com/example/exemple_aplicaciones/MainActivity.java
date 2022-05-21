package com.example.exemple_aplicaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public String TAG = "MainActivity";

    private void secondScreenActivity() {
        Intent i = new Intent(this, SecondScreenShot.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate");

        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.password);
        Button send = findViewById(R.id.button_enviar);

        send.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d(TAG, "Botton Clicked");
                Editable emailText = email.getText();
                if(emailText.length() == 0){
                    Toast.makeText(getBaseContext(), "Introduce un email!!", Toast.LENGTH_SHORT).show();
                }
                else if(password.length() == 0){
                    Toast.makeText(getBaseContext(), "Introduce una contraseña!!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getBaseContext(), "Tu email introducido es: " + emailText, Toast.LENGTH_SHORT).show();
                    secondScreenActivity();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}