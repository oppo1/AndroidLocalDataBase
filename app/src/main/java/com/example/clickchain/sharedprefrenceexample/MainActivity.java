package com.example.clickchain.sharedprefrenceexample;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.couchbase.lite.CouchbaseLiteException;
import com.couchbase.lite.Database;
import com.couchbase.lite.Document;
import com.couchbase.lite.Manager;
import com.couchbase.lite.android.AndroidContext;
import com.couchbase.lite.internal.database.sqlite.SQLiteDatabaseConfiguration;
import com.couchbase.lite.util.Log;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Manager manager = null;
        Database database = null;
        EmployeeData sohaibData = new EmployeeData(1, "Sohaib", "BWP");
        EmployeeData umerData = new EmployeeData(2, "Umer", "BWP");
        EmployeeData asmaData = new EmployeeData(2, "Asma", "BWP");
        EmployeeData jazibData = new EmployeeData(2, "Jazib", "BWP");

        try {
            manager = new Manager(new AndroidContext(getApplicationContext()), Manager.DEFAULT_OPTIONS);
            database = manager.getDatabase("example");
        } catch (Exception e) {
            Log.e(TAG, "Error getting database");
        }

        Map<String, Object> map = new HashMap<>();
        map.put(sohaibData.getName(),sohaibData);
        map.put(umerData.getName(),umerData);
        map.put(asmaData.getName(),asmaData);
        map.put(jazibData.getName(),jazibData);

        Document employeesDocument = database.createDocument();

        try {
            employeesDocument.putProperties(map);
        } catch (CouchbaseLiteException e) {
            e.printStackTrace();
        }

        Document employees = database.getDocument(employeesDocument.getId());
        /*EmployeeData sohaib = (EmployeeData) employees.getProperty("Sohaib");
        EmployeeData umer = (EmployeeData) employees.getProperty("Umer");*/

        Gson gson = new Gson();
        String jsonSohaib = gson.toJson(employees.getProperty("Sohaib"));
        EmployeeData sohaibDataa = new Gson().fromJson(jsonSohaib,EmployeeData.class);

        String jsonAsma = gson.toJson(employees.getProperty("Sohaib"));
        EmployeeData asmaDataa = new Gson().fromJson(jsonAsma,EmployeeData.class);

        String jsonUmer = gson.toJson(employees.getProperty("Sohaib"));
        EmployeeData umerDataa = new Gson().fromJson(jsonUmer,EmployeeData.class);

        String jsonJazib = gson.toJson(employees.getProperty("Sohaib"));
        EmployeeData jazibDataa = new Gson().fromJson(jsonJazib,EmployeeData.class);

        jazibDataa.getName();
        umerDataa.getCity();
        asmaDataa.getId();

        startActivity(new Intent(MainActivity.this,CheckActivity.class));

        /*try {
            jazibDataa.check(employeesDocument.getId());
        } catch (CouchbaseLiteException e) {
            e.printStackTrace();
        }*/












        /*SharedPreferences data = getSharedPreferences("EmployeeData", MODE_PRIVATE);
        data.edit().clear().commit();
        Gson gson = new Gson();

        EmployeeData employeeData1 = new EmployeeData(1, "Sohaib", "BWP");
        String json = gson.toJson(employeeData1);
        data.edit().putString(employeeData1.city, json).commit();
        data.edit().putString(employeeData1.name, json).commit();
        String employee1 = (String) data.getAll().get(employeeData1.city);
        EmployeeData sohaibData = new Gson().fromJson(employee1,EmployeeData.class);




        *//*EmployeeData employeeData2 = new EmployeeData(2, "umar", "bahawalpur");
        data.edit().putString(employeeData2.city, json);
        data.edit().putString(employeeData2.name, json).commit();
        String employee2 = (String) data.getAll().get(employeeData2.city);
        EmployeeData umarData = new Gson().fromJson(employee2,EmployeeData.class);*//*
        String ali = "";*/


    }
}
