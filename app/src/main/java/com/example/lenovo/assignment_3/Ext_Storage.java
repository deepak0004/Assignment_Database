package com.example.lenovo.assignment_3;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Ext_Storage extends AppCompatActivity {
    String data;
    Button readd, writee;
    EditText ext_storagevieww;
    TextView tv;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ext__storage);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        readd = (Button) findViewById(R.id.read);
        writee = (Button) findViewById(R.id.write);
        ext_storagevieww = (EditText) findViewById(R.id.ext_storagevieww);
        tv = (TextView) findViewById(R.id.txtview_wri);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });

        writee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String state = Environment.getExternalStorageState();
                if (Environment.MEDIA_MOUNTED.equals(state)) {
                    //File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
                    String Message = ext_storagevieww.getText().toString();
                    //File file = new File(path, "myda.txt");
                    String secStore = "/storage/extSdCarcd";

                    try {
                        //file.mkdirs();
                        FileOutputStream fileOutputStream = new FileOutputStream(secStore, false);
                        fileOutputStream.write(Message.getBytes());
                        fileOutputStream.close();
                        Toast.makeText(getBaseContext(), "File saved", Toast.LENGTH_SHORT).show();
                    }
                    catch (Exception e)  {
                        Toast.makeText(getBaseContext(), "Not saved", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                }
                else {
                    Toast.makeText(getBaseContext(), "Not Not saved", Toast.LENGTH_SHORT).show();
                }
            }
        });
//        readd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try {
//                    File Root = Environment.getExternalStorageDirectory();
//                    File Dir = new File(Root.getAbsolutePath() + "/MyAppFile");
//                    File file = new File(Dir, "MyMessage.txt");
//                    FileInputStream fin = new FileInputStream(file);
//                    int c;
//                    String temp = "";
//
//                    while ((c = fin.read()) != -1) {
//                        temp = temp + Character.toString((char) c);
//                    }
//                    tv.setText(temp);
//                    Toast.makeText(getBaseContext(), "File Read", Toast.LENGTH_SHORT).show();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
   }
}