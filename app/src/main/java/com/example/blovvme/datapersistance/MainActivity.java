package com.example.blovvme.datapersistance;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main";
    private static final String MY_PREF_FILE = "mypref_file" ;
    EditText edt1,edt2;
    Button saveData,getData;
    TextView tvVal1,tvVal2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = (EditText) findViewById(R.id.edt1);
        edt2 = (EditText) findViewById(R.id.edt2);
        tvVal1 = (TextView) findViewById(R.id.tvVal1);
        tvVal2 = (TextView) findViewById(R.id.tvVal2);
    }

    public void saveData(View view) {
        //To save the data File in Phone
        SharedPreferences sharedPreferences = getSharedPreferences(MY_PREF_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("value1", edt1.getText().toString());
        editor.putString("value2",edt2.getText().toString());
        boolean worked = editor.commit();
       //if (worked) {

         //   Toast.makeText(this, +  " " + );
        //}else{

        //}

    }

    public void getData(View view) {

        SharedPreferences sharePreferences = getSharedPreferences(MY_PREF_FILE, Context.MODE_PRIVATE);
        Log.d(TAG,"getData: " + sharePreferences.getString("value1","default"));
        tvVal1.setText(sharePreferences.getString("value1","default"));
        tvVal2.setText(sharePreferences.getString("value2","default"));

    }

//para ir a otra actividad
    public void goToActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

//Para hacer logs en consola
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d(TAG,"onConfigurationChanged");

        if(newConfig.orientation==Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();

        }
    }
}
