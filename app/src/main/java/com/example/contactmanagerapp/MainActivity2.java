package com.example.contactmanagerapp;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.contactmanagerapp.databinding.ActivityMain2Binding;


public class MainActivity2 extends AppCompatActivity {
    private ActivityMain2Binding activityMain2Binding;
    private ContactViewModel contactViewModel;
    private MainActivity2ClickHandler clickHandler;
    private Contacts c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        activityMain2Binding = DataBindingUtil.setContentView(this, R.layout.activity_main2);
        c = new Contacts();
        contactViewModel = new ViewModelProvider(this).get(ContactViewModel.class);
        activityMain2Binding.setContact(c);
        clickHandler = new MainActivity2ClickHandler(this, c, contactViewModel);
        activityMain2Binding.setClickHandler(clickHandler);
    }
}