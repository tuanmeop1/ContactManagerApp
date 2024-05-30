package com.example.contactmanagerapp;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository {
    private final ContactsDAO contactDAO;
    public ExecutorService executor;
    public Handler handler;
    public Repository(Application application) {
        ContactsDatabase contactDatabase = ContactsDatabase.getInstance(application);
        this.contactDAO = contactDatabase.getContactsDAO();
        executor = Executors.newSingleThreadExecutor();
        handler = new Handler(Looper.getMainLooper());
    }
    public void addContact(Contacts contact) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                contactDAO.insert(contact);
            }
        });
    }
    public void deleteContact(Contacts contact) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                contactDAO.delete(contact);
            }
        });
    }

    public LiveData<List<Contacts>> getAllContacts() {
        return contactDAO.getAllContacts();
    }
}
