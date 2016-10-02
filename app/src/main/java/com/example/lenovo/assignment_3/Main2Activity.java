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
    String data, i2 = "Textview";;
    Button readd, writee;
    EditText ext_storagevieww;
    TextView tv;
    String filename = "deepak.txt";

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
                if(isWritable()){
                    write();
                }
            }
        });
        readd.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    read();
            }
        });
    }

    public void write(){
        //File sdCard = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
        //File sdCard = Environment.getExternalStorageDirectory();
        File sdCard = getExternalFilesDir(null);
        File f = new File(sdCard, filename);

        try{
            FileOutputStream fos = new FileOutputStream(f);
            String data = ext_storagevieww.getText().toString();
            fos.write(data.getBytes());
            fos.close();
            Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(), "Not Saved", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
    public boolean isWritable(){
        if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())){
            return true;
        }
        return false;
    }

    public void read(){
        //File sdCard = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
        //File sdCard = Environment.getExternalStorageDirectory();
        File sdCard = getExternalFilesDir( null );
        File file = new File( sdCard, filename );

        StringBuilder text = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                text.append(line);
                text.append('\n');
            }
            br.close();
            tv.setText( text );
            Toast.makeText(getBaseContext(),"File Read", Toast.LENGTH_SHORT).show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}