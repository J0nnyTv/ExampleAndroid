package com.example.exemple_aplicaciones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.exemple_aplicaciones.databinding.ActivityMainBinding;
import com.example.exemple_aplicaciones.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    public String TAG = "MainActivity";
    public EditText password;
    public Button send;

    //------------------------------------
    public ActivityMainBinding binding;
    public MainViewModel model;
    //------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate");

        //--------------------------------------------------------------------------------------------

        // @Jordi: Bind the xml with the activity (ActivityLevelsBinding is auto generated).
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        // Set the Content of the xml to the view
        setContentView(binding.getRoot());

        // Set the viewModel
        model = new ViewModelProvider(this).get(MainViewModel.class);

        binding.setMainViewModel(model);
        binding.setLifecycleOwner(this);

        //--------------------------------------------------------------------------------------------

        PreferencesProvider.init(this);

        int coin = PreferencesProvider.providePreferences().getInt("coins", 0);
        if (coin == 0){
            PreferencesProvider.providePreferences().edit().putInt("coins", 10).commit();
        }

        //--------------------------------------------------------------------------------------------

        password = findViewById(R.id.password);
        send = findViewById(R.id.button_enviar);

        String name = model.email_live.getValue();  //para poner el email_live
        Toast.makeText(getBaseContext(), name, Toast.LENGTH_SHORT).show();

        send.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d(TAG, "Botton Clicked");
                if(model.email_live.getValue().length() == 0){
                    Toast.makeText(getBaseContext(), "Introduce un email!!", Toast.LENGTH_SHORT).show();
                }
                else if(password.length() == 0){
                    Toast.makeText(getBaseContext(), "Introduce una contraseña!!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getBaseContext(), "Tu email introducido es: " + model.email_live.getValue(), Toast.LENGTH_SHORT).show();
                    secondScreenActivity();
                }
            }
        });
    }

    private void secondScreenActivity() {
        Intent i = new Intent(this, SecondScreenShot.class);
        startActivity(i);
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