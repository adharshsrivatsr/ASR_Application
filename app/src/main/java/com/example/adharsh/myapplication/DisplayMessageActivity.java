package com.example.adharsh.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.adharsh.myapplication.R.id.textView;

public class DisplayMessageActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        Intent intent = getIntent();
        String m = intent.getStringExtra(MainActivity.EXTRA);
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(m);
        init();
    }
    public void init()
    {
        Button add=(Button) findViewById(R.id.button2);
        Button sub=(Button) findViewById(R.id.button3);
        Button mul=(Button) findViewById(R.id.button4);
        Button div=(Button) findViewById(R.id.button5);

        add.setOnClickListener( this);
        sub.setOnClickListener(this);
        mul.setOnClickListener( this);
        div.setOnClickListener(this);
}

    @Override
    public void onClick(View view) {
        EditText e1 = (EditText) findViewById(R.id.editText3);
        EditText e2 = (EditText) findViewById(R.id.editText4);
        TextView textView = (TextView) findViewById(R.id.textView4);

        String a = e1.getText().toString();
        String b = e2.getText().toString();

        switch (view.getId())
        {
        case R.id.button2:
        float x = Float.parseFloat(a) +Float.parseFloat(b);
        textView.setText(String.valueOf(x));
        break;

        case R.id.button3:
            x = Integer.parseInt(a) - Integer.parseInt(b);
        textView.setText(String.valueOf(x));
        break;

        case R.id.button4:
            x = Integer.parseInt(a) * Integer.parseInt(b);
        textView.setText(String.valueOf(x));
        break;

        case R.id.button5:
        try {
            x = Integer.parseInt(a) / Integer.parseInt(b);
            textView.setBackgroundColor(Color.CYAN);
            textView.setText(String.valueOf(x));
                    } catch (Exception e) {
            textView.setText("DIVIDE by 0!");
            }
        break;

            case R.id.button6:
                Intent i=new Intent(this,OpenApps.class);
                startActivity(i);
                break;


    }

    }

}
