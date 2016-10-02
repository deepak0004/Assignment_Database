package com.example.lenovo.assignment_3;

import android.app.AlertDialog;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class  MainActivity extends AppCompatActivity {
    DataBase base_data;
    EditText name, semester, rollno;
    Button insertt, updatee, showw, deletee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        base_data = new DataBase(this);

        name = (EditText)findViewById(R.id.nameview);
        rollno = (EditText)findViewById(R.id.rollno_view);
        semester = (EditText)findViewById(R.id.semesterview);

        insertt = (Button)findViewById(R.id.insert);
        showw = (Button)findViewById(R.id.show);
        updatee = (Button)findViewById(R.id.update);
        deletee = (Button)findViewById(R.id.delete);

        insertt.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean check_inser = base_data.insertData( name.getText().toString(), rollno.getText().toString(), semester.getText().toString() );
                if(check_inser == true)
                    Toast.makeText(getApplicationContext(), "Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "Not Inserted", Toast.LENGTH_SHORT).show();
            }
        });

        updatee.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean check_up = base_data.updateData(name.getText().toString(), rollno.getText().toString(), semester.getText().toString());
                if(check_up == true)
                    Toast.makeText(getApplicationContext(), "Update", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "Not Updated", Toast.LENGTH_SHORT).show();
            }
        });

        deletee.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer no_of_del_row = base_data.deleteData(rollno.getText().toString());
                if(no_of_del_row > 0)
                    Toast.makeText(getApplicationContext(), "Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "Not Deleted", Toast.LENGTH_SHORT).show();
            }
        });

        showw.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor anss = base_data.getAllData();
                if(anss.getCount() == 0) {
                    disp("Error", "No Data");
                    return;
                }

                StringBuffer temp = new StringBuffer();
                while (anss.moveToNext()) {
                    temp.append("Name :" + anss.getString(0) + "\n");
                    temp.append("Roll No :" + anss.getString(1) + "\n");
                    temp.append("Semester :" + anss.getString(2) + "\n\n");
                }

                disp("Data", temp.toString());
            }
        });
    }

    public void disp(String head, String text){
        AlertDialog.Builder gradle = new AlertDialog.Builder(this);
        gradle.setCancelable(true);
        gradle.setTitle(head);
        gradle.setMessage(text);
        gradle.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}