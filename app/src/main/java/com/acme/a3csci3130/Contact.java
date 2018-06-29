package com.acme.a3csci3130;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Class that defines how the data will be stored in the
 * Firebase databse. This is converted to a JSON format
 */

public class Contact implements Serializable {

    public  String uid;
    public  String name;
    public  String number;
    public  String province;
    public  String primaryBusiness;
    public  String address;



    public Contact(String uid, String name, String number,String province, String primaryBusiness, String address){
        this.uid = uid;
        this.name = name;
        this.number = number;
        this.address=address;
        this.primaryBusiness=primaryBusiness;
        this.province=province;
    }

    @Override
    public int hashCode() {

        return Objects.hash( uid, name, number, province,  primaryBusiness, address);
    }
    public Contact() {
        // Default constructor required for calls to DataSnapshot.getValue
    }
}
