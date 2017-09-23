package com.example.adharsh.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.content.Intent.ACTION_DIAL;
import static android.content.Intent.ACTION_VIEW;

public class OpenApps extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_apps);

        Button y,c,w;
        y=(Button)findViewById(R.id.button7);
        c=(Button)findViewById(R.id.button8);
        w=(Button)findViewById(R.id.button9);

        y.setOnClickListener(this);
        c.setOnClickListener(this);
        w.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.button8:
                Uri number=Uri.parse("tel:9003822580");
                Intent call=new Intent(ACTION_DIAL,number);
                startActivity(call);
                break;

            case R.id.button9:
                Uri w=Uri.parse("http://www.google.com");
                Intent web=new Intent(ACTION_VIEW,w);
                startActivity(web);
                break;

            case R.id.button7:
                Intent i=getPackageManager().getLaunchIntentForPackage("com.google.android.youtube");
                startActivity(i);
                break;

            case R.id.button10:
                alert();
                break;
        }
    }

    public void alert()
    {
        AlertDialog.Builder b=new AlertDialog.Builder(this);
        b.setTitle("Alert Box");

        b
                       .setMessage("Confirm the process?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent i1 = new Intent(getApplicationContext(), NextClass.class);
                                startActivity(i1);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getApplicationContext(), "NO", Toast.LENGTH_SHORT).show();
                            }
                        });


                AlertDialog a=b.create();
                a.show();

    }
}
