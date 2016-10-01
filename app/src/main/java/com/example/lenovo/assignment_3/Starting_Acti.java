package com.example.lenovo.assignment_3;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Starting_Acti extends AppCompatActivity {
    // Pressing back button takes us to home screen
    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_);
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

        Button sharedpreferencee = (Button)findViewById(R.id.sharedpreference);
        Button internalsecurityy = (Button)findViewById(R.id.internalsecurity);
        Button externalstoragee = (Button)findViewById(R.id.externalstorage);
        Button usingsqll = (Button)findViewById(R.id.usingsql);

        sharedpreferencee.setOnClickListener(new Button.OnClickListener()
        {
            public void onClick(View v)
            {
                startActivity( new Intent(getApplicationContext(), shared_Preference.class) );
            }
        });
        internalsecurityy.setOnClickListener(new Button.OnClickListener()
        {
            public void onClick(View v)
            {
                startActivity( new Intent(getApplicationContext(), Storage.class) );
            }
        });
        externalstoragee.setOnClickListener(new Button.OnClickListener()
        {
            public void onClick(View v)
            {
                startActivity( new Intent(getApplicationContext(), Ext_Storage.class) );
            }
        });
        usingsqll.setOnClickListener(new Button.OnClickListener()
        {
            public void onClick(View v)
            {
                startActivity( new Intent(getApplicationContext(), MainActivity.class) );
            }
        });
    }

}
