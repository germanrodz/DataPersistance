package com.example.blovvme.datapersistance;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {

    private static final String MY_PREF_FILE = "mypref_file" ;
    TextView tvE1,tvE2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvE1 = (TextView) findViewById(R.id.tvE1);
        tvE2 = (TextView) findViewById(R.id.tvE2);

        SharedPreferences sharePreferences = getSharedPreferences(MY_PREF_FILE, Context.MODE_PRIVATE);
        tvE1.setText(sharePreferences.getString("value1","default"));
        tvE2.setText(sharePreferences.getString("value2","default"));
    }
}
