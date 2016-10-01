package com.example.lenovo.assignment_3;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class shared_Preference extends AppCompatActivity {
    public static final String MyPREFERENCES = "MyPrefs";
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared__preference);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button savee = (Button)findViewById(R.id.save);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        String restoredText = sharedpreferences.getString("edit", null);
        if (restoredText != null) {
            EditText sh_editt = (EditText)findViewById(R.id.sh_edit);
            sh_editt.setText(restoredText);
        }

        savee.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences.Editor editor = sharedpreferences.edit();
             EditText sh_editt = (EditText)findViewById(R.id.sh_edit);
             String n  = sh_editt.getText().toString();

             editor.putString("edit", n);
             editor.commit();
             Toast.makeText(getBaseContext(), "Done", Toast.LENGTH_SHORT).show();
        }
        });
    }
}