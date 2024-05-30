package com.example.contactmanagerapp;

import android.content.Context;
import android.content.Intent;
import android.view.View;

public class MainActivityClickHandler {

    private Context context;
    public MainActivityClickHandler(Context context) {
        this.context = context;
    }

    public void FABClicker (View view){
        Intent i = new Intent(view.getContext(), MainActivity2.class);
        context.startActivity(i);
    }
}
