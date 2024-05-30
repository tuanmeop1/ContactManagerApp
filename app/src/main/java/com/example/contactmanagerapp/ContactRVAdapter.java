package com.example.contactmanagerapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactmanagerapp.databinding.ContactListItemBinding;

import java.util.ArrayList;

public class ContactRVAdapter extends RecyclerView.Adapter<ContactRVAdapter.ContactViewHolder> {
    private ArrayList<Contacts> contactsArrayList;
    public ContactRVAdapter(ArrayList<Contacts> contactsArrayList) {
        this.contactsArrayList = contactsArrayList;
    }
    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ContactListItemBinding contactListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.contact_list_item, parent, false);
        return new ContactViewHolder(contactListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        holder.contactListItemBinding.setContact(contactsArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return !contactsArrayList.isEmpty() ? contactsArrayList.size() : 0;
    }

    public void setContactsArrayList(ArrayList<Contacts> contactsArrayList) {
        this.contactsArrayList = contactsArrayList;
        notifyDataSetChanged();
    }
    public static class ContactViewHolder extends RecyclerView.ViewHolder {
        ContactListItemBinding contactListItemBinding;

        public ContactViewHolder(ContactListItemBinding contactListItemBinding) {
            super(contactListItemBinding.getRoot());
            this.contactListItemBinding = contactListItemBinding;
        }
    }
}
