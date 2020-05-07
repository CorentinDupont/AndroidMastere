package com.example.mastereapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mastereapp.Entities.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        int permission = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS);

        // affichage de la popup demande de permission :
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.READ_CONTACTS},
                123);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 123)
        {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                displayContacts(getContactList());
            }
            else
            {
                Toast.makeText(this, "Impossible d'afficher les contacts après refus des autorisations.", Toast.LENGTH_LONG);
            }
        }

    }

    private List<Contact> getContactList() {
        // projection (colonnes utilisées après la requète) :
        String[] projection = {
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER};
        // filtre (clause WHERE) :
        String selection = ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " = ? ";
        String[] selectionArgs = {""};
        // tri :
        String tri = ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC ";
        // requête :
        Cursor cursor = getContentResolver().query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI, // table requétée
                projection, // colonnes à retourner
                null, null,
                tri);

        List<Contact> listeContacts = new ArrayList<>();
        if (cursor != null) {
            try {
                while (cursor.moveToNext()) {
                    // conversion des données remontées en un objet métier :
                    Contact contact = new Contact(
                            cursor.getString(cursor.getColumnIndex(
                                    ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)),
                            cursor.getString(cursor.getColumnIndex(
                                    ContactsContract.CommonDataKinds.Phone.NUMBER)));
                    listeContacts.add(contact);
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            } finally {
                cursor.close();
            }
        }

        return listeContacts;
    }

    private String getContactsString(List<Contact> contactList) {
        String contactString = "";
        for (Contact contact : contactList) {
            contactString += contact.nom + " " + contact.numero + "\n";
        }

        return contactString;
    }

    private void displayContacts(List<Contact> contactList) {
        String text = getContactsString(contactList);
        TextView contactTextView = findViewById(R.id.contact_tv);
        contactTextView.setText(text);
    }
}
