package com.example.adharsh.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.makeText;

public class SQL extends AppCompatActivity {

    private Cursor c;
    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql);
    }


    public void create(View view) {
        SQLiteDatabase db = openOrCreateDatabase("Stud", Context.MODE_PRIVATE, null);
        db.execSQL("DROP TABLE IF EXISTS STUDENT");
        db.execSQL("CREATE TABLE STUDENT(name VARCHAR,contact VARCHAR);");

        db.execSQL("INSERT INTO STUDENT VALUES('ASR','123');");
        db.execSQL("INSERT INTO STUDENT VALUES('ASw','1213');");

        long numRows = DatabaseUtils.queryNumEntries(db, "STUDENT");
//        makeText(getApplicationContext(), String.valueOf(numRows), Toast.LENGTH_SHORT).show();


        c=db.rawQuery("SELECT * FROM STUDENT",null);
        c.moveToFirst();
        Log.v("Cursor Object", DatabaseUtils.dumpCursorToString(c));
        showrecords();
    }

    public void showrecords()
    {
        EditText editText8=(EditText) findViewById(R.id.editText8);
        EditText editText9=(EditText) findViewById(R.id.editText9);

        editText8.setText(c.getString(c.getColumnIndex("contact")));
        editText9.setText(c.getString(c.getColumnIndex("contact")));
        //Toast.makeText(this,c.getString(2),Toast.LENGTH_LONG).show();

    }
   /*public void add(View view) {

           EditText name = (EditText) findViewById(R.id.editText8);
        EditText con = (EditText) findViewById(R.id.editText9);

        Button btn = (Button) findViewById(R.id.button20);

        db.execSQL("INSERT INTO STUDENT VALUES('" + name.getText().toString() + "','" + con.getText().toString() + "');");

        long numRows = DatabaseUtils.queryNumEntries(db, "STUDENT");
        Toast.makeText(getApplicationContext(), String.valueOf(numRows), Toast.LENGTH_SHORT).show();

    }*/


}
