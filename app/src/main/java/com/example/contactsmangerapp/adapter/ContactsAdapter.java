package com.example.contactsmangerapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.contactsmangerapp.MainActivity;
import com.example.contactsmangerapp.R;
import com.example.contactsmangerapp.db.entity.Contact;

import java.util.ArrayList;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<Contact> contactArrayList;
    private MainActivity mainActivity;

    public ContactsAdapter(Context context, ArrayList<Contact> contactArrayList, MainActivity mainActivity) {
        this.context = context;
        this.contactArrayList = contactArrayList;
        this.mainActivity = mainActivity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.contact_list_items,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Contact contact = contactArrayList.get(position);
        holder.txtName.setText(contact.getName());
        holder.txtEmail.setText(contact.getEmail());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.addAndEditContacts(true,contact,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactArrayList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView txtName,txtEmail;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.name);
            txtEmail = itemView.findViewById(R.id.email);
        }
    }

}
