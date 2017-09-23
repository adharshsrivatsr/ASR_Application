package com.example.adharsh.myapplication;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class Auto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto);

        AutoCompleteTextView atv=(AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        String[] words={"ASR","ASS","Adharsh","Srivats"};
        ArrayAdapter a=new ArrayAdapter(this,android.R.layout.simple_list_item_1,words);
        atv.setAdapter(a);
        atv.setThreshold(1);

        /*TextToSpeech t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(status!=TextToSpeech.ERROR)
                {
                t1.setLanguage(Locale.UK);
            }
        });

        Button button18=(Button) findViewById(R.id.button18);
            EditText ed7=(EditText) findViewById(R.id.editText7);
            button18.setOnClickListener(new View.OnClickListener()
            {
                String toSpeak = ed7.getText().toString();
                Toast.makeText(getApplicationContext(), toSpeak, Toast.LENGTH_SHORT).show();
                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                        t1.spe
            }*/
    }

    public void next(View view)
    {
        Intent in=new Intent(getApplicationContext(),SQL.class);
        startActivity(in);
    }
}
