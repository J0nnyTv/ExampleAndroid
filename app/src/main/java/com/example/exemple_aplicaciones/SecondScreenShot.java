package com.example.exemple_aplicaciones;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;

import com.example.exemple_aplicaciones.databinding.ActivityMainBinding;
import com.example.exemple_aplicaciones.viewmodel.MainViewModel;
import com.example.exemple_aplicaciones.viewmodel.SecondViewModel;

public class SecondScreenShot extends Activity {

    public String TAG = "SecondScreen";
    public TextView texto;
    public Button settings;
    public Button button_inc;
    public  int coins;

    //------------------------------------
    public ActivityMainBinding binding;     // Se debe de poner el Binding del secondScreen
    public SecondViewModel model;
    //------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.second_screen);
        Log.d(TAG, "onCreate");

        //--------------------------------------------------------------------------------------------

        // @Jordi: Bind the xml with the activity (ActivityLevelsBinding is auto generated).
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        // Set the Content of the xml to the view
        setContentView(binding.getRoot());

        // Set the viewModel
        model = new ViewModelProvider(this).get(SecondViewModel.class);

        binding.setMainViewModel(model);
        binding.setLifecycleOwner(this);

        //--------------------------------------------------------------------------------------------

        coins = PreferencesProvider.providePreferences().getInt("coins", 0);
        button_inc = findViewById(R.id.button_increment_coin);

        settings = findViewById(R.id.button_opciones);

        texto = findViewById(R.id.textoPrueba);
        texto.setText("Tus coins actuales son: " + coins);

        button_inc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d(TAG,"Coins -> " + String.valueOf(coins));
                PreferencesProvider.providePreferences().edit().putInt("coins", coins + 1).commit();
                coins = PreferencesProvider.providePreferences().getInt("coins", 0);
                Log.d(TAG,"Money -> " + String.valueOf(coins));
                texto.setText("Tus coins actuales son: " + String.valueOf(coins));
            }
        });

        /*settings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SettingsFragment settingsFragment = new SettingsFragment();

            }
        });*/
    }
}
