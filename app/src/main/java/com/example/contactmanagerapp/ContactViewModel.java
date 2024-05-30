package com.example.contactmanagerapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ContactViewModel extends AndroidViewModel {
    private Repository myRepository;

    public ContactViewModel(@NonNull Application application) {
        super(application);
        this.myRepository = new Repository(application);
    }

    public void addContact(Contacts contact) {
        myRepository.addContact(contact);
    }

    public void deleteContact(Contacts contact) {
        myRepository.deleteContact(contact);
    }

    public LiveData<List<Contacts>> getAllContacts() {
        return myRepository.getAllContacts();
    }

}
