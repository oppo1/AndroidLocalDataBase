package com.example.clickchain.sharedprefrenceexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.couchbase.lite.Database;
import com.couchbase.lite.Document;
import com.couchbase.lite.Manager;
import com.couchbase.lite.android.AndroidContext;
import com.couchbase.lite.util.Log;

public class CheckActivity extends AppCompatActivity {

    private static final String TAG = "";
    Database database = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        try {
            Manager manager = new Manager(new AndroidContext(getApplicationContext()), Manager.DEFAULT_OPTIONS);
            database = manager.getDatabase("example");
        } catch (Exception e) {
            Log.e(TAG, "Error getting database");
        }



        Document employees = database.getDocument("32d22dab-7e7c-459e-92be-4b92f481f04a");
        employees.getProperty("Sohaib");
    }
}
