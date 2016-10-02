/*
getExternalFilesDir()
It returns the path to files folder inside Android/data/data/your_package/ on your SD card. It is used to store any required files for your app (e.g. images downloaded from web or cache files). Once the app is uninstalled, any data stored in this folder is gone too.

getExternalStorageDirectory()
It returns the root path to your SD card (e.g mnt/sdcard/). If you save data on this path and uninstall the app, that data won't be lost.
*/
package com.example.lenovo.assignment_3;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class Main2Activity extends AppCompatActivity {
    String i2 = "Textview", filename = "deepak", data, line;
    Button readd, writee;
    EditText ext_storagevieww;
    TextView tv;

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(i2, tv.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        readd = (Button) findViewById(R.id.read);
        writee = (Button) findViewById(R.id.write);
        ext_storagevieww = (EditText) findViewById(R.id.ext_storagevieww);
        tv = (TextView) findViewById(R.id.txtview_wri);

        if( savedInstanceState!=null ) {
            String i1 = savedInstanceState.getString( i2 );
            tv.setText(i1);
        }

        writee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    write_func();
            }
        });
        readd.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View view ) {
                    read_func();
            }
        });
    }

    public void write_func(){
        if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            //File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
            File path = Environment.getExternalStorageDirectory();
            //File path = getExternalFilesDir(null);
            File f = new File(path, filename);

            try {
                FileOutputStream oup = new FileOutputStream(f);
                data = ext_storagevieww.getText().toString();
                oup.write(data.getBytes());
                oup.close();
                Toast.makeText(getApplicationContext(), "Saved in ext_storage", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "Not Saved", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        }
    }
//    public boolean check_wri(){
//        if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())){
//            return true;
//        }
//        return false;
//    }

    public void read_func(){
        StringBuilder inpu_me = new StringBuilder();
        //File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
        File path = Environment.getExternalStorageDirectory();
        //File path = getExternalFilesDir( null );
        File file = new File( path, filename );

        try {
            BufferedReader inp = new BufferedReader(new FileReader(file));

            while ((line = inp.readLine()) != null) {
                inpu_me.append(line);
                inpu_me.append('\n');
            }
            tv.setText( inpu_me );
            Toast.makeText(getApplicationContext(), "Read", Toast.LENGTH_SHORT).show();
            inp.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}