package com.example.contactmanagerapp;

import android.content.Context;
import android.content.Intent;
import android.view.View;

public class MainActivity2ClickHandler {
    Context context;
    Contacts contact;
    ContactViewModel contactViewModel;
    public MainActivity2ClickHandler(Context context, Contacts contact, ContactViewModel contactViewModel) {
        this.context = context;
        this.contact = contact;
        this.contactViewModel = contactViewModel;
    }

    public void addContact(View view) {
        Contacts c = new Contacts(contact.getName(), contact.getEmail());
        contactViewModel.addContact(c);
        Intent i = new Intent(context, MainActivity.class);
        context.startActivity(i);
    }
}
