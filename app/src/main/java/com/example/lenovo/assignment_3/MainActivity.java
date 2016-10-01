package com.example.lenovo.assignment_3;

import android.app.AlertDialog;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class  MainActivity extends ActionBarActivity {
    DataBase DataB;
    EditText name, semester, rollno;
    Button insertt, updatee, showw, deletee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataB = new DataBase(this);

        name = (EditText)findViewById(R.id.nameview);
        rollno = (EditText)findViewById(R.id.rollno_view);
        semester = (EditText)findViewById(R.id.semesterview);

        insertt = (Button)findViewById(R.id.insert);
        showw = (Button)findViewById(R.id.show);
        updatee = (Button)findViewById(R.id.update);
        deletee = (Button)findViewById(R.id.delete);

        INSERTTDATA();
        SHOWWDATA();
        UPDATEEDATA();
        DELETEEDATA();
    }

    public  void INSERTTDATA() {
        insertt.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = DataB.insertData( name.getText().toString(), rollno.getText().toString(), semester.getText().toString() );
                        if(isInserted == true)
                            Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                    }
                });
    }

    public void UPDATEEDATA() {
        updatee.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = DataB.updateData(name.getText().toString(), rollno.getText().toString(), semester.getText().toString());
                        if(isUpdate == true)
                            Toast.makeText(MainActivity.this,"Data Update",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this,"Data not Updated",Toast.LENGTH_LONG).show();
                    }
                });
    }

    public void DELETEEDATA() {
        deletee.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = DataB.deleteData(rollno.getText().toString());
                        if(deletedRows > 0)
                            Toast.makeText(MainActivity.this,"Data Deleted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this,"Data not Deleted",Toast.LENGTH_LONG).show();
                    }
                });
    }

    public void SHOWWDATA() {
        showw.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = DataB.getAllData();
                        if(res.getCount() == 0) {
                            // show message
                            showMessage("Error", "Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Name :" + res.getString(0) + "\n");
                            buffer.append("Roll No :" + res.getString(1) + "\n");
                            buffer.append("Semester :" + res.getString(2) + "\n\n");
                        }

                        // Show all data
                        showMessage("Data", buffer.toString());
                    }
                });
    }

    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }


}