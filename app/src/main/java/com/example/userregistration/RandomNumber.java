package com.example.userregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RandomNumber extends AppCompatActivity {
    TextView txt;
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_number);
        txt = (TextView)findViewById(R.id.text);
        bt = (Button) findViewById(R.id.login);
        String randomNo = getIntent().getExtras().getString("no");
        txt.setText("!!IMP: Remember your one time random number: "+ randomNo);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });
    }

}