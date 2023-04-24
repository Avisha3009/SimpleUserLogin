package com.example.userregistration;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    TextView n,a,p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        n=findViewById(R.id.name);
        a=findViewById(R.id.age);
        p=findViewById(R.id.pwd);
        String age = getIntent().getExtras().getString("age");
        String name = getIntent().getExtras().getString("name");
        String pwd = getIntent().getExtras().getString("pwd");
        a.setText("Name: "+name);
        p.setText("Password: "+pwd);
        n.setText("Age: "+ age);
    }
}