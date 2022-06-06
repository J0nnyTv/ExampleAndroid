package com.example.exemple_aplicaciones.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SecondViewModel extends ViewModel {

    public MutableLiveData<String> text_live;

    public SecondViewModel() {
        this.text_live = new MutableLiveData<>();
    }
}
