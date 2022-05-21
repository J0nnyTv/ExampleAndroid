package com.example.exemple_aplicaciones;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class SecondScreenShot extends Activity {

    public String TAG = "SecondScreen";
    public TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_screen);
        Log.d(TAG, "onCreate");

        texto = findViewById(R.id.textoPrueba);

        texto.setText("hola este es el email que has introducido: " + MainActivity.email.getText() + "\nY tu contraseña es: " + MainActivity.password.getText());
    }
}
