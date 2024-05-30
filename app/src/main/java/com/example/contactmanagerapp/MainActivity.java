package com.example.contactmanagerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.contactmanagerapp.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;
    private MainActivityClickHandler clickHandler;
    private ArrayList<Contacts> contactsArrayList;
    private ContactsDatabase contactsDatabase;
    private ContactRVAdapter contactRVAdapter;
    private RecyclerView contactRV;
    private FloatingActionButton addContactButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Data binding
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        clickHandler = new MainActivityClickHandler(this);
        activityMainBinding.setClickHandler(clickHandler);
        //Get Reference
        contactRV = activityMainBinding.recyclerView;
        addContactButton = activityMainBinding.fabBtn;
        //Initialize contacts list
        contactsArrayList = new ArrayList<>();
        contactRVAdapter = new ContactRVAdapter(contactsArrayList);
        //Get Database
        contactsDatabase = ContactsDatabase.getInstance(this);
        ContactViewModel contactViewModel = new ViewModelProvider(this).get(ContactViewModel.class);
        Contacts contact = new Contacts("Tuan", "tuanmeop1@gmail.com");
        contactViewModel.addContact(contact);
        contactViewModel.getAllContacts().observe(this, new Observer<List<Contacts>>() {
            @Override
            public void onChanged(List<Contacts> contacts) {
                contactsArrayList.clear();
                contactsArrayList.addAll(contacts);
                contactRVAdapter.setContactsArrayList(contactsArrayList);
            }
        });
        contactRV.setAdapter(contactRVAdapter);
        contactRV.setLayoutManager(new LinearLayoutManager(this));
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                contactViewModel.deleteContact(contactsArrayList.get(viewHolder.getAdapterPosition()));
            }
        }).attachToRecyclerView(contactRV);
    }
}