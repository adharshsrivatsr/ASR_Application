package com.example.adharsh.myapplication;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NextClass extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_class);

        Button b1,b2,b3,b4,b5;
        b1=(Button) findViewById(R.id.button11);
        b2=(Button) findViewById(R.id.button12);
        b3=(Button) findViewById(R.id.button13);
        b4=(Button) findViewById(R.id.button14);
        b5=(Button) findViewById(R.id.button15);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        AudioManager a=(AudioManager) getSystemService(Context.AUDIO_SERVICE);
        switch (view.getId())
        {
            case R.id.button11:
                a.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                Toast.makeText(this,"Muted!",Toast.LENGTH_SHORT).show();
                break;

            case R.id.button12:
                a.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                Toast.makeText(this,"Normal",Toast.LENGTH_SHORT).show();
                break;

            case R.id.button13:
                a.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
                Toast.makeText(this,"Vibrate",Toast.LENGTH_SHORT).show();
                break;

            case R.id.button14:
                int n=a.getRingerMode();
                if(n==AudioManager.RINGER_MODE_NORMAL)
                    Toast.makeText(this,"Normal",Toast.LENGTH_SHORT).show();
                if(n==AudioManager.RINGER_MODE_VIBRATE)
                    Toast.makeText(this,"Vibrate",Toast.LENGTH_SHORT).show();
                if(n==AudioManager.RINGER_MODE_SILENT)
                    Toast.makeText(this,"Muted",Toast.LENGTH_SHORT).show();
                break;

            case R.id.button15:
                SmsManager m=SmsManager.getDefault();
                EditText no=(EditText)findViewById(R.id.editText5);
                EditText t=(EditText)findViewById(R.id.editText6);
                String nu="9000234563";
                Long ln=Long.parseLong(nu);
                String msg="LoremnIpsum";                         /*t.getText().toString();*/
                m.sendTextMessage(nu,null,msg,null,null);
                Toast.makeText(this,"Sent!",Toast.LENGTH_SHORT).show();
                break;

            case R.id.button16:
                BluetoothAdapter BA = BluetoothAdapter.getDefaultAdapter();
                if(BA.isEnabled())
                    Toast.makeText(this,"ALREADY ON",Toast.LENGTH_LONG).show();
                BA.enable();
                break;

            case  R.id.button17:
                Intent next=new Intent(this,Auto.class);
                startActivity(next);
                break;
        }
    }


}
