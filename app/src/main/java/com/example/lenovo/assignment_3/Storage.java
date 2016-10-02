package com.example.lenovo.assignment_3;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Storage extends AppCompatActivity {
    String data, i2 = "Textview", file = "deepak", temp;
    Button readd, writee;
    EditText int_storagevieww;
    TextView tv;

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(i2, tv.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        readd = (Button)findViewById( R.id.read );
        writee = (Button)findViewById( R.id.write );
        int_storagevieww = (EditText)findViewById( R.id.int_storageview );
        tv = (TextView)findViewById( R.id.txtview_wri );

        if( savedInstanceState!=null ) {
            String i1 = savedInstanceState.getString( i2 );
            tv.setText(i1);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        writee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = int_storagevieww.getText().toString();

                try {
                    FileOutputStream writeoup = openFileOutput(file, MODE_PRIVATE);
                    writeoup.write( data.getBytes() );
                    writeoup.close();
                    Toast.makeText( getApplicationContext(), "file saved", Toast.LENGTH_SHORT ).show();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        readd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    FileInputStream writein = openFileInput(file);
                    int opop;
                    temp = "";

                    while( (opop = writein.read()) != -1){
                        temp = temp + Character.toString((char)opop);
                    }
                    tv.setText( temp );
                    Toast.makeText(getApplicationContext(), "Read", Toast.LENGTH_SHORT).show();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}