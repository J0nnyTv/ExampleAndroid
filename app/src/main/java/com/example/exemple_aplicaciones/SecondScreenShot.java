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

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import com.example.exemple_aplicaciones.databinding.ActivityMainBinding;
import com.example.exemple_aplicaciones.databinding.SecondScreenBinding;
import com.example.exemple_aplicaciones.viewmodel.MainViewModel;
import com.example.exemple_aplicaciones.viewmodel.SecondViewModel;

// TODO @Didac. En la siguiente linea es lo que tenias. Hay que extender AppCombatActivity
// public class SecondScreenShot extends Activity
public class SecondScreenShot extends AppCompatActivity  {

    public String TAG = "SecondScreen";
    public TextView texto;
    public Button settings;
    public Button button_inc;
    public  int coins;

    //------------------------------------
    //TODO  @Didac Aqui tienes que referenciar el binding del xml, el cual te lo genera solo. Ahora mismo te da error porque el xml tiene otro binding
    //
    //TODO @Didac El Main binding forma parte de l'activity MainActivity. Dejo comentado este y pongo el nuevo

    //TODO@Didac. Lo otro estaba todo bien

    public SecondScreenBinding secondScreenBinding;

    //public ActivityMainBinding binding;     // Se debe de poner el Binding del secondScreen
    public SecondViewModel model;
    //------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.second_screen);
        Log.d(TAG, "onCreate");

        //--------------------------------------------------------------------------------------------

        // @Jordi: Bind the xml with the activity (ActivityLevelsBinding is auto generated).
        secondScreenBinding = SecondScreenBinding.inflate(getLayoutInflater());

        // Set the Content of the xml to the view
        setContentView(secondScreenBinding.getRoot());

        // Set the viewModel
        model = new ViewModelProvider(this).get(SecondViewModel.class);

        secondScreenBinding.setSecondViewModel(model);
        secondScreenBinding.setLifecycleOwner(this);

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
