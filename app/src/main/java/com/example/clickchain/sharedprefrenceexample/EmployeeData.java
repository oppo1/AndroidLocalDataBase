package com.example.clickchain.sharedprefrenceexample;

import com.couchbase.lite.CouchbaseLiteException;
import com.couchbase.lite.Database;
import com.couchbase.lite.Document;
import com.couchbase.lite.Manager;
import com.couchbase.lite.android.AndroidContext;
import com.google.gson.Gson;

public class EmployeeData {
    int id;
    String name;
    String city;

    public EmployeeData(int id, String name, String fatherName) {
        this.id = id;
        this.name = name;
        city = fatherName;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }
}
