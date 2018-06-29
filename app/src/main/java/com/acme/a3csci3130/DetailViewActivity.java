package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DetailViewActivity extends Activity {

    private EditText nameField, numberField,provinceFeild,addressFeild,primaryBusinessFeild;
    Contact receivedPersonInfo;
    private MyApplicationData app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Contact)getIntent().getSerializableExtra("Contact");

        nameField = (EditText) findViewById(R.id.name);
        numberField = (EditText) findViewById(R.id.number);
        provinceFeild = (EditText) findViewById(R.id.province);
        addressFeild = (EditText) findViewById(R.id.Address);
        primaryBusinessFeild = (EditText) findViewById(R.id.primaryBusiness);
        if(receivedPersonInfo != null){
            nameField.setText(receivedPersonInfo.name);
            numberField.setText(receivedPersonInfo.number);
            provinceFeild.setText(receivedPersonInfo.province);
            addressFeild.setText(receivedPersonInfo.address);
            primaryBusinessFeild.setText(receivedPersonInfo.primaryBusiness);
        }
    }

    public void updateContact(View v){
        //TODO: Update contact funcionality
        Contact updatedEntry = new Contact(receivedPersonInfo.uid, nameField.toString(), numberField.toString(),provinceFeild.toString(), primaryBusinessFeild.toString(), addressFeild.toString());
        app.firebaseReference.child(receivedPersonInfo.uid).setValue(updatedEntry);
    }

    public void eraseContact(View v)
    {
        //TODO: Erase contact functionality
        app.firebaseReference.child(receivedPersonInfo.uid).removeValue();
    }
}
